package com.example.myapplication.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Stack;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

public class UserTest{

    String username = "fotispanos";
    String password = "p1p2p3p4p5";
    double amount = 50.0;
    int id1 = 4;
    Balance b;
    Flat f;
    User u;
    User u2;
    HashMap<String, String> credentials;
    Payment p;


    @Before
    public void setUp() throws Exception {
        b = new Balance(400.0, 4, 11);
        f = new Flat(4, 3, 55.5, 15.0);
        u = new User(4, username, password, 11, f);
        u.updateBalance(400.0);
        credentials = u.getCredentials();
        u2 = new User(0, "0", "0", 0, f);
        u2.setFlatId(20);
        u2.setPassword("20");
        u2.setUsername("20");
        u2.setId(20);
        p = new Payment(20, u.getId(), PaymentType.ONLINE, "now");
    }

    @Test
    public void updateBalanceTest(){
        u.updateBalance(amount);
        Assert.assertEquals(50.0, u.getBalance().getAmount(), 0.001);
    }

    @Test
    public void getUsernameTest(){
        Assert.assertEquals("fotispanos", u.getUsername());
    }

    @Test
    public void getPasswordTest(){
        Assert.assertEquals("p1p2p3p4p5", u.getPassword());
    }

    @Test
    public void getFlatIdTest(){
        Assert.assertEquals(11, u.getFlatId());
    }

    @Test
    public void getIdTest(){
        Assert.assertEquals(4, u.getId());
    }

    @Test
    public void getBalanceTest(){
        Assert.assertEquals(b.getAmount(), u.getBalance().getAmount(), 0);
    }

    @Test
    public void getFlatTest(){
        Assert.assertEquals(f, u.getFlat());
    }

    @Test
    public void checkTrue() {
        Assert.assertEquals(true, u.check(credentials, username, password));
    }

    @Test
    public void checkFalse() {
        Assert.assertEquals(false, u.check(credentials, username, "wrong"));
    }

    @Test
    public void showBalanceTest(){
        Assert.assertEquals(b.getAmount(), u.showBalance(), 0);
    }

    @Test
    public void testGetId() {
        Assert.assertEquals(4, u.getId());
    }

    @Test
    public void testGetUsername() {
        Assert.assertEquals(username, u.getUsername());
    }

    @Test
    public void testGetPassword() {
        Assert.assertEquals(password, u.getPassword());
    }

    @Test
    public void testGetFlatId() {
        Assert.assertEquals(11, u.getFlatId());
    }

    @Test
    public void testSetId() {
        u.setId(5);
        Assert.assertEquals(5, u.getId());
    }

    @Test
    public void testSetUsername() {
        u.setUsername("new");
        Assert.assertEquals("new", u.getUsername());
    }

    @Test
    public void testSetPassword() {
        u.setPassword("12345");
        Assert.assertEquals("12345", u.getPassword());
    }

    @Test
    public void testSetFlatId() {
        u.setFlatId(12);
        Assert.assertEquals(12, u.getFlatId());
    }

    @Test
    public void testGetFlat() {
        Assert.assertEquals(f.getId(), u.getFlat().getId());
    }

    @Test
    public void testShowNotifications() {
        Notification n = mock(Notification.class);
        u.addNotification(n);
        Assert.assertEquals(1, u.showNotifications());
    }

    @Test
    public void testChangePasswordTrue() {
        Assert.assertEquals(true, u.changePassword(password, password));
    }

    @Test
    public void testChangePasswordFalse() {
        Assert.assertEquals(false, u.changePassword("password", password));
    }

    @Test
    public void testSignInTrue(){
        Assert.assertEquals(true, u.signIn(username, password));
    }

    @Test
    public void testSignInFalse(){
        Assert.assertEquals(false, u.signIn(username, "password"));
    }

    @Test
    public void testShowUserInfo(){
        Assert.assertEquals(5, u.showUserInfo());
    }

    @Test
    public void testAddPayment() {
        u2.addPayment(p);
    }
}