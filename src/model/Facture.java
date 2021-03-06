package model;

import model.decorator.Beverage;

import java.util.ArrayList;
import java.util.Date;

public class Facture {
    private String clientName;
    private ArrayList<Beverage> arrayBeverages;
    private String stateOrder;
    private String date;
    private double totalCost;

    public Facture(String clientName, ArrayList<Beverage> arrayBeverages, String stateOrder, String date, double totalCost) {
        this.clientName = clientName;
        this.arrayBeverages = arrayBeverages;
        this.stateOrder = stateOrder;
        this.date = date;
        this.totalCost = totalCost;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public ArrayList<Beverage> getArrayBeverages() {
        return arrayBeverages;
    }

    public void setArrayBeverages(ArrayList<Beverage> arrayBeverages) {
        this.arrayBeverages = arrayBeverages;
    }

    public String getStateOrder() {
        return stateOrder;
    }

    public void setStateOrder(String stateOrder) {
        this.stateOrder = stateOrder;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
}
