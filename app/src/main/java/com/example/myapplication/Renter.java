package com.example.myapplication;

import java.io.*;
import java.util.*;

public class Renter extends User{
    private Balance b;
    private ArrayList<Payment> payments = new ArrayList<Payment>();

    public Renter(int id, String username, String password, int fid, Flat f) {
        super(id, username, password, fid, f);
        this.b = f.getBalance();
    }

    public Payment makePayment(double amount, String card_number, String expiration_date, String name, String cvv, String date) {
        PaymentType pt = PaymentType.ONLINE;
        Payment payment = new Payment(amount, super.id, pt, date);
        payments.add(payment);
        this.getBalance().setAmount(this.getBalance().getAmount() - payment.getAmount());
        this.getYourFlat().updateBalance(this.getBalance().getAmount() - payment.getAmount());
        return payment;
    }

    public int showPayments(){
        int count = 0;
        for (Payment pay : payments) {
            System.out.println("Payment Date: " + pay.getDate() + ", Payment Amount: " + pay.getAmount());
            count++;
        }
        return count;
    }
    public NonRegExpense nonRegExpensesRequest(String description, double cost, double time){
        int flatId = super.flat_id;
        NonRegExpense nre = new NonRegExpense(flatId, description, cost, time);
        return nre;
    }

    public Flat getYourFlat(){
        return this.flat;
    }
}