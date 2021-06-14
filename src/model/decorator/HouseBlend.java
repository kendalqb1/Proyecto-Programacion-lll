package model.decorator;

public class HouseBlend extends  Beverage{
    public HouseBlend() {
        description = "HouseBlend -> ";
        cost = 2300.0;
    }

    public Double cost() {
        return 2300.0;
    }
}
