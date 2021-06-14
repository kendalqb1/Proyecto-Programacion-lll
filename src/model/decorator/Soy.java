package model.decorator;

public class Soy extends CondimentDecorator {

    Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + "Soy. ";
    }
    public Double getCost() { return beverage.cost() + 400; }

    public  Double cost() {
        return 400 + beverage.getCost();
    }

}
