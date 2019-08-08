package com.jimmy.teacher.pad.api.controller.admin;

import com.jimmy.core.base.Page;
import com.jimmy.dao.entity.Question;
import com.jimmy.dao.entity.QuestionItem;
import com.jimmy.dao.entity.ResourceInfo;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.mvc.common.model.dto.QuestionDTO;
import com.jimmy.mvc.common.model.dto.QuestionItemDTO;
import com.jimmy.mvc.common.model.dto.ResourceInfoDTO;
import com.jimmy.mvc.common.model.enums.QuestionTypeEnum;
import com.jimmy.mvc.common.model.transfer.QuestionDTOTransfer;
import com.jimmy.mvc.common.model.transfer.QuestionItemDTOTransfer;
import com.jimmy.mvc.common.model.transfer.ResourceInfoDTOTransfer;
import com.jimmy.service.QuestionItemService;
import com.jimmy.service.QuestionService;
import com.jimmy.teacher.pad.api.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;
import java.util.stream.Collectors;

@Api(value = "题库信息", description = "题库信息")
@Controller
@RequestMapping("/admin/question")
public class QuestionController extends BaseController{
    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuestionItemService questionItemService;


    @ResponseBody
    @GetMapping("/page")
    @ApiOperation("题库分页信息")
    public Result<Page<QuestionDTO>> page(String name, Integer pageNo, Integer pageSize) {
        this.setPage(pageNo, pageSize);
        List<Question> list = questionService.list(name);
        Page<QuestionDTO> resultList = getPageResult(list, target -> QuestionDTOTransfer.INSTANCE.toQuestionDTOList(target));
        return ResultBuilder.ok(resultList);
    }

    @ResponseBody
    @GetMapping("/info")
    @ApiOperation("查询题库信息")
    public Result<QuestionDTO> info(Long id) {
        QuestionDTO questionDTO=QuestionDTOTransfer.INSTANCE.toQuestionDTO(questionService.findById(id));
        questionDTO.setItemList(QuestionItemDTOTransfer.INSTANCE.toQuestionItemDTOList(questionItemService.list(questionDTO.getId())));
        return ResultBuilder.ok(questionDTO);
    }

    @ResponseBody
    @GetMapping("/list")
    @ApiOperation("题库信息列表")
    @ApiImplicitParams({@ApiImplicitParam(required = true, paramType = "header", value = "token", name = "token")})
    public Result<List<QuestionDTO>> list(String title) {
        List<Question> questionList = questionService.list(title);

        if (CollectionUtils.isEmpty(questionList)) {
            return ResultBuilder.ok(Collections.EMPTY_LIST);
        }
        Map<Long, QuestionDTO> questionIdMap = new HashMap<>();
        List<Long> questionIdList = new ArrayList<>();
        questionList.forEach(question -> {
            questionIdMap.put(question.getId(), QuestionDTOTransfer.INSTANCE.toQuestionDTO(question));
            if (QuestionTypeEnum.MULTIPLE_CHOICE.getValue() != question.getType()) {
                questionIdList.add(question.getId());
            }
        });

        if (CollectionUtils.isEmpty(questionIdList)) {
            return ResultBuilder.ok(questionIdMap.values().stream().collect(Collectors.toList()));
        }
        List<QuestionItem> questionItemList = questionItemService.list(questionIdList);
        if (CollectionUtils.isEmpty(questionItemList)) {
            return ResultBuilder.ok(questionIdMap.values().stream().collect(Collectors.toList()));
        }
        Map<Long, List<QuestionItemDTO>> itemMap = new HashMap<>();
        questionItemList.forEach(questionItem -> {
            List<QuestionItemDTO> itemDTOList = itemMap.get(questionItem.getQuestionId());
            if (itemDTOList == null) {
                itemDTOList = new ArrayList<>();
                itemMap.put(questionItem.getQuestionId(), itemDTOList);
            }
            itemDTOList.add(QuestionItemDTOTransfer.INSTANCE.toQuestionItemDTO(questionItem));
        });
        for (Long questionId : questionIdMap.keySet()) {
            QuestionDTO questionDTO = questionIdMap.get(questionId);
            questionDTO.setItemList(itemMap.get(questionId));
        }
        return ResultBuilder.ok(questionIdMap.values().stream().collect(Collectors.toList()));
    }
}
