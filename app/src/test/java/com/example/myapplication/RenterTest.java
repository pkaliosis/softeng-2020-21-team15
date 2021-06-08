package com.example.myapplication;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.configuration.IMockitoConfiguration;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class RenterTest {

    Renter r;
    int id = 456;
    String username = "username";
    String password = "password";
    Flat flat;
    int fid;
    double amount = 20.0;
    String date = "today";
    Payment p;
    NonRegExpense nre;

    @Before
    public void setUp() throws Exception {
        flat = new Flat(0, 4, 45, 0.23);
        fid = flat.getId();
        r = new Renter(id, username, password, fid, flat);
        p = new Payment(amount, r.getId(), PaymentType.ONLINE, date);
        nre = new NonRegExpense(fid, "description", 20.0, 23.0);
    }

    @Test
    public void testGetYourFlat() {
        Assert.assertEquals(fid, r.getYourFlat().getId());
    }

    @Test
    public void testMakePayment() {
        Payment newP = r.makePayment(amount ,"12345678", "09/23", "gp", "123", date);
        Assert.assertEquals(p.getAmount(), newP.getAmount(), 0.01);
        Assert.assertEquals(p.getDate(), newP.getDate());
        Assert.assertEquals(p.getType(), newP.getType());
        Assert.assertEquals(p.getUserId(), newP.getUserId());
    }

    @Test
    public void testShowPayments() {
        Payment newP1 = r.makePayment(amount ,"12345678", "09/23", "gp", "123", date);
        Payment newP2 = r.makePayment(amount+10 ,"12345678", "09/23", "gp", "123", date);
        Assert.assertEquals(2, r.showPayments());
    }

    @Test
    public void testNonRegExpensesRequest() {
        Assert.assertEquals(fid, r.nonRegExpensesRequest("description", 20.0, 23.0).getFlatId());
        Assert.assertEquals("description", r.nonRegExpensesRequest("description", 20.0, 23.0).getDescription());
    }
}