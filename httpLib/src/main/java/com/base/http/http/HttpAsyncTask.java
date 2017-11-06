package com.base.http.http;

import android.os.AsyncTask;

import com.base.http.api.Api;
import com.base.http.api.ApiImpl;
import com.base.http.app.ActionCallback;
import com.base.http.entity.ApiResponse;
import com.base.http.entity.DownloadResult;
import com.base.http.util.CommonUtil;
import com.base.http.util.Logger;

/**
 * 封装AsyncTask
 * Created by malijie on 2017/11/2.
 */

public class HttpAsyncTask extends AsyncTask<Void, Void, ApiResponse>{
    private static final String TAG = HttpAsyncTask.class.getSimpleName();

    private static final String POST = "POST";
    private static final String GET = "GET";
    private static final String DOWNLOAD = "DOWNLOAD";

    private RequestParams requestParams;
    private ActionCallback callback;
    private Api api = null;

    public HttpAsyncTask(RequestParams requestParams, ActionCallback callback){
        this.requestParams = requestParams;
        this.callback = callback;
        api = new ApiImpl();
    }

    // post请求
    private ApiResponse executePostRequest(){
        return api.postRequest(requestParams);
    }

    // get请求
    private ApiResponse executeGetRequest(){
        return api.getRequest(requestParams);
    }

    //下载请求
    private ApiResponse executeDownload(){
        return api.downloadRequest(requestParams);
    }

    @Override
    protected void onPreExecute() {
        if(!requestPreCheck(requestParams,callback)){
            return;
        }
    }

    @Override
    protected ApiResponse doInBackground(Void... params) {

        if(requestParams.getAction().equals(POST)){
            return executePostRequest();

        }else if(requestParams.getAction().equals(GET)){
            return executeGetRequest();

        }else if(requestParams.getAction().equals(DOWNLOAD)){
            return executeDownload();
        }
        return null;
    }

    @Override
    protected void onPostExecute(ApiResponse apiResponse) {
        postExecute(apiResponse,callback);
    }

    /**
     * 统一处理请求回调
     * @param response
     * @param callback
     */
    private void postExecute(ApiResponse response, ActionCallback callback){
        Logger.d(TAG,"response=" + response + ",callback=" + callback);

        if(response == null || callback == null){
            return;
        }
        if (response.getCode() == ResultEnum.SUCCESS.getCode()) {
             callback.onSuccess(response.getData());
        } else {
            callback.onFailed( ResultEnum.FAILED.getMsg());
        }
    }

    /**
     * 请求之前参数，网络检查
     * @param requestParams
     * @param callback
     */
    private boolean requestPreCheck(RequestParams requestParams, final ActionCallback callback){
        if(!requestParams.isValidate()){
            callback.onFailed("参数错误");
            return false;
        }

        if(!CommonUtil.hasInternet()){
            callback.onFailed("当前无网络");
            return false;
        }
        return true;
    }
}
