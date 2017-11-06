package com.base.http.app;

import android.os.AsyncTask;

import com.base.http.api.Api;
import com.base.http.api.ApiImpl;
import com.base.http.entity.ApiResponse;
import com.base.http.http.DefaultThreadPool;
import com.base.http.http.HttpAsyncTask;
import com.base.http.http.RequestParams;
import com.base.http.http.ResultEnum;
import com.base.http.util.CommonUtil;
import com.base.http.util.Logger;

import java.util.concurrent.Executor;


/**
 * Created by malijie on 2017/7/31.
 */

public class ActionImpl implements AppAction {

    private HttpAsyncTask mHttpAsyncTask = null;
    private DefaultThreadPool mThreadPool = null;

    public ActionImpl(){
        mThreadPool = DefaultThreadPool.getInstance();
    }


    @Override
    public void startRequest(final RequestParams requestParams, final ActionCallback callback) {
        mThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                Logger.mlj("startRequest");
                mHttpAsyncTask = new HttpAsyncTask(requestParams,callback);
                mHttpAsyncTask.execute();
            }
        });
    }

    @Override
    public void download(final RequestParams requestParams, final DownloadCallback callback) {
        mThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                mHttpAsyncTask = new HttpAsyncTask(requestParams,callback);
                mHttpAsyncTask.execute();
            }
        });
    }

}
