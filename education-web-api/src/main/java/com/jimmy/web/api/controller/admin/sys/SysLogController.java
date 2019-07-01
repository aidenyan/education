package com.jimmy.web.api.controller.admin.sys;

import com.github.pagehelper.Page;
import com.jimmy.dao.entity.SysLogInfo;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.mvc.common.enums.ResultCodeEnum;
import com.jimmy.mvc.common.model.enums.LogTypeEnum;
import com.jimmy.mvc.common.model.enums.OperationSysEnum;
import com.jimmy.service.SysLogInfoService;
import com.jimmy.web.api.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Api(tags = "ϵͳ��Ϣ��־ģ��", description = "ϵͳ��Ϣ��־ģ��API")
@Controller
@RequestMapping("/admin/sys/log")
public class SysLogController extends BaseController {

    @Autowired
    private SysLogInfoService sysLogInfoService;


    @ResponseBody
    @GetMapping("/operation_sys")
    @ApiOperation("����ϵͳ����Ϣ")
    public Result<List<OperationSysEnum>> operationSysList() {
        List<OperationSysEnum> operationSysList = Arrays.asList(OperationSysEnum.values());
        return ResultBuilder.ok(operationSysList);
    }

    @ResponseBody
    @GetMapping("/log_type")
    @ApiOperation("������Ϣ������")
    public Result<List<LogTypeEnum>> logTypeList() {
        List<LogTypeEnum> logTypeList = Arrays.asList(LogTypeEnum.values());
        return ResultBuilder.ok(logTypeList);
    }

    @ResponseBody
    @GetMapping("/page")
    @ApiOperation("������Ϣ������")
    public Result<Page<SysLogInfo>> logTypeList(Date startDate, Date endDate, Integer operationSys, Integer logType, Integer pageNo, Integer pageSize) {
        this.setPage(pageNo, pageSize);
        List<SysLogInfo> list = sysLogInfoService.list(startDate, endDate, operationSys, logType);
        Result<Page<SysLogInfo>> result = getPageResult(list, ResultCodeEnum.OK);
        return result;
    }
    @ResponseBody
    @GetMapping("/info")
    @ApiOperation("��ϸ��Ϣ")
    public Result<SysLogInfo> info(Long id) {

        SysLogInfo sysLogInfo = sysLogInfoService.findById(id);
        return ResultBuilder.ok(sysLogInfo);
    }
}
