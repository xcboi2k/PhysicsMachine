package com.example.physicsmachinev2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class activity_test_B1prtscore extends AppCompatActivity {
    private Button continueButton;

    private ImageButton exitButton;
    private ImageButton homeButton;

    private TextView scoreTextView;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test__b1prtscore);
        getSupportActionBar().hide();

        scoreTextView = findViewById(R.id.B1PRT_score_text);

        String score_str = getIntent().getStringExtra("SCORE");
        scoreTextView.setText(score_str);

        sharedPreferences = getSharedPreferences("TEST_SCORES", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        myEdit.putString("B1PRT_SCORE", scoreTextView.getText().toString());
        myEdit.commit();

        continueButton = findViewById(R.id.B1PRT_continueButton);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenLesson();
            }
        });

        exitButton = findViewById(R.id.B1PRTscoreview_close_button);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Exit();
            }
        });

        homeButton = findViewById(R.id.B1PRTscoreview_home_button);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Home();
            }
        });
    }

    private void OpenLesson(){
        Intent intent = new Intent(this, activity_branch1menu.class);
        startActivity(intent);
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
        Intent intent = new Intent(this, activity_learningbranch.class);
        startActivity(intent);
    }
}