package com.sumutella.departmentcrud.aspects;

import com.sumutella.departmentcrud.entities.ApplicationLog;
import com.sumutella.departmentcrud.services.ApplicationLogServiceInterface;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author sumutella
 * @time 8:36 PM
 * @since 11/7/2019, Thu
 */
@Component
@Aspect
public class AroundAspect {
    @Autowired
    private ApplicationLogServiceInterface applicationLogService;




    @Around("execution(* com.sumutella.departmentcrud.controllers.*.*(..))")
    private Object anyMethodMoreThan2SecondRuntime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        String methodSignature = proceedingJoinPoint.getSignature().toShortString();

        Object[] methodArguments = proceedingJoinPoint.getArgs();

        long begin = System.currentTimeMillis();

        Object result = proceedingJoinPoint.proceed();

        long end = System.currentTimeMillis();

        double duration = ((end-begin)/1000.0);

        if (duration>1.5){
            StringBuilder sb = new StringBuilder();
            for (Object arg : methodArguments) {
                sb.append(arg+" ");
            }

            ApplicationLog applicationLog = new ApplicationLog();

            applicationLog.setParameters(sb.toString());
            applicationLog.setMethodName(methodSignature);
            applicationLog.setReturnObject(result.toString());
            applicationLog.setDuration(duration+"");

            applicationLogService.save(applicationLog);

        }

        return result;
    }

}
