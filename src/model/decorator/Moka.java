package model.decorator;

public class Moka extends CondimentDecorator{
    Beverage beverage;

    public Moka(Beverage beverage) {
        this.beverage= beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + "Moka, ";
    }

    public double cost() {
        return 350 + beverage.cost();
    }

}
