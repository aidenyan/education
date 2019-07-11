package com.jimmy.web.api.controller.admin;

import com.jimmy.core.base.Page;
import com.jimmy.dao.entity.ResourceInfo;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.mvc.common.model.dto.ResourceInfoDTO;
import com.jimmy.mvc.common.model.transfer.ResourceInfoDTOTransfer;
import com.jimmy.service.ResourceInfoService;
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
@Api(value = "��Դ��Ϣ����", description = "��Դ��Ϣ����API")
@Controller
@RequestMapping("/admin/resource")
public class ResourceController extends BaseController {
    @Autowired
    private ResourceInfoService resourceInfoService;

    @ResponseBody
    @GetMapping("/page")
    @ApiOperation("��Դ��Ϣ�ķ�ҳ��Ϣ")
    public Result<Page<ResourceInfoDTO>> page(Integer type, Integer pageNo, Integer pageSize) {
        this.setPage(pageNo, pageSize);
        List<ResourceInfo> list = resourceInfoService.list(type);
        Page<ResourceInfoDTO> resultList = getPageResult(list, target -> ResourceInfoDTOTransfer.INSTANCE.toResourceInfoDTOList(target));
        return ResultBuilder.ok(resultList);
    }

    @ResponseBody
    @GetMapping("/save")
    @ApiOperation("������Դ��Ϣ")
    public Result<Void> save(@Validated @RequestBody ResourceInfoDTO resourceInfoDTO) {
        resourceInfoService.save(ResourceInfoDTOTransfer.INSTANCE.toResourceInfo(resourceInfoDTO));
        return ResultBuilder.ok(null);
    }

    @ResponseBody
    @GetMapping("/info")
    @ApiOperation("��ѯ���ҵ���ϸ��Ϣ")
    public Result<ResourceInfoDTO> info(Long id) {
        ResourceInfo resourceInfo = resourceInfoService.findById(id);
        return ResultBuilder.ok(ResourceInfoDTOTransfer.INSTANCE.toResourceInfoDTO(resourceInfo));
    }
    @ResponseBody
    @PostMapping("/deleted/{id}")
    @ApiOperation("ɾ����Դ��Ϣ")
    public Result<Void> deleted(@PathVariable("id") Long id) {
        resourceInfoService.deleted(id);
        return ResultBuilder.ok(null);
    }
}
