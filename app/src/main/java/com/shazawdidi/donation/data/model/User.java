package com.shazawdidi.donation.data.model;


import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by shazalia on Sep, 2018
 */
@IgnoreExtraProperties public class User {
  public String fName;
  public String lName;
  public String email;
  public String bloodGroup;
  public String dob;
  public String gender;
  public double latitude;
  public double longitude;

  public User() {
  }
}
