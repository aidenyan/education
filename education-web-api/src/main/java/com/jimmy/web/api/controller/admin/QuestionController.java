package com.jimmy.web.api.controller.admin;

import com.jimmy.common.utils.StringUtils;
import com.jimmy.core.base.Page;
import com.jimmy.core.consts.PageConst;
import com.jimmy.dao.entity.Question;
import com.jimmy.dao.entity.QuestionItem;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.mvc.common.enums.ResultCodeEnum;
import com.jimmy.mvc.common.model.dto.QuestionDTO;
import com.jimmy.mvc.common.model.dto.QuestionItemDTO;
import com.jimmy.mvc.common.model.enums.QuestionTypeEnum;
import com.jimmy.mvc.common.model.transfer.QuestionDTOTransfer;
import com.jimmy.mvc.common.model.transfer.QuestionItemDTOTransfer;
import com.jimmy.service.QuestionItemService;
import com.jimmy.service.QuestionService;
import com.jimmy.web.api.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName: StudentController
 * @Description:
 * @author: aiden
 * @date: 2019/7/11/011.
 */
@Api(value = "题库相关的信息", description = "题库相关的信息API")
@Controller
@RequestMapping("/admin/question")
public class QuestionController extends BaseController {
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
    @PostMapping("/save")
    @ApiOperation("保存题库信息")
    public Result<Void> save(@Validated @RequestBody QuestionDTO questionDTO) {
        if (QuestionTypeEnum.QUESTION_AN_ANSWERS.equals(questionDTO.getType())) {
            if (StringUtils.isBlank(questionDTO.getResult())) {
               return  ResultBuilder.error(ResultCodeEnum.QUESTION_RESULT_IS_BLANK);
            }
        } else {
            if (CollectionUtils.isEmpty(questionDTO.getItemList())) {
                return ResultBuilder.error(ResultCodeEnum.QUESTION_ITEM_IS_EMPTY);
            }
            int resultBoolNum = 0;
            for (QuestionItemDTO itemDTO : questionDTO.getItemList()) {
                resultBoolNum = itemDTO.getIsResult() ? resultBoolNum + 1 : resultBoolNum;
            }
            if(resultBoolNum==0){
                return ResultBuilder.error(ResultCodeEnum.QUESTION_ITEM_ANSWER_EMPTY);
            }
            if(QuestionTypeEnum.SINGLE_CHOICE.equals(questionDTO.getType())&&resultBoolNum>1){
                return ResultBuilder.error(ResultCodeEnum.QUESTION_ITEM_ANSWER_SIMPLE);
            }
        }
        questionService.save(QuestionDTOTransfer.INSTANCE.toQuestion(questionDTO),
                QuestionItemDTOTransfer.INSTANCE.toQuestionItemList(questionDTO.getItemList()));
        return ResultBuilder.ok(null);
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
    @PostMapping("/deleted/{id}")
    @ApiOperation("删除题库信息")
    public Result<Void> deleted(@PathVariable("id") Long id) {
        questionService.deleted(id);
        return ResultBuilder.ok(null);
    }

    @ResponseBody
    @GetMapping("/detail/page")
    @ApiOperation("题库信息列表")
    public Result<Page<QuestionDTO>> Page(String title, Long pageNo, Long pageSize) {
        if (pageNo == null) {
            pageNo = PageConst.PAGE_FIRST.longValue();
        }
        if (pageSize == null) {
            pageSize = PageConst.PAGE_DEFAULT_SIZE.longValue();
        }
        Page<QuestionDTO> page = new Page<>();
        Long count = questionService.count(title);
        if (count < (pageNo - 1) * pageSize) {
            pageNo = count % pageSize == 0 ? count / pageSize : (count - count % pageSize) / pageSize + 1;
        }
        page.setPageNo(pageNo.intValue());
        page.setPageSize(pageSize.intValue());
        page.setTotal(count);
        if (count == 0) {
            return ResultBuilder.ok(page);
        }
        List<Question> questionList = questionService.list(title, (pageNo - 1) * pageSize, pageSize);
        Map<Long, QuestionDTO> questionIdMap = new HashMap<>();
        List<Long> questionIdList = new ArrayList<>();
        questionList.forEach(question -> {
            questionIdMap.put(question.getId(), QuestionDTOTransfer.INSTANCE.toQuestionDTO(question));
            if (QuestionTypeEnum.MULTIPLE_CHOICE.getValue() != question.getType()) {
                questionIdList.add(question.getId());
            }
        });

        if (CollectionUtils.isEmpty(questionIdList)) {
            page.setResult(questionIdMap.values().stream().collect(Collectors.toList()));
            return ResultBuilder.ok(page);
        }
        List<QuestionItem> questionItemList = questionItemService.list(questionIdList);
        if (CollectionUtils.isEmpty(questionItemList)) {
            page.setResult(questionIdMap.values().stream().collect(Collectors.toList()));
            return ResultBuilder.ok(page);
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
        page.setResult(questionIdMap.values().stream().collect(Collectors.toList()));
        return ResultBuilder.ok(page);
    }

    @ResponseBody
    @GetMapping("/detail/list")
    @ApiOperation("题库信息列表")
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
