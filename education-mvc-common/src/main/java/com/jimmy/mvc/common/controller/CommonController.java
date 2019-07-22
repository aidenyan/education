package com.jimmy.mvc.common.controller;

import com.jimmy.common.utils.DateUtils;
import com.jimmy.common.utils.FileUtils;
import com.jimmy.core.exception.ParamterException;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.mvc.common.config.FilePathConfig;
import com.jimmy.mvc.common.model.dto.StreamDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName: CommonController
 * @Description:
 * @author: aiden
 * @date: 2019/6/16/016.
 */
@Api(value = "公共信息接口", description = "公共信息接口")
@Controller
@RequestMapping("/education/common")
public class CommonController {
    @Autowired
    private FilePathConfig filePathConfig;


    @ApiOperation("上传文件")
    @PostMapping("/update_stream")
    @ResponseBody
    public Result<String> updateFile(@RequestBody @Validated StreamDTO streamDTO) {
        Result<String> result = null;

        try {
            String headerUrl = FileUtils.saveFile(filePathConfig.getFilePath(), "/base/" + DateUtils.getCurrentDateString() + "/", streamDTO.getContent(), streamDTO.getType());
            result = ResultBuilder.ok(headerUrl);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ParamterException("写入文件失败！");
        }
        return result;
    }

    @ApiOperation("上传文件")
    @PostMapping("/update_file")
    @ResponseBody
    @ApiImplicitParams({@ApiImplicitParam(required = true, paramType = "header", value = "token", name = "token")})
    public Result<String> updateFile(@RequestParam("file") MultipartFile multipartFile, String name) {
        Result<String> result = null;
        if (multipartFile != null) {
            try {
                String fileType = multipartFile.getOriginalFilename();
                fileType = fileType.substring(fileType.lastIndexOf("."));
                String headerUrl = FileUtils.saveFile(filePathConfig.getFilePath(), "/" + name + "/" + DateUtils.getCurrentDateString() + "/", multipartFile.getInputStream(), fileType);
                result = ResultBuilder.ok(headerUrl);
            } catch (Exception e) {
                throw new ParamterException("写入文件失败！");
            }
        } else {
            result = ResultBuilder.ok(null);
        }
        return result;
    }

}
