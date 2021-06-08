package com.example.myapplication.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PaymentTest {
    Payment p;
    @Before
    public void setUp() throws Exception {
        double amount = 500;
        int uid = 4;
        PaymentType pt = PaymentType.PHYSICAL;
        String date = "17.5.2021";

        p = new Payment(amount, uid, pt, date);
        p.setP_id(0);
    }

    @Test
    public void testGetType(){
        Assert.assertEquals(PaymentType.PHYSICAL, p.getType());
    }

    @Test
    public void testGetUserId(){
        Assert.assertEquals(4, p.getUserId());
    }

    @Test
    public void testGetAmount(){
        Assert.assertEquals(500, p.getAmount(), 0);
    }

    @Test
    public void testGetDate(){
        Assert.assertEquals("17.5.2021", p.getDate());
    }

    @Test
    public void testGetPId() {
        Assert.assertEquals(0, p.getPId());
    }
}