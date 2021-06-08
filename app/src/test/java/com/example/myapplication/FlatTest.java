package com.example.myapplication;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FlatTest {

    int userId = 12;
    int floor = 12;
    double area = 12.0;
    double heating_percentage = 0.12;
    Flat test, test2, test3, test4;

    @Before
    public void setup(){
        test = new Flat(userId, floor, area, heating_percentage);
        test2 = new Flat(userId, floor, area, heating_percentage);
        test3 = new Flat(userId, floor, area, heating_percentage);
        test4 = new Flat(userId, floor, area, heating_percentage);
        test4.updateBalance(12.0);
        test3.setHeatingPercentage(0.5);
    }

    @Test
    public void getArea() {
        Assert.assertEquals(area, test.getArea(), 0.01);
    }

    @Test
    public void getFloor() {
        Assert.assertEquals(floor, test.getFloor());
    }

    @Test
    public void getUserId() {
        Assert.assertEquals(userId, test.getUserId());
    }

    @Test
    public void testGetUserId2(){
        test.setUserId(123);
        Assert.assertEquals(123, test.getUserId());
    }

    @Test
    public void getHeatingPercentage() {
        Assert.assertEquals(heating_percentage, test.getHeatingPercentage(), 0);
    }

    @Test
    public void getBalance() {
        Assert.assertEquals(0, test.getBalance().getAmount(), 0.01);
    }

    @Test
    public void updateBalance() {
        Assert.assertEquals(12, test4.getBalance().getAmount(), 0.01);
    }

    @Test
    public void setHeatingPercentage() {
        Assert.assertEquals(0.5, test3.getHeatingPercentage(), 0);
    }
}