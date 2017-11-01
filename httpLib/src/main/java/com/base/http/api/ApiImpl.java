package com.base.http.api;

import com.base.http.entity.ApiResponse;
import com.base.http.http.HttpEngine;
import com.base.http.http.RequestParams;
import com.base.http.http.ResultEnum;
import com.base.http.http.URLContainer;
import com.base.http.util.Logger;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * Created by malijie on 2017/7/31.
 */

public class ApiImpl implements Api {
    private static final String TAG = ApiImpl.class.getName();

    @Override
    public ApiResponse getRequestInfo(RequestParams params) {
        Type type = new TypeToken<ApiResponse>(){}.getType();
        try {
            ApiResponse result = HttpEngine.getInstance().
                    requestHandle(URLContainer.getDeviceListURL(),params, HttpEngine.REQUEST_METHOD_POST,type);
            Logger.d(TAG,"getTestPostRequest result = " + result);
            return result;
        } catch (IOException e) {
            return new ApiResponse(ResultEnum.FAILED.getCode(),"error", "参数错误");
        }
    }
}
