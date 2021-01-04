package com.a.artifact.pojo;

import java.util.List;

import lombok.Data;

@Data
public class Product {
    private Integer id;
    private String name;
    private Double price;
    // 多对多中的一个一对多
    private List<Order> orders;
}
