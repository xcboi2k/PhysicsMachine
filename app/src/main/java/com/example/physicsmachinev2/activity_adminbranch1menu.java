package com.example.physicsmachinev2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class activity_adminbranch1menu extends AppCompatActivity {
    private ImageButton exitButton;
    private ImageButton homeButton;

    private Button b1prtButton;
    private Button b1pstButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminbranch1menu);
        getSupportActionBar().hide();

        exitButton = findViewById(R.id.adminb1_close_button);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Exit();
            }
        });

        homeButton = findViewById(R.id.adminb1_home_button);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Home();
            }
        });

        b1prtButton = findViewById(R.id.adminb1_pretest_button);
        b1prtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditB1PRT();
            }
        });

        b1pstButton = findViewById(R.id.adminb1_posttest_button);
        b1pstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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

    private void EditB1PRT(){
        Intent intent = new Intent(this, activity_adminbranch1pretest.class);
        startActivity(intent);
    }
}