package model.decorator;

public class Whip  extends CondimentDecorator{

    Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + "Whip. ";
    }
    public Double getCost() { return beverage.cost() + 300; }

    public Double cost() {
        return 300 + beverage.getCost();
    }

}

