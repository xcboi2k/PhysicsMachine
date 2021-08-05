package com.example.physicsmachinev2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class activity_adminlogin extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Attempts;
    private Button loginButton;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);
        getSupportActionBar().hide();

        Name = (EditText) findViewById(R.id.admin_text);
        Password = (EditText) findViewById(R.id.password_text);
        Attempts = (TextView) findViewById(R.id.attempts_textview);
        loginButton = findViewById(R.id.login_button);

        Attempts.setText("No. of attempts remaining: 5");

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });
    }

    private void validate(String enteredName, String enteredPassword){
        if (enteredName.equals("Admin") && enteredPassword.equals("123456")){
            Intent intent = new Intent(this, activity_adminmenu.class);
            startActivity(intent);
        }

        else{
            counter --;
            Attempts.setText("No. of attempts remaining: " + String.valueOf(counter));
            if(counter == 0){
                loginButton.setEnabled(false);
            }
        }
    }
}