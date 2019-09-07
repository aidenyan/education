package com.jimmy.web.api.controller.admin;

import com.jimmy.core.base.Page;
import com.jimmy.dao.entity.ClassRoomInfo;
import com.jimmy.dao.entity.CourseInfo;
import com.jimmy.model.vo.ClassRoomVO;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.mvc.common.enums.ResultCodeEnum;
import com.jimmy.mvc.common.model.dto.ClassRoomDTO;
import com.jimmy.mvc.common.model.dto.ClassRoomVoDTO;
import com.jimmy.mvc.common.model.transfer.ClassRoomDTOTransfer;
import com.jimmy.mvc.common.model.transfer.ClassRoomVoDTOTransfer;
import com.jimmy.mvc.common.model.transfer.MachineInfoTOTransfer;
import com.jimmy.service.ClassRoomService;
import com.jimmy.service.CourseInfoService;
import com.jimmy.web.api.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName: ClassRoomController
 * @Description:
 * @author: aiden
 * @date: 2019/7/11/011.
 */
@Api(value = "教室的信息处理", description = "教室的信息处理API")
@Controller
@RequestMapping("/admin/classroom")
public class ClassRoomController extends BaseController {
    @Autowired
    private ClassRoomService classRoomService;

    @Autowired
    private CourseInfoService courseInfoService;

    @ResponseBody
    @GetMapping("/page")
    @ApiOperation("教室的分页信息")
    public Result<Page<ClassRoomDTO>> page(String name, Integer pageNo, Integer pageSize) {
        this.setPage(pageNo, pageSize);
        List<ClassRoomInfo> list = classRoomService.list(name);
        Page<ClassRoomDTO> resultList = getPageResult(list, target -> ClassRoomDTOTransfer.INSTANCE.toClassRoomDTOList(target));
        return ResultBuilder.ok(resultList);
    }

    @ResponseBody
    @PostMapping("/save")
    @ApiOperation("保存教室信息")
    public Result<Void> save(@Validated @RequestBody ClassRoomVoDTO classRoomVoDTO) {
        if (classRoomVoDTO.getClassRoomInfo().getId() != null) {
            CourseInfo courseInfo = courseInfoService.findByRoomId(classRoomVoDTO.getClassRoomInfo().getId());
            if (courseInfo != null) {
                return ResultBuilder.error(ResultCodeEnum.ROOM_IS_USING);
            }
        }
        classRoomService.save(ClassRoomDTOTransfer.INSTANCE.toClassRoom(classRoomVoDTO.getClassRoomInfo()), MachineInfoTOTransfer.INSTANCE.toMachineInfoList(classRoomVoDTO.getMachineInfoList()));
        return ResultBuilder.ok(null);
    }

    @ResponseBody
    @GetMapping("/info")
    @ApiOperation("查询教室的详细信息")
    public Result<ClassRoomVoDTO> info(Long id) {
        ClassRoomVO classRoomVo = classRoomService.find(id);
        return ResultBuilder.ok(ClassRoomVoDTOTransfer.INSTANCE.toClassRoomVoDTO(classRoomVo));
    }

    @ResponseBody
    @PostMapping("/deleted/{id}")
    @ApiOperation("删除教室信息")
    public Result<Void> deleted(@PathVariable("id") Long id) {
        if (!courseInfoService.isExitByRoomId(id)) {
            return ResultBuilder.error(ResultCodeEnum.ROOM_IS_USING);
        }
        classRoomService.deleted(id);
        return ResultBuilder.ok(null);
    }
}
