package com.example.androidassignments;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

public class ListItemsActivity extends AppCompatActivity {
    private ImageButton imageButton;
    private Switch toggle;

    private CheckBox checkBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(this.getClass().getSimpleName(), "onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_items);

        imageButton = super.findViewById(R.id.layout_imageButton);
        imageButton.setOnClickListener(view -> {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent,1);
        });

        toggle = super.findViewById(R.id.layout_toggle);
        toggle.setOnCheckedChangeListener((view, isChecked) -> {
            if (isChecked){
                print(super.getString(R.string.SwitchToastOn), Toast.LENGTH_SHORT);
            }
            else print(super.getString(R.string.SwitchToastOff), Toast.LENGTH_LONG);
        });

        checkBox = super.findViewById(R.id.layout_checkBox);
        checkBox.setOnCheckedChangeListener((view, isChecked) ->{
            AlertDialog.Builder builder = new AlertDialog.Builder(ListItemsActivity.this);
            builder.setMessage(super.getString(R.string.dialog_message))
                    .setTitle(super.getString(R.string.title))
                    .setPositiveButton(super.getString(R.string.ActivityConfirm), (dialog,id) -> {
                        Intent resultIntent = new Intent();
                        resultIntent.putExtra("Response", super.getString(R.string.ActivityConfirm));
                        setResult(Activity.RESULT_OK, resultIntent);
                        finish();
                    })
                    .setNegativeButton(super.getString(R.string.ActivityCancel), (dialog,id) -> {
                    })
                    .show();
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
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode == 1 && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imageBM = (Bitmap) extras.get("data");
            imageButton.setImageBitmap(imageBM);

        }
    }

    private void print(String msg, int duration){
        Toast toast = Toast.makeText(this, msg, duration);
        toast.show();
    }

}