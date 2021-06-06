package controller.decorator;

public class HouseBlend extends  Beverage{
    public HouseBlend() {
        description = "HouseBlend";
    }

    public double cost() {
        return 2300;
    }
}
