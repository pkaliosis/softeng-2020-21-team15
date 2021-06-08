package com.example.myapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * <p>
 * This class handles the main functions and elements of the flat
 * </p>
 */
public class Flat implements Parcelable {
    private int id;
    private int userId;
    private int floor;
    private double area;
    private double heating_percentage;
    private Balance balance;

    public Flat(int id, int uid, int floor, double area, double heating_percentage){
        this.id = id;
        this.userId = uid;
        this.floor = floor;
        this.area = area;
        this.heating_percentage = heating_percentage;
        this.balance = new Balance(0, uid, id);
    }

    public Flat(Flat f) {
        this.id = f.id;
        this.userId = f.userId;
        this.floor = f.floor;
        this.area = f.area;
        this.heating_percentage = f.heating_percentage;
        this.balance = new Balance(0, f.userId, this.id);
    }

    protected Flat(Parcel in) {
        id = in.readInt();
        userId = in.readInt();
        floor = in.readInt();
        area = in.readDouble();
        heating_percentage = in.readDouble() / 100;
        balance = new Balance(0, userId, this.id);
    }

    public static final Creator<Flat> CREATOR = new Creator<Flat>() {
        @Override
        public Flat createFromParcel(Parcel in) {
            return new Flat(in);
        }

        @Override
        public Flat[] newArray(int size) {
            return new Flat[size];
        }
    };

    public double getArea() {
        return area;
    }

    public int getFloor() {
        return floor;
    }

    public int getId() {
        return id;
    }

    public void setUserId(int uid2){
        this.userId = uid2;
    }

    public int getUserId() {
        return userId;
    }

    public double getHeatingPercentage() {
        return heating_percentage;
    }

    public void setHeatingPercentage(double hp) {
        this.heating_percentage = hp;
    }
    public Balance getBalance() {
        return this.balance;
    }
    public void updateBalance(double am) {
        this.getBalance().setAmount(am);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(userId);
        dest.writeInt(floor);
        dest.writeDouble(area);
        dest.writeDouble(heating_percentage);
    }

    public String toString(){
        return "Flat ID: " + this.getId() + "Flats User ID: " + this.getUserId() + "Flats Balanace: " + this.getBalance().getAmount();
    }
}
