package com.scaler.lld.basics;

public class OopBankAccount {
    private Integer number;
    private String name;
    private Integer balance;

    public OopBankAccount(Integer number, Integer balance, String name) {
        this.number = number;
        this.balance = balance;
        this.name = name;
    }

    // GETTERS AND SETTERS START  
    public Integer getNumber() {
        return this.number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBalance() {
        return this.balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    // GETTERS AND SETTERS END


    public void deposit(Integer amount) {
        this.balance  += amount;
    }

    public void withdraw(Integer amount) {
        this.balance  -= amount;
    }

    public void transfer(OopBankAccount destination, Integer amount) {
        this.withdraw(amount);
        destination.deposit(amount);
    }
    
}

