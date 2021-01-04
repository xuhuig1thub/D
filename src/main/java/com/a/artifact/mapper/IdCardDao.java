package com.a.artifact.mapper;

import com.a.artifact.pojo.Idcard;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository("idCardDao")
@Mapper
public interface IdCardDao {
    Idcard selectCodeById(Integer i);
}