package com.example.quizadmin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.quizadmin.ApiModel.Quiz_topic;
import com.example.quizadmin.adapter.Selection_Adapter;
import com.example.quizadmin.retrofit.QuizApi;
import com.example.quizadmin.retrofit.RetrofitServices;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Home extends AppCompatActivity {


    RecyclerView recyclerView;
    Context context = this;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        RetrofitServices retrofitServices = new RetrofitServices();
        QuizApi quizApi = retrofitServices.getRetrofit().create(QuizApi.class);


        recyclerView = findViewById(R.id.Quiz_selection_recycler_view);
        button = findViewById(R.id.addTopic);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, TopicAdd.class);
                startActivity(i);
                finish();
            }
        });

        quizApi.getAllTopic().enqueue(new Callback<ArrayList<Quiz_topic>>() {
            @Override
            public void onResponse(Call<ArrayList<Quiz_topic>> call, Response<ArrayList<Quiz_topic>> response) {
                ArrayList<Quiz_topic> qt = response.body();
                Selection_Adapter sa = new Selection_Adapter(qt,context);
                recyclerView = findViewById(R.id.Quiz_selection_recycler_view);
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
                recyclerView.setAdapter(sa);
            }

            @Override
            public void onFailure(Call<ArrayList<Quiz_topic>> call, Throwable t) {

            }
        });

    }
}