package com.example.magic8ballapi.model;

import javax.validation.constraints.NotEmpty;

public class Answer {
//    @NotEmpty(message="Must not be empty.")
    private String question;
//    @NotEmpty(message="Must not be empty.")
    private String answer;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }


}
