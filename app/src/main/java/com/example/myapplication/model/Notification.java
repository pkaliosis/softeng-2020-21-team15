package com.example.myapplication.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 * <p>
 * This class handles the main functions and elements of a notification
 * </p>
 */

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

    public Notification(int nid, String description, String date){
        n_id = nid;
        this.date = date;
        this.description = description;
    }

    public String toString(){
        return "Notifications ID: " + this.getNId() + " Date: " + this.getDate() + " Description: " + this.getDescription();
    }
}
