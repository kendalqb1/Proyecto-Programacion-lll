package model.decorator;

public class Espresso extends Beverage{
    public Espresso() {
        description = "Espresso -> ";
        cost = 1900.0;
    }

    public Double cost() {
        return 1900.0;
    }
}
