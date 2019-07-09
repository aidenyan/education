package com.jimmy.web.api.controller;

import com.github.pagehelper.PageHelper;
import com.jimmy.core.base.Page;
import com.jimmy.core.consts.PageConst;
import com.jimmy.dao.entity.MenuInfo;
import com.jimmy.dao.entity.TeacherStaffInfo;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.web.api.local.thread.MenuInfoLocalThread;
import com.jimmy.web.api.local.thread.TeacherLocalThread;

import java.util.ArrayList;
import java.util.List;

public class BaseController {

    public TeacherStaffInfo getTeacherStaffInfo() {
        return TeacherLocalThread.get();
    }

    public void setPage(Integer pageNo, Integer pageSize) {
        if (pageNo == null) {
            pageNo = PageConst.PAGE_FIRST;
        }
        if (pageSize == null) {
            pageSize = PageConst.PAGE_DEFAULT_SIZE;
        }
        PageHelper.startPage(pageNo, pageSize);
    }

    public <T> Page<T> getPageResult(List<T> resultList) {
        Page<T> resultPage = new Page();
        if (resultList instanceof com.github.pagehelper.Page) {
            com.github.pagehelper.Page page = (com.github.pagehelper.Page) resultList;
            resultPage.setPageNo(page.getPageNum());
            resultPage.setPageSize(page.getPageSize());
            resultPage.setTotal(page.getTotal());
            resultPage.setTotalPage(page.getPages());
        }
        resultPage.setResult(resultList);
        return resultPage;
    }


    public <T, E> Page<T> getPageResult(List<E> resultList,Convert<E,T> convert) {
        Page<T> resultPage = new Page();
        if (resultList instanceof com.github.pagehelper.Page) {
            com.github.pagehelper.Page page = (com.github.pagehelper.Page) resultList;
            resultPage.setPageNo(page.getPageNum());
            resultPage.setPageSize(page.getPageSize());
            resultPage.setTotal(page.getTotal());
            resultPage.setTotalPage(page.getPages());
        }
        resultPage.setResult(convert.convert(resultList));
        return resultPage;
    }

    public <T> Result<T> addAuthorityCodeList(Result<T> result) {
        List<MenuInfo> menuInfoList = MenuInfoLocalThread.get();
        List<String> authorityCodeList = new ArrayList<String>();
        for (MenuInfo tempMenuInfo : menuInfoList) {
            authorityCodeList.add(tempMenuInfo.getCode());
        }
        result.setAuthorityCodeList(authorityCodeList);
        return result;
    }

    ;

    public interface Convert<T,E> {
        List<E> convert(List<T> target);
    }
}
