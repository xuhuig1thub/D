package com.a.artifact.mapper;

import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class SqlProvider {
    public String selectUser(Map<String,Object> m) {
              return  new SQL(){{
                  SELECT("*");
                  FROM("person");
                  WHERE("id="+m.get("idd")+" and a_ge="+m.get("agee"));
              }}.toString();
          }
    public String selectUser2(Map<String,Object> m) {
        return  new SQL(){{
            SELECT("*");
            FROM("person");
            WHERE("id="+m.get("id"));
            WHERE("a_ge="+m.get("age"));
        }}.toString();
    }

}
