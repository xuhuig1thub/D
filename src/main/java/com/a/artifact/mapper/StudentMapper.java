package com.a.artifact.mapper;

import com.a.artifact.pojo.Student;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface StudentMapper {

    Student selectUsersa(int id);

    List<Student> getAll();

    int countByList(List<Integer> l);

    void insert(Student s);

    void insertStus(List<Student> s);

    void update(Student student);

    void delete(int id);

}
