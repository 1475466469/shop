package com.shop.shop.common;

import java.io.Serializable;

public class ResponseResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    //状态
    private Integer code;
    //消息
    private String msg;
    //数据
    private  T date;


}
