package com.example.androidassignments;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(this.getClass().getSimpleName(), "onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button activityButton = super.findViewById(R.id.activityButton);
        activityButton.setOnClickListener((view) -> {

            Intent intent = new Intent(MainActivity.this, ListItemsActivity.class);
            startActivityForResult(intent,10);
        });

        Button testToolbarButton = super.findViewById(R.id.testToolbarButton);
        testToolbarButton.setOnClickListener((view) -> {
            Intent intent = new Intent(this, TestToolbar.class);
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
        Log.i(this.getClass().getSimpleName(), "onDestroy()");
    }

    @Override
    protected void onActivityResult(int requestCode, int responseCode, Intent data){
        super.onActivityResult(requestCode, responseCode, data);
        if (requestCode == 10)
            Log.i(this.getClass().getSimpleName(), "Returned to MainActivity.onActivityResult");

        if (responseCode == Activity.RESULT_OK){
            String messageParsed = data.getStringExtra("Response");
            print(super.getString(R.string.Response), 10);
        }
    }

    private void print(String message, int toastDuration){
        Toast toast = Toast.makeText(this, message, toastDuration);
        toast.show();
    }
}