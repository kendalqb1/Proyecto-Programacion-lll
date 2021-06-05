package model;

import java.util.ArrayList;

public class HouseBlend extends  Beverage{
    public HouseBlend() {
        price = 2300;
        basic = true;
        description = "HouseBlend";
        extra = new ArrayList<>();
    }
    @Override
    public void addExtra(double ex){
    extra.add(ex);
}    
 
    public double cost() {
        return price;
    }
}
