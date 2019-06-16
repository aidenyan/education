package com.jimmy.mvc.common.controller;

import com.jimmy.common.utils.DateUtils;
import com.jimmy.common.utils.FileUtils;
import com.jimmy.core.exception.ParamterException;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.mvc.common.config.FilePathConfig;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName: CommonController
 * @Description:
 * @author: aiden
 * @date: 2019/6/16/016.
 */
@Api(tags = "公共信息接口", description = "公共信息接口")
@Controller
@RequestMapping("/admin/common")
public class CommonController {
    @Autowired
    private FilePathConfig filePathConfig;

    @PostMapping("/update_file")
    @ResponseBody
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
