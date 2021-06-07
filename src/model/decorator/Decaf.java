package model.decorator;

public class Decaf  extends Beverage{
    public Decaf() {
        description = "Decaf\n";
    }

    public double cost() {
        return 2100;
    }
}
