package com.jimmy.mvc.common.aop;

import com.alibaba.fastjson.JSON;
import com.jimmy.common.utils.ObjectUtils;
import com.jimmy.common.utils.StringUtils;
import com.jimmy.core.anno.DisabledLog;
import com.jimmy.core.anno.LogInfo;
import com.jimmy.core.enums.OperationSysEnum;
import com.jimmy.core.local.thread.LogInfoLocalThread;
import com.jimmy.core.local.thread.OperationSysLocalThread;
import com.jimmy.core.local.thread.SysLogUuidLocalThread;
import com.jimmy.dao.entity.SysLogInfo;
import com.jimmy.mvc.common.local.thread.RequestLocalThread;
import com.jimmy.mvc.common.utils.BeanUtils;
import com.jimmy.mvc.common.utils.IpUtils;
import com.jimmy.service.SysLogInfoService;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wuyao
 * @date 2017年4月2日 上午09:22:33
 */
@Aspect
@Component
public class LogAop {
    Logger logger = Logger.getLogger(LogAop.class);
    /**
     * 默认忽略参数
     */
    private static final String[] DEFAULT_IGNORE_PARAMETERS = new String[]{"password", "rePassword", "currentPassword"};
    /**
     * 忽略参数
     */
    private String[] ignoreParameters = DEFAULT_IGNORE_PARAMETERS;
    @Autowired
    private SysLogInfoService sysLogInfoService;


    @Around("@annotation(transactional)")
    public Object aroundServiceLogInfo(ProceedingJoinPoint joinPoint, Transactional transactional) throws Throwable {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        LogInfo logInfo = method.getAnnotation(LogInfo.class);
        Object obj = null;
        LogInfo logInfoLocal = LogInfoLocalThread.get();
        DisabledLog disabledLog = method.getAnnotation(DisabledLog.class);
        if (disabledLog == null && logInfo == null && logInfoLocal != null && !transactional.readOnly()) {
            obj = dealSysLog(joinPoint, logInfoLocal, method, 1);
        } else {
            obj = joinPoint.proceed(joinPoint.getArgs());
        }
        return obj;
    }

    /**
     * 前置通知 用于拦截使用LogInfo注解的方法
     *
     * @param joinPoint 切点
     */
    @Around("@annotation(logInfo)")
    public Object aroundLogInfo(ProceedingJoinPoint joinPoint, LogInfo logInfo) throws Throwable {
        Object obj = null;
        LogInfo logInfoLocal = LogInfoLocalThread.get();
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        if (logInfoLocal == null) {
            LogInfoLocalThread.set(logInfo);
        }
        DisabledLog disabledLog = method.getAnnotation(DisabledLog.class);
        if (logInfo != null && disabledLog == null) {
            obj = dealSysLog(joinPoint, logInfo, method, 0);
        } else {
            obj = joinPoint.proceed(joinPoint.getArgs());
        }
        return obj;
    }

    private Object dealSysLog(ProceedingJoinPoint joinPoint, LogInfo logInfo, Method method, Integer logType) throws Throwable {
        Object obj = joinPoint.proceed(joinPoint.getArgs());
        SysLogInfo sysLogInfo = new SysLogInfo();
        sysLogInfo.setOperationUuid(SysLogUuidLocalThread.get());
        OperationSysEnum sysEnum = OperationSysLocalThread.get();
        if (sysEnum != null) {
            sysLogInfo.setOperationSys(sysEnum.getCode());
        }
        try {
            HttpServletRequest request = RequestLocalThread.get();
            if (request != null) {
                String ip = IpUtils.getIP(request);
                sysLogInfo.setOperationIp(ip);
            }
            sysLogInfo.setOperationContent(logInfo.operation().getDesc());
            String[] paramterArray = null;
            if (joinPoint.getArgs() != null && joinPoint.getArgs().length > 0) {
                paramterArray = BeanUtils.getParamterName(method);
                Map<String, Object> paramMap = new HashMap<String, Object>();
                Object[] paramObj = joinPoint.getArgs();
                if (paramterArray != null) {
                    for (int i = 0; i < paramterArray.length; i++) {
                        if (!(paramObj[i] instanceof ServletRequest) && !(paramObj[i] instanceof ServletResponse) && !(paramObj[i] instanceof BindingResult)) {
                            paramMap.put(paramterArray[i], paramObj[i]);
                        }

                    }
                    sysLogInfo.setOperationContent(JSON.toJSONString(paramMap));
                } else {
                    if (paramObj != null) {
                        List<Object> paramList = new ArrayList<Object>();
                        for (Object tempObj : paramObj) {

                            if (!(tempObj instanceof ServletRequest) && !(tempObj instanceof ServletResponse) && !(tempObj instanceof BindingResult)) {
                                paramList.add(tempObj);
                            }
                        }
                        sysLogInfo.setOperationDetail(JSON.toJSONString(paramList));
                    }
                }
            }
            if (StringUtils.isNotBlank(logInfo.param())) {
                Object value = ObjectUtils.getMethodParamValue(logInfo.param(), method, paramterArray, joinPoint.getArgs());
                if (value != null) {
                    sysLogInfo.setObjId(JSON.toJSONString(value));
                }

            }
            sysLogInfo.setOperationCode(logInfo.operation().getCode().toString());
            sysLogInfo.setObjType(logInfo.type().getCode());
            sysLogInfo.setSign(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
            sysLogInfo.setLogType(logType);

            if (obj != null) {
                sysLogInfo.setOperationResult(JSON.toJSONString(obj));
            }
            sysLogInfoService.insert(sysLogInfo);
        } catch (Throwable ex) {
            sysLogInfo.setOperationResult(ex.getMessage());
            sysLogInfoService.insert(sysLogInfo);
            ex.printStackTrace();
            logger.error("", ex);
        }
        return obj;
    }

}