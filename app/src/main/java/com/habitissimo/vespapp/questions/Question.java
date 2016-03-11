package com.habitissimo.vespapp.questions;

/**
 * Created by archi on 11/03/16.
 */
public class Question {
    public static final int TYPE_RADIO = 1;
    public static final int TYPE_CHECKBOX = 2;

    private int question_type;
    private String title;
    private boolean is_active;

    public Question() {
    }

    public Question(int question_type, String title, boolean is_active) {
        this.question_type = question_type;
        this.title = title;
        this.is_active = is_active;
    }
}
