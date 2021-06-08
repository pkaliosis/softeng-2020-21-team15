package com.example.myapplication;

import java.util.*;

public class Admin {
    public int id;
    public String username;
    public String password;
    //-------------------------------
    public String address;
    public int floors;
    public int num_flats;
    public String heating;
    public boolean elevator;
    public ArrayList<User> users = new ArrayList<User>();
    public Stack<Notification> st = new Stack<Notification>();
    public Building myBuilding;
    public double monthly_cost;
    public HashMap<Integer, Double> monthlyCosts = new HashMap<Integer, Double>();

    public Admin(int id, String username, String password, Building b) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.myBuilding = b;
    }

    public Building initBuilding(String addr, int floors, String heatype, boolean elev, int num_flats){
        myBuilding = new Building(addr, floors, heatype, elev, num_flats);
        return myBuilding;
    }

    public boolean initApartment(double area, int floor, double heatPct){
            Flat apartment = new Flat(-1, -1, floor, area, heatPct);
            int count1 = myBuilding.getNumOfFlats();
            myBuilding.addFlat(apartment);
            int count2 = myBuilding.getNumOfFlats();
            return count1 == count2-1;
    }

    public Renter initRenter(int uid, Flat f, String username, String password){
        Balance balance = new Balance(0, uid, f.getId());

        Renter renter = new Renter(uid, username, password, f.getId(), f);

        this.users.add(renter);

        return renter;
    }

    public boolean signIn(String username, String password){
        if (this.username.equals(username)) {
            if (this.password.equals(password)){
                return true;
            }
        }
        return false;
    }

    public void addUser(User u) {
        users.add(u);
    }

    public User getUser(int id) {
        for (User u : users){
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }

    public void addFlat(Flat f){
        myBuilding.addFlat(f);
    }

    public Flat getFlat(int fid) {
        for (int i=0; i<=this.myBuilding.getFlatsSize(); i++){
            if (this.myBuilding.getFlat(i).getId() == fid) {
                return this.myBuilding.getFlat(i);
            }
        }
        return null;
    }

    public void sendNotification(Notification not){
        st.push(not);
        System.out.println(st.peek()); //wont stay here...
    }

    public HashMap<Integer, Double> showUsersBalances(int mode) {// 1 - total balance, 2 - monthly balance
        HashMap<Integer, Double> temp = new HashMap<>();
        if (mode==1){
            for (User u : users) {
                temp.put(u.getId(), u.getBalance().getAmount());
            }
            return temp;
        }
        else if (mode==2){
            for (User u : users) {
                System.out.println("User: " + u.getId() + ", Balance: " + monthlyCosts.get(u.getFlatId()));
                temp.put(u.getId(), monthlyCosts.get(u.getId()));
            }
            return temp;
        }
        else{
            return null;
        }
    }

    public Building insertMonthlyExpenses(double electricity, double elevator, double cleaning, double heating) {
        myBuilding.setMonthlyExpenses(electricity, elevator, cleaning, heating);
        return myBuilding;
    }

    public boolean managePayment(int uid, double paymentAmount, String description, String date, IntegerAsker asker) throws UserNotFoundException, InvalidTransactionException {
        boolean found = false;

        try{
            for (User u : users){
                if (u.getId() == uid) {
                    found = true;

                    int answer = asker.ask("Accept Payment (1 - confirm or 2 - decline) : \n");

                    if (answer == 1) {
                        double currentBalance = u.getBalance().getAmount();
                        if (currentBalance > 0.0 && paymentAmount <= currentBalance) {
                            u.getBalance().setAmount(currentBalance - paymentAmount);
                            this.myBuilding.getFlat(u.getFlatId()).updateBalance(currentBalance - paymentAmount);
                            Payment payment = new Payment(paymentAmount, u.getId(), PaymentType.PHYSICAL, date);
                            u.addPayment(payment);
                        } else {
                            throw new InvalidTransactionException();
                        }
                    }
                    break;
                }
            }
            if (found==false) {
                throw new UserNotFoundException();
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return found;
    }

    public boolean updateHeatingPercentage(Flat f, Double percentage){
        boolean done = false;
        for (int z=1; z<=myBuilding.getFlatsSize(); z++){
            myBuilding.getFlat(z).setHeatingPercentage(percentage);
            if(myBuilding.getFlat(z).getId() == f.getId()){
                done = true;
                myBuilding.getFlat(z).setHeatingPercentage(percentage);
                break;
            }
        }
        return done;
    }

    public void updateMonthlyBalance(String date){
        for (int j=0; j<=myBuilding.getFlatsSize(); j++) {
            monthlyCosts.remove(myBuilding.getFlat(j).getId());
        }
        for (int z=0; z<=myBuilding.getFlatsSize(); z++){
            monthly_cost = this.myBuilding.calculateMonthlyBalance(myBuilding.getElectricityCost(), myBuilding.getElevatorCost(), myBuilding.getCleaningCost(), myBuilding.getHeatingCost(), myBuilding.getFlat(z));
            monthlyCosts.put(myBuilding.getFlat(z).getId(), monthly_cost);
            for(User u: users){
                if (u.getId() == myBuilding.getFlat(z).getUserId()){
                    u.updateBalance(monthly_cost);
                }
            }
        }
        this.createBalanceNotification(monthlyCosts, date);
    }

    public void createNotification(String description, String date){
        Notification n = new Notification(description, date);
        this.sendNotification(n);
    }

    public Notification createBalanceNotification(HashMap<Integer, Double> hashcost, String date) {
        String message = "";

        for (int i: hashcost.keySet()){
            String flatmessage = "Renter: " + i + ", Amount: " + hashcost.get(i);
            message += flatmessage;
        }

        Notification nf = new Notification(message, date);
        this.sendNotification(nf);
        return nf;
    }

    public boolean editUsersUsername(int id, String newUsername){
        boolean found = false;
        for (User u : users) {
            if (u.getId() == id){
                found = true;
                u.setUsername(newUsername);
                break;
            }
        }
        return found;
    }

    public boolean editUsersId(int id, int newId){
        boolean found = false;
        for (User u : users) {
            if (u.getId() == id){
                found = true;
                u.setId(newId);
                break;
            }
        }
        return found;
    }

    public boolean editUsersPassword(int id, String newPassword){
        boolean found = false;
        for (User u : users) {
            if (u.getId() == id){
                found = true;
                u.setPassword(newPassword);
                break;
            }
        }
        return found;
    }

    public boolean deleteUser(int id) {
        boolean found = false;

        if(!users.isEmpty()){
            for (User u : users) {
                if (u.getId() == id) {
                    found = true;
                    users.remove(u);
                    u.getFlat().setUserId(-1);
                }
            }
        }
        return found;
    }

    public void submitNonRegExpenses(){
        //TO-DO
    }

    public String getUsername(){
        return this.username;
    }

    public Stack<Notification> getNotifStack() {
        return st;
    }

    public static class UserNotFoundException extends Throwable {}

    public static class InvalidTransactionException extends Throwable {}
}