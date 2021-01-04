package com.a.artifact.mapper;

import com.a.artifact.pojo.Order;
import com.a.artifact.pojo.Perso;
import com.a.artifact.pojo.SelectPersonPOJO;
import com.a.artifact.pojo.SelectPersonOrderById;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("PersonDao")
//@Mapper
public interface PersoDao {
    Perso selectPersonById1(Integer id);

    Perso selectPersonById2(Integer id);

    SelectPersonPOJO selectPersonById3(Integer id);

    Perso selectUserOrdersById1(int id);

    Perso selectUserOrdersById2(int id);

    List<SelectPersonOrderById> selectUserOrdersById3(int id);

    List<Order> getOrders(Integer id);
}