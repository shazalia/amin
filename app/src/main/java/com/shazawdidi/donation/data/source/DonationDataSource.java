package com.shazawdidi.donation.data.source;

import com.firebase.geofire.GeoLocation;
import com.shazawdidi.donation.data.model.ReceiverDonorRequestType;
import com.shazawdidi.donation.data.model.User;
import com.shazawdidi.donation.ui.home.presenter.RequestDialogPresenter;

/**
 * Created by shazalia on Sep, 2018
 */
public interface DonationDataSource {
  void saveNewUser(String userId, User user);

  void saveReceiverDetails(String userId, ReceiverDonorRequestType receiverDonorRequestType);

  void saveDonorDetails(String userId, ReceiverDonorRequestType receiverDonorRequestType);
}
