package com.a.artifact.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Setter
@Getter
public   class Student {
    public Student() {
        System.out.println("public Student()-BrokerAspect()");
    }

    public Student(int id, int studentID, String name) {
        this.id = id;
        this.studentID = studentID;
        this.name = name;
    }

    public int id;
    public int studentID;
    public String name;

    @Override
    public String toString() {
        log.info("hahahahaahahahahahahaahahahahah");
        return "Student{" +
                "id=" + id +
                ", studentID=" + studentID +
                ", name='" + name + '\'' +
                '}';
    }
}