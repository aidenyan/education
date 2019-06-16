package com.jimmy.student.api.controller.admin;

import com.alibaba.fastjson.JSON;
import com.jimmy.core.enums.ResultCoreEnum;
import com.jimmy.dao.entity.CourseAnswer;
import com.jimmy.dao.entity.CourseStudent;
import com.jimmy.dao.entity.StudentInfo;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.mvc.common.enums.ResultCodeEnum;
import com.jimmy.mvc.common.model.dto.CourseAnswerDTO;
import com.jimmy.mvc.common.model.dto.StudentInfoDTO;
import com.jimmy.mvc.common.model.transfer.StudentInfoDTOTransfer;
import com.jimmy.service.CourseAnswerService;
import com.jimmy.service.CourseStudentService;
import com.jimmy.service.StudentInfoService;
import com.jimmy.service.StudentStarInfoService;
import com.jimmy.student.api.local.thread.CourseStudentLocalThread;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName: StudentController
 * @Description:
 * @author: aiden
 * @date: 2019/6/12/012.
 */
@Api(tags = "ѧ����Ϣ��ؽӿ�", description = "ѧ����Ϣ��ؽӿ�API")
@Controller
@RequestMapping("/admin/student")
public class StudentController {
    @Autowired
    private StudentInfoService studentInfoService;

    @Autowired
    private CourseStudentService courseStudentService;


    @Autowired
    private CourseAnswerService courseAnswerService;

    @Autowired
    private StudentStarInfoService studentStarInfoService;

    @ApiOperation("��ȡ����ѧϰ֮�ǽӿ�")
    @ResponseBody
    @GetMapping("/star")
    public Result<List<StudentInfoDTO>> list() {
        List<StudentInfo> staffInfoDTOList = studentStarInfoService.listStar();
        return ResultBuilder.error(ResultCodeEnum.OK, StudentInfoDTOTransfer.INSTANCE.toStudentInfoDTOList(staffInfoDTOList));
    }

    @ApiOperation("��ȡĳ������������ѧ����Ϣ")
    @ResponseBody
    @GetMapping("/machine/list")
    public Result<List<StudentInfoDTO>> listMachine() {
        CourseStudent courseStudent = CourseStudentLocalThread.get();
        List<CourseStudent> courseStudentList = courseStudentService.list(courseStudent.getCourseId(), courseStudent.getMachineId());
        if (CollectionUtils.isEmpty(courseStudentList)) {
            return ResultBuilder.error(ResultCodeEnum.OK);
        }
        List<Long> studentIdList = new ArrayList<>();
        courseStudentList.forEach(tempCourseStudent -> studentIdList.add(tempCourseStudent.getStudentId()));
        List<StudentInfo> studentInfoList = studentInfoService.list(studentIdList);
        return ResultBuilder.error(ResultCodeEnum.OK, StudentInfoDTOTransfer.INSTANCE.toStudentInfoDTOList(studentInfoList));
    }
    @ApiOperation("������ʦ����ѧ��ͼֽ��Ʒ�Ĵ�")
    @ResponseBody
    @PostMapping("/answer/save/{courseId}/{machineId}")
    public Result<Boolean> save(@PathVariable("courseId") Long courseId,
                                @PathVariable("machineId") Long machineId,
                                CourseAnswerDTO[] courseAnswerDTOArray) {
        if (courseAnswerDTOArray == null || courseAnswerDTOArray.length == 0) {
            return ResultBuilder.error(ResultCoreEnum.RESULT_PARAMETER_EXCEPTION);
        }
        List<Long> itemIdList = new ArrayList<>();
        for (CourseAnswerDTO courseAnswerDTO : courseAnswerDTOArray) {
            itemIdList.add(courseAnswerDTO.getCoursewareItemId());
        }
        List<CourseAnswer> courseAnswerList = courseAnswerService.listMachineAnswer(courseId, machineId, itemIdList);
        if (courseAnswerList == null ) {
            courseAnswerList=new ArrayList<>();
        }
        Map<Long, CourseAnswer> courseAnswerMap = new HashMap<>();
        courseAnswerList.forEach(courseAnswer -> courseAnswerMap.put(courseAnswer.getCoursewareItemId(), courseAnswer));
        for (CourseAnswerDTO courseAnswerDTO : courseAnswerDTOArray) {
            CourseAnswer courseAnswer = courseAnswerMap.get(courseAnswerDTO.getCoursewareItemId());
            if(courseAnswer==null){
                courseAnswer=new CourseAnswer();
                courseAnswerMap.put(courseAnswerDTO.getCoursewareItemId(),courseAnswer);
            }
            courseAnswer.setCourseId(courseId);
            courseAnswer.setCoursewareId(courseAnswerDTO.getCoursewareId());
            courseAnswer.setFraction(null);
            courseAnswer.setStudentResult(JSON.toJSONString(courseAnswerDTO.getStudentResult()));
        }
        courseAnswerService.update(courseAnswerMap.values().stream().collect(Collectors.toList()));
        return ResultBuilder.ok(Boolean.TRUE);
    }
}