package com.habitissimo.vespapp.questions;

import java.util.Date;

/**
 * Created by archi on 11/03/16.
 */
public class Question {

    private int question_type;
    private String title;
    private boolean is_active;
    private Date created_at;
    private Date updated_at;

    public Question(int question_type, String title, boolean is_active, Date created_at, Date updated_at) {
        this.question_type = question_type;
        this.title = title;
        this.is_active = is_active;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

}
