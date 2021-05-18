package com.dongs.dongsfinal.model;

import java.io.Serializable;
import lombok.Data;
import org.springframework.stereotype.Repository;

/**
 * purchase
 * @author 
 */
@Data
@Repository
public class Purchase implements Serializable {
    /**
     * 订单id
     */
    private Integer purchaseId;

    /**
     * 商品名
     */
    private String goodName;

    /**
     * 订单状态
     */
    private String purchaseStatus;

    /**
     * 收货人
     */
    private String receiver;

    /**
     * 应收数量
     */
    private Integer shouldReceiveAmount;

    /**
     * 商品编码
     */
    private String sku;

    private static final long serialVersionUID = 1L;
}