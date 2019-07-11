package com.jimmy.web.api.controller.admin;

import com.jimmy.core.base.Page;
import com.jimmy.dao.entity.Question;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.mvc.common.model.dto.QuestionDTO;
import com.jimmy.mvc.common.model.transfer.QuestionDTOTransfer;
import com.jimmy.service.QuestionService;
import com.jimmy.web.api.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    @GetMapping("/save")
    @ApiOperation("����γ���Ϣ")
    public Result<Void> save(@Validated @RequestBody QuestionDTO questionDTO) {
        questionService.save(QuestionDTOTransfer.INSTANCE.toQuestion(questionDTO));
        return ResultBuilder.ok(null);
    }

    @ResponseBody
    @GetMapping("/info")
    @ApiOperation("��ѯ�γ���Ϣ")
    public Result<QuestionDTO> info(Long id) {
        return ResultBuilder.ok(QuestionDTOTransfer.INSTANCE.toQuestionDTO(questionService.findById(id)));
    }

    @ResponseBody
    @PostMapping("/deleted/{id}")
    @ApiOperation("ɾ�������Ϣ")
    public Result<Void> deleted(@PathVariable("id") Long id) {
        questionService.deleted(id);
        return ResultBuilder.ok(null);
    }
}
