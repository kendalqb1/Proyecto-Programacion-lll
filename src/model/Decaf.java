package model;

import java.util.ArrayList;

public class Decaf extends  Beverage{
    public Decaf() {
        price = 2100;
        basic = true;
        description = "Decaf";
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
