package com.a.artifact.aop;


import com.a.artifact.config.DruidConfig;
import com.a.artifact.pojo.Student;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @desc: 经纪人切面
 * @author: CSH
 **/
@Aspect
@Component("dada")
@Order(-2)
@Lazy
public class BrokerAspect {
    @Qualifier("ss")
    Student s;

    @Autowired
    public void  s(){
        s= new Student();
    }

    @PostConstruct
    public void a(){
        System.out.println("@PostConstruct-BrokerAspect()");
    }
    @PreDestroy
    public void b(){
        System.out.println("@PreDestroy-BrokerAspect()");
    }
    public BrokerAspect() {
        System.out.println("Constructor-BrokerAspect()");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize()r-BrokerAspect()");
    }

    /**
     * 定义切入点，切入点为com.example.demo.aop.AopController中的所有函数
     *通过@Pointcut注解声明频繁使用的切点表达式
     */
//    @Pointcut("execution(public * com.a.artifact.controller.AopController.*(..)))")
    @Pointcut("within(com.a.artifact.controller.AopController)")
    public void aAspect(){
        System.out.print("aAspect()");
    }

    @Pointcut("execution(public * com.a.artifact.controller.AopController.Durant(..)) && args(int,int))")
    public void c(){ }
    /** @description  使用环绕通知*/
    @Around("c()")
    public void c(ProceedingJoinPoint pjp ) throws Throwable {
        try{
            System.out.println("invoker is "+pjp.getTarget().getClass().getName());
            System.out.println(pjp.getArgs().length);
            for (Object o :
                    pjp.getArgs()) {
                System.out.println(o);
            }
            pjp.proceed();
            System.out.println("going to finish");
        }
        catch(Throwable e){
            System.out.println("异常通知：球迷要求退票！");
        }
    }


    /**
     * @description  在连接点执行之前执行的通知
     */
    @Before("aAspect()")
    public void doBefore(){
        System.out.println("@Before(\"aAspect()\")");
    }

    /**
     * @description  在连接点执行之后执行的通知（返回通知和异常通知的异常）
     */
    @After("aAspect()")
    public void doAfter(){
        System.out.println("@After(\"aAspect()\")");
//        DruidConfig.testArgs("",null);
    }

    /**
     * @description  在连接点执行之后执行的通知（返回通知）
     */
    @AfterReturning("aAspect()")
    public void doAfterReturning(){
        System.out.println("@AfterReturning(\"aAspect()\")");
    }

    /**
     * @description  在连接点执行之后执行的通知（异常通知）
     */
    @AfterThrowing("aAspect()")
    public void doAfterThrowing(){
        System.out.println("@AfterThrowing(\"aAspect()\")");
    }


}