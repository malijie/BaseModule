package com.base.http.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by malijie on 2017/7/31.
 */

public class ApiResponse<T> {

    public ApiResponse(int code ,String msg,T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    @SerializedName("returnCode")
    private int code;
    @SerializedName("returnMsg")
    private String msg;
    @SerializedName("details")
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

    public void setData(T data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "ApiResponse{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
