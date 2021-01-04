package com.a.artifact.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
   public int id;
    public String name;
    public String tittle;
    public int age;

    public Person() {
    }

    public Person(int id, String name, String tittle, int age) {
        this.id = id;
        this.name = name;
        this.tittle = tittle;
        this.age = age;
    }

    public Person(String name, String tittle, int age) {
        this.name = name;
        this.tittle = tittle;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tittle='" + tittle + '\'' +
                ", age=" + age +
                '}';
    }
}
