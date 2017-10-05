package com.example.shubhraj.volibase;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
{
    FirebaseDatabase mFirebase;
    DatabaseReference mDbReference;

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    @BindView(R.id.edit_pincode)
    EditText mLocationEditText;
    @BindView(R.id.submit_button)
    Button mFindRestaurantsButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mFirebase = FirebaseDatabase.getInstance();
        mDbReference = mFirebase.getReference();

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();

        mFindRestaurantsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view == mFindRestaurantsButton) {
                    String location = mLocationEditText.getText().toString();
                    if(location.equals(""))
                    {
                        Toast.makeText(MainActivity.this, "Please input Pincode",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        addToSharedPreferences(location);
                        Intent intent = new Intent(MainActivity.this, RestaurantListActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }

    private void addToSharedPreferences(String location) {
        mEditor.putString(Constants.PREFERENCES_LOCATION_KEY, location).apply();
    }
}
