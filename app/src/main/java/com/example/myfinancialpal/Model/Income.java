package com.example.myfinancialpal.Model;

import java.util.Date;

public class Income {


    // private String title;  // pentru pagina afisata

    private String source;
    private double amount;
    private Date date;

    public Income() {
    }

    public Income(String source, double amount, Date date) {
        this.source = source;
        this.amount = amount;
        this.date = date;
    }


    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
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
