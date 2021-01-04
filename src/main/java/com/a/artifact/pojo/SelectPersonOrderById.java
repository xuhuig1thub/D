package com.a.artifact.pojo;

import lombok.Data;

@Data
public class SelectPersonOrderById {
    private Integer uid;
    private String uname;
    private Integer oId;
    private String ordersn;

    // 省略setter和getter方法
//    @Override
//    public String toString() { // 为了方便查看结果，重写了toString方法
//        return "User[uid=" + uid + ",uname=" + uname +
//                ",oid=" + oId + ",ordersn=" + ordersn + "]";
//    }
}