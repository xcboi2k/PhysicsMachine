package com.example.physicsmachinev2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Integer.valueOf;

public class activity_test_B1prtquestions extends AppCompatActivity implements View.OnClickListener {
    private TextView question_number;
    private TextView question;
    private int questionNum;
    private int score;

    private Button option1;
    private Button option2;
    private Button option3;
    private Button option4;

    private List<b1prt_questions> b1prt_qList;
    private FirebaseFirestore firestore;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test__b1prtquestions);
        getSupportActionBar().hide();

        question_number = (TextView) findViewById(R.id.B1PRT_question_number);
        question = (TextView) findViewById(R.id.B1PRT_question);

        option1 = findViewById(R.id.B1PRT_option1);
        option2 = findViewById(R.id.B1PRT_option2);
        option3 = findViewById(R.id.B1PRT_option3);
        option4 = findViewById(R.id.B1PRT_option4);

        option1.setOnClickListener(this);
        option2.setOnClickListener(this);
        option3.setOnClickListener(this);
        option4.setOnClickListener(this);

        firestore = FirebaseFirestore.getInstance();

        getQuestionList();

        score = 0;
    }

    private void getQuestionList() {
        b1prt_qList = new ArrayList<>();

        firestore.collection("B1_PreTest").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()){
                    QuerySnapshot questions = task.getResult();

                    for (QueryDocumentSnapshot doc : questions){
                        b1prt_qList.add(new b1prt_questions(doc.getString("Question"),
                                doc.getString("A"), doc.getString("B"),
                                doc.getString("C"), doc.getString("D"),
                                Integer.valueOf(doc.getString("Answer"))));
                    }
                    setQuestion();
                }
                else{
                    Toast.makeText(activity_test_B1prtquestions.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void setQuestion() {
        String question_string1 = String.valueOf(1) + "/" + String.valueOf(b1prt_qList.size());
        question_number.setText(question_string1);
        question.setText(b1prt_qList.get(0).getQuestion());
        option1.setText(b1prt_qList.get(0).getOptionA());
        option2.setText(b1prt_qList.get(0).getOptionB());
        option3.setText(b1prt_qList.get(0).getOptionC());
        option4.setText(b1prt_qList.get(0).getOptionD());

        questionNum = 0;
    }

    @Override
    public void onClick(View v) {
        int selectedOption = 0;

        switch(v.getId()){
            case R.id.B1PRT_option1:
                selectedOption = 1;
                break;
            case R.id.B1PRT_option2:
                selectedOption = 2;
                break;
            case R.id.B1PRT_option3:
                selectedOption = 3;
                break;
            case R.id.B1PRT_option4:
                selectedOption = 4;
                break;
            default:
        }

        checkAnswer(selectedOption, v);
    }

    private void checkAnswer(int selectedOption, View view) {
        if(selectedOption == b1prt_qList.get(questionNum).correctAns){
            ((Button)view).setBackgroundColor(valueOf(Color.GREEN));
            score++;
        }
        else{
            ((Button)view).setBackgroundColor(valueOf(Color.RED));

            switch(b1prt_qList.get(questionNum).getCorrectAns()){
                case 1:
                    option1.setBackgroundColor(valueOf(Color.GREEN));
                    break;
                case 2:
                    option2.setBackgroundColor(valueOf(Color.GREEN));
                    break;
                case 3:
                    option3.setBackgroundColor(valueOf(Color.GREEN));
                    break;
                case 4:
                    option4.setBackgroundColor(valueOf(Color.GREEN));
                    break;
            }
        }

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                changeQuestion();
            }
        }, 2000);
    }

    private void playAnim(View view, final int value, int viewNum) {
        view.animate().alpha(value).scaleX(value).scaleY(value).setDuration(500)
                .setStartDelay(100).setInterpolator(new DecelerateInterpolator())
                .setListener(new Animator.AnimatorListener() {
                    public void onAnimationStart(Animator animation) {
                    }
                    public void onAnimationEnd(Animator animation) {
                        if(value == 0){
                            switch (viewNum){
                                case 0:
                                    ((TextView)view).setText(b1prt_qList.get(questionNum).getQuestion());
                                    break;
                                case 1:
                                    ((Button)view).setText(b1prt_qList.get(questionNum).getOptionA());
                                    break;
                                case 2:
                                    ((Button)view).setText(b1prt_qList.get(questionNum).getOptionB());
                                    break;
                                case 3:
                                    ((Button)view).setText(b1prt_qList.get(questionNum).getOptionC());
                                    break;
                                case 4:
                                    ((Button)view).setText(b1prt_qList.get(questionNum).getOptionD());
                                    break;
                            }

                            if (viewNum != 0){
                                ((Button)view).setBackgroundColor(valueOf(Color.parseColor("#FF6200EE")));
                            }
                            playAnim(view, 1, viewNum);
                        }
                    }
                    public void onAnimationCancel(Animator animation) {
                    }
                    public void onAnimationRepeat(Animator animation) {
                    }
                });
    }

    private void changeQuestion() {
        if(questionNum < b1prt_qList.size() - 1){
            questionNum++;
            playAnim(question, 0, 0);
            playAnim(option1, 0, 1);
            playAnim(option2, 0, 2);
            playAnim(option3, 0, 3);
            playAnim(option4, 0, 4);

            String question_string2 = String.valueOf(questionNum + 1) + "/" + String.valueOf(b1prt_qList.size());
            question_number.setText(question_string2);
        }
        else{
            Intent intent = new Intent(this, activity_test_B1prtscore.class);
            intent.putExtra("SCORE", String.valueOf(score) + "/" + String.valueOf(b1prt_qList.size()));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            //activity_test_B1prtquestions.this.finish();
        }
    }
}
