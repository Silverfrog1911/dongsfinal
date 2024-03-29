package com.dongs.dongsfinal.util;

import java.io.Serializable;


public class ResultVO<T> implements Serializable {
    private static final long serialVersionUID = -4414926978700453869L;

    private Integer code;


    private String msg;


    private T data;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
