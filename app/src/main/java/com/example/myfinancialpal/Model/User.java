package com.example.myfinancialpal.Model;

import java.util.List;

public class User {
    private String username;
    private String password;

    private List<Cost> costs; //cheltuieli
    private List<Income> incomes;  //venituri

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Cost> getCosts() {
        return costs;
    }

    public void setCosts(List<Cost> costs) {
        this.costs = costs;
    }

    public List<Income> getIncomes() {
        return incomes;
    }

    public void setIncomes(List<Income> incomes) {
        this.incomes = incomes;
    }

    //TODO
    // preluare sume din Firebase

    //TODO
    // calcul venituri totale


    //TODO
    // preluare sume din Firebase

    //TODO
    // calcul cheltiueli totale

}
