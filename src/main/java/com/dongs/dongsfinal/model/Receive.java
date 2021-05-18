package com.dongs.dongsfinal.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import org.springframework.stereotype.Repository;

/**
 * receive
 * @author 
 */
@Data
@Repository
public class Receive implements Serializable {
    /**
     * 收货id
     */
    private Integer receiveId;

    private Integer goodId;

    private Integer purchaseId;

    private Integer realReceiveAmount;

    private Date receiveDate;

    private static final long serialVersionUID = 1L;
}