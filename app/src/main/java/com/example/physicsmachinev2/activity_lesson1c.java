package com.example.physicsmachinev2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class activity_lesson1c extends AppCompatActivity {
    private ImageButton exitButton;
    private ImageButton homeButton;
    private ImageButton nextButton;
    private ImageButton previousButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson1c);
        getSupportActionBar().hide();

        exitButton = findViewById(R.id.lesson1c_close_button);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Exit();
                finishAffinity();
                System.exit(0);
            }
        });

        homeButton = findViewById(R.id.lesson1c_home_button);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Home();
            }
        });

        nextButton = findViewById(R.id.lesson1c_nextpage_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Next();
            }
        });

        previousButton = findViewById(R.id.lesson1c_previouspage_button);
        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Previous();
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
        Intent intent = new Intent(this, activity_lesson.class);
        startActivity(intent);
    }

    private void Next(){
        Intent intent = new Intent(this, activity_lesson1d.class);
        startActivity(intent);
    }

    private void Previous(){
        Intent intent = new Intent(this, activity_lesson1b.class);
        startActivity(intent);
    }
}