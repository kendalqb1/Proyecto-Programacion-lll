package model;

import model.decorator.Beverage;

import java.util.ArrayList;

public class Facture {
    private String clientName;
    private ArrayList<Beverage> arrayBeverages;
    private String stateOrder;
    private double subTotal;
    private double totalCost;

    public Facture(String clientName, ArrayList<Beverage> arrayBeverages, String stateOrder, double subTotal, double totalCost) {
        this.clientName = clientName;
        this.arrayBeverages = arrayBeverages;
        this.stateOrder = stateOrder;
        this.subTotal = subTotal;
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

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
}
