package model;

import model.decorator.Beverage;

import java.util.ArrayList;
import java.util.List;

public class Order {
    int id;
    List<Beverage> beverages;

    public Order(int num){
        this.id = num;
        this.beverages = new ArrayList<>();
    }
    //id de la lista
    public int getId() {return id;}

    //agregar bebida por tipo
    public void addBeverage(Beverage bv) {
        beverages.add(bv);
    }

    //para contar las bebidas en el menu
    public int sizeBeverages() {
        return beverages.size();
    }

    //para remover bebidas especificas podemos hacer un pop menu con la descripcion de las bebidas
    //pero por ahora solo remueve la ultima bebida
    public void removeBeverage() {
        beverages.remove(1);
    }

    public void clearList() {
        beverages.clear();
    }

    //get individual para cada bebida por index en la lista en caso que sea necesario usar uno de sus metodos
    public Beverage getBeverages(int ind){ return beverages.get(ind); }

    @Override
    public String toString() {
        StringBuilder ss = new StringBuilder();
        for (int i = 0; i < sizeBeverages(); i++) {
            ss.append(getBeverages(i).getDescription());
        }
        return ss.toString();
    }

}
