package com.shazawdidi.donation.storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.shazawdidi.donation.App;

/**
 * Created by shazalia on Sep, 2018
 */
public final class SharedPreferenceManager {

    private static SharedPreferenceManager INSTANCE;
    private final String NAME = "com.shazawdidi.donation";
    private SharedPreferences mSharedPreferences;

    private SharedPreferenceManager() {
        mSharedPreferences =
                App.getInstance().getApplicationContext().getSharedPreferences(NAME,
                        Context.MODE_PRIVATE);
    }

    public static SharedPreferenceManager getInstance() {
        if (INSTANCE == null) {
            synchronized (SharedPreferenceManager.class) {
                if (INSTANCE != null) {
                    INSTANCE = new SharedPreferenceManager();
                }
            }
        }
        return INSTANCE;
    }


    public void put(String key, String value) {
        mSharedPreferences.edit().putString(key, value).apply();
    }

    public void put(String key, int value) {
        mSharedPreferences.edit().putInt(key, value).apply();
    }

    public void put(String key, boolean value) {
        mSharedPreferences.edit().putBoolean(key, value).apply();
    }

    public String getString(String key) {
        return mSharedPreferences.getString(key, "");
    }

    public int getInt(String key) {
        return mSharedPreferences.getInt(key, -1);
    }

    public Boolean getBoolean(String key) {
        return mSharedPreferences.getBoolean(key, false);
    }

}
