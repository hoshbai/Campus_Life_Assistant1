package com.example.campus_life_assistant.entry;

import java.util.Date;

public class Transaction {
    private String date;
    private double amount;

    public Transaction(String date, double amount) {
        this.date = date;
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }
// Getters and setters
}