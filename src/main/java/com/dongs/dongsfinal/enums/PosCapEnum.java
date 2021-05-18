package com.dongs.dongsfinal.enums;

/**
 * Description:用来返回货架容量
 * Date: 2021/4/27
 */
public enum PosCapEnum {

    CAPACITY(20);

    Integer Shelfcapacity;

    public Integer getShelfcapacity() {
        return Shelfcapacity;
    }

    public void setShelfcapacity(Integer shelfcapacity) {
        Shelfcapacity = shelfcapacity;
    }

    PosCapEnum(Integer Shelfcapacity){
        this.Shelfcapacity = Shelfcapacity;
    }

}
