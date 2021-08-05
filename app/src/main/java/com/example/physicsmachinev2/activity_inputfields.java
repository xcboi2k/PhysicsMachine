package com.example.physicsmachinev2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.model.Document;

import java.util.HashMap;
import java.util.Map;

public class activity_inputfields extends AppCompatActivity {
    private ImageButton exitButton;
    private ImageButton homeButton;

    private Button updateButton;

    private EditText editQuestion;
    private EditText editChoice1;
    private EditText editChoice2;
    private EditText editChoice3;
    private EditText editChoice4;
    private EditText editAnswer;

    private TextView textQuestionNum;

    private FirebaseFirestore firestore;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inputfields);
        getSupportActionBar().hide();

        editQuestion = findViewById(R.id.Question_editText);
        editChoice1 = findViewById(R.id.Option1_editText);
        editChoice2 = findViewById(R.id.Option2_editText);
        editChoice3 = findViewById(R.id.Option3_editText);
        editChoice4 = findViewById(R.id.Option4_editText);
        editAnswer = findViewById(R.id.Answer_editText);

        textQuestionNum = (TextView) findViewById(R.id.numquestion_text);

        sharedPreferences = getSharedPreferences("TEST", MODE_PRIVATE);
        String checkNum = sharedPreferences.getString("CATEGORY", "");

        if(checkNum == "B1PRTQ1"){
            textQuestionNum.setText("Question 1");
        }
        if(checkNum == "B1PRTQ2"){
            textQuestionNum.setText("Question 2");
        }
        if(checkNum == "B1PRTQ3"){
            textQuestionNum.setText("Question 3");
        }
        if(checkNum == "B1PRTQ4"){
            textQuestionNum.setText("Question 4");
        }
        if(checkNum == "B1PRTQ5"){
            textQuestionNum.setText("Question 5");
        }

        updateButton = findViewById(R.id.Update_Button);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateData();
            }
        });

        exitButton = findViewById(R.id.inputfields_close_button);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Exit();
            }
        });

        homeButton = findViewById(R.id.inputfields_home_button);
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
        Intent intent = new Intent(this, activity_adminmenu.class);
        startActivity(intent);
    }

    private void UpdateData(){
        sharedPreferences = getSharedPreferences("TEST", MODE_PRIVATE);
        String checkNum = sharedPreferences.getString("CATEGORY", "");

        String q = editQuestion.getText().toString();
        String a = editChoice1.getText().toString();
        String b = editChoice2.getText().toString();
        String c = editChoice3.getText().toString();
        String d = editChoice4.getText().toString();
        String z = editAnswer.getText().toString();

        firestore = FirebaseFirestore.getInstance();

        if(checkNum == "B1PRTQ1"){
            Map<String, Object> map1 = new HashMap<>();
            map1.put("Question", q);
            map1.put("A", a);
            map1.put("B", b);
            map1.put("C", c);
            map1.put("D", d);
            map1.put("Answer", z);

            DocumentReference docRef = firestore.collection("B1_PreTest").document("jzFGn5qmaIWDeMLLpA9A");
            docRef.update(map1).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    editQuestion.getText().clear();
                    editChoice1.getText().clear();
                    editChoice2.getText().clear();
                    editChoice3.getText().clear();
                    editChoice4.getText().clear();
                    editAnswer.getText().clear();
                    Toast.makeText(activity_inputfields.this, "Updated Succesfully!", Toast.LENGTH_SHORT).show();
                }
            })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.e("TAG", "Not Updated");
                        }
                    });
        }
        if(checkNum == "B1PRTQ2"){
            Map<String, Object> map2 = new HashMap<>();
            map2.put("Question", q);
            map2.put("A", a);
            map2.put("B", b);
            map2.put("C", c);
            map2.put("D", d);
            map2.put("Answer", z);

            DocumentReference docRef = firestore.collection("B1_PreTest").document("kIfCI2MFcXSscFTDYYPX");
            docRef.update(map2).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    editQuestion.getText().clear();
                    editChoice1.getText().clear();
                    editChoice2.getText().clear();
                    editChoice3.getText().clear();
                    editChoice4.getText().clear();
                    editAnswer.getText().clear();
                    Toast.makeText(activity_inputfields.this, "Updated Succesfully!", Toast.LENGTH_SHORT).show();
                }
            })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.e("TAG", "Not Updated");
                        }
                    });
        }
        if(checkNum == "B1PRTQ3"){
            Map<String, Object> map3 = new HashMap<>();
            map3.put("Question", q);
            map3.put("A", a);
            map3.put("B", b);
            map3.put("C", c);
            map3.put("D", d);
            map3.put("Answer", z);
            DocumentReference docRef = firestore.collection("B1_PreTest").document("loRqaluAP67EUVrsKOlB");
            docRef.update(map3).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    editQuestion.getText().clear();
                    editChoice1.getText().clear();
                    editChoice2.getText().clear();
                    editChoice3.getText().clear();
                    editChoice4.getText().clear();
                    editAnswer.getText().clear();
                    Toast.makeText(activity_inputfields.this, "Updated Succesfully!", Toast.LENGTH_SHORT).show();
                }
            })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.e("TAG", "Not Updated");
                        }
                    });
        }
        if(checkNum == "B1PRTQ4"){
            Map<String, Object> map4 = new HashMap<>();
            map4.put("Question", q);
            map4.put("A", a);
            map4.put("B", b);
            map4.put("C", c);
            map4.put("D", d);
            map4.put("Answer", z);
            DocumentReference docRef = firestore.collection("B1_PreTest").document("nud4hmSIhAMDI96BEqBg");
            docRef.update(map4).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    editQuestion.getText().clear();
                    editChoice1.getText().clear();
                    editChoice2.getText().clear();
                    editChoice3.getText().clear();
                    editChoice4.getText().clear();
                    editAnswer.getText().clear();
                    Toast.makeText(activity_inputfields.this, "Updated Succesfully!", Toast.LENGTH_SHORT).show();
                }
            })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.e("TAG", "Not Updated");
                        }
                    });
        }
        if(checkNum == "B1PRTQ5"){
            DocumentReference docRef = firestore.collection("B1_PreTest").document("rv891kGbX4pgcsHkeA07");
            docRef.update("Question", q,
                    "A", a,
                    "B", b,
                    "C", c,
                    "D", d,
                    "Answer", z
            ).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    editQuestion.getText().clear();
                    editChoice1.getText().clear();
                    editChoice2.getText().clear();
                    editChoice3.getText().clear();
                    editChoice4.getText().clear();
                    editAnswer.getText().clear();
                    Toast.makeText(activity_inputfields.this, "Updated Succesfully!", Toast.LENGTH_SHORT).show();
                }
            })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.e("TAG", "Not Updated");
                        }
                    });
        }
    }
}