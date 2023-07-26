package com.example.quizadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.quizadmin.ApiModel.Quiz_model;
import com.example.quizadmin.retrofit.QuizApi;
import com.example.quizadmin.retrofit.RetrofitServices;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QusAdd extends AppCompatActivity {

    EditText question;
    EditText correct;
    EditText opt1;
    EditText opt2;
    EditText opt3;
    EditText opt4;
    Button btn;
    int qusId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qus_add);

        RetrofitServices retrofitServices = new RetrofitServices();
        QuizApi quizApi = retrofitServices.getRetrofit().create(QuizApi.class);

        qusId=getIntent().getExtras().getInt("QusId");

        question=findViewById(R.id.editText2);
        correct=findViewById(R.id.editText3);
        opt1=findViewById(R.id.editText4);
        opt2=findViewById(R.id.editText5);
        opt3=findViewById(R.id.editText6);
        opt4=findViewById(R.id.editText7);

        btn=findViewById(R.id.addQus);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String ques =question.getText().toString();
                String op1 = opt1.getText().toString();
                String op2 = opt2.getText().toString();
                String op3 = opt3.getText().toString();
                String op4 = opt4.getText().toString();
                String cor = correct.getText().toString();

                Quiz_model model = new Quiz_model(qusId,ques,op1,op2,op3,op4,cor);

                quizApi.addModel(model).enqueue(new Callback<Quiz_model>() {
                    @Override
                    public void onResponse(Call<Quiz_model> call, Response<Quiz_model> response) {
                        Intent i = new Intent(getApplicationContext(), Home.class);
                        startActivity(i);
                        finish();

                    }

                    @Override
                    public void onFailure(Call<Quiz_model> call, Throwable t) {

                    }
                });
            }
        });


    }
}