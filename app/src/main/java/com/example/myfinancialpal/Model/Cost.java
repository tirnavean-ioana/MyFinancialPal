package com.example.myfinancialpal.Model;

import java.util.Date;

class Cost {

    private String destination;
    private double amount;
    private Date date;

    public Cost() {
    }

    public Cost(String destination, double amount, Date date) {
        this.destination = destination;
        this.amount = amount;
        this.date = date;
    }


    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
