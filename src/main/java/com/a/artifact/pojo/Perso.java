package com.a.artifact.pojo;


import org.apache.ibatis.type.Alias;

import java.util.List;

import lombok.Data;

@Data
@Alias("p")
public class Perso {
    private Integer id;
    private String name;
    private Integer age;
    // 一对多级联查询，用户关联的订单
    private List<Order> ordersList;

    // 个人身份证关联
    private Idcard card;

    // 省略setter和getter方法


    @Override
    public String toString() {
        return "Perso{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", ordersList=" + ordersList +
                ", card=" + card +
                '}';
    }
}