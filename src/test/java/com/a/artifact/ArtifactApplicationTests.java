package com.a.artifact;

import com.a.artifact.config.Environment;
import com.a.artifact.controller.OneToOneController;
import com.a.artifact.mapper.PersonMaper;
import com.a.artifact.mapper.StudentMapper;
import com.a.artifact.pojo.Person;
import com.a.artifact.pojo.Student;
import com.alibaba.druid.pool.DruidDataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@MapperScan("com.a.artifact.mapper")
@RunWith(SpringRunner.class)
@PropertySources({@PropertySource("classpath:jdbc.properties"), @PropertySource("classpath:df.xixi")
        , @PropertySource("classpath:cf.yml")})
//@EnableConfigurationProperties(Environment.class)
//@ContextConfiguration(locations = {"classpath:*.xml"},classes = {WebSecurityConfig.class})
@SpringBootTest(classes = {ArtifactApplication.class})
@Ignore
class ArtifactApplicationTests {
//    private final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ArtifactApplicationTests.class);

    @Autowired
    StudentMapper stuMapper;
    @Autowired
    PersonMaper pMapper;
    //    @Autowired
    Environment env;

    //
//    public Student test1(){
//        Student stu=stuMapper.selectUsersa(6);
//        return stu;
//    }
//    @Test
//    void contextLoads() {
//    }
    @Test
    public void testt(@Value("${jdbc.url}") String a,@Value("${bb}") String b,@Value("${environment.dev.url:#{null}}")String c){
        log.error(">>>>>>"+a+"-"+b+"-" +c);
    }

    @Test
    public void test1() {
        //..测试内容
        Student stu = stuMapper.selectUsersa(2);
//        System.out.print("\n"+stu);
        log.error(stu.toString());
    }

    @Test
    public void testPersonMapper() {
       { Person p=new Person("JJ",null,25);
       Person p2=new Person("KK",null,25);
   int lastId=pMapper.insert(p);
   int lastId2=pMapper.insert(p2);
   log.error("----lastId={}-----{}---"+p.id+"---"+p2.id,lastId,lastId2);}
        List<Person> list = pMapper.getAll();
        log.error(list.toString());
    }

    @Test
    public void testSelectProvider() {
//      Person p=  pMapper.getUserByIdAndAge(129,25);
        Person p = pMapper.getUserByIdAndAge2(25, 125);
        log.error("-----" + p.toString());
    }

    @Test
    public void test2(@Value("${cc}") String a) {
        log.error("------{}-", a);
        {
            Student s = new Student(9, 124, "NOdicnnn");
            Student s1 = new Student(10, 2, "ragnnn");
            List list = new ArrayList();
            list.add(s);
            list.add(s1);
            stuMapper.insertStus(list);
        }
        List list = new ArrayList();
        list.add(2);
        list.add(122);
        int count = stuMapper.countByList(list);
        log.error("-----------------------{}", count);

    }
    @Test
    public void test3(){
        List<Student> list= stuMapper.getAll();
        System.out.print("--------\n"+list+"\n");
        for(Student s:list){
            log.error(s.toString());
        }
    }
    @Test
    public void testNIO() throws IOException, InterruptedException {
    new Thread(() ->{
        log.debug("server run");
        NIOServer server = new NIOServer();
        try {
            server. initServer(8000);
            server.listen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }).start();
    for( int i=0 ;i<10;i++){
        new Thread(new Runnable() {
            @Override
            public void run() {
                log.debug("run");
                NIOClient client = new NIOClient();
                try {
                    client.initClient("127.0.0.1",8000);
                    client.connect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();}
        new Thread(() ->{
            try {
                NIOFileCopy.openFileMapped("D:\\1111\\107530791_5.jpg");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
//        NIOServer server = new NIOServer();
//            server. initServer(8000);
//            server.listen();
        Thread.currentThread().sleep(100);
    }

    @Autowired
    private OneToOneController oto;

    @Test
    public void testDAO() {
        oto.test();
        oto.test2();
    }

    @Test
    public void testJDBC() throws SQLException, ClassNotFoundException {
        //加载数据库驱动
//        Class.forName("com.mysql.jdbc.Driver");
        //通过驱动管理类获取数据库连接
        Connection connection = DriverManager
                .getConnection("jdbc:mysql:///vueblog2?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai",
                        "root", "234@#$wer");
        //定义sql语句 ?表示占位符
        String sql = "insert into student values(12,123,'fddfdf')";
        //获取预处理statement
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //设置参数，第一个参数为sql语句中参数的序号（从1开始），第二个参数为设置的参数值
//        preparedStatement.setInt(1, 123);
        //向数据库发出sql执行查询，查询出结果集
        int restNum = preparedStatement.executeUpdate();
        log.error("----restNum{}", restNum);
        ResultSet rs = preparedStatement.executeQuery("SELECT LAST_INSERT_ID()");
        rs.next();
        System.out.print("-----" + rs.getObject(1) + "-----");
    }

    //    @Test
//    public void testAsser(){
//        //JUnit4.1.2后Assert过时，TestCase.assertEquals成为替代
//        //(期望结果,条件语句)
//        //("提示",true,条件语句)
////        TestCase.assertEquals(1, 1);
//    }
    @BeforeClass
    public void beforeClass() {
        log.error("@BeforeClass");
    }

    @Before
    public void testBefore() {
        //测试前执行
        log.error("@Before");
    }

    @After
    public void testAfter() {
        //测试结束后
        log.error("@After");
    }

    @AfterClass
    public void afterClass() {
        log.error("AfterClass");
    }


    @Resource
    DataSource dataSource;

    @Test
    public void testDruid() throws SQLException {
        System.out.println("数据源>>>>>>" + dataSource.getClass());
        Connection connection = dataSource.getConnection();

        System.out.println("连接>>>>>>>>>" + connection);
        System.out.println("连接地址>>>>>" + connection.getMetaData().getURL());

        DruidDataSource druidDataSource = (DruidDataSource) dataSource;
        System.out.println("druidDataSource 数据源最大连接数：" + druidDataSource.getMaxActive());
        System.out.println("druidDataSource 数据源初始化连接数：" + druidDataSource.getInitialSize());

        connection.close();
    }
}
