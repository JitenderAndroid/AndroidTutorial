package com.jitenderkumar.demoducat.telephony;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class NetworkConnection {

     static void netConnection(Activity activity) {
        ConnectivityManager conMgr =  (ConnectivityManager)activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conMgr.getActiveNetworkInfo();
        if (netInfo == null){
        } else{
        }

        ConnectivityManager cm = (ConnectivityManager)activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
            boolean isMetered = cm.isActiveNetworkMetered();
            Log.e("network", ""+isMetered);
        }
    }
}
