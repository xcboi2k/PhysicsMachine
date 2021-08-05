package com.example.physicsmachinev2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class activity_test_B1prt extends AppCompatActivity {
    private Button startPreTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test__b1prt);
        getSupportActionBar().hide();

        startPreTest = findViewById(R.id.B1PRT_startButton);
        startPreTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenPRT();
            }
        });
    }

    private void OpenPRT(){
        Intent intent = new Intent(this, activity_test_B1prtquestions.class);
        startActivity(intent);
    }
}