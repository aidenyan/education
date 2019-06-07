package com.jimmy.mvc.common.interceptor;

import com.jimmy.core.exception.SiteException;
import com.jimmy.dao.entity.SiteInfo;
import com.jimmy.dao.local.thread.SiteLocalThread;
import com.jimmy.service.SiteInfoService;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class SiteInterceptor implements HandlerInterceptor {
    private SiteInfoService siteInfoService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse httpServletResponse, Object o) throws Exception {
        StringBuffer url = request.getRequestURL();
        String domain = url.delete(url.length() - request.getRequestURI().length(), url.length()).append("/").toString();
        SiteInfo siteInfo = siteInfoService.findByDomain(domain);
        if (siteInfo == null) {
            throw new SiteException("site is not exist");
        }
        SiteLocalThread.setSiteId(siteInfo.getSiteId());
        List<SiteInfo> siteInfoList = null;
        if (siteInfo.getChildEnabled()) {
            siteInfoList = siteInfoService.listChild(siteInfo.getSiteId());
        } else {
            siteInfoList = new ArrayList<>();
            siteInfoList.add(siteInfo);
        }
        List<Long> siteIdList = new ArrayList<>();
        siteInfoList.forEach(site -> siteIdList.add(site.getSiteId()));
        SiteLocalThread.setSiteIdList(siteIdList);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    public void setSiteInfoService(SiteInfoService siteInfoService) {
        this.siteInfoService = siteInfoService;
    }
}
