package com.a.artifact.pojo;

import java.util.List;

import lombok.Data;

@Data
public class Order {
    private Integer id;
    private String ordersn;
    // 多对多中的另一个一对多
    private List<Product> products;
    private int userId;
    private Perso perso;

}