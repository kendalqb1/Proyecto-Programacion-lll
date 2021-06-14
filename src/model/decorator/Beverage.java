package model.decorator;


public abstract class Beverage {
    String description;
    Double cost;

    public String getDescription() {
        return description;
    }
    public Double getCost() { return cost; }

    public  abstract  Double cost();


}
