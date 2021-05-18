package com.dongs.dongsfinal.model;

import java.io.Serializable;
import lombok.Data;
import org.springframework.stereotype.Repository;

/**
 * storage
 * @author 
 */
@Data
@Repository
public class Storage implements Serializable {
    /**
     * 商品id
     */
    private Integer goodId;

    /**
     * 商品数量
     */
    private Integer goodAmount;

    /**
     * 商品名字
     */
    private String goodName;

    /**
     * 商品编码
     */
    private String sku;

    private static final long serialVersionUID = 1L;
}