package com.example.physicsmachinev2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Select_User extends AppCompatActivity {
    private Button guestButton;
    private Button adminButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select__user);
        getSupportActionBar().hide();

        guestButton = findViewById(R.id.guest_button);
        guestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGuestMenu();
            }
        });
        adminButton = findViewById(R.id.admin_button);
        adminButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { openAdminMenu(); }
        });
    }

    public void openGuestMenu(){
        Intent intent = new Intent(this, activity_menu.class);
        startActivity(intent);
    }
    public void openAdminMenu(){
        Intent intent = new Intent(this, activity_adminlogin.class);
        startActivity(intent);
    }
}