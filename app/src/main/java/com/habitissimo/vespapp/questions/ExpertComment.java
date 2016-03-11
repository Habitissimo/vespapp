package com.habitissimo.vespapp.questions;

import java.util.Date;

/**
 * Created by archi on 11/03/16.
 */
public class ExpertComment {
    public String body;
    public boolean is_valid;
    public Date created_at;
    public Date updated_at;

    public ExpertComment(String body, boolean is_valid, Date created_at, Date updated_at) {
        this.body = body;
        this.is_valid = is_valid;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
}
