package com.base.http.http;

import com.base.http.util.Logger;
import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by malijie on 2017/8/1.
 */

public class HttpEngine {
    private final static String TAG = "HttpEngine";

    public final static String REQUEST_METHOD_POST = "POST";
    public final static String REQUEST_METHOD_GET = "GET";
    private final static int TIME_OUT = 20000;
    private static HttpEngine sHttpEngine = null;

    public static HttpEngine getInstance(){
           if(sHttpEngine == null){
               synchronized (HttpEngine.class){
                   if(sHttpEngine == null){
                        sHttpEngine = new HttpEngine();
                   }
               }
           }
       return sHttpEngine;
    }

    public <T> T requestHandle(String url, RequestParams params, String requestMethod, Type typeOfT)  throws IOException {
        HttpURLConnection connection = getConnection(url, params, requestMethod);
        int code = connection.getResponseCode();
        Logger.d(TAG,"code="+ code);
        if (code == 200) {
            // 获取响应的输入流对象
            InputStream is = connection.getInputStream();
            // 创建字节输出流对象
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            // 定义读取的长度
            int len = 0;
            // 定义缓冲区
            byte buffer[] = new byte[1024];
            // 按照缓冲区的大小，循环读取
            while ((len = is.read(buffer)) != -1) {
                // 根据读取的长度写入到os对象中
                baos.write(buffer, 0, len);
            }
            // 释放资源
            is.close();
            baos.close();
            connection.disconnect();

            String result = new String(baos.toByteArray());
            // 打印出结果
            Logger.d(TAG, "response: " + result);
            Gson gson = new Gson();
            return gson.fromJson(result, typeOfT);
        }else{
            connection.disconnect();
            return null;
        }
    }


    // 获取connection
    private HttpURLConnection getConnection(String strUrl, RequestParams params, String method) {

        HttpURLConnection connection = null;
        try {
           String finalURL = null;
           if(method.equals(REQUEST_METHOD_GET)){
               finalURL = strUrl +"?"+ joinParams(params);
           }else if(method.equals(REQUEST_METHOD_POST)){
               finalURL = strUrl;
           }
            Logger.d(TAG,"finalURL==" + finalURL + ",params=" + params + ",method=" + method);

            URL url = new URL(finalURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(method);
            connection.setReadTimeout(TIME_OUT);
            connection.setConnectTimeout(TIME_OUT);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Connection", "keep-alive");
            connection.setRequestProperty("Response-Type", "json");
            connection.setChunkedStreamingMode(0);
            connection.connect();

            if(method.equals(REQUEST_METHOD_POST)){
                byte[] data = joinParams(params).toString().getBytes();
                OutputStream outputStream = connection.getOutputStream();
                outputStream.write(data);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return connection;
    }


    private String joinParams(RequestParams requestParams){
        Map<String,String> paramsMap = requestParams.getParamsMap();
        String params = "?";
        List<String> keyList = new ArrayList<>(paramsMap.keySet());
        for(int i=0;i<keyList.size();i++){
            String key = keyList.get(i);
            params +=  key+ "=" +paramsMap.get(key) + "&";
        }
        return params.substring(1,params.length()-1);
    }


    public void handleDownload(RequestParams params){

    }

    /**
     * 假数据，用于测试
     * @param url
     * @param params
     * @param requestMethod
     * @param typeOfT
     * @param <T>
     * @return
     * @throws IOException
     */
    public <T> T requestHandleTest(String url, RequestParams params, String requestMethod, Type typeOfT)  throws IOException {
        String result =  "{\"returnCode\": 1," +
                "    \"returnMsg\": \"xxxxx\"," +
                "    \"details\": [" +
                "        {" +
                "            \"name\": \"设备88\"," +
                "            \"sn\": \"12200000000\"," +
                "            \"longitude\": \"100.9898\"," +
                "            \"lantitude\": \"67.009\"," +
                "            \"radius\": 1," +
                "            \"addessDetail\": \"某某街某某路xx号\"" +
                "        }," +
                "        {" +
                "            \"name\": \"设备88\"," +
                "            \"sn\": \"12200000000\"," +
                "            \"longitude\": \"100.9898\"," +
                "            \"lantitude\": \"67.009\"," +
                "            \"radius\": 1," +
                "            \"addessDetail\": \"某某街某某路xx号\"" +
                "        }" +
                "    ]" +
                "}";

        Gson gson = new Gson();
        Logger.d(TAG,"result=" + result);
        return gson.fromJson(result, typeOfT);
    }


}
