package model;

public abstract class CondimentDecorator extends Beverage{
    
    private final Beverage beverage;
    
    CondimentDecorator(Beverage bev){
    this.beverage = bev;
   
    }
    @Override
    public void addExtra(double ex){
    beverage.addExtra(ex);
    }    
    @Override
    public abstract String getDescription();
    
    @Override
    public double cost(){
    return this.beverage.cost();
    }
}
