package com.udith.mycontacts.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ContactLogger {

//  @Pointcut("execution(* com.udith.mycontacts.bo.ContactBO.saveContact(..))")
//  public void contact(){
//  }
  

  @Before("execution(* com.udith.mycontacts.bo.ContactBO.saveContact(..))")
  public void startLogger(){
    System.out.println("Logging:going to call saveContact() method in ContactBOImpl class...");
  }

  @AfterReturning("execution(* com.udith.mycontacts.bo.ContactBO.saveContact(..))")
  public void finishLogger(){
    System.out.println("Logging: call ended to  saveContact() method in ContactBOImpl class... ");
  }

  @AfterThrowing("execution(* com.udith.mycontacts.bo.ContactBO.saveContact(..))")
  public void errorLogger(){
     System.out.println("Logging: exception occured from  saveContact() method in ContactBOImpl class... ");
  }


    @Around("execution(* com.udith.mycontacts.bo.ContactBO.saveContact(..))")
    public void logSaveContact(ProceedingJoinPoint jointpoint){

        try {
          System.out.println("Logging:going to call saveContact() method in ContactBOImpl class...");
          long startTime = System.currentTimeMillis();
          jointpoint.proceed();
          long endTime = System.currentTimeMillis();
          System.out.println("Logging: call ended to  saveContact() method in ContactBOImpl class... ");
          System.out.println("Logging: saveContact() method in ContactBOImpl class took " + (endTime - startTime) + " milliseconds");

        } catch (Throwable ex) {
           System.out.println("Logging: exception occured from  saveContact() method in ContactBOImpl class... ");
        }
    }

}
