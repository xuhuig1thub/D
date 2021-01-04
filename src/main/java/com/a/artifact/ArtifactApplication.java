package com.a.artifact;

import com.a.artifact.mapper.StudentMapper;
import com.a.artifact.pojo.Student;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationImportSelector;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@MapperScan("com.a.artifact.mapper")
@SpringBootApplication
public class ArtifactApplication implements CommandLineRunner {

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext run = SpringApplication.run(ArtifactApplication.class, args);
        String[] beanDefinitionNames = run.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println("778899"+name);
        }
        AutoConfigurationImportSelector autoConfigurationImportSelector = (AutoConfigurationImportSelector)run.getBean("AutoConfigurationImportSelector");
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//
        // 然后根据 sqlSessionFactory 得到 session
//        SqlSession session = sqlSessionFactory.openSession();
//        // 最后通过 session 的 selectList() 方法调用 sql 语句 listStudent
//        List<Student> listStudent = session.selectList("selectUsers",2);
//        for (Student student : listStudent) {
//            System.out.println("ID:" + student.getId() + ",NAME:" + student.getName());
//        }
//        StudentMapper stuMapper=session.getMapper(StudentMapper.class);
//        if(null==stuMapper){
//            System.out.print("stuMapper =null");
//        }if(null!=stuMapper){
//            System.out.print(stuMapper.toString());
//
//        }
//
//        Student stu = stuMapper.selectUsersa(2);
//        System.out.println(stu);
//        Test1 test=new Test1();
//        Student s=test.test1();
//        System.out.print(s);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("args="+args[0]+"\n==================");
    }
}
