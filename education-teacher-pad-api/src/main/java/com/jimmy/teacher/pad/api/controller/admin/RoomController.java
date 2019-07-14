package com.jimmy.teacher.pad.api.controller.admin;

import com.jimmy.dao.entity.ClassRoomInfo;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.service.ClassRoomService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Api(value = "教室信息", description = "教室信息")
@Controller
@RequestMapping("/admin/room")
public class RoomController {
    @Autowired
    private ClassRoomService classRoomService;

    @ResponseBody
    @GetMapping("/list")
    @ApiOperation("教室列表")
    @ApiImplicitParams({@ApiImplicitParam(required = true, paramType = "header", value = "token", name = "token")})
    public Result<List<ClassRoomInfo>> list(String name) {
        List<ClassRoomInfo> classRoomInfoList = classRoomService.list(name);
        return ResultBuilder.ok(classRoomInfoList);
    }
}
