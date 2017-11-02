package com.base.http.app;

import android.os.AsyncTask;

import com.base.http.api.Api;
import com.base.http.api.ApiImpl;
import com.base.http.entity.ApiResponse;
import com.base.http.http.DefaultThreadPool;
import com.base.http.http.RequestParams;
import com.base.http.http.ResultEnum;
import com.base.http.util.CommonUtil;


/**
 * Created by malijie on 2017/7/31.
 */

public class ActionImpl implements AppAction {
    private static final String TAG = ActionImpl.class.getSimpleName();

    private Api api = null;
    private DefaultThreadPool mThreadPool = null;

    public ActionImpl(){
        api = new ApiImpl();
        mThreadPool = DefaultThreadPool.getInstance();
    }

    /**
     * 统一处理请求回调
     * @param response
     * @param callback
     */
    private void postExecute(ApiResponse response, ActionCallback callback){
        if (response != null && response.getCode() == ResultEnum.SUCCESS.getCode()) {
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

    @Override
    public void sendRequest(final RequestParams requestParams, final ActionCallback callback) {
        if (!requestPreCheck(requestParams,callback)){
            return;
        }

        mThreadPool.submit(new Runnable() {
            @Override
            public void run() {
                new AsyncTask<Void, Void, ApiResponse>() {
                    @Override
                    protected ApiResponse doInBackground(Void... params) {
                        return api.postRequest(requestParams);
                    }
                    @Override
                    protected void onPostExecute(ApiResponse apiResponse) {
                        postExecute(apiResponse,callback);
                    }
                }.execute();
            }
        });
    }

}
