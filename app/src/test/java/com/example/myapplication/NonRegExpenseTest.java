package com.example.myapplication;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NonRegExpenseTest {

    int flat_id = 40;
    String description = "Test Message";
    int time_expected = 120;
    double cost = 70;
    NonRegExpense test1, test2, test3, test4;

    @Before
    public void setUp() throws Exception {
        test1 = new NonRegExpense(flat_id, description, cost, time_expected);
        test2 = new NonRegExpense(flat_id, description, cost, time_expected);
        test3 = new NonRegExpense(flat_id, description, cost, time_expected);
        test4 = new NonRegExpense(flat_id, description, cost, time_expected);
    }

    @Test
    public void testToString() {
        Assert.assertEquals("Non Regular Expense ID: " + test1.getNonRegExpenseId() + "\nFlat ID: 40\n" +
                "Description: Test Message\nTime Expected: 120.0\nCost: 70.0", test1.toString());
    }

    @Test
    public void testgetFlatID(){
        Assert.assertEquals(flat_id, test4.getFlatId());
    }

    @Test
    public void testgetCost(){
        Assert.assertEquals(cost, test4.getCost(), 0.02);
    }

    @Test
    public void testgetTimeExpected(){
        Assert.assertEquals(time_expected, test4.getTimeExpected(), 0.01);
    }

    @Test
    public void testgetDescription(){
        Assert.assertEquals(description, test4.getDescription());
    }
}