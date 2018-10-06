package com.shazawdidi.donation.ui.home;

import android.support.annotation.NonNull;

import com.shazawdidi.donation.base.BasePresenter;
import com.shazawdidi.donation.data.model.ReceiverDonorRequestType;
import com.shazawdidi.donation.ui.home.model.RequestDetails;

/**
 * Created by shazalia on Sep, 2018
 */
public interface RequestDialogContract {
  interface View {
    void getLastLocation();

    void dismissDialog(@NonNull String userId, boolean isReceiver, ReceiverDonorRequestType receiverDonorRequestType);
  }

  interface Presenter extends BasePresenter {

    void onSubmitButtonClick(RequestDetails requestDetails);

    void onLocationClick();
  }
}
