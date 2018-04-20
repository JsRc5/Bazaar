package com.example.jsrc.bazaar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.jsrc.bazaar.model.HashMapFactory;
import com.example.jsrc.bazaar.model.Preferences;

import java.util.HashMap;


public class UserInformationActivity extends AppCompatActivity
{
    private HashMapFactory _preferencesFactory = new HashMapFactory();
    private HashMap _preferences = _preferencesFactory.getPreferenceHash();
    private int _distance;
    private SeekBar _distanceBar;
    private Button _doneButton;
    private TextView _distanceTextView;

    private static final String TAG = "UserInformationActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_information);

        _distanceBar = findViewById(R.id.distanceBar);
        _distance = _distanceBar.getProgress();
        _distanceBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                _distance = i;
                setDistanceText(_distance);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });

        _doneButton = findViewById(R.id.doneButton);
        _doneButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                Log.d(TAG, "Clicked Done Button");
                Log.d(TAG, "distance = " + _distance + " km");

            }

        });

        _distanceTextView = findViewById(R.id.distanceTextView);
        setDistanceText(_distance);
    }


    public void onCheckboxClicked(View view)
    {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId())
        {
            case R.id.artsAndCrafts:
                Log.d(TAG, "arts clicked");
                _preferences.replace(Preferences.ArtsAndCrafts, checked);
                break;

            case R.id.electronics:
                Log.d(TAG, "elec clicked");
                _preferences.replace(Preferences.Electronics, checked);
                break;

            case R.id.bikes:
                Log.d(TAG, "bikes clicked");
                _preferences.replace(Preferences.Bikes, checked);
                break;

            case R.id.home:
                Log.d(TAG, "home clicked");
                _preferences.replace(Preferences.Home, checked);
                break;

            case R.id.misc:
                Log.d(TAG, "misc clicked");
                _preferences.replace(Preferences.Misc, checked);
                break;

            case R.id.books:
                _preferences.replace(Preferences.Books, checked);
                Log.d(TAG, _preferences.toString());
                break;

            case R.id.clothing:
                Log.d(TAG, "clothing clicked");
                break;

        }
        Log.d(TAG, _preferences.toString());

    }

    public void setDistanceText(int distance)
    {
        String text = "Distance = " + String.valueOf(distance) + " km";
        _distanceTextView.setText(text);
    }

}
