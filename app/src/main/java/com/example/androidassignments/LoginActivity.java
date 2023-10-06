package com.example.androidassignments;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @SuppressLint("ApplySharedPref")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(this.getClass().getSimpleName(), "onCreate()");
        setContentView(R.layout.activity_login);

        SharedPreferences prefs = getSharedPreferences("userDetails", MODE_PRIVATE);
        String prefEmail = prefs.getString("DefaultEmail", "email@domain.com");
        EditText emailInputField = super.findViewById(R.id.loginUsernameInput);
        emailInputField.setText(prefEmail);


        Button loginButton = super.findViewById(R.id.loginButton);
        loginButton.setOnClickListener((view) -> {

            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(this.getClass().getSimpleName(), "onResume()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(this.getClass().getSimpleName(), "onStart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(this.getClass().getSimpleName(), "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(this.getClass().getSimpleName(), "onStop()");
    }


    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(this.getClass().getSimpleName(), "onSaveInstanceState()");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(this.getClass().getSimpleName(), "onRestoreInstanceState()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(this.getClass().getSimpleName(), "In onDestroy()");
    }
}