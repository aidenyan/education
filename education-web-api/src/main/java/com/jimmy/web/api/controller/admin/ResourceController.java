package com.jimmy.web.api.controller.admin;

import com.jimmy.core.base.Page;
import com.jimmy.core.enums.ResultCoreEnum;
import com.jimmy.dao.entity.ResourceInfo;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.mvc.common.model.dto.ResourceInfoDTO;
import com.jimmy.mvc.common.model.enums.ResourceTypeEnum;
import com.jimmy.mvc.common.model.transfer.ResourceInfoDTOTransfer;
import com.jimmy.service.ResourceInfoService;
import com.jimmy.web.api.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: ClassRoomController
 * @Description:
 * @author: aiden
 * @date: 2019/7/11/011.
 */
@Api(value = "资源信息处理", description = "资源信息处理API")
@Controller
@RequestMapping("/admin/resource")
public class ResourceController extends BaseController {
    @Autowired
    private ResourceInfoService resourceInfoService;

    @ResponseBody
    @GetMapping("/list/type")
    @ApiOperation("资源类型的列表")
    public Result<List<ResourceTypeEnum>> listType() {
        return ResultBuilder.ok(Arrays.asList(ResourceTypeEnum.values()));
    }

    @ResponseBody
    @GetMapping("/list/resource")
    @ApiOperation("根据资源类型获取资源列表")
    public Result<Page<ResourceInfoDTO>> listType(ResourceTypeEnum resourceType, Integer pageNo, Integer pageSize) {

        if (resourceType == null) {
            return ResultBuilder.error(ResultCoreEnum.RESULT_PARAMETER_EXCEPTION);
        }
        this.setPage(pageNo, pageSize);
        List<ResourceInfo> resourceInfoList = resourceInfoService.list(resourceType.getValue());
        Page<ResourceInfoDTO> resultList = getPageResult(resourceInfoList, target -> ResourceInfoDTOTransfer.INSTANCE.toResourceInfoDTOList(target));
        return ResultBuilder.ok(resultList);
    }

    @ResponseBody
    @GetMapping("/page")
    @ApiOperation("资源信息的分页信息")
    public Result<Page<ResourceInfoDTO>> page(Integer type, Integer pageNo, Integer pageSize) {
        this.setPage(pageNo, pageSize);
        List<ResourceInfo> list = resourceInfoService.list(type);
        Page<ResourceInfoDTO> resultList = getPageResult(list, target -> ResourceInfoDTOTransfer.INSTANCE.toResourceInfoDTOList(target));
        return ResultBuilder.ok(resultList);
    }

    @ResponseBody
    @PostMapping("/save")
    @ApiOperation("保存资源信息")
    public Result<Void> save(@Validated @RequestBody ResourceInfoDTO resourceInfoDTO) {
        try {
            resourceInfoDTO.getBlueprintDTO();
            resourceInfoDTO.getVideoDTO();
            resourceInfoDTO.getImgWordText();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultBuilder.error(ResultCoreEnum.RESULT_PARAMETER_EXCEPTION);
        }

        resourceInfoService.save(ResourceInfoDTOTransfer.INSTANCE.toResourceInfo(resourceInfoDTO));
        return ResultBuilder.ok(null);
    }

    @ResponseBody
    @GetMapping("/info")
    @ApiOperation("查询教室的详细信息")
    public Result<ResourceInfoDTO> info(Long id) {
        ResourceInfo resourceInfo = resourceInfoService.findById(id);
        return ResultBuilder.ok(ResourceInfoDTOTransfer.INSTANCE.toResourceInfoDTO(resourceInfo));
    }

    @ResponseBody
    @PostMapping("/deleted/{id}")
    @ApiOperation("删除资源信息")
    public Result<Void> deleted(@PathVariable("id") Long id) {
        resourceInfoService.deleted(id);
        return ResultBuilder.ok(null);
    }
}
