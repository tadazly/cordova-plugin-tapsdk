package com.tadazly.tapsdk;

import android.app.Activity;
import android.util.Log;

import com.taptap.services.update.TapUpdate;
import com.taptap.services.update.TapUpdateCallback;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaArgs;
import org.apache.cordova.CordovaPlugin;

public class TapSDKCordovaPlugin extends CordovaPlugin {
    public final static String LOG_TAG = "plugin.TapSDK";
    private static String TAP_CLIENT_ID;
    private static String TAP_CLIENT_TOKEN;

    @Override
    protected void pluginInitialize() {
        super.pluginInitialize();
        TAP_CLIENT_ID = webView.getPreferences().getString("TAP_CLIENT_ID", "");
        TAP_CLIENT_TOKEN = webView.getPreferences().getString("TAP_CLIENT_TOKEN", "");
        Log.d(LOG_TAG, "TapSDK pluginInitialize");
    }

    @Override
    public boolean execute(String action, CordovaArgs args, CallbackContext callbackContext) {
        if (action.equals("updateGame")) {
            return this.updateGame(args, callbackContext);
        }
        return false;
    }

    private boolean updateGame(CordovaArgs args, CallbackContext callbackContext) {
        Activity activity = cordova.getActivity();
        Log.d(LOG_TAG, "TapSDK init");
        TapUpdate.init(activity, TAP_CLIENT_ID, TAP_CLIENT_TOKEN);
        Log.d(LOG_TAG, "TapSDK updateGame");
        TapUpdate.updateGame(activity, new TapUpdateCallback() {
            @Override
            public void onCancel() {
                Log.d(LOG_TAG, "TapSDK updateGame onCancel");
                callbackContext.success();
            }
        });
        return true;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}