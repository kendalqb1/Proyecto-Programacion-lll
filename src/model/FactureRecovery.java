package model;

import model.decorator.Beverage;

import java.util.ArrayList;
import java.util.Date;

public class FactureRecovery {
    private String ID;
    private String clientName;
    private String arrayBeverages;
    private String stateOrder;
    private String date;
    private double totalCost;

    public FactureRecovery(String ID, String clientName, String arrayBeverages, String stateOrder, String date, double totalCost) {
        this.ID = ID;
        this.clientName = clientName;
        this.arrayBeverages = arrayBeverages;
        this.stateOrder = stateOrder;
        this.date = date;
        this.totalCost = totalCost;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String  getArrayBeverages() {
        return arrayBeverages;
    }

    public void setArrayBeverages(String arrayBeverages) {
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
