package model.decorator;

public class Caramel extends CondimentDecorator {
    Beverage beverage;

    public Caramel(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Caramel";
    }
    public Double getCost() { return beverage.cost() + 0; }

    public Double cost() {
        return 0 + beverage.cost();
    }

}


