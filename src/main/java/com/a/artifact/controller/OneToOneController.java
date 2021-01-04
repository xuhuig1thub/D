package com.a.artifact.controller;

import com.a.artifact.mapper.OrderDao;
import com.a.artifact.mapper.PersoDao;
import com.a.artifact.pojo.Order;
import com.a.artifact.pojo.Perso;
import com.a.artifact.pojo.SelectPersonPOJO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Component("oneToOneController")
public class OneToOneController {
    @Autowired
    private PersoDao persoDao;
    @Autowired
    private OrderDao orderDao;

    public void test() {
        Perso p1 = persoDao.selectPersonById1(2);
        System.out.println(p1);
        System.out.println("=============================");
        Perso p2 = persoDao.selectPersonById2(3);
        System.out.println(p2);
        System.out.println("=============================");
        SelectPersonPOJO p3 = persoDao.selectPersonById3(4);
        System.out.println(p3);
        log.error(persoDao.selectUserOrdersById1(2) + "\n================");
        log.error(persoDao.selectUserOrdersById2(3) + "\n================");
        log.error(persoDao.selectUserOrdersById3(0) + "\n================");
    }

    public void test2() {
        log.error("order==null?"+(null==orderDao));
        List<Order> os = orderDao.selectallOrdersAndProducts(2);
        for (Order orders : os) {
            System.out.println(orders);
        }
    }
}