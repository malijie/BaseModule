package com.base.http.api;


import com.base.http.entity.ApiResponse;
import com.base.http.http.RequestParams;

/**
 * Created by malijie on 2017/7/31.
 */

public interface Api<T> {
    ApiResponse<T> postRequest(RequestParams params);
    ApiResponse<T> getRequest(RequestParams params);
    ApiResponse<T> downloadRequest(RequestParams params);

}
