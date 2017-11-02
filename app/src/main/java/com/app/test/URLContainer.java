package com.app.test;


/**
 * Created by malijie on 2017/9/18.
 * URL请求地址类
 */

public class URLContainer {

    private static final String TEST_GET = "http://gank.io/api/data/%E7%A6%8F%E5%88%A9/";
    private static final String TEST_POST = "https://gank.io/api/add2gank";

    private static String BASE_URL = "http://117.139.247.133:18080/rest/app/";
    private static final String BASE_BAIDU = "http://api.map.baidu.com/geocoder/v2/";

    private static final String DEVICE_LIST = "query-devices";
    private static final String LOGIN = "login-check";
    private static final String SEND_MESSAGE = "send-code";
    private static final String REGISTER = "register";
    private static final String FORGET_PASSWORD = "forget-password";
    private static final String VERIFICATION_IMEI = "verification-imei";
    private static final String BIND_DEVICE = "device-binding";
    private static final String PERSON_INFOR = "person-infor";
    private static final String QUERY_SWITCH = "query-switch";
    private static final String MESSAGE_SWITCH = "message-switch";
    private static final String DEVICE_LISTS = "device-lists";
    private static final String DEVICE_DETAIL = "device-query";
    private static final String UNBIND_DEVICE = "relive-binding";
    private static final String MODIFY_DEVICE = "device-update";
    private static final String DEVICE_DETAIL_MODIFY ="device-administer";
    private static final String HISTORY_TRACK ="history-locus";
    private static final String CHANGE_MODE ="switch-mode";
    private static final String MESSAGE_LIST ="query-alarmlist";
    private static final String FENCE_LIST ="query-electronic";
    private static final String INVITE_CONTACTS ="invitation-contact";
    private static final String CHANGE_PASSWORD = "update-password";
    private static final String DELETE_CONTACT = "delete-attach";
    private static final String DELETE_FENCE = "delete-electronic";
    private static final String DEFAULT_FENCE = "switch-fence";
    private static final String NEW_FENCE="electronic-fence";
    private static final String MODIFY_FENCE = "electronic-update";
    private static final String IDEN_CODE = "idencode-binding";
    private static final String QUERY_MODE = "query-mode";
    private static final String DELETE_MESSAGE = "delete-alarm";
    private static final String REBINDING = "re-binding";
    private static final String UPDATE_PERSONAL ="modify-personinfo";




    public static final String getTestGetURL() {
        return TEST_GET;
    }

    public static final String getTestPostURL() {
        return TEST_POST;
    }

    public static final String getLoginURL() {
        return BASE_URL + LOGIN;
    }

    public static final String getSendMessageURL() {
        return BASE_URL + SEND_MESSAGE;
    }

    public static final String getRegisterURL() {
        return BASE_URL + REGISTER;
    }

    public static final String getForgetPasswordURL() {
        return BASE_URL + FORGET_PASSWORD;
    }

    public static final String getVerificationSnURL() {
        return BASE_URL + VERIFICATION_IMEI;
    }

    public static final String getBindDeviceURL() {
        return BASE_URL + BIND_DEVICE;
    }

    public static final String getDeviceListURL() {
        return BASE_URL + DEVICE_LIST;
    }

    public static final String getPersonInforURL() {
        return BASE_URL + PERSON_INFOR;
    }

    public static String getQuerySwitchURL() {
        return BASE_URL + QUERY_SWITCH;
    }

    public static String getMessageSwitchURL() {
        return BASE_URL + MESSAGE_SWITCH;
    }

    public static String getDeviceListsURL() {
        return BASE_URL + DEVICE_LISTS;
    }

    public static String getDeviceDetailURl() {
        return BASE_URL + DEVICE_DETAIL;
    }

    public static final String getBaiduGeoURL() {
        return BASE_BAIDU;
    }

    public static String getDeviceDetailModifyURL() {
        return BASE_URL + DEVICE_DETAIL_MODIFY;
    }

    public static String getHistoryTrackURL() {
        return BASE_URL + HISTORY_TRACK;
    }

    public static String getChangeModeURL() {
        return BASE_URL + CHANGE_MODE;
    }

    public static String getMessageListURL() {
        return BASE_URL + MESSAGE_LIST;
    }

    public static String getFenceListURL() {
        return BASE_URL+FENCE_LIST;
    }

    public static String getUnbindDeviceURL() {
        return BASE_URL + UNBIND_DEVICE;
    }

    public static String getModifyDeviceURL() {
        return BASE_URL +MODIFY_DEVICE;
    }
    public static String getInviteContactsURL() {
        return BASE_URL +INVITE_CONTACTS;
    }

    public static String getChangePasswordURL() {
        return BASE_URL+CHANGE_PASSWORD;
    }
    public static String getDeleteContactURL() {
        return BASE_URL+ DELETE_CONTACT;
    }

    public static String getDeleteFenceURL() {
        return BASE_URL+DELETE_FENCE;
    }

    public static String getDefaultFenceURL() {
        return BASE_URL+DEFAULT_FENCE;
    }

    public static String getNewFenceURL() {
        return BASE_URL +NEW_FENCE;
    }
    public static String getModifyFenceURL() {
        return BASE_URL +MODIFY_FENCE;
    }
    public static String getIdenCodeURL() {return BASE_URL +IDEN_CODE;}

    public static String getQueryMode(){return  BASE_URL + QUERY_MODE;}

    public static String getDeleteMessageURL() {
        return BASE_URL+DELETE_MESSAGE;
    }

    public static String getRebindingURL() {
        return BASE_URL+REBINDING;
    }

    public static String getPersonalUpdateURL() {
        return BASE_URL+UPDATE_PERSONAL;
    }

    public static String getBaseUrl() {
        return null;
    }
}
