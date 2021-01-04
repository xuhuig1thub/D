package com.a.artifact.exception;

/**
 * @author XXX
 * @site www.muddywater.com
 * @company muddywater .corp
 * @create 2020-12-20 22:06
 */
public class MyException extends RuntimeException{

    private String id;


    public MyException(String id,String message) {
        super(message);
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}