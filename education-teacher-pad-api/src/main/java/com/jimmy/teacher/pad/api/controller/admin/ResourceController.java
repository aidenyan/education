package com.jimmy.teacher.pad.api.controller.admin;

import com.jimmy.core.enums.ResultCoreEnum;
import com.jimmy.dao.entity.ResourceInfo;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.mvc.common.model.dto.ResourceInfoDTO;
import com.jimmy.mvc.common.model.enums.ResourceTypeEnum;
import com.jimmy.mvc.common.model.transfer.ResourceInfoDTOTransfer;
import com.jimmy.service.ResourceInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Api(value = "资源信息", description = "资源信息")
@Controller
@RequestMapping("/admin/resource")
public class ResourceController {
    @Autowired
    private ResourceInfoService resourceInfoService;

    @ResponseBody
    @GetMapping("/list/type")
    @ApiOperation("资源类型的列表")
    @ApiImplicitParams({@ApiImplicitParam(required = true, paramType = "header", value = "token", name = "token")})
    public Result<List<ResourceTypeEnum>> listType() {
        return ResultBuilder.ok(Arrays.asList(ResourceTypeEnum.values()));
    }

    @ResponseBody
    @GetMapping("/list/resource")
    @ApiOperation("根据资源类型获取资源列表")
    @ApiImplicitParams({@ApiImplicitParam(required = true, paramType = "header", value = "token", name = "token")})
    public Result<List<ResourceInfoDTO>> listType(ResourceTypeEnum resourceType) {
        if (resourceType == null) {
            return ResultBuilder.error(ResultCoreEnum.RESULT_PARAMETER_EXCEPTION);
        }
        List<ResourceInfo> resourceInfoList = resourceInfoService.list(resourceType.getValue());
        return ResultBuilder.ok(ResourceInfoDTOTransfer.INSTANCE.toResourceInfoDTOList(resourceInfoList));
    }

    @ResponseBody
    @PostMapping("/save")
    @ApiOperation("保存资源信息")
    @ApiImplicitParams({@ApiImplicitParam(required = true, paramType = "header", value = "token", name = "token")})
    public Result<Boolean> listType(@Validated @RequestBody ResourceInfoDTO resourceInfoDTO) {
        if (resourceInfoDTO == null) {
            return ResultBuilder.error(ResultCoreEnum.RESULT_PARAMETER_EXCEPTION);
        }
        resourceInfoService.save(ResourceInfoDTOTransfer.INSTANCE.toResourceInfo(resourceInfoDTO));
        return ResultBuilder.ok(Boolean.TRUE);
    }
}
