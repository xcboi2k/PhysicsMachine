package com.example.physicsmachinev2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class activity_branch1menu extends AppCompatActivity {
    private ImageButton exitButton;
    private ImageButton homeButton;

    private ImageButton postTestButton;
    private ImageButton lessonButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch1menu);
        getSupportActionBar().hide();

        exitButton = findViewById(R.id.branch1_close_button);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Exit();
                finishAffinity();
                System.exit(0);
            }
        });

        homeButton = findViewById(R.id.branch1_home_button);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Home();
            }
        });

        postTestButton = findViewById(R.id.branch1posttest_button);
        postTestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenPST();
            }
        });

        lessonButton = findViewById(R.id.branch1lesson1_button);
        lessonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenLesson();
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
        Intent intent = new Intent(this, activity_learningbranch.class);
        startActivity(intent);
    }

    public void OpenPST(){
        Intent intent = new Intent(this, activity_test_B1pst.class);
        startActivity(intent);
    }

    public void OpenLesson(){
        Intent intent = new Intent(this, activity_lesson.class);
        startActivity(intent);
    }
}