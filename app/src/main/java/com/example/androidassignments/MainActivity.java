package com.example.androidassignments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button activityButton = super.findViewById(R.id.activityButton);
        activityButton.setOnClickListener((view) -> {

            Intent intent1 = new Intent(MainActivity.this, ListItemsActivity.class);
            startActivity(intent1);
        });


    }
}