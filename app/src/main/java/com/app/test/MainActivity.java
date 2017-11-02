package com.app.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.base.http.app.ActionCallback;
import com.base.http.base.HttpCenter;
import com.app.test.entity.DeviceInfo;
import com.base.http.http.RequestParams;
import com.base.http.util.Logger;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView mTxtResult = null;
    private Button mBtnRequest = null;
    private Button mBtnCancel = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTxtResult = (TextView) findViewById(R.id.text_result);
        mBtnRequest = (Button) findViewById(R.id.btn_request);
        mBtnCancel = (Button) findViewById(R.id.btn_cancel);
        final HttpCenter center = HttpCenter.getInstance();

        mBtnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RequestParams params = new RequestParams();
                params.setURL(URLContainer.getDeviceListURL());
                params.setMethod("POST");
                params.setParamsValue("phone","13896107262");

                center.startRequest(params, new ActionCallback<List<DeviceInfo>>() {
                    @Override
                    public void onSuccess(List<DeviceInfo> data) {
                        mTxtResult.setText("result：" + data);
                        Logger.mlj("result=" + data);
                    }

                    @Override
                    public void onFailed(String errorMsg) {
                        Logger.mlj("errorMsg=" + errorMsg);
                    }
                });
            }
        });

        mBtnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logger.mlj("cancel...");
            }
        });

    }
}
