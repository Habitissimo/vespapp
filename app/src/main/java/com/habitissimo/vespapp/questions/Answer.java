package com.habitissimo.vespapp.questions;

/**
 * Created by archi on 11/03/16.
 */
public class Answer {
    private Question question;
    private String value;

    public Answer() {
    }

    public Answer(Question question, String value) {
        this.question = question;
        this.value = value;
    }
}
