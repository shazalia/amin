package com.shazawdidi.donation.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import  com.shazawdidi.donation.App;

public class NetworkUtil {

  public static boolean isOnline() {

    ConnectivityManager connectivityManager = (ConnectivityManager) App.getInstance()
        .getSystemService(Context.CONNECTIVITY_SERVICE);


      NetworkInfo netInfo ;
      netInfo = connectivityManager.getActiveNetworkInfo();
      return netInfo != null && netInfo.isConnectedOrConnecting();

  }
}
