package model;

public class Caramel extends  CondimentDecorator{
    
    public Caramel(Beverage bev) {
        super(bev);
        if(super.basic){
            
        super.description +=  "con Leche batida";
        super.basic = false;
        }
        else{super.basic = false; super.description +=  ", Leche batida";}
        super.addExtra(300);
    }

    @Override
    public double cost() {
        double finalPrice = 0;
       for (int i = 0; i < super.extra.size(); i++){
           finalPrice += super.extra.get(i);}
       finalPrice += super.price;
       return finalPrice;
    }

    @Override
    public String getDescription() {
        return super.description;
    }
}
