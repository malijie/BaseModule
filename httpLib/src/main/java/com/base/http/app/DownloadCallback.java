package com.base.http.app;

/**
 * Created by malijie on 2017/11/2.
 */

public interface DownloadCallback extends ActionCallback{
    void onProgress(int progress);
}
