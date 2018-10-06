package com.shazawdidi.donation.ui.userdetail.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;
import  com.shazawdidi.donation.R;
import  com.shazawdidi.donation.base.BaseActivity;
import  com.shazawdidi.donation.common.picker.DatePickerFragment;
import  com.shazawdidi.donation.databinding.ActivityUserDetailsBinding;
import  com.shazawdidi.donation.injection.Injection;
import  com.shazawdidi.donation.ui.home.view.HomeActivity;
import  com.shazawdidi.donation.ui.userdetail.UserDetailContract;
import  com.shazawdidi.donation.ui.userdetail.model.UserDetail;
import  com.shazawdidi.donation.ui.userdetail.presenter.UserDetailPresenter;
import  com.shazawdidi.donation.util.location.LocationUtil;


/**
 * Created by shazalia on Sep, 2018
 */
public class UserDetailActivity extends BaseActivity implements UserDetailContract.View, LocationUtil.LocationListener {


    private UserDetailContract.Presenter mPresenter;
    private ActivityUserDetailsBinding mActivityUserDetailsBinding;
    private UserDetail mUserDetail;
    private LocationUtil mLocationUtil;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        mLocationUtil.onResolutionResult(requestCode, resultCode, data);

        super.onActivityResult(requestCode, resultCode, data);

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter =
                new UserDetailPresenter(this, Injection.provideFireBaseAuth(), Injection.getSharedPreference(),
                        Injection.providesDataRepo());
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_user_details);
        mActivityUserDetailsBinding = (ActivityUserDetailsBinding) mBinding;
        mUserDetail = new UserDetail();
        mActivityUserDetailsBinding.setPresenter(mPresenter);
        mActivityUserDetailsBinding.setUserdetail(mUserDetail);
        mActivityUserDetailsBinding.etFirstName.setOnEditorActionListener((v, actionId, event) -> {
            mActivityUserDetailsBinding.etLastName.requestFocus();
            return true;
        });
        getSupportActionBar().setTitle(R.string.user_profile);
        initSpinner();


        mLocationUtil = new LocationUtil(this, Injection.getSharedPreference());
        mLocationUtil.fetchApproximateLocation(this);
        mPresenter.onCreate();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
        mLocationUtil.onDestroy();
    }

    private void initSpinner() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.blood_group,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mActivityUserDetailsBinding.bloodGroupDropDown.setAdapter(adapter);
    }

    @Override
    public void showDatePickerDialog() {
        DialogFragment dialogFragment = DatePickerFragment.newInstance(mUserDetail.dob);
        dialogFragment.show(getSupportFragmentManager(), "datefragment");
    }

    @Override
    public void getLastLocation() {
        mLocationUtil.fetchApproximateLocation(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        mLocationUtil.onPermissionResult(requestCode, permissions, grantResults);
    }

    @Override
    public void launchHomeScreen() {
        Intent intent = new Intent(this, HomeActivity.class);
        finish();
        startActivity(intent);
    }

    @Override
    public void generalResponse(int responseId) {
        Toast.makeText(this, responseId, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLocationReceived(@NonNull LatLng location, @NonNull String addressString) {
        mUserDetail.latitiude.set(location.latitude);
        mUserDetail.longitude.set(location.longitude);
        mActivityUserDetailsBinding.tvLocationPicker.setText(addressString);

    }
}
