package com.example.quizadmin.retrofit;


import com.example.quizadmin.ApiModel.Quiz_model;
import com.example.quizadmin.ApiModel.Quiz_topic;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface QuizApi {
    @GET("/quiz_topic/getAllTopicModel")
    Call<ArrayList<Quiz_topic>> getAllTopic();

    @GET("/quiz_model/getAll")
    Call<ArrayList<Quiz_model>> getAllModel();
    @GET("/quiz_model/{id}")
    Call<Quiz_model> getModelById(@Path("id") int id);

    @POST("/quiz_topic/addTopic")
    Call<Quiz_topic> addTopic(@Body Quiz_topic topic);

    @POST("/quiz_Model/AddQuiz")
    Call<Quiz_model> addModel(@Body Quiz_model model);


}
