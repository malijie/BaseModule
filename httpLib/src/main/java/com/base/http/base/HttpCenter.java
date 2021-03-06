package com.base.http.base;

import android.content.Context;
import android.content.Intent;

import com.base.http.app.ActionCallback;
import com.base.http.app.ActionImpl;
import com.base.http.app.AppAction;
import com.base.http.app.DownloadCallback;
import com.base.http.http.RequestParams;
import com.base.http.service.DownloadService;

/**
 * Created by malijie on 2017/11/1.
 */

public class HttpCenter {
    private static HttpCenter sHttpManager = null;
    private AppAction mAction = null;

    private HttpCenter(){
        mAction = new ActionImpl();
    }

    public static HttpCenter getInstance(){
        if(sHttpManager == null){
            synchronized (HttpCenter.class){
                if(sHttpManager == null){
                    sHttpManager = new HttpCenter();
                }
            }
        }
        return sHttpManager;
    }

    public static void init(Context context){
        BaseProfile.mContext = context;
        startDownloadService();
    }

    public void startRequest(RequestParams params, ActionCallback callback){
        mAction.startRequest(params,callback);
    }

    public void download(RequestParams params, DownloadCallback callback){
        mAction.download(params,callback);
    }

    private static void startDownloadService(){
        Intent i = new Intent(BaseProfile.mContext, DownloadService.class);
        i.setAction(DownloadService.ACTION_START_DOWNLOAD);
        BaseProfile.mContext.startService(i);
    }

}
