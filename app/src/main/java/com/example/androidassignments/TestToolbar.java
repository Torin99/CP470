package com.example.androidassignments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.androidassignments.databinding.ActivityTestToolbarBinding;

public class TestToolbar extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityTestToolbarBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTestToolbarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_test_toolbar);
//        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Torin's Snackbar", Snackbar.LENGTH_LONG)
                        .setAnchorView(R.id.fab)
                        .setAction("Action", null).show();
            }
        });
    }
//
//    @Override
//    public boolean onSupportNavigateUp() {
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_test_toolbar);
//        return NavigationUI.navigateUp(navController, appBarConfiguration)
//                || super.onSupportNavigateUp();
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    @SuppressLint("NonConstantResourceId")
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.action_one) {
            SharedPreferences sp = getSharedPreferences("userPrefs", Context.MODE_PRIVATE);

            String string = sp.getString("option_1_msg", this.getString(R.string.option_1));

            if (string.length() == 0) {
                string = this.getString(R.string.option_1);
            }
            Log.d("Toolbar", "Option 1 selected");
            Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
        }
        else if (menuItem.getItemId() == R.id.action_two) {
            Log.d("Toolbar", "Option 2 selected");
            Toast.makeText(this, R.string.option_2, Toast.LENGTH_SHORT).show();
            AlertDialog.Builder builder = new AlertDialog.Builder(TestToolbar.this);

            View dialogue_view = getLayoutInflater().inflate(R.layout.dialogue_layout, null);
            builder.setView(dialogue_view);
            builder.setTitle(R.string.ToolbarDialogTitle);
            builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {

                    SharedPreferences shared_pref = getSharedPreferences("userPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor spEditor = shared_pref.edit();
                    EditText edit_snackbar = dialogue_view.findViewById(R.id.new_snackbar);
                    Log.d("DEBUG", String.valueOf(edit_snackbar));

                    String new_snackbar = edit_snackbar.getText().toString();

                    // put the message into the chared preferences
                    spEditor.putString( "option_1_msg",new_snackbar);
                    spEditor.apply();
                    finish();
                }
            });
            builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // User cancelled the dialog
                }
            });
            builder.create().show();
        }

        else if (menuItem.getItemId() ==R.id.action_three) {
            Log.d("Toolbar", "Option 3 selected");
            Toast.makeText(this, R.string.option_3, Toast.LENGTH_SHORT).show();
        }

        else if (menuItem.getItemId() == R.id.action_four) {
            Log.d("Toolbar", "Option 4 selected");
            Toast.makeText(this, "Version 1.0, by Torin Borton-McCallum", Toast.LENGTH_SHORT).show();
        }

        else{
            Log.d("Toolbar", "Default selected");
        }

        return super.onOptionsItemSelected(menuItem);
    }
}