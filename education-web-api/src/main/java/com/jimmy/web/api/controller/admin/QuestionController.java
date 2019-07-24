package com.jimmy.web.api.controller.admin;

import com.jimmy.common.utils.StringUtils;
import com.jimmy.core.base.Page;
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
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName: StudentController
 * @Description:
 * @author: aiden
 * @date: 2019/7/11/011.
 */
@Api(value = "�����ص���Ϣ", description = "�����ص���ϢAPI")
@Controller
@RequestMapping("/admin/question")
public class QuestionController extends BaseController {
    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuestionItemService questionItemService;

    @ResponseBody
    @GetMapping("/page")
    @ApiOperation("����ҳ��Ϣ")
    public Result<Page<QuestionDTO>> page(String name, Integer pageNo, Integer pageSize) {
        this.setPage(pageNo, pageSize);
        List<Question> list = questionService.list(name);
        Page<QuestionDTO> resultList = getPageResult(list, target -> QuestionDTOTransfer.INSTANCE.toQuestionDTOList(target));
        return ResultBuilder.ok(resultList);
    }

    @ResponseBody
    @PostMapping("/save")
    @ApiOperation("���������Ϣ")
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
    @ApiOperation("��ѯ�����Ϣ")
    public Result<QuestionDTO> info(Long id) {
        QuestionDTO questionDTO=QuestionDTOTransfer.INSTANCE.toQuestionDTO(questionService.findById(id));
        questionDTO.setItemList(QuestionItemDTOTransfer.INSTANCE.toQuestionItemDTOList(questionItemService.list(questionDTO.getId())));
        return ResultBuilder.ok(questionDTO);
    }

    @ResponseBody
    @PostMapping("/deleted/{id}")
    @ApiOperation("ɾ�������Ϣ")
    public Result<Void> deleted(@PathVariable("id") Long id) {
        questionService.deleted(id);
        return ResultBuilder.ok(null);
    }
}
