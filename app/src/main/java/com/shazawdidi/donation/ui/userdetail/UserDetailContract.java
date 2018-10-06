package com.shazawdidi.donation.ui.userdetail;

import  com.shazawdidi.donation.base.BasePresenter;
import  com.shazawdidi.donation.base.BaseView;
import  com.shazawdidi.donation.ui.userdetail.model.UserDetail;

/**
 * Created by shazalia on Sep, 2018
 */
public interface UserDetailContract {
    interface Presenter extends BasePresenter {
        void onCreateNowClick(UserDetail userDetail);

        void onDobButtonClick();

        void onLocationClick();
    }

    interface View extends BaseView {
        void showDatePickerDialog();

        void getLastLocation();

        void launchHomeScreen();

    }
}
