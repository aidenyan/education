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
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Api(tags = "��Դ��Ϣ", description = "��Դ��Ϣ")
@Controller
@RequestMapping("/admin/resource")
public class ResourceController {
    @Autowired
    private ResourceInfoService resourceInfoService;

    @ResponseBody
    @GetMapping("/list/type")
    @ApiOperation("��Դ���͵��б�")
    public Result<List<ResourceTypeEnum>> listType() {
        return ResultBuilder.ok(Arrays.asList(ResourceTypeEnum.values()));
    }

    @ResponseBody
    @GetMapping("/list/resour")
    @ApiOperation("������Դ���ͻ�ȡ��Դ�б�")
    public Result<List<ResourceInfoDTO>> listType(ResourceTypeEnum resourceType) {
        if (resourceType == null) {
            return ResultBuilder.error(ResultCoreEnum.RESULT_PARAMETER_EXCEPTION);
        }
        List<ResourceInfo> resourceInfoList = resourceInfoService.list(resourceType.getValue());
        return ResultBuilder.ok(ResourceInfoDTOTransfer.INSTANCE.toResourceInfoDTOList(resourceInfoList));
    }
}
