package com.jimmy.teacher.api.controller.admin;


import com.alibaba.fastjson.JSON;
import com.jimmy.core.enums.ResultCoreEnum;
import com.jimmy.dao.entity.*;
import com.jimmy.model.vo.StudentFractionVo;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.mvc.common.enums.ResultCodeEnum;
import com.jimmy.mvc.common.model.dto.*;
import com.jimmy.mvc.common.model.enums.ContentTypeEnum;
import com.jimmy.mvc.common.model.enums.FractionTypeEnum;
import com.jimmy.mvc.common.model.transfer.CoursewareItemDTOTransfer;
import com.jimmy.mvc.common.model.transfer.TeacherStaffInfoDTOTransfer;
import com.jimmy.service.*;
import com.jimmy.teacher.api.config.TeacherConfig;
import com.jimmy.teacher.api.controller.BaseController;
import com.jimmy.teacher.api.local.thread.TeacherLocalThread;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: TeacherController
 * @Description:
 * @author: aiden
 * @date: 2019/6/11/011.
 */
@Api(value = "老师相关信息接口", description = "老师相关信息接口API")
@Controller
@RequestMapping("/admin/teacher")
@EnableConfigurationProperties(TeacherConfig.class)
public class TeacherController extends BaseController {

    @Autowired
    private TeacherConfig teacherConfig;

    @Autowired
    private CoursewareService coursewareService;

    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private CourseAnswerService courseAnswerService;

    @Autowired
    private CourseStudentService courseStudentService;

    @Autowired
    private StudentFractionService studentFractionService;

    @ApiOperation("获取老师的基本信息接口")
    @ResponseBody
    @GetMapping("/detail")
    @ApiImplicitParams({@ApiImplicitParam(required = true, paramType = "header", value = "token", name = "token")})
    public Result<TeacherStaffInfoDTO> detail() {
        TeacherStaffInfo teacherStaffInfo = TeacherLocalThread.get();
        TeacherStaffInfoDTO teacherStaffInfoDTO = TeacherStaffInfoDTOTransfer.INSTANCE.toTeacherStaffInfoDTO(teacherStaffInfo);
        return ResultBuilder.error(ResultCodeEnum.OK, teacherStaffInfoDTO);
    }


    @ApiOperation("保存老师对象学生图纸作品的答案")
    @ResponseBody
    @PostMapping("/answer/save/{courseId}/{machineId}")
    @ApiImplicitParams({@ApiImplicitParam(required = true, paramType = "header", value = "token", name = "token")})
    public Result<Boolean> save(@PathVariable("courseId") Long courseId,
                                @PathVariable("machineId") Long machineId,
                                @RequestBody ListDTO<CourseAnswerDTO> courseAnswerDTOList) {
        if (courseAnswerDTOList == null || CollectionUtils.isEmpty(courseAnswerDTOList.getResult())) {
            return ResultBuilder.error(ResultCoreEnum.RESULT_PARAMETER_EXCEPTION);
        }
        List<Long> itemIdList = new ArrayList<>();
        for (CourseAnswerDTO courseAnswerDTO : courseAnswerDTOList.getResult()) {
            itemIdList.add(courseAnswerDTO.getCoursewareItemId());
        }
        List<CourseAnswer> courseAnswerList = courseAnswerService.listMachineAnswer(courseId, machineId, itemIdList);
        if (courseAnswerList == null || courseAnswerList.size() != itemIdList.size()) {
            return ResultBuilder.error(ResultCodeEnum.STUDNE_ANSWER_NOT_EXIST);
        }
        Map<Long, CourseAnswer> courseAnswerMap = new HashMap<>();
        courseAnswerList.forEach(courseAnswer -> courseAnswerMap.put(courseAnswer.getCoursewareItemId(), courseAnswer));
        for (CourseAnswerDTO courseAnswerDTO : courseAnswerDTOList.getResult()) {
            CourseAnswer courseAnswer = courseAnswerMap.get(courseAnswerDTO.getCoursewareItemId());
            courseAnswer.setFraction(null);
            courseAnswer.setStudentResult(null);
            courseAnswer.setTearchResult(JSON.toJSONString(courseAnswerDTO.getTearchResult()));
        }
        courseAnswerService.update(courseAnswerList);
        return ResultBuilder.ok(Boolean.TRUE);
    }

