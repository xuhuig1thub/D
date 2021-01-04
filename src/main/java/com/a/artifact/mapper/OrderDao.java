package com.a.artifact.mapper;

import com.a.artifact.pojo.Order;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface OrderDao {
    List<Order> selectOrdersById(Integer uid);

    List<Order> selectallOrdersAndProducts(int uid);
}