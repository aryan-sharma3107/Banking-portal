package com.bankingportal.model;

public class User {

    private String name;
    private String email;
    private String password;
    private String address;
    private String phoneNumber;
    private String accountNumber;
    private double balance;
    private String pin;

    public User() {
    }

    public User(String name, String email, String password,
                String address, String phoneNumber,
                String accountNumber) {

        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.accountNumber = accountNumber;
        this.balance = 0;
        this.pin = null;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
