package com.a.artifact.controller;

import com.a.artifact.SameTenant;
import com.a.artifact.exception.MyException;
import com.a.artifact.mapper.StudentMapper;
import com.a.artifact.pojo.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RestController
public class BcController {
    @Autowired
    StudentMapper stuMapper;


    @Value("haha")
    @Valid
    @SameTenant
    private String s;
    @RequestMapping("/bc")
    public String bc() {


        Student stu=stuMapper.selectUsersa(6);
        System.out.println("@RequestMapping(\"/login\")"+stu.toString());
        return stu.toString();
    }

    @GetMapping("/testControllerAdvice")
    public Object hello(ModelMap mm) {
            return mm.get("myMap")+s;
        // return "success";
//        throw new MyException("12","haha");
        // return "hello";
    }
}
