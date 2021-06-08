package com.example.myapplication.model;

import org.junit.*;

import static org.junit.Assert.*;

public class BuildingTest {

    double electricity = 200.0;
    double elevator = 50.0;
    double cleaning = 20.6;
    double heating = 12.3;
    double totalSquareArea = 1200.0;
    String address = "local";
    int floors = 5;
    Boolean hasElevator = true;
    int flats = 30;


    Balance balance = new Balance(0, 1, 1);
    Flat test = new Flat(1, 4, 40, 0.22);

    Building b1;
    Building b2;

    @Before
    public void setUp() throws Exception {
        b1 = new Building(address, floors, "central", hasElevator, flats);
        b1.setTotalSquareArea(totalSquareArea);
        b1.setMonthlyExpenses(electricity, elevator, cleaning, heating);

        for (int i =0; i<flats; i++){
            b1.addFlat(test);
        }

        b2 = new Building(address, floors, "individual", hasElevator, flats);
        b2.setTotalSquareArea(totalSquareArea);
    }

    @Test
    public void calculateMonthlyBalanceTestCentral() {
        Assert.assertEquals(21.10, b1.calculateMonthlyBalance(electricity, elevator, cleaning, heating, test), 0.01);
    }

    @Test
    public void calculateMonthlyBalanceTestIndividual(){
        Assert.assertEquals(23.40, b2.calculateMonthlyBalance(electricity, elevator, cleaning, heating, test), 0.01);
    }

    @Test
    public void getTotalSquareArea() {
        Assert.assertEquals(totalSquareArea, b1.getTotalSquareArea(), 0);
    }

    @Test
    public void getAddress() {
        Assert.assertEquals(address, b1.getAddress());
    }

    @Test
    public void getFloors() {
        Assert.assertEquals(floors, b1.getFloors());
    }

    @Test
    public void getNumOfFlats() {
        Assert.assertEquals(flats, b1.getNumOfFlats());
    }

    @Test
    public void getHeatingType() {
        Assert.assertEquals("central", b1.getHeatingType());
    }

    @Test
    public void hasElevator() {
        Assert.assertEquals(hasElevator, b1.hasElevator());
    }

    @Test
    public void getElectricityCost() {
        Assert.assertEquals(electricity, b1. getElectricityCost(), 0);
    }

    @Test
    public void getElevatorCost() {
        Assert.assertEquals(elevator, b1.getElevatorCost(), 0);
    }

    @Test
    public void getCleaningCost() {
        Assert.assertEquals(cleaning, b1.getCleaningCost(), 0);
    }

    @Test
    public void getHeatingCost() {
        Assert.assertEquals(heating, b1.getHeatingCost(), 0);
    }

    @Test
    public void getFlat() {
        Assert.assertEquals(test.getId(), b1.getFlat(0).getId());
    }

    @Test
    public void getFlatsSize() {
        Assert.assertEquals(flats, b1.getFlatsSize());
    }

    @Test
    public void addFlatsMonthlyBalance() {
        b1.addFlatsMonthlyBalance(test, 50);
        b1.addFlatsMonthlyBalance(test, 100);
        Assert.assertEquals(150, b1.getFlat(0).getBalance().getAmount(), 0.01);
    }

    @Test
    public void testGetId() {
        b1.setId(123);
        Assert.assertEquals(123, b1.getId());
    }
}