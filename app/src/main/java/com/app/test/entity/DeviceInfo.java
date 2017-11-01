package com.app.test.entity;

import android.text.TextUtils;

import java.io.Serializable;

/**
 * Created by malijie on 2017/9/14.
 */

public class DeviceInfo implements Serializable{
    /**
     * 设备id
     */
    private String imei;
    /**
     * 设备名称
     */
    private String name;
    /**
     * 设备编号
     */
    private String deviceNo;
    /**
     * 是否激活，0：激活 1：未激活
     */
    private int status;
    /**
     * 设备类型 0：老人 1：小孩
     */
    private int deviceType;

    /**
     * 定位类型 1：GPS 2：LBS
     */
    private int type;

    /**
     * 精度
     */
    private double latitude;
    /**
     * 纬度
     */
    private double longitude;
    /**
     * 绑定状态
     */
    private int bindStatus;
    /**
     * 激活状态
     */
    private int activateStatus;
    /**
     * 半径
     */
    private int radius;
    /**
     * 过期时间
     */
    private String expireTime;
    /**
     * 最近访问时间
     */
    private String updateTime;
    /**
     * 设备模式
     */
    private int mode;
    /**
     * 定位模式
     */
    private int locMode;
    /**
     * 电量
     */
    private int percent;

    /**
     * 电话号码
     */
    private String telephone;

    /**
     * 设备在线
     */
    private int onlineStatus;

    private String sim;

    private String idenCode;

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    private String addessDetail;

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getAddessDetail() {
        return addessDetail;
    }

    public void setAddessDetail(String addessDetail) {
        this.addessDetail = addessDetail;
    }

    public int getBindStatus() {
        return bindStatus;
    }

    public void setBindStatus(int bindStatus) {
        this.bindStatus = bindStatus;
    }

    public int getActivateStatus() {
        return activateStatus;
    }

    public void setActivateStatus(int activateStatus) {
        this.activateStatus = activateStatus;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public String getExpireTime() {
        if(TextUtils.isEmpty(expireTime)){
            return "--";
        }
        return expireTime;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int deviceMode) {
        this.mode = deviceMode;
    }

    public int getLocMode() {
        return locMode;
    }

    public void setLocMode(int locMode) {
        this.locMode = locMode;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public int getOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(int onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    public int getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(int deviceType) {
        this.deviceType = deviceType;
    }

    public String getSim() {
        return sim;
    }

    public void setSim(String sim) {
        this.sim = sim;
    }

    public String getIdenCode() {
        return idenCode;
    }

    public void setIdenCode(String idenCode) {
        this.idenCode = idenCode;
    }

    @Override
    public String toString() {
        return "DeviceInfo{" +
                "imei='" + imei + '\'' +
                ", name='" + name + '\'' +
                ", deviceNo='" + deviceNo + '\'' +
                ", status=" + status +
                ", deviceType=" + deviceType +
                ", type=" + type +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", bindStatus=" + bindStatus +
                ", activateStatus=" + activateStatus +
                ", radius=" + radius +
                ", expireTime='" + expireTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", mode=" + mode +
                ", locMode=" + locMode +
                ", percent=" + percent +
                ", telephone='" + telephone + '\'' +
                ", onlineStatus=" + onlineStatus +
                ", sim='" + sim + '\'' +
                ", idenCode='" + idenCode + '\'' +
                ", addessDetail='" + addessDetail + '\'' +
                '}';
    }
}
