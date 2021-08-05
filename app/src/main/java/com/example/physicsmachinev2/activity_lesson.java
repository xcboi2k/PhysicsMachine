package com.example.physicsmachinev2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class activity_lesson extends AppCompatActivity {
    private ImageButton exitButton;
    private ImageButton homeButton;

    private ImageButton lesson1Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);
        getSupportActionBar().hide();

        exitButton = findViewById(R.id.lesson_close_button);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Exit();
                finishAffinity();
                System.exit(0);
            }
        });

        homeButton = findViewById(R.id.lesson_home_button);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Home();
            }
        });

        lesson1Button = findViewById(R.id.lesson1_button);
        lesson1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenLesson1();
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
        Intent intent = new Intent(this, activity_branch1menu.class);
        startActivity(intent);
    }

    public void OpenLesson1(){
        Intent intent = new Intent(this, activity_lesson1a.class);
        startActivity(intent);
    }
}