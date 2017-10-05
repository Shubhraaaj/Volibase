package com.example.shubhraj.volibase;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Shubhraj on 05-10-2017.
 */

public class RestaurantListActivity extends AppCompatActivity
{
    private static final String TAG = "RestaurantList";
    private SharedPreferences mSharedPreferences;
    private String mRecentAddress;

    @BindView(R.id.rest_text)
    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_list);
        ButterKnife.bind(this);
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mRecentAddress = mSharedPreferences.getString(Constants.PREFERENCES_LOCATION_KEY, null);
        Log.d(TAG, mRecentAddress);
    }
}
