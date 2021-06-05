package model;

public class Soy extends  CondimentDecorator{
    
    public Soy(Beverage bev) {
        super(bev);
        if(super.basic){
            
        super.description +=  "con Leche de Soya";
        super.basic = false;
        }
        else{super.basic = false; super.description +=  ", Leche de Soya";}
        super.addExtra(400);
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
