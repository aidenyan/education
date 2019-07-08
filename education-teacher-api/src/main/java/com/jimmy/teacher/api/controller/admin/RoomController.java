package com.jimmy.teacher.api.controller.admin;

import com.jimmy.dao.entity.TeacherStaffInfo;
import com.jimmy.model.vo.ClassRoomVO;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.mvc.common.enums.ResultCodeEnum;
import com.jimmy.mvc.common.model.dto.ClassRoomVoDTO;
import com.jimmy.mvc.common.model.transfer.ClassRoomVoDTOTransfer;
import com.jimmy.service.ClassRoomService;
import com.jimmy.teacher.api.controller.BaseController;
import com.jimmy.teacher.api.local.thread.TeacherLocalThread;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName: RoomController
 * @Description:
 * @author: aiden
 * @date: 2019/6/12/012.
 */
@Api(tags = "教室信息", description = "教室信息API")
@Controller
@RequestMapping("/admin/room")
public class RoomController  extends BaseController {

    @Autowired
    private ClassRoomService classRoomService;

    @ApiOperation("获取教室以及机床的信息")
    @ResponseBody
    @GetMapping("/detail")
    public Result<ClassRoomVoDTO> detail() {
        TeacherStaffInfo teacherStaffInfo = TeacherLocalThread.get();
        ClassRoomVO classRoomVO = classRoomService.find(teacherStaffInfo.getAppRoomId());
        return ResultBuilder.error(ResultCodeEnum.OK, ClassRoomVoDTOTransfer.INSTANCE.toClassRoomVoDTO(classRoomVO));
    }
}
