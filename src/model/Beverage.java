package model;

import java.util.ArrayList;
import java.util.List;


public abstract class Beverage {
    public double price; 
    public String description;
    public boolean basic;
    public List<Double> extra;
    

    public double  getprice() {
        return price;
    }
    public String  getDescription() {
        return description;
    }
    public abstract void addExtra(double ex);
        
    public  abstract  double cost();

}
