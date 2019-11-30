package com.shop.shop.exception;

import com.shop.shop.enums.ShiroExceptionEnum;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ShrioException extends Exception {

    /**
     * 错误编码
     */
    private Integer code;

    /**
     * 错误的提示信息
     */
    private String errorMessage;

    public ShrioException(ShiroExceptionEnum exception) {
        super(exception.getMessage());
        this.code = exception.getCode();
        this.errorMessage = exception.getMessage();
    }




}
