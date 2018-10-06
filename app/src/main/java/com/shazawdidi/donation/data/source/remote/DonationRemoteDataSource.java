package com.shazawdidi.donation.data.source.remote;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;
import com.shazawdidi.donation.constants.FireBaseConstants;
import com.shazawdidi.donation.data.model.ReceiverDonorRequestType;
import com.shazawdidi.donation.data.model.User;
import com.shazawdidi.donation.data.source.DonationDataSource;

/**
 * Created by shazalia on Sep, 2018
 */
public class DonationRemoteDataSource implements DonationDataSource {

    public static DonationRemoteDataSource INSTANCE;

    private FirebaseDatabase mFirebaseDatabase;

    private DonationRemoteDataSource(FirebaseDatabase firebaseDatabase) {
        mFirebaseDatabase = firebaseDatabase;
    }

    public static DonationDataSource getInstance(FirebaseDatabase firebaseDatabase) {
        if (INSTANCE == null) {
            synchronized (DonationRemoteDataSource.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DonationRemoteDataSource(firebaseDatabase);
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public void saveNewUser(String userId, User user) {
        mFirebaseDatabase.getReference().child(FireBaseConstants.USERS).child(userId).setValue(user);
    }

    @Override
    public void saveReceiverDetails(String userId, ReceiverDonorRequestType receiverDonorRequestType) {

        receiverDonorRequestType.setInstanceId(FirebaseInstanceId.getInstance().getToken());

        mFirebaseDatabase.getReference()
                .child(FireBaseConstants.RECEIVER)
                .child(userId)
                .setValue(receiverDonorRequestType);
    }

    @Override
    public void saveDonorDetails(String userId, ReceiverDonorRequestType receiverDonorRequestType) {

        receiverDonorRequestType.setInstanceId(FirebaseInstanceId.getInstance().getToken());

        mFirebaseDatabase.getReference()
                .child(FireBaseConstants.DONOR)
                .child(userId)
                .setValue(receiverDonorRequestType);
    }
}
