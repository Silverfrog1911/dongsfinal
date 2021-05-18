package com.dongs.dongsfinal.enums;

public enum RedisPrefix {


    /**
     * 发送数量
     */
    //MESSAGE_SEND_TIMES("messageSendTimes"),//Example
    //;

    ;

    private String p;

    RedisPrefix(String p) {
        this.p = p;
    }

    public String getP() {
        return p;
    }
}
