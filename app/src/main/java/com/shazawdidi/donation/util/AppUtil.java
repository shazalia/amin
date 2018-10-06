package com.shazawdidi.donation.util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/**
 * Created by shazalia on Sep, 2018
 */
public final class AppUtil {
    private AppUtil() {
    }

    public static void replaceFragmentInActivity(FragmentManager fragmentManager, Fragment fragment,
            int containerId) {
        fragmentManager.beginTransaction().replace(containerId, fragment).commit();
    }
}
