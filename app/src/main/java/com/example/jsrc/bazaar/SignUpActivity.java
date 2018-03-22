package com.example.jsrc.bazaar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SignUpActivity extends AppCompatActivity {

    private static final String TAG = "SignUpActivity";

    private Button _signUpButton;
    private Button _facebookButton;
    private Button _googleButton;

    private EditText _usernameEditText;
    private EditText _passwordEditText;
    private EditText _confirmPasswordEditText;
    private EditText _emailEditText;
    private TextView _warningWrongPassword;

    private String _username;
    private String _password;
    private String _confirmPassword;
    private String _email;

    private boolean _firstTimeConfirmPassword = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Log.d(TAG,"Test");

        _warningWrongPassword = (TextView) findViewById(R.id.warning_wrong_password);
        _warningWrongPassword.setText("");


        _signUpButton = findViewById(R.id.sign_up_button);
        _signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"Sign Up Button Clicked");

                Log.d(TAG,"Username = " + _username);
                Log.d(TAG,"EMail = " + _email);
                Log.d(TAG,"Password = " + _password);
                Log.d(TAG,"Confirm password = " + _confirmPassword);


            }
        });

        _facebookButton = findViewById(R.id.facebook_button);
        _facebookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Facebook Button Clicked");
            }
        });

        _googleButton = findViewById(R.id.google_button);
        _googleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Google Button Clicked");
            }
        });

        _usernameEditText = findViewById(R.id.username_edit_text);
        _usernameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d(TAG,"Username Text Changed");
                _username = charSequence.toString();

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        _passwordEditText = (EditText) findViewById(R.id.password_edit_text);
        _passwordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d(TAG,"Password Text Changed");
                _password = charSequence.toString();
                if (_firstTimeConfirmPassword) {
                    if (_confirmPassword.equals(_password)) {
                        _warningWrongPassword.setText("");
                    } else {
                        _warningWrongPassword.setText("!");
                    }
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        _confirmPasswordEditText = (EditText) findViewById(R.id.confirm_password_edit_text);
        _confirmPasswordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d(TAG,"Confirm Password Text Changed");
                _firstTimeConfirmPassword = true;
                _confirmPassword = charSequence.toString();
                if ( _confirmPassword.equals(_password)) {
                    _warningWrongPassword.setText("");
                } else {
                    _warningWrongPassword.setText("!");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        _emailEditText = (EditText) findViewById(R.id.email_edit_text);
        _emailEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d(TAG,"Email Text Changed");
                _email = charSequence.toString();

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

}
