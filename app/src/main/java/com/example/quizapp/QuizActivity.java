package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

public class QuizActivity extends AppCompatActivity {

    private Button submitButton;
    private int score;
    private RadioGroup numOneRadionGroup;
    private RadioGroup numTwoRadionGroup;
    private RadioGroup numFiveRadionGroup;

    private EditText editText;
    private CheckBox indiaCheckbox;
    private CheckBox chinaCheckbox;
    private CheckBox japanCheckbox;
    private CheckBox koreaCheckbox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        submitButton = findViewById(R.id.submit_button);
        editText = findViewById(R.id.edit_text);
        indiaCheckbox = findViewById(R.id.indiaCheckbox);
        japanCheckbox = findViewById(R.id.japanCheckbox);
        koreaCheckbox = findViewById(R.id.koreaCheckbox);
        chinaCheckbox = findViewById(R.id.chinaCheckbox);
        numOneRadionGroup = findViewById(R.id.num_one_radio_group);
        numTwoRadionGroup = findViewById(R.id.num_two_radio_group);
        numFiveRadionGroup = findViewById(R.id.num_five_radio_group);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                score = 0;

                if(numOneRadionGroup.getCheckedRadioButtonId() == R.id.FirstRadio){
                    score += 1;
                }

                if(numTwoRadionGroup.getCheckedRadioButtonId() == R.id.SixthRadio){
                    score += 1;
                }



                String userAnswer = editText.getText().toString();
                if(userAnswer.equalsIgnoreCase("1776")){
                    score += 1;
                }

                if(indiaCheckbox.isChecked() && chinaCheckbox.isChecked() && !japanCheckbox.isChecked()
                && !koreaCheckbox.isChecked()){
                    score += 1;
                }

            Intent intent = new Intent(QuizActivity.this, ScoreActivity.class);
            intent.putExtra("SCORE", score+"/4");
            startActivity(intent);

            }
        });


    }
}




