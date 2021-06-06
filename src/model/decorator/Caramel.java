package model.decorator;

public class Caramel extends CondimentDecorator {
    Beverage beverage;

    public Caramel(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Caramel";
    }

    public double cost() {
        return 0 + beverage.cost();
    }

}


