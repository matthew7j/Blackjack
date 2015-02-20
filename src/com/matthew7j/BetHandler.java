package com.matthew7j;

public class BetHandler {

    private Person p;
    private double amount, tableMin, tableMax;

    public BetHandler(Player p, double amount, double tableMin, double tableMax){
        this.p = p;
        this.amount = amount;
        this.tableMin = tableMin;
        this.tableMax = tableMax;

        betHandlerEngine();
    }

    private void betHandlerEngine(){

    }
}