    @ApiOperation("获取课程下课件中所有需要评价项")
    @ResponseBody
    @GetMapping("/appraise/list/{courseId}")
    @ApiImplicitParams({@ApiImplicitParam(required = true, paramType = "header", value = "token", name = "token")})
    public Result<List<AppraiseItemDTO>> listAppraiseItem(@PathVariable("courseId") Long courseId) {
        List<AppraiseItemDTO> appraiseItemDTOList = new ArrayList<>();
        List<DictionaryItem> itemList = dictionaryService.list(teacherConfig.getDictionaryId());
        if (!CollectionUtils.isEmpty(itemList)) {
            itemList.forEach(item -> {
                AppraiseItemDTO appraiseItemDTO = new AppraiseItemDTO();
                appraiseItemDTO.setFractionType(FractionTypeEnum.DICTIONARY);
                appraiseItemDTO.setId(item.getId());
                appraiseItemDTO.setName(item.getContent());
                appraiseItemDTOList.add(appraiseItemDTO);
            });
        }
        List<CoursewareItem> coursewareItemList = coursewareService.listByCourseId(courseId, ContentTypeEnum.BLUEPRINT.getValue());
        if (!CollectionUtils.isEmpty(coursewareItemList)) {
            CoursewareItemDTOTransfer.INSTANCE.toCoursewareItemDTOList(coursewareItemList).forEach(item -> {
                AppraiseItemDTO appraiseItemDTO = new AppraiseItemDTO();
                appraiseItemDTO.setFractionType(FractionTypeEnum.COURSEWARE_ITEM);
                appraiseItemDTO.setId(item.getId());
                appraiseItemDTO.setName(item.convert(DrawingDTO.class).getName());
                appraiseItemDTOList.add(appraiseItemDTO);
            });
        }
        return ResultBuilder.ok(appraiseItemDTOList);
    }

    @ApiOperation("保存课程中所有需要评价项")
    @ResponseBody
    @PostMapping("/appraise/save/{courseId}/{machineId}")
    @ApiImplicitParams({@ApiImplicitParam(required = true, paramType = "header", value = "token", name = "token")})
    public Result<Boolean> listAppraiseItem(@PathVariable("courseId") Long courseId,
                                            @PathVariable("machineId") Long machineId, @RequestBody @Validated ListDTO<AppraiseItemDTO> itemDTOListDTO) {

        List<CourseStudent> courseStudentList = courseStudentService.list(courseId, machineId);
        if (CollectionUtils.isEmpty(courseStudentList)) {
            return ResultBuilder.error(ResultCodeEnum.MACHINE_STUDENT_NOT_EXIST);
        }
        List<Long> studentIdList = new ArrayList<>();
        courseStudentList.forEach(courseStudent -> studentIdList.add(courseStudent.getStudentId()));
        List<StudentFraction> studentFractionList = studentFractionService.list(courseId, studentIdList);
        if (!CollectionUtils.isEmpty(studentFractionList)) {
            return ResultBuilder.error(ResultCodeEnum.APPRIASE_ALREADY_EXIST);
        }
        List<StudentFractionVo> studentFractionVoList = new ArrayList<>();
        for (Long studentId : studentIdList) {
            StudentFractionVo studentFractionVo = new StudentFractionVo();
            StudentFraction studentFraction = new StudentFraction();
            List<StudentFractionItem> studentFractionItemList = new ArrayList<>();
            BigDecimal totalFration = BigDecimal.ZERO;
            StudentFractionItem studentFractionItem;
            for (AppraiseItemDTO appraiseItemDTO : itemDTOListDTO.getResult()) {
                studentFractionItem = new StudentFractionItem();
                studentFractionItem.setFraction(appraiseItemDTO.getFraction());
                studentFractionItem.setName(appraiseItemDTO.getName());
                studentFractionItem.setDictionaryItemId(appraiseItemDTO.getId());
                studentFractionItem.setType(appraiseItemDTO.getFractionType().getValue());
                totalFration = totalFration.add(appraiseItemDTO.getFraction());
                studentFractionItemList.add(studentFractionItem);
            }
            studentFraction.setCourseId(courseId);
            studentFraction.setStudentId(studentId);
            studentFractionVo.setStudentFraction(studentFraction);
            studentFractionVo.setStudentFractionItemList(studentFractionItemList);
            studentFractionVoList.add(studentFractionVo);
        }
        studentFractionService.save(studentFractionVoList);
        return ResultBuilder.ok(Boolean.TRUE);
    }


