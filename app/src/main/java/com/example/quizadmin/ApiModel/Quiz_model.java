package com.example.quizadmin.ApiModel;




public class Quiz_model {

    private int id;
    public   int titleId;
    private String question;
    private  String options1;
    private  String options2;
    private  String options3;
    private  String options4;
    private String correct_option;

    public Quiz_model( int titleId, String question, String options1, String options2, String options3, String options4, String correct_option) {
        this.titleId = titleId;
        this.question = question;
        this.options1 = options1;
        this.options2 = options2;
        this.options3 = options3;
        this.options4 = options4;
        this.correct_option = correct_option;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTitleId() {
        return titleId;
    }

    public void setTitleId(int titleId) {
        this.titleId = titleId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOptions1() {
        return options1;
    }

    public void setOptions1(String options1) {
        this.options1 = options1;
    }

    public String getOptions2() {
        return options2;
    }

    public void setOptions2(String options2) {
        this.options2 = options2;
    }

    public String getOptions3() {
        return options3;
    }

    public void setOptions3(String options3) {
        this.options3 = options3;
    }

    public String getOptions4() {
        return options4;
    }

    public void setOptions4(String options4) {
        this.options4 = options4;
    }

    public String getCorrect_option() {
        return correct_option;
    }

    public void setCorrect_option(String correct_option) {
        this.correct_option = correct_option;
    }
}
