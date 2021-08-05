package com.example.physicsmachinev2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class activity_ratings extends AppCompatActivity {
    private ImageButton exitButton;
    private ImageButton homeButton;

    private ImageButton scoreButton;
    private ImageButton achievementButton;
    private ImageButton badgesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratings);
        getSupportActionBar().hide();

        scoreButton = findViewById(R.id.score_button);
        scoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenScoreView();
            }
        });

        achievementButton = findViewById(R.id.achievements_button);
        achievementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity_ratings.this, "Feature not yet available.", Toast.LENGTH_SHORT).show();
            }
        });

        badgesButton = findViewById(R.id.badges_button);
        badgesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity_ratings.this, "Feature not yet available.", Toast.LENGTH_SHORT).show();
            }
        });

        exitButton = findViewById(R.id.ratings_close_button);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Exit();
            }
        });

        homeButton = findViewById(R.id.ratings_home_button);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Home();
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
        Intent intent = new Intent(this, activity_menu.class);
        startActivity(intent);
    }

    private void OpenScoreView(){
        Intent intent = new Intent(this, activity_scoresviewer.class);
        startActivity(intent);
    }

}