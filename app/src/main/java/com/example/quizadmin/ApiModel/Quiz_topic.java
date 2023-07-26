package com.example.quizadmin.ApiModel;



import java.util.ArrayList;


public class Quiz_topic {

    private int id;
    private String title;
    private int numOfQues;
    private ArrayList<Integer> questionModelId = new ArrayList<>();

    public Quiz_topic(String title, int numOfQues) {
        this.id = id;
        this.title = title;
        this.numOfQues = numOfQues;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumOfQues() {
        return numOfQues;
    }

    public void setNumOfQues(int numOfQues) {
        this.numOfQues = numOfQues;
    }

    public ArrayList<Integer> getQuestionModelId() {
        return questionModelId;
    }

    public void setQuestionModelId(ArrayList<Integer> questionModelId) {
        this.questionModelId = questionModelId;
    }
}
