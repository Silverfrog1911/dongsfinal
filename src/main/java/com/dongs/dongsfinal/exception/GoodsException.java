package com.dongs.dongsfinal.exception;



import com.dongs.dongsfinal.enums.ExceptionCodeEnums;
import lombok.Data;

@Data
public class GoodsException extends RuntimeException {

    private Integer code;

    public GoodsException(ExceptionCodeEnums exceptionCodeEnums) {
        super(exceptionCodeEnums.getMsg());
        this.code = exceptionCodeEnums.getCode();
    }

    public GoodsException(ExceptionCodeEnums exceptionCodeEnums, String msg) {
        super(msg);
        this.code = exceptionCodeEnums.getCode();
    }

}
