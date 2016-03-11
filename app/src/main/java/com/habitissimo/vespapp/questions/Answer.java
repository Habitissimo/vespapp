package com.habitissimo.vespapp.questions;

import java.util.Date;

/**
 * Created by archi on 11/03/16.
 */
public class Answer {

    private Question question;
    private String value;
    private Date created_at;
    private Date updated_at;


    public Answer(Question question, String value, Date created_at, Date updated_at) {
        this.question = question;
        this.value = value;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
}
