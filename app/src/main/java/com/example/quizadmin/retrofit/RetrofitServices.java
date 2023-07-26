package com.example.quizadmin.retrofit;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitServices {
    private Retrofit retrofit;
    public RetrofitServices(){
        initializeRetrofit();
    }
    private void initializeRetrofit(){
        retrofit = new Retrofit.Builder().
                baseUrl("https://api-production-a1aa.up.railway.app/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
    }
    public Retrofit getRetrofit(){
        return retrofit;
    }
}
