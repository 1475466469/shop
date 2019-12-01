package com.shop.shop.enums;



public enum ShiroExceptionEnum {

    NOT_LOGIN(400,"用户未登陆");


    ShiroExceptionEnum(Integer code,String message){
        this.code=code;
        this.message=message;
    }
    private Integer code;
    private  String message;

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
