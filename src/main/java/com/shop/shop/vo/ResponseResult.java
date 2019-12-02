package com.shop.shop.vo;

import lombok.Data;

import java.io.Serializable;


@Data
public class ResponseResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    //状态
    private Integer code;
    //消息
    private String msg;
    //数据
    private  T data;



}
