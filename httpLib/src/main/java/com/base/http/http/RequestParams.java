package com.base.http.http;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by malijie on 2017/8/3.
 */

public class RequestParams {
    private Map<String,String> paramsMap = new HashMap<>();

    public boolean isValidate() {
        List<String> paramsKey = new ArrayList<>(paramsMap.keySet());
        for(int i=0;i<paramsKey.size();i++){
            if(TextUtils.isEmpty(paramsMap.get(paramsKey.get(i)))){
                return false;
            }
        }
        return true;
    }

    public Map<String,String> getParamsMap(){
        return paramsMap;
    }

    public void setParamsValue(String key, String value){
        paramsMap.put(key,value);
    }

    public String getParamsValue(String key){
        return paramsMap.get(key);
    }

    public void setURL(String url){
        paramsMap.put("url",url);
    }

    public String getURL(){
        return paramsMap.get("url");
    }

    public void setAction(String method){
        paramsMap.put("action",method);
    }

    public String getAction(){
        return paramsMap.get("action");
    }

    @Override
    public String toString() {
        return paramsMap.toString();
    }
}
