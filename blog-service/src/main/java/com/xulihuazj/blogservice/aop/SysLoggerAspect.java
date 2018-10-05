package com.xulihuazj.blogservice.aop;

import com.xulihuazj.blogservice.data.SysLogDO;
import com.xulihuazj.blogservice.service.LoggerService;
import com.xulihuazj.blogservice.util.HttpUtils;
import com.xulihuazj.blogservice.util.UserUtils;
import com.xulihuazj.common.annotation.SysLogger;
import com.xulihuazj.common.utils.JSONHelper;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;

@Aspect
@Component
public class SysLoggerAspect {

    @Autowired
    private LoggerService loggerService;

    @Pointcut("@annotation(com.xulihuazj.common.annotation.SysLogger)")
    public void loggerPointCut() {

    }

    @Before("loggerPointCut()")
    public void saveSystemLog(JoinPoint joinpoint) {
        // 获取被注解的方法
        MethodSignature signature = (MethodSignature) joinpoint.getStaticPart();
        Method method = signature.getMethod();

        SysLogDO sysLog = new SysLogDO();
        SysLogger logAnnotation = method.getAnnotation(SysLogger.class);
        if (null != logAnnotation) {
            // 注解上的描述
            sysLog.setOperation(logAnnotation.value());
        }
        // 请求的方法名称
        String className = joinpoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        sysLog.setMethod(className + "." + methodName + "（）");
        // 方法上的参数
        Object[] args = joinpoint.getArgs();
        String params = "";
        for (Object obj : args) {
            params += JSONHelper.toJoson(obj);
        }
        if (StringUtils.isNotBlank(params)) {
            sysLog.setParams(params);
        }
        // 设置IP地址
        sysLog.setIp(HttpUtils.getIpAddress());
        // 用户名
        String username = UserUtils.getCurrentPrinciple();
        if (StringUtils.isNotBlank(username)) {
            sysLog.setUsername(username);
        }
        // 创建时间
        sysLog.setCreateTime(new Date());
        this.loggerService.saveLog(sysLog);
    }

}
