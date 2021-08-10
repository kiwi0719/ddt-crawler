package com.xjx.ddtcrawler.exception;

import com.xjx.ddtcrawler.vo.ResultCodeConstant;

import java.io.Serializable;

/**
 * @author XieJiaxing
 * @date 2021/8/1 22:52
 */
public class MyException extends Exception implements Serializable {
    private static final long serialVersionUID = 2625531273324815042L;
    private Integer code;

    public MyException() {
        this.code = ResultCodeConstant.CodeEnum.COMMON_ERROR.getCode();
    }

    public MyException(String message) {
        super(message);
        this.code = ResultCodeConstant.CodeEnum.COMMON_ERROR.getCode();
    }

    public MyException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
