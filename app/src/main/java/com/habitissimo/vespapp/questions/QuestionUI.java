package com.habitissimo.vespapp.questions;

import java.util.List;

/**
 * Created by archi on 11/03/16.
 */
public class QuestionUI {
    public String preg;
    public String idPreg;
    public List<Question> questions;
    public int question_type; //2 = checkbox, 1 = radioButon

    public QuestionUI(String preg, String idPreg, List<Question> question, int question_type) {
        this.preg = preg;
        this.idPreg = idPreg;
        this.questions = question;
        this.question_type = question_type;
    }

    public boolean isCheckBox() {
        if (this.question_type == 2) {
            return true;
        }
        return false;
    }
}
