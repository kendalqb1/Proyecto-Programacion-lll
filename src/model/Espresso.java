package model;

import java.util.ArrayList;

public class Espresso extends  Beverage{
    public Espresso() {
        price = 1900;
        basic = true;
        description = "Espresso";
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
