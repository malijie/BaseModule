package com.base.http.util;

import android.widget.Toast;

import com.base.http.base.BaseProfile;
/**
 * Created by Administrator on 2017/2/22.
 */

public class ToastUtil {
    private static Toast sToast = null;

    public static void showMsg(String msg, int during){
        if(sToast != null){
            sToast.setText(msg);
            sToast.setDuration(during);
            sToast.show();
        }else{
            sToast = Toast.makeText(BaseProfile.mContext,msg,during);
            sToast.show();
        }
    }

    public static void showMsg(String msg){
        if(sToast != null){
            sToast.setText(msg);
            sToast.show();
        }else{
            sToast = Toast.makeText(BaseProfile.mContext,msg, Toast.LENGTH_SHORT);
            sToast.show();
        }
    }

}
