package com.a.artifact.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author XXX
 * @site www.muddywater.com
 * @company muddywater .corp
 * @create 2020-10-27 3:26
 */
@Aspect
@Component
@Order(1)
public class NiceAspect {
    public NiceAspect() {
        System.out.println("Constructor-NiceAspect()");
    }

    @Pointcut("args(java.lang.String,java.lang.String,java.lang.String,int)")
    public void pc(){
        System.out.print("bAspect()");
    }

    @Before("pc()")
    public void sdfsf(){
        System.out.println("@Before(\"bAspect()\")");
    }
}
