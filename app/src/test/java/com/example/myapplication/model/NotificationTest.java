package com.example.myapplication.model;

import org.junit.*;

import static org.junit.Assert.*;

public class NotificationTest {

    String date = "17-5-2021";
    String description = "Test Message";
    Notification test;

    @Before
    public void setUp() throws Exception {
        test = new Notification(description, date);
    }

    @Test
    public void getNId() {
        Assert.assertEquals(1, test.getNId());
    }

    @Test
    public void getDescription() {
        Assert.assertEquals(description, test.getDescription());
    }

    @Test
    public void getDate() {
        Assert.assertEquals(date, test.getDate());
    }
}