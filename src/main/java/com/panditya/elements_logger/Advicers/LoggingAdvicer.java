package com.panditya.elements_logger.Advicers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAdvicer {
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final void print(String s){
        System.out.println("\n".repeat(2)+"-".repeat(50)+s+"\n".repeat(2)+"-".repeat(50));
    }

    
    private Long getTimestamp(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddHHmmssSSSS");
        LocalDateTime now = LocalDateTime.now();
        return Long.valueOf(dtf.format(now));
       
    }

    private Long getTimestampFull(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YY-MM-dd-HH-mm-ss-SSSS");
        LocalDateTime now = LocalDateTime.now();
        return Long.valueOf(dtf.format(now));
       
    }


    /**
     * Advice that logs normal logging.
     * 
     *   "within(@com.panditya.elements_service_admin.Controllers.*(..))"+
        "|| within(@com.panditya.elements_service_admin.Services.*(..))"
     *
     * @param Controller
     * @param Services
     */
    @Pointcut(
         value
    = "execution(* com.panditya.elements_service_admin.Controllers.College..*.*(..))"+
     " || execution(* com.panditya.elements_service_admin.Services.College..*.*(..))"
    )
    public void allNormalLoggingRequiredPackages(){

    }

    /**
     * Advice that logs methods throwing exceptions.
     *
     * @param joinPoint join point for advice
     * @param e exception
    */
    @AfterThrowing(pointcut = "allNormalLoggingRequiredPackages()",throwing = "Exception")
    public void logIfThrowsAnyException(JoinPoint joinpoint , Throwable exception){
        print(" Error we catch in "+this.getClass().getName()+
        "Declaring Name "+joinpoint.getSignature().getDeclaringTypeName()+
        "Name "+joinpoint.getSignature().getName()
       // "Cause of Exception "+(exception.getCause() != null ? exception.getCause() : "Unknown cause")  
        );
    }

    /**   
     * Advice that log when any Method gets executed before and after if required 
     *
     * @param joinpoint join point for the Advice
     * @return result that returns the result generated
     * @throws Throwable throws if any exception needs to be thrown from advice
    */  
    @Around("allNormalLoggingRequiredPackages()")
    public Object logAllAround(ProceedingJoinPoint joinpoint)throws  Throwable{
        Long starttime = getTimestamp();
        print("Enter into "+
                "Declaring Name "+joinpoint.getSignature().getDeclaringTypeName()+
                "Name "+joinpoint.getSignature().getName()+
                //"Arguments "+(String[])joinpoint.getArgs()+
                "Timestamp "+starttime
            );

        try{
            Object result = joinpoint.proceed();
            print("Exit from "+
                "Declaring Name "+joinpoint.getSignature().getDeclaringTypeName()+
                "Name "+joinpoint.getSignature().getName()+
                "Result "+result.toString()+
                "Timestamp "+getTimestamp()+
                "Time Taken "+(getTimestamp()-starttime)            
            );
            return result;
        }catch (Exception ex){
            print("Error catched in "+
                    this.getClass().getName()+
                    "Declaring Name "+joinpoint.getSignature().getDeclaringTypeName()+
                    "Name "+joinpoint.getSignature().getName()+
                    "Timestamp "+getTimestamp()+
                    "Error "+ex.getMessage()+
                    "Time Taken "+(getTimestamp()-starttime)     
            );
            throw ex;
        }
    }



}
