package model.decorator;

public class Espresso extends Beverage{
    public Espresso() {
        description = "Espresso";
    }

    public double cost() {
        return 1900;
    }
}
