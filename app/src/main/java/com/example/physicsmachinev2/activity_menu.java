package com.example.physicsmachinev2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class activity_menu extends AppCompatActivity {
    private ImageButton branchButton;
    private ImageButton ratingsButton;
    private ImageButton helpButton;
    private ImageButton aboutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        getSupportActionBar().hide();

        branchButton = findViewById(R.id.branch_button);
        branchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLearningBranch();
            }
        });

        ratingsButton = findViewById(R.id.ratings_button);
        ratingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRatings();
            }
        });

        helpButton = findViewById(R.id.help_button);
        helpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHelp();
            }
        });

        aboutButton = findViewById(R.id.about_button);
        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAbout();
            }
        });
    }
    public void openLearningBranch(){
        Intent intent = new Intent(this, activity_learningbranch.class);
        startActivity(intent);
    }

    public void openRatings(){
        Intent intent = new Intent(this, activity_ratings.class);
        startActivity(intent);
    }

    public void openHelp(){
        Intent intent = new Intent(this, activity_help.class);
        startActivity(intent);
    }

    public void openAbout(){
        Intent intent = new Intent(this, activity_about.class);
        startActivity(intent);
    }
}