package model;

import java.util.ArrayList;

public class DarkRoast extends  Beverage{
    public DarkRoast() {
        price = 2500;
        basic = true;
        description = "Dark Roast";
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
