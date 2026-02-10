package com.example.SpringBoot_rest_JopApp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    //return type full-qualified-class-name.method-name(args)
    @Before("execution(* com.example.SpringBoot_rest_JopApp.service.JobService.*(..))")
    public void logMethodCalled(JoinPoint jp){
        LOGGER.info("Method called " + jp.getSignature().getName());
    }

    //we can also use
    //AfterReturning (executes only when method executes successfully)
    //AfterThrowing (executes only when we have issue )
    //After (it work as a finally executes all the time )
    @After("execution(* com.example.SpringBoot_rest_JopApp.service.JobService.*(..))")
    public void logMethodExecuted(JoinPoint jp){
        LOGGER.info("Method Executed " + jp.getSignature().getName());
    }
}
