package com.a.artifact.pojo;

import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

import lombok.Data;
@Alias("i")
@Data
@Component("hehe")
public class Idcard {
    private Integer id;
    private String code;

    // 省略setter和getter方法
    /**
     * 为方便测试，重写了toString方法
     */
    @Override
    public String toString() {
        return "Idcard [id=" + id + ",code=" + code + "]";
    }
}
