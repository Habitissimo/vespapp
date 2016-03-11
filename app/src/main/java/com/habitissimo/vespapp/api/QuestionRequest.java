package com.habitissimo.vespapp.api;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by archi on 11/03/16.
 */
public class QuestionRequest {
    public List<String> answers_ids;

    public QuestionRequest() {
        this.answers_ids = new ArrayList();
    }

    public void add(String s) {
        this.answers_ids.add(s);
    }
}
