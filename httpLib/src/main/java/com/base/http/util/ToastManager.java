package com.base.http.util;

import android.widget.Toast;


/**
 * Created by Administrator on 2017/2/22.
 */

public class ToastManager {
    public static void showLongMsg(String msg){
        ToastUtil.showMsg(msg, Toast.LENGTH_LONG);
    }

    public static void showShortMsg(String msg){
        ToastUtil.showMsg(msg, Toast.LENGTH_SHORT);
    }

    public static void showNoNetwork(){
        ToastUtil.showMsg("当前无网络...");
    }

    public static void showFenceInValidate(){
        ToastUtil.showMsg("围栏创建不合法");
    }

    public static void showNoDeviceBind(){
        ToastUtil.showMsg("没有绑定设备");
    }

    public static void showNoStartTimeLateEndTime(){
        ToastUtil.showMsg("起始时间不能大于结束时间");
    }
    public static void showNoHistoryTrack(){
        ToastUtil.showMsg("暂时没有历史轨迹");
    }

    public static void showNoNavigate(){
        ToastUtil.showMsg("请安装百度地图才能进行导航");
    }

    public static void showNoFences(){
        ToastUtil.showMsg("没有设置围栏");
    }

    public static void showChangeModeTip(){ToastUtil.showMsg("模式切换中，请稍后...");}

    public static void showLatLngErrorTip(){ToastUtil.showMsg("坐标异常...");}

    public static void showDeviceNoOnline(){ToastUtil.showMsg("设备不在线，暂时无法切换...");}


}
