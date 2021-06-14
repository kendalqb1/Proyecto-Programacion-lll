package model.decorator;

public class Milk extends CondimentDecorator {
    Beverage beverage;

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + "Milk. ";
    }
    public Double getCost() { return beverage.cost() + 450; }

    public Double cost() {
        return 450 + beverage.getCost();
    }

}
