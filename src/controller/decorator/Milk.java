package controller.decorator;

public class Milk extends CondimentDecorator {
    Beverage beverage;

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ",Milk";
    }
    //TODO: price milk
    public double cost() {
        return 0 + beverage.cost();
    }

}
