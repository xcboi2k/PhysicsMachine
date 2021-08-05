package com.example.physicsmachinev2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class activity_scoresviewer extends AppCompatActivity {
    private ImageButton exitButton;
    private ImageButton homeButton;

    private TextView b1prtscoretext;
    private TextView b1pstscoretext;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoresviewer);

        getSupportActionBar().hide();

        b1prtscoretext = (TextView) findViewById(R.id.sv_B1PRT_scoretext);
        b1pstscoretext = (TextView) findViewById(R.id.sv_B1PST_scoretext);

        getScores();

        exitButton = findViewById(R.id.scoresviewer_close_button);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Exit();
            }
        });

        homeButton = findViewById(R.id.scoresviewer_home_button);
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

    private void getScores(){

        sharedPreferences = getSharedPreferences("TEST_SCORES", MODE_PRIVATE);

        String b1_prt = sharedPreferences.getString("B1PRT_SCORE", "");
        String b1_pst = sharedPreferences.getString("B1PST_SCORE", "");

        b1prtscoretext.setText(b1_prt);
        b1pstscoretext.setText(b1_pst);
    }

}