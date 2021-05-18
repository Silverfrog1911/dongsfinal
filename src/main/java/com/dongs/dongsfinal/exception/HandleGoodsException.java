package com.dongs.dongsfinal.exception;

import com.dongs.dongsfinal.util.ResultUtils;
import com.dongs.dongsfinal.util.ResultVO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * Description: 全局异常处理
 */
@ControllerAdvice
public class HandleGoodsException {

    @ExceptionHandler(GoodsException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResultVO handlerSellException(GoodsException e) {
        return ResultUtils.error(e.getCode() , e.getMessage());
    }
}