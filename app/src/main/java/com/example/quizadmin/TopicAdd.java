package com.example.quizadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.quizadmin.ApiModel.Quiz_topic;
import com.example.quizadmin.retrofit.QuizApi;
import com.example.quizadmin.retrofit.RetrofitServices;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopicAdd extends AppCompatActivity {
    EditText editText;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_add);
        editText = findViewById(R.id.editText);
        btn = findViewById(R.id.button);

        RetrofitServices retrofitServices = new RetrofitServices();
        QuizApi quizApi = retrofitServices.getRetrofit().create(QuizApi.class);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editText.getText().toString();

                Quiz_topic topic = new Quiz_topic(str,0);
                quizApi.addTopic(topic).enqueue(new Callback<Quiz_topic>() {
                    @Override
                    public void onResponse(Call<Quiz_topic> call, Response<Quiz_topic> response) {
                        Intent i = new Intent(getApplicationContext(), Home.class);
                        startActivity(i);
                        finish();
                    }

                    @Override
                    public void onFailure(Call<Quiz_topic> call, Throwable t) {

                    }
                });
            }
        });

    }
}