package model.decorator;

public class Moka extends CondimentDecorator{
    Beverage beverage;

    public Moka(Beverage beverage) {
        this.beverage= beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + "Moka. ";
    }
    public Double getCost() { return beverage.cost() + 350; }

    public Double cost() {
        return 350 + beverage.getCost();
    }

}
