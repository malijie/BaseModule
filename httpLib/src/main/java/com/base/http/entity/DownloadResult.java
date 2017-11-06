package com.base.http.entity;

import com.base.http.api.Api;

/**
 * Created by malijie on 2017/11/6.
 */

public class DownloadResult<T> {

    private int code;
    private String msg;
    private T data;


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

    public T getData() {
        return data;
    }

    public void setData(T data){
        this.data = data;
    }


    @Override
    public String toString() {
        return "DownloadResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
