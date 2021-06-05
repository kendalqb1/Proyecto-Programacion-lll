package model;

public class SteamedMilk extends  CondimentDecorator{
    
    public SteamedMilk(Beverage bev) {
        super(bev);
        if(super.basic){
            
        super.description +=  "con Leche al Vapor";
        super.basic = false;
        }
        else{super.basic = false; super.description +=  ", Leche al Vapor";}
        super.addExtra(450);
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
