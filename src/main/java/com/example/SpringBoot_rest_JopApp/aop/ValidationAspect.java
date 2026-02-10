package com.example.SpringBoot_rest_JopApp.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);

    @Around("execution(* com.example.SpringBoot_rest_JopApp.service.JobService.getJob(..)) && args(id)")
    public Object validateInput(ProceedingJoinPoint pjp,int id) throws Throwable {

        if(id < 0){
            LOGGER.info("oops the value is negative let me update it "+ id);
            id = -id;
            LOGGER.info("New update value "+ id);

        }

        Object obj = pjp.proceed(new Object[]{id});

        return obj;

    }


}
