package model.decorator;

public class Decaf  extends Beverage{
    public Decaf() {
        description = "Decaf";
    }

    public double cost() {
        return 2100;
    }
}
