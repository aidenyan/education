package com.jimmy.web.api.controller.admin;

import com.jimmy.core.base.Page;
import com.jimmy.dao.entity.Dictionary;
import com.jimmy.dao.entity.DictionaryItem;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.mvc.common.model.dto.DictionaryDTO;
import com.jimmy.mvc.common.model.dto.DictionaryItemDTO;
import com.jimmy.mvc.common.model.transfer.DictionaryDTOTransfer;
import com.jimmy.mvc.common.model.transfer.DictionaryItemDTOTransfer;
import com.jimmy.service.DictionaryService;
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
@Api(value = "字典信息处理", description = "字典信息处理API")
@Controller
@RequestMapping("/admin/dictionary")
public class DictionaryController extends BaseController {
    @Autowired
    private DictionaryService dictionaryService;


    @ResponseBody
    @GetMapping("/page")
    @ApiOperation("字典的分页信息")
    public Result<Page<DictionaryDTO>> page(String name, Integer pageNo, Integer pageSize) {
        this.setPage(pageNo, pageSize);
        List<Dictionary> list = dictionaryService.list(name);
        Page<DictionaryDTO> resultList = getPageResult(list, target -> DictionaryDTOTransfer.INSTANCE.toDictionaryDTOList(target));
        return ResultBuilder.ok(resultList);
    }

    @ResponseBody
    @PostMapping("/save")
    @ApiOperation("保存字典信息")
    public Result<Void> save(@Validated @RequestBody DictionaryDTO dictionaryDTO) {
        dictionaryService.save(DictionaryDTOTransfer.INSTANCE.toDictionary(dictionaryDTO));
        return ResultBuilder.ok(null);
    }

    @ResponseBody
    @GetMapping("/item")
    @ApiOperation("字典详细的列表")
    public Result<List<DictionaryItemDTO>> info(Long id) {
        List<DictionaryItem> dictionaryItemList = dictionaryService.list(id);
        return ResultBuilder.ok(DictionaryItemDTOTransfer.INSTANCE.toDictionaryItemDTOList(dictionaryItemList));
    }

    @ResponseBody
    @PostMapping("/deleted/{id}")
    @ApiOperation("删除字典信息")
    public Result<Void> deleted(@PathVariable("id") Long id) {
        dictionaryService.deletedDictionary(id);
        return ResultBuilder.ok(null);
    }

    @ResponseBody
    @PostMapping("/item/deleted/{id}")
    @ApiOperation("删除字典信息")
    public Result<Void> deletedItem(@PathVariable("id") Long id) {
        dictionaryService.deletedDictionaryItem(id);
        return ResultBuilder.ok(null);
    }
}
