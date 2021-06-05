package model;

public class Moca extends  CondimentDecorator{
    
    public Moca(Beverage bev) {
        super(bev);
        if(super.basic){
            
        super.description +=  "con Moca";
        super.basic = false;
        }
        else{super.basic = false; super.description +=  ", Moca";}
        super.addExtra(350);
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
