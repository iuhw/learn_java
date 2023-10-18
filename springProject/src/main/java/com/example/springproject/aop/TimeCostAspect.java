package com.example.springproject.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author:
 */
@Slf4j
@Aspect
@Component
public class TimeCostAspect {

    @Around("execution(public * com.example.springproject.controller.*Controller.*(..))")
    public Object timeCost(ProceedingJoinPoint joinPoint) {
        long startTime = System.currentTimeMillis();
        try {
            Object proceed = joinPoint.proceed();
            return proceed;
        } catch (Throwable e) {
            log.error("{}", e);
        } finally {
            log.info("接口耗时:{}ms", System.currentTimeMillis() - startTime);
        }
        return null;
    }
}
