package com.base.http.service;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;

import com.base.http.http.HttpEngine;
import com.base.http.util.Logger;


/**
 * Created by malijie on 2017/11/3.
 */

public class DownloadService extends Service{
    private static final String TAG = DownloadService.class.getSimpleName();

    public static final String ACTION_START_SERVICE = "ACTION_START_SERVICE";
    public static final String ACTION_START_DOWNLOAD = "ACTION_START_DOWNLOAD";
    public static final String ACTION_STOP_DOWNLOAD = "ACTION_STOP_DOWNLOAD";

    public static final int MSG_START_DOWNLOAD = 0x01;
    public static final int MSG_STOP_DOWNLOAD = 0x02;
    public static final int MSG_START_SERVICE = 0x03;

    private Handler mHandler = null;
    private HandlerThread mHandlerThread = new HandlerThread("download_thread");

    @Override
    public void onCreate() {
        mHandlerThread.start();
        mHandler = new Handler(mHandlerThread.getLooper()){
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what){
                    case MSG_START_SERVICE:
                        break;

                    case MSG_START_DOWNLOAD:
                        HttpEngine.getInstance().handleDownload(null);
                        break;

                    case MSG_STOP_DOWNLOAD:
                        stopSelf();
                        break;
                }
            }
        };
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String action = intent.getAction();
        Logger.d(TAG, "action=" + action);
        if(action != null){
            if(action.equals(ACTION_START_DOWNLOAD)){
                mHandler.sendEmptyMessage(MSG_START_DOWNLOAD);

            }else if(action.equals(ACTION_STOP_DOWNLOAD)){
                mHandler.sendEmptyMessage(MSG_STOP_DOWNLOAD);

            }else if(action.equals(ACTION_START_SERVICE)){
                mHandler.sendEmptyMessage(MSG_START_SERVICE);
            }
        }

        return START_NOT_STICKY;
    }


    @Override
    public void onDestroy() {
        mHandlerThread.quit();
        stopSelf();
    }
}
