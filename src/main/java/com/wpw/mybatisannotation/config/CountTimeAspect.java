package com.wpw.mybatisannotation.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 定义一个统计方法执行耗时的切面类，基于@Component注解注入到spring容器进行管理
 *
 * @author wpw
 */
@Aspect
@Component
@Slf4j
public class CountTimeAspect {
    /**
     * 首先定义一个切点
     */
    @org.aspectj.lang.annotation.Pointcut("@annotation(com.wpw.mybatisannotation.config.CountTime)")
    public void countTime() {
    }

    @Around("countTime()")
    public Object doAround(ProceedingJoinPoint joinPoint) {
        Object obj = null;
        try {
            long beginTime = System.currentTimeMillis();
            obj = joinPoint.proceed();
            //获取方法名称
            String methodName = joinPoint.getSignature().getName();
            //获取类名称
            String className = joinPoint.getSignature().getDeclaringTypeName();
            log.debug("类:[{}]，方法:[{}]耗时时间为:[{}]", className, methodName, System.currentTimeMillis() - beginTime + "毫秒");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return obj;
    }

}
