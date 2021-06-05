package controller.decorator;

public class Moka extends CondimentDecorator{
    Beverage beverage;

    public Moka(Beverage beverage) {
        this.beverage= beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Moka";
    }

    public double cost() {
        return 0 + beverage.cost();
    }

}
