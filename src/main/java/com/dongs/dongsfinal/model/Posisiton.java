package com.dongs.dongsfinal.model;

import java.io.Serializable;
import lombok.Data;
import org.springframework.stereotype.Repository;

/**
 * posisiton
 * @author 
 */
@Data
@Repository
public class Posisiton implements Serializable {
    private Integer posId;

    private Integer goodId;

    private Integer currentamount;

    private static final long serialVersionUID = 1L;
}