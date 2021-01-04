package com.a.artifact;

import com.a.artifact.mapper.StudentMapper;
import com.a.artifact.pojo.Student;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;

public class Test {
    private static Logger logger= LoggerFactory.getLogger(Test.class);
    public static void main(String[] args) throws IOException, JoranException {
//        String resource = "classpath:mybatis-config.xml";
//         根据 mybatis-config.xml 配置的信息得到 sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 然后根据 sqlSessionFactory 得到 session
        SqlSession session = sqlSessionFactory.openSession();
        // 最后通过 session 的 selectList() 方法调用 sql 语句 listStudent
//        List<Student> listStudent = session.selectList("selectUsers",2);
//        for (Student student : listStudent) {
//            System.out.println("ID:" + student.getId() + ",NAME:" + student.getName());
//        }
        StudentMapper stuMapper=session.getMapper(StudentMapper.class);
        Student stu = stuMapper.selectUsersa(2);
        System.out.println(stu);

//        logger.debug("--------errrrroooorrrrr{}",new Student());
//        Student st=new Student(6,0,"implicated");
//        stuMapper.update(st);
//        session.commit();
       List<Student> list= stuMapper.getAll();
        System.out.print("--------\n"+list+"\n");
       for(Student s:list){
           logger.error(s.toString());
       }
//       stuMapper.insert(new Student(7,99,"implication"));
//        stuMapper.insert(new Student(8,929,"failed to consider wider implications for the surrounding countryside"));
////        session.rollback();
        stuMapper.delete(3);
        session.commit();



    }

}
