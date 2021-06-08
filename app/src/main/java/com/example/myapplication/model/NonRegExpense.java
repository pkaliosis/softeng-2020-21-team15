package com.example.myapplication.model;

/**
 * <p>
 * This class handles the main functions of the non regular expenses
 * </p>
 */
public class NonRegExpense {
    private static int nid = 0;
    private int flat_id;
    private String description;
    private double time_expected;
    private double cost;

    public int getNonRegExpenseId() {
        return nid;
    }

    public int getFlatId() {
        return flat_id;
    }

    public double getCost() {
        return cost;
    }
    
    public double getTimeExpected() {
        return time_expected;
    }
    
    public String getDescription() {
        return description;
    }

    NonRegExpense(int flat_id, String description, double cost, double time_expected){
        nid++;
        this.flat_id = flat_id;
        this.description = description;
        this.time_expected = time_expected;
        this.cost = cost;
    }

    public String toString(){
        return "Non Regular Expense ID: " + this.getNonRegExpenseId() + "\n"
        + "Flat ID: " + this.getFlatId() + "\n"
        + "Description: " + this.getDescription() + "\n"
        + "Time Expected: " + this.getTimeExpected() + "\n"
        + "Cost: " + this.getCost();
    }
}
