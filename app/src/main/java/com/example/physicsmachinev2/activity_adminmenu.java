package com.example.physicsmachinev2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class activity_adminmenu extends AppCompatActivity {
    private ImageButton exitButton;
    private ImageButton homeButton;

    private Button branch1Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminmenu);
        getSupportActionBar().hide();

        exitButton = findViewById(R.id.adminmenu_close_button);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Exit();
            }
        });

        homeButton = findViewById(R.id.adminmenu_home_button);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Home();
            }
        });

        branch1Button = findViewById(R.id.adminb1_button);
        branch1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenBranch1();
            }
        });
    }

    public void Exit(){
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

    public void Home(){
        Intent intent = new Intent(this, Select_User.class);
        startActivity(intent);
    }

    public void OpenBranch1(){
        Intent intent = new Intent(this, activity_adminbranch1menu.class);
        startActivity(intent);
    }

}