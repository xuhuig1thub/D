package com.a.artifact.controller;

import com.a.artifact.pojo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * @author XXX
 * @site www.muddywater.com
 * @company muddywater .corp
 * @create 2020-12-30 1:36
 * 测试controller的线程安全性问题
 */
@RestController
@Scope(value = "singleton") // prototype singleton
//@Scope(value= ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Slf4j
public class TestController {

    private int var = 0; // 定义一个普通变量

    private static int staticVar = 0; // 定义一个静态变量

    @Value("${test-int}")
    private int testInt; // 从配置文件中读取变量

    ThreadLocal<Integer> tl = new ThreadLocal<>(); // 用ThreadLocal来封装变量

    @Autowired
    private User user; // 注入一个对象来封装变量

    @GetMapping(value = "/test_var")
    public String test() {
        tl.set(1);
        System.out.println("user.getAge()="+user.getAge()+"---user.hashCode()="+user.hashCode());
        user.setAge(user.getAge()+1);
        System.out.println("成员变量var=" + (++var) + "---静态变量staticVar=" + (++staticVar) + "---配置变量testInt=" + (++testInt)
                + "---ThreadLocal变量=" + tl.get()+"---注入变量user=" + user.getAge());
        return "成员变量var=" + var + "---静态变量staticVar=" + staticVar + "---配置testInt=" + testInt + "---ThreadLocal变量="
                + tl.get() + "---注入变量user=" + user.getAge()+"---Thread="+Thread.currentThread().getName();
    }

    public static void main(String[] args) {
        Integer a=129;
        Integer b=129;
        System.out.println(a==b);
    }
}
