package com.biaobiao.prijectLibrary.net;

/**
 * @author: biao
 * @create: 2019/4/8
 * @Describe:
 */
public class RxHttpResponse<T> {
    private T data;//数据
    private int code;//标志码
    private String message;//错误描述

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
