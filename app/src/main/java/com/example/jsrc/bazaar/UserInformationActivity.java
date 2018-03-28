package com.example.jsrc.bazaar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;


public class UserInformationActivity extends AppCompatActivity {

    private SeekBar _distanceBar;
    private TextView _distanceTextView;

    private Button _doneButton;

    private int _distance;

    private static final String TAG = "UserInformationActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_information);

        _distanceBar = findViewById(R.id.distanceBar);
        _distanceBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                _distance = i;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        _doneButton = findViewById(R.id.doneButton);
        _doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d(TAG,"Clicked Done Button");
                Log.d(TAG, "distance = " + _distance + " km");

            }
        });



    }


}
