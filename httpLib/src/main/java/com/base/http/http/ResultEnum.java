package com.base.http.http;

/**
 * Created by malijie on 2017/9/21.
 */

public enum ResultEnum {

    SUCCESS(1,"成功"), FAILED(-1,"服务器返回错误");


    private int code;
    private String msg;

    ResultEnum(int code,String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
