package com.shazawdidi.donation.ui.home.model;

import android.databinding.ObservableDouble;
import com.shazawdidi.donation.common.binding.ObservableString;

/**
 * Created by shazalia on Sep, 2018
 */
public class RequestDetails {
  public ObservableString requestType = new ObservableString();
  public ObservableString bloodGroup = new ObservableString();
  public ObservableDouble latitude = new ObservableDouble();
  public ObservableDouble longitude = new ObservableDouble();
  public ObservableString purpose = new ObservableString();
}
