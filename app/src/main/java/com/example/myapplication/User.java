package com.example.myapplication;
import java.util.*;

public class User {
    protected int id;
    protected String username;
    protected String password;
    protected int flat_id;
    protected Balance balance;
    protected Flat flat;
    protected ArrayList<Payment> payments = new ArrayList<>();
    Stack<Notification> s = new Stack<>();

    public HashMap<String, String> getCredentials() {
        return credentials;
    }

    HashMap<String, String> credentials = new HashMap<String, String>();

    public User(int id, String username, String password, int fid, Flat f) {
        this.id = id;
        this.username = username;
        this.password = password;
        credentials.put(username, password);
        this.flat_id = fid;
        this.flat = f;
        balance = f.getBalance();
    }

    public void updateBalance(double amount) {
        this.getBalance().setAmount(amount);
    }

    public double showBalance() {
        System.out.println(balance.getAmount()); //depends on how we implement this on android studio...
        return balance.getAmount();
    }

    public Balance getBalance() {
        return this.balance;
    }

    public int getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public int getFlatId() {
        return this.flat_id;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setFlatId(int fid){
        this.flat_id = fid;
    }

    public Flat getFlat() {
        return this.flat;
    }

    public boolean signIn(String username, String password) {
        boolean checked = this.check(credentials, username, password);
        if (checked == true) {
            System.out.println("Succesful sign in!");
        }
        else{ System.out.println("Unsuccesful sign in!"); }

        return checked;
    }

    public boolean check(HashMap<String, String> credentials, String username, String password){
        for (String i : credentials.keySet()) {
            if (i.equals(username)){
                if (credentials.get(i).equals(password)){
                    return true;
                }
            }
        }
        return false;
    }

    public int showNotifications(){
        int count = 0;
        for (Notification notif : s) {
            System.out.println(notif.getDate() + notif.getDescription());
            count++;
        }
        return count;
    }

    public boolean changePassword(String currentP, String newP) {
        if (currentP.equals(this.password)){
            this.setPassword(newP);
            return true;
        }
        else{
            return false;
        }
    }

    public int showUserInfo() {
        int count = 0;
        System.out.println("Id: " + this.getId()); count++;
        System.out.println("Username: " + this.getUsername()); count++;
        System.out.println("Password: " + this.getPassword()); count++;
        System.out.println("Flat ID: " + this.getFlatId()); count++;
        System.out.println("Balance: " + this.getBalance().getAmount());count++;
        return count;
    }

    public void addPayment(Payment payment) {
        this.payments.add(payment);
    }

    public void addNotification(Notification n){
        this.s.push(n);
    }
}