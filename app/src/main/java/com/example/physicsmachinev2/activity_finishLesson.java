package com.example.physicsmachinev2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class activity_finishLesson extends AppCompatActivity {
    private Button finishButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_lesson);
        getSupportActionBar().hide();

        finishButton = findViewById(R.id.lesson1_finish_button);
            finishButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Finish();
                }
            });
    }

    public void Finish(){
        Intent intent = new Intent(this, activity_lesson.class);
        startActivity(intent);
    }
}