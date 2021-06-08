package com.example.myapplication.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AdminTest {
    Admin admin;
    String s1;
    String s2;
    Flat f;
    User u;
    Stack<Notification> st;

    double electricity = 200.0;
    double elevator = 50.0;
    double cleaning = 20.6;
    double heating = 12.3;
    int flats = 20;

    @Before
    public void setUp() throws Exception {
        String address = "Patission 76";
        int floors = 5;
        String heating = "central";
        boolean elevator = true;
        int flats = 20;

        Building b = new Building(address, floors, heating, elevator, flats);

        int id =1;
        String username = "username";
        String password = "password";
        admin = new Admin(id, username, password, b);

        s1 = "username";
        s2 = "password";

        int uid = 2;
        int floor = 2;
        double area = 250;
        double heatingPercentage = 0.9;

        double amount = 200.0;
        int fid = 12;

        f = new Flat(fid, uid, floor, area, heatingPercentage);
        admin.addFlat(f);

        int id1 = 2;
        String username1 = "user1";
        String password1 = "password1";

        u = new User(id1, username1, password, fid, f);
        admin.addUser(u);

        String description = "A very nice description.";
        String date = "17.5.2021";
        int nid = 1;

        Notification n = new Notification(nid, description, date);
        admin.sendNotification(n);
        st = admin.getNotifStack();
    }

    @Test
    public void testSignINtrue() {
        Assert.assertEquals(true, admin.signIn(s1, s2));
    }

    @Test
    public void testSignINfalse() {
        Assert.assertEquals(false, admin.signIn(s1, "s2"));
    }

    @Test
    public void testGetUsertrue(){
        Assert.assertEquals(this.u, admin.getUser(2));
    }

    @Test
    public void testGetUserfalse(){ Assert.assertEquals(null, admin.getUser(888888888));}

    @Test
    public void testAddUser() {
        boolean found=false;
        for (User user : admin.users) {
            if (user.getId() == u.getId()) {
                found = true;
            }
        }
        Assert.assertEquals(true, found);
    }

    @Test
    public void testInitBuilding() {
        Building temp = admin.initBuilding("pathsiwn76", 4, "central", true, flats);
        for (int i = 0; i<flats; i++){
            temp.addFlat(f);
        }
        Assert.assertEquals(flats, temp.getNumOfFlats());
    }

    @Test
    public void testAddFlat() {
        Flat f1 = new Flat(0, 0, 0, 0.0, 0);
        int temp = f1.getId();
        admin.addFlat(f1);
        Assert.assertEquals(temp, admin.getFlat(temp).getId());
    }

    @Test
    public void testInsertMonthlyExpenses() {
        Assert.assertEquals(electricity, admin.insertMonthlyExpenses(electricity, elevator, cleaning, heating).getElectricityCost(), 0);
    }

    @Test
    public void testUpdateMonthlyBalance() {
    }

    @Test
    public void testEditUsersUsername(){
        Assert.assertEquals(true, admin.editUsersUsername(u.getId(), "newusername"));
    }

    @Test
    public void testInitApartments() {
        Assert.assertEquals(true, admin.initApartment(0, 0, 0));
    }

    @Test
    public void testInitRenter() {
        Renter temp = new Renter(0, "u", "p", f.getId(), f);
        Assert.assertEquals(temp.getId(), admin.initRenter(0, f, "u", "p").getId());
    }

    @Test
    public void testeditUsersId() {
        Assert.assertEquals(true, admin.editUsersId(u.getId(), 29));
    }

    @Test
    public void testEditUsersPassword() {
        Assert.assertEquals(true, admin.editUsersPassword(u.getId(), "newpassword"));
    }

    @Test
    public void testDeleteUser(){
        admin.addUser(u);
        Assert.assertEquals(true, admin.deleteUser(u.getId()));
    }

    @Test
    public void testManagePayment() throws Admin.InvalidTransactionException, Admin.UserNotFoundException {
        IntegerAsker asker = mock(IntegerAsker.class);
        when(asker.ask(anyString())).thenReturn(1);
        u.updateBalance(30.0);
        Assert.assertEquals(true, admin.managePayment(u.getId(), 20.0, "payment", "today", asker));
    }

    @Test
    public void testCreateBalanceNotification(int nid){
        Notification temp = new Notification(nid, "description", "today");
        HashMap<Integer, Double> hm = new HashMap<>();
        hm.put(0, 20.0);
        hm.put(0, 40.0);
        Assert.assertEquals(temp.getNId(), admin.createBalanceNotification(hm, "today", nid).getNId());
    }
}