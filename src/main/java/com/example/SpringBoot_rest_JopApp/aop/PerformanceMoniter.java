package com.example.SpringBoot_rest_JopApp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMoniter {

    private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceMoniter.class);

    @Around("execution(* com.example.SpringBoot_rest_JopApp.service.JobService.*(..))")
    public Object moniterTimeConsumed(ProceedingJoinPoint pjp) throws Throwable {
        long start,end;
        start = System.currentTimeMillis();

        Object obj = pjp.proceed();

        end = System.currentTimeMillis();
        long res = end - start;
        LOGGER.info("time take by the method: "+ pjp.getSignature().getName()+ " " + res + " ms");

        return obj;
    }

}
