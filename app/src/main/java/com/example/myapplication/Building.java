package com.example.myapplication;

import java.util.ArrayList;

public class Building {
    private int id = -1;
    private String address;

    public double getTotalSquareArea() {
        return totalSquareArea;
    }

    private double totalSquareArea;
    private int floors;
    private int flats;
    private String heating_type;
    private boolean elevator;
    //-------------------------
    public double monthlyElectricityCost;
    public double monthlyElevatorCost;
    public double cleaningCost;
    public double heatingCost;
    public double cost;
    public int sum;
    public Flat f;
    public ArrayList<Flat> myFlats = new ArrayList<Flat>();
    
    public int getId(){
        return id;
    }

    public void setId(int id){this.id = id;}

    public String getAddress(){
        return address;
    }

    public int getFloors(){
        return floors;
    }

    public int getNumOfFlats(){
        return myFlats.size();
    }

    public String getHeatingType(){
        return heating_type;
    }

    public boolean hasElevator(){
        return elevator;
    }

    public double getElectricityCost(){
        return this.monthlyElectricityCost;
    }

    public void setElectricityCost(double ec){
        this.monthlyElectricityCost = ec;
    }

    public double getElevatorCost(){
        return this.monthlyElevatorCost;
    }

    public void setElevatorCost(double elcost){
       this.monthlyElevatorCost = elcost;
    }

    public double getCleaningCost(){
        return this.cleaningCost;
    }

    public void setCleaningCost(double cc){
        this.cleaningCost = cc;
    }

    public double getHeatingCost(){
        return this.heatingCost;
    }

    public void setHeatingCost(double hc){
        this.heatingCost = hc;
    }

    public Flat getFlat(int i){
        return this.myFlats.get(i);
    }

    public void addFlat(Flat f) {
        this.myFlats.add(f);
    }

    public int getFlatsSize() {
        return this.myFlats.size();
    }

    public void setTotalSquareArea(double totalSquareArea) {
        this.totalSquareArea = totalSquareArea;
    }

    public double calculateMonthlyBalance(double electricity, double elevator, double cleaning, double heating, Flat f){
        sum = 0;
        for (int y=1; y <= floors; y++){
            sum += y;
        }
        if (heating_type.equalsIgnoreCase("central")) {
            cost = electricity/flats + cleaning/flats + (f.getArea()/totalSquareArea)*heating + (f.getFloor() * (elevator/sum));
        }
        else if (heating_type.equalsIgnoreCase("individual")) {
            cost = electricity/flats + cleaning/flats + f.getHeatingPercentage()*heating + (f.getFloor() * (elevator/sum));
        }
        this.addFlatsMonthlyBalance(f, cost);
        return cost;
    }

    public void addFlatsMonthlyBalance(Flat f, double cost) {
        double currentBalance = f.getBalance().getAmount();
        f.getBalance().setAmount(currentBalance + cost);
    }

    public Building(String address, int floors, String heating, boolean elevator, int flats){
        id++;
        this.address = address;
        this.floors = floors;
        this.heating_type = heating;
        this.elevator = elevator;
        this.flats = flats;
    }

    public void setMonthlyExpenses(double electricity, double elevator, double cleaning, double heating){
        setCleaningCost(cleaning);
        setElectricityCost(electricity);
        setElevatorCost(elevator);
        setHeatingCost(heating);
    }

    public String toString(){
        return "Id:" + this.id + "\n" + "Address: " + this.address + "\n" + "Floors: " + this.floors + "\n" + "Heating type: " + this.heating_type + "\n" + "Elevator: " + this.elevator + "\n" + "Flats: " + this.flats;
    }
}
