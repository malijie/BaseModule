package com.base.http.app;

import com.base.http.http.RequestParams;


/**
 * Created by malijie on 2017/7/31.
 */

public interface AppAction<T> {
    void sendRequest(RequestParams requestParams, ActionCallback<T> callback);

}
