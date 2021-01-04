package com.a.artifact.mapper;

import com.a.artifact.pojo.Person;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
@Repository
@Mapper
public interface PersonMaper {


    //    @Results({
//            @Result(property = "userSex",  column = "user_sex", javaType = UserSexEnum.class),
//            @Result(property = "nickName", column = "nick_name")
//    })
    @Results(id = "person", value = {@Result(id = true, column = "id", property = "id"),
            @Result(column = "na_me", property = "name"),
            @Result(column = "title", property = "tittle"),
            @Result(column = "a_ge", property = "age")})
    @Select("SELECT * FROM person")
    List<Person> getAll();

    @SelectProvider(type=SqlProvider.class,method = "selectUser")
    @ResultMap("person")
    Person getUserByIdAndAge(@Param("idd")int id, @Param("agee")int age);

    @SelectProvider(type=SqlProvider.class,method="selectUser2")
    @Options(useCache = true,flushCache =Options.FlushCachePolicy.FALSE,timeout = 1000)
    @ResultMap("person")
    Person getUserByIdAndAge2(int age,int id);

    @SelectKey(statement = "select last_insert_id()", before = false, keyProperty = "id", resultType = Integer.class)
    @Insert("INSERT INTO person(na_me,title,a_ge) VALUES(#{name}, #{tittle},#{age})")
//    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    int insert(Person p);

     @Update(" UPDATE    student set")
    void update(Person p);

}
