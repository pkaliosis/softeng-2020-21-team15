package com.example.myapplication;

import java.util.ArrayList;
import java.util.Scanner;

public class Owner extends User{

    ArrayList<NonRegExpense> nonRegExpenses = new ArrayList<NonRegExpense>();

    public Owner(int id, String username, String password, int fid, Balance balance, Flat flat, ArrayList<NonRegExpense> nonRegExpenses){
        super(id, username, password, fid, flat);
        this.nonRegExpenses = nonRegExpenses;
    }

    public boolean evaluateNonRegExpense(NonRegExpense nre, IntegerAsker asker) {
        int input = asker.ask("Type your answer (1 - confirm or 2 - decline) : \n");
        return input == 1 ? true : false;
    }

    public int showNonRegExpenses() {
        int count = 0;
        for (NonRegExpense nonreg : nonRegExpenses) {
            System.out.println(nonreg.getDescription());
            count++;
        }
        return count;
    }

    public void submitResult(NonRegExpense nre){
        nonRegExpenses.add(nre);
    }
}