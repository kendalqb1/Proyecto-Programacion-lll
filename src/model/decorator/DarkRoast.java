package model.decorator;

public class DarkRoast extends Beverage {
    public DarkRoast() {
        description = "Dark Roast -> ";
        cost = 2500.0;
    }

    public Double cost() {
        return 2500.0;
    }
}
