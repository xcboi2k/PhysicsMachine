package com.example.physicsmachinev2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class activity_test_B1pst extends AppCompatActivity {

    private Button startPostTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test__b1pst);
        getSupportActionBar().hide();

        startPostTest = findViewById(R.id.B1PST_startButton);
        startPostTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenPSTQ();
            }
        });
    }

    private void OpenPSTQ(){
        Intent intent = new Intent(this, activity_test_B1pstquestions.class);
        startActivity(intent);
    }
}