    @ApiOperation("保存老师对象所有的学生图纸作品的答案")
    @ResponseBody
    @PostMapping("/all/answer/save/{courseId}")
    @ApiImplicitParams({@ApiImplicitParam(required = true, paramType = "header", value = "token", name = "token")})
    public Result<Boolean> save(@PathVariable("courseId") Long courseId,
                                @RequestBody ListDTO<CourseAnswerAllDTO> courseAnswerAllDTOList) {
        if (courseAnswerAllDTOList == null || CollectionUtils.isEmpty(courseAnswerAllDTOList.getResult())) {
            return ResultBuilder.error(ResultCoreEnum.RESULT_PARAMETER_EXCEPTION);
        }
        List<Long> itemIdList = new ArrayList<>();
        List<Long> machineIdList = new ArrayList<>();
        for (CourseAnswerAllDTO courseAnswerAllDTO : courseAnswerAllDTOList.getResult()) {
            if (courseAnswerAllDTO.getMachineId() == null || CollectionUtils.isEmpty(courseAnswerAllDTO.getCourseAnswerDTOList())) {
                return ResultBuilder.error(ResultCoreEnum.RESULT_PARAMETER_EXCEPTION);
            }
            machineIdList.add(courseAnswerAllDTO.getMachineId());
            for (CourseAnswerDTO courseAnswerDTO : courseAnswerAllDTO.getCourseAnswerDTOList()) {
                itemIdList.add(courseAnswerDTO.getCoursewareItemId());
            }
        }


        List<CourseAnswer> courseAnswerList = courseAnswerService.listMachineAnswer(courseId, machineIdList, itemIdList);
        if (CollectionUtils.isEmpty(courseAnswerList)) {
            return ResultBuilder.error(ResultCodeEnum.STUDNE_ANSWER_NOT_EXIST);
        }
        Map<Long, Map<Long, CourseAnswer>> courseAnswerMap = new HashMap<>();
        courseAnswerList.forEach(courseAnswer -> {
            Map<Long, CourseAnswer> courseAnswerIdMap = courseAnswerMap.get(courseAnswer.getMachineId());
            if (courseAnswerIdMap == null) {
                courseAnswerIdMap = new HashMap<>();
                courseAnswerMap.put(courseAnswer.getMachineId(), courseAnswerIdMap);
            }
            courseAnswerIdMap.put(courseAnswer.getCoursewareItemId(), courseAnswer);
        });

        for (CourseAnswerAllDTO courseAnswerAllDTO : courseAnswerAllDTOList.getResult()) {
            Map<Long, CourseAnswer> courseAnswerIdMap = courseAnswerMap.get(courseAnswerAllDTO.getMachineId());
            if (courseAnswerIdMap == null) {
                return ResultBuilder.error(ResultCodeEnum.STUDNE_ANSWER_NOT_EXIST);
            }
            machineIdList.add(courseAnswerAllDTO.getMachineId());
            for (CourseAnswerDTO courseAnswerDTO : courseAnswerAllDTO.getCourseAnswerDTOList()) {
                CourseAnswer courseAnswer = courseAnswerIdMap.get(courseAnswerDTO.getCoursewareItemId());
                if (courseAnswer == null) {
                    return ResultBuilder.error(ResultCodeEnum.STUDNE_ANSWER_NOT_EXIST);
                }
                courseAnswer.setFraction(null);
                courseAnswer.setStudentResult(null);
                courseAnswer.setTearchResult(JSON.toJSONString(courseAnswerDTO.getTearchResult()));
            }
        }
        courseAnswerService.update(courseAnswerList);
        return ResultBuilder.ok(Boolean.TRUE);
    }
}
