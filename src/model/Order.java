package model;

import model.decorator.Beverage;

import java.util.ArrayList;
import java.util.List;

public class Order {
    int id;
    List<Beverage> beverages;

    public Order(int num) {
        this.id = num;
        this.beverages = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void addBeverage(Beverage bv) {
        beverages.add(bv);
    }

    public int sizeBeverages() {
        return beverages.size();
    }

    public void removeBeverage(int i) {
        beverages.remove(i);
    }

    public boolean isClear() {
        return beverages.isEmpty();
    }

    public void clearList() {
        beverages.clear();
    }

    public Beverage getBeverages(int ind) {
        return beverages.get(ind);
    }

    @Override
    public String toString() {
        StringBuilder ss = new StringBuilder();
        for (int i = 0; i < sizeBeverages(); i++) {
            ss.append(getBeverages(i).getDescription());
        }
        return ss.toString();
    }

}
