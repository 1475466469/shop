package com.shop.shop.util;

import com.shop.shop.vo.ResponseResult;

public class ResultVOUtil {

    public static ResponseResult success(Object object) {
        ResponseResult resultVO = new ResponseResult();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }

    public static ResponseResult success() {
        return success(null);
    }

    public static ResponseResult error(Integer code, String msg) {
        ResponseResult resultVO = new ResponseResult();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }
}
