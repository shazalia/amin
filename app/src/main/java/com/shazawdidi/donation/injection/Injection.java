package com.shazawdidi.donation.injection;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.shazawdidi.donation.data.source.DonationDataRepository;
import com.shazawdidi.donation.data.source.DonationDataSource;
import com.shazawdidi.donation.data.source.local.DonationLocalDataSource;
import com.shazawdidi.donation.data.source.remote.DonationRemoteDataSource;
import com.shazawdidi.donation.storage.SharedPreferenceManager;

/**
 * Created by shazalia on Sep, 2018
 */
final public class Injection {
  private Injection() {
  }

  public static FirebaseAuth provideFireBaseAuth() {
    return FirebaseAuth.getInstance();
  }

  public static FirebaseDatabase provideFireBaseDatabase() {
    return FirebaseDatabase.getInstance();
  }

  public static SharedPreferenceManager getSharedPreference() {
    return SharedPreferenceManager.getInstance();
  }

  public static DonationDataSource provideLocalDataSource() {
    return DonationLocalDataSource.getInstance();
  }

  public static DonationDataSource provideRemoteDataSource() {
    return DonationRemoteDataSource.getInstance(Injection.provideFireBaseDatabase());
  }

  public static DonationDataSource providesDataRepo() {
    return DonationDataRepository.getInstance(Injection.provideLocalDataSource(),
        Injection.provideRemoteDataSource());
  }
}
