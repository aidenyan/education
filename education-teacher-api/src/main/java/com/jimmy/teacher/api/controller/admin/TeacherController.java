package com.jimmy.teacher.api.controller.admin;


import com.jimmy.dao.entity.TeacherStaffInfo;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.mvc.common.enums.ResultCodeEnum;
import com.jimmy.mvc.common.model.dto.TeacherStaffInfoDTO;
import com.jimmy.mvc.common.model.transfer.TeacherStaffInfoDTOTransfer;
import com.jimmy.service.TeacherStaffInfoService;
import com.jimmy.teacher.api.local.thread.TeacherLocalThread;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName: TeacherController
 * @Description:
 * @author: aiden
 * @date: 2019/6/11/011.
 */
@Api(tags = "��ʦ�����Ϣ�ӿ�", description = "��ʦ�����Ϣ�ӿ�API")
@Controller
@RequestMapping("/admin/teacher")
public class TeacherController {
    @Autowired
    private TeacherStaffInfoService teacherStaffInfoService;

    @ApiOperation("��ȡ��ʦ�Ļ�����Ϣ�ӿ�")
    @ResponseBody
    @PostMapping("/detail")
    public Result<TeacherStaffInfoDTO> detail() {
        TeacherStaffInfo teacherStaffInfo = TeacherLocalThread.get();
        TeacherStaffInfoDTO teacherStaffInfoDTO = TeacherStaffInfoDTOTransfer.INSTANCE.toTeacherStaffInfoDTO(teacherStaffInfo);
        return ResultBuilder.error(ResultCodeEnum.OK, teacherStaffInfoDTO);
    }

}
