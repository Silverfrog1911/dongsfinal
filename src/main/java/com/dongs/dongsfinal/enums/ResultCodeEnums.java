package com.dongs.dongsfinal.enums;


/**
 * Description:用来返回成功或者失败
 * Date: 2021/4/5
 */
public enum ResultCodeEnums {
    OK(0, "成功"),
    ERROR(-1, "失败");

    private Integer code;

    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    ResultCodeEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
