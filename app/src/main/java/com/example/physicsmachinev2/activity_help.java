package com.example.physicsmachinev2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class activity_help extends AppCompatActivity {
    private ImageButton exitButton;
    private ImageButton homeButton;
    private ImageButton reportButton;
    private ImageButton suggestionButton;
    private ImageButton instructionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        getSupportActionBar().hide();

        exitButton = findViewById(R.id.help_close_button);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Exit(); }
        });

        homeButton = findViewById(R.id.help_home_button);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Home(); }
        });

        instructionButton = findViewById(R.id.instruction_button);
        instructionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity_help.this, "Take the pre-test to measure your prior knowledge, \nIngest the lessons to further up your capacity, " +
                                "\nAnd engage the post-test to assess your understanding!",
                        Toast.LENGTH_SHORT).show();
            }
        });

        reportButton = findViewById(R.id.report_button);
        reportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity_help.this, "Email us at softbois@gmail.com \nWith a subject: REPORTING PROBLEM",
                        Toast.LENGTH_SHORT).show();
            }
        });

        suggestionButton = findViewById(R.id.suggestion_button);
        suggestionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity_help.this, "Email us at softbois@gmail.com \nWith a subject: SUGGESTION",
                        Toast.LENGTH_SHORT).show();
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
        Intent intent = new Intent(this, activity_menu.class);
        startActivity(intent);
    }
}