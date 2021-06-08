package com.example.myapplication.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BalanceTest {
    Balance b;
    @Before
    public void setUp() throws Exception {
        double amount = 1000;
        int uid = 3;
        int fid = 15;
        b = new Balance(amount, uid, fid);
    }

    @Test
    public void testGetBId(){
        Assert.assertEquals(0, b.getBId());
    }


    @Test
    public void testGetUserId(){
        Assert.assertEquals(3, b.getUserId());
    }

    @Test
    public void testGetAmount(){
        Assert.assertEquals(1000, b.getAmount(), 0);
    }

}