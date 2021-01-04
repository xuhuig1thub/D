package com.a.artifact.controller;

import com.a.artifact.config.DruidConfig;
import com.a.artifact.pojo.Person;
import com.a.artifact.pojo.Student;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc: 核心业务模块
 * @author: CSH
 **/
@RestController
@RequestMapping("/aopController")
public class AopController {

    @RequestMapping(value = "/Curry")
    public Object Curry(){
        System.out.println("库里上场打球了！！");
        return new Person(2,"niu","zhe",0);
    }

    @RequestMapping(value = "/Harden")
    public void Harden(){
        System.out.println("哈登上场打球了！！");
    }

    @RequestMapping(value = "/Antetokounmpo")
    public void Antetokounmpo(String aa,String bb,String cc,int dd){
        System.out.println("字母哥上场打球了！！");
    }

    @RequestMapping(value = "/Jokic")
    public void Jokic(){
        System.out.println("约基奇上场打球了！！");
    }

    @RequestMapping(value = "/Durant/{point}&{fds}")
    public void Durant(@PathVariable("point")  int point,@PathVariable("fds") int fds){
        System.out.println("杜兰特上场打球了！！"+point+"----"+fds);
    }
}