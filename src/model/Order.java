package model;

import java.util.ArrayList;
import java.util.List;


public class Order {
    int id;
    List<Beverage> drinks;
    
    public Order(int num){
        this.id = num;
        this.drinks = new ArrayList<Beverage>();
    }
    
    public int getId() {return id;}
    
    public List getDrinks(){return this.drinks;}
    
    public void print() {
        drinks.forEach((drink) -> {drink.getDescription();});
    }
}
