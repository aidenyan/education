package com.jimmy.teacher.api.controller.admin;

import com.jimmy.dao.entity.StudentInfo;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.mvc.common.enums.ResultCodeEnum;
import com.jimmy.mvc.common.model.dto.StudentInfoDTO;
import com.jimmy.mvc.common.model.transfer.StudentInfoDTOTransfer;
import com.jimmy.service.StudentStarInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName: StudentController
 * @Description:
 * @author: aiden
 * @date: 2019/6/12/012.
 */
@Api(tags = "学生信息相关接口", description = "学生信息相关接口API")
@Controller
@RequestMapping("/admin/student")
public class StudentController {

    @Autowired
    private StudentStarInfoService studentStarInfoService;

    @ApiOperation("获取本周学习之星接口")
    @ResponseBody
    @PostMapping("/star")
    public Result<List<StudentInfoDTO>> list() {
        List<StudentInfo> staffInfoDTOList = studentStarInfoService.listStar();
        return ResultBuilder.error(ResultCodeEnum.OK, StudentInfoDTOTransfer.INSTANCE.toStudentInfoDTOList(staffInfoDTOList));
    }
}
