package com.example.myapplication;

public class Balance {
    private int b_id = -1;
    private double amount;
    private int user_id;
    private int flat_id;
    
    public int getBId() {
        return b_id;
    }
    public int getUserId() {
        return user_id;
    }
    
    public double getAmount() {
        return amount;
    }

    public void setAmount(double am) {
        this.amount = am;
    }

    Balance(double amount, int user_id, int fid){
        b_id++;
        this.amount = amount;
        this.user_id = user_id;
        this.flat_id = fid;
    }
}
