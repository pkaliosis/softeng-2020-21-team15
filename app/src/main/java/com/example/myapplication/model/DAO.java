package com.example.myapplication.model;

import java.util.ArrayList;

/**
 * <p>
 * This class represents the local memory of the app
 * </p>
 * <p>
 * It stores the necessary data of the app
 * </p>
 */
public class DAO {
    public static ArrayList<User> DAOusers = new ArrayList<User>();
    public static ArrayList<Flat> DAOflats = new ArrayList<Flat>();
    public static ArrayList<Notification> DAOnotifications = new ArrayList<Notification>();
    public static String adminusername;
    public static String adminpassword;
    public static Building building;

    public static void addUser(User u){
        DAOusers.add(u);
    }

    public static void addFlat(Flat f){
        DAOflats.add(f);
    }

    public static void addNotification(Notification n){
        DAOnotifications.add(n);
    }




    public void deleteUser(User u){
        for (int i=0; i< DAOusers.size(); i++){
            if (DAOusers.get(i).getId() == u.getId()){
                DAOusers.remove(i);
            }
        }
    }

    public void deleteFlat(Flat f){
        for (int i=0; i< DAOflats.size(); i++){
            if (DAOflats.get(i).getId() == f.getId()){
                DAOflats.remove(i);
            }
        }
    }

    public User getUser(int id){
        for (int i=0; i< DAOusers.size(); i++){
            if (DAOusers.get(i).getId() == id){
                return DAOusers.get(i);
            }
        }
        return null;
    }

    public Flat getFlat(int id){
        for (int i=0; i< DAOflats.size(); i++){
            if (DAOflats.get(i).getId() == id){
                return DAOflats.get(i);
            }
        }
        return null;
    }

    public Notification getNotification(int nid){
        for (int i=0; i< DAOnotifications.size(); i++){
            if (DAOnotifications.get(i).getNId() == nid){
                return DAOnotifications.get(i);
            }
        }
        return null;
    }

    public static void setAdminUsername(String un){
        adminusername = un;
    }

    public static void setAdminPassword(String pw){
        adminpassword = pw;
    }

    public static void setBuilding(Building b){
        building = b;
    }

    public static String getAdminUsername(){
        return adminusername;
    }

    public static String getAdminPassword(){
        return adminpassword;
    }

    public static Building getBuilding(){
        return building;
    }

}
