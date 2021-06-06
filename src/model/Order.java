package model;

import java.util.ArrayList;
import java.util.List;


public class Order {
    int id;
    //listas separadas para poder remover bebidas independientes en el menu de pedido
    List<Beverage> DarkRoast;
    List<Beverage> Decaf;
    List<Beverage> Espresso;
    List<Beverage> HouseBlend;

    public Order(int num){
        this.id = num;
        this.DarkRoast = new ArrayList<>();
        this.Decaf = new ArrayList<>();
        this.Espresso = new ArrayList<>();
        this.HouseBlend = new ArrayList<>();
    }
    //id de la lista
    public int getId() {return id;}

    //agregar bebida por tipo
    public void addDarkRoast(Beverage bv){
        DarkRoast.add(bv);
    }
    public void addDecaf(Beverage bv){
        Decaf.add(bv);
    }
    public void addEspresso(Beverage bv){
        Espresso.add(bv);
    }
    public void addHouseBlend(Beverage bv){
        HouseBlend.add(bv);
    }

    //para contar las bebidas en el menu
    public int sizeDarkRoast(){
        return DarkRoast.size();
    }
    public int sizeDecaf(){
        return Decaf.size();
    }
    public int sizeEspresso(){
        return Espresso.size();
    }
    public int sizeHouseBlend(){
        return HouseBlend.size();
    }

    //para remover bebidas especificas podemos hacer un pop menu con la descripcion de las bebidas
    //pero por ahora solo remueve la ultima bebida
    public void removeLastDarkRoast(){
        DarkRoast.remove(DarkRoast.size() -1);
    }
    public void removeLastDecaf(){
        Decaf.remove(Decaf.size() -1);
    }
    public void removeLastEspresso(){
        Espresso.remove(Espresso.size() -1);

    } public void removeLastHouseBlend(){
        HouseBlend.remove(HouseBlend.size() -1);
    }


    //get individual para cada bebida por index en la lista en caso que sea necesario usar uno de sus metodos
    public Beverage getDarkRoast(int ind){
        return DarkRoast.get(ind);
    }
    public Beverage getDecaf(int ind){
        return Decaf.get(ind);
    }
    public Beverage getEspresso(int ind){
        return Espresso.get(ind);
    }
    public Beverage getHouseBlend(int ind){
        return HouseBlend.get(ind);
    }

    public String printDarkRoast() {
        String s = "";
        for (int i = 0; i < DarkRoast.size(); i++){
            s += DarkRoast.get(i).getDescription();
            s+= "\n";}
        return s;
    }
    public String printDecaf() {
        String s = "";
        for (int i = 0; i < Decaf.size(); i++){
            s += Decaf.get(i).getDescription();
            s+= "\n";}
        return s;
    }
    public String printEspresso() {
        String s = "";
        for (int i = 0; i < Espresso.size(); i++){
            s += Espresso.get(i).getDescription();
            s+= "\n";}
        return s;
    }
    public String printHouseBlend() {
        String s = "";
        for (int i = 0; i < HouseBlend.size(); i++){
            s += HouseBlend.get(i).getDescription();
            s+= "\n";}
        return s;
    }

    // descripcion de todas las bebidas en la orden para la lista de ordenes
    public String printOrder(){
        String s = "";
        s+= printDarkRoast();
        s+=printDecaf();
        s+=printEspresso();
        s+=printHouseBlend();
        return s;
    }
}
