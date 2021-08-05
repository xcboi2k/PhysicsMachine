package com.example.physicsmachinev2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class activity_adminbranch1pretest extends AppCompatActivity {
    private ImageButton exitButton;
    private ImageButton homeButton;

    private Button editQ1Button;
    private Button editQ2Button;
    private Button editQ3Button;
    private Button editQ4Button;
    private Button editQ5Button;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminbranch1pretest);
        getSupportActionBar().hide();

        exitButton = findViewById(R.id.adminb1pretest_close_button);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Exit();
            }
        });

        homeButton = findViewById(R.id.adminb1pretest_home_button);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Home();
            }
        });

        editQ1Button = findViewById(R.id.editb1q1_button);
        editQ1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenQ1();
            }
        });

        editQ2Button = findViewById(R.id.editb1q2_button);
        editQ2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenQ2();
            }
        });
        editQ3Button = findViewById(R.id.editb1q3_button);
        editQ3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenQ3();
            }
        });
        editQ4Button = findViewById(R.id.editb1q4_button);
        editQ4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenQ4();
            }
        });
        editQ5Button = findViewById(R.id.editb1q5_button);
        editQ5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenQ5();
            }
        });
    }

    private void Exit(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to Exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        finishAffinity();
                        System.exit(0);
                    }
                })

                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void Home(){
        Intent intent = new Intent(this, activity_adminmenu.class);
        startActivity(intent);
    }

    private void OpenQ1(){
        sharedPreferences = getSharedPreferences("TEST", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        myEdit.putString("CATEGORY", "B1PRTQ1");
        myEdit.commit();

        Intent intent = new Intent(this, activity_inputfields.class);
        startActivity(intent);
    }
    private void OpenQ2(){
        sharedPreferences = getSharedPreferences("TEST", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        myEdit.putString("CATEGORY", "B1PRTQ2");
        myEdit.commit();

        Intent intent = new Intent(this, activity_inputfields.class);
        startActivity(intent);
    }
    private void OpenQ3(){
        sharedPreferences = getSharedPreferences("TEST", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        myEdit.putString("CATEGORY", "B1PRTQ3");
        myEdit.commit();

        Intent intent = new Intent(this, activity_inputfields.class);
        startActivity(intent);
    }
    private void OpenQ4(){
        sharedPreferences = getSharedPreferences("TEST", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        myEdit.putString("CATEGORY", "B1PRTQ4");
        myEdit.commit();

        Intent intent = new Intent(this, activity_inputfields.class);
        startActivity(intent);
    }
    private void OpenQ5(){
        sharedPreferences = getSharedPreferences("TEST", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        myEdit.putString("CATEGORY", "B1PRTQ5");
        myEdit.commit();

        Intent intent = new Intent(this, activity_inputfields.class);
        startActivity(intent);
    }
}