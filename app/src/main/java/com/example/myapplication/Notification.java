package com.example.myapplication;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Notification {
    private int n_id = 0;
    private String date;
    private String description;

    public int getNId() {
        return n_id;
    }

    public String getDescription() {
        return description;
    }
    
    public String getDate() {
        return date;
    }

    Notification(String description, String date){
        n_id++;
        this.date = date;
        this.description = description;
    }
}
