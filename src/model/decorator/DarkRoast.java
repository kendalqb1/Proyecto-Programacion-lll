package model.decorator;

public class DarkRoast extends Beverage {
    public DarkRoast() {
        description = "Dark Roast\n";
    }

    public double cost() {
        return 2500;
    }
}
