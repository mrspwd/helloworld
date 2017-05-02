package org.cocos2dx.lua.update;

class Constants {


    // json {"url":"http://192.168.205.33:8080/Hello/app_v3.0.1_Other_20150116.apk","versionCode":2,APK_ISMASKSHOW:true,"updateMessage":"版本更新信息"}

    static final String APK_DOWNLOAD_URL = "url"; //apk下载地址
    static final String APK_UPDATE_CONTENT = "updateMessage"; // 更新信息
    static final String APK_ISMASKSHOW_VERSION_CODE = "isMaskShowVersionCode"; // 是否强制更新版本号(此版本一下强制更新)
    static final String APK_VERSION_CODE = "versionCode"; // 版本号


    static final int TYPE_NOTIFICATION = 2;

    static final int TYPE_DIALOG = 1;

    static final String TAG = "UpdateChecker";

    static final String UPDATE_URL = "https://mrspwd.github.io/android_update_test/update.json";
}
