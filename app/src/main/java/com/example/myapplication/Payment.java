package com.example.myapplication;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;    

public class Payment{
    public static void setP_id(int p_id) {
        Payment.p_id = p_id;
    }

    private static int p_id = -1;
    private String date;
    private double amount;
    private int user_id;
    private PaymentType type;

    Payment(double amount, int user_id, PaymentType type, String date){
        p_id++;
        this.date = date;
        this.amount = amount;
        this.user_id = user_id;
        this.type = type;
    }

    public PaymentType getType() {
        return type;
    }

    public int getUserId() {
        return user_id;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public static int getPId() {
        return p_id;
    }
} 