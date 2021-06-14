package model;
import java.util.Observable;

public class Checkout extends Observable {
    private Order order = new Order(-1);
    private static Checkout instance;

    private Checkout() {

    }

    //setChanged() its protected so this lets you update from outside
    public void observeChanged(){ setChanged();notifyObservers(); }
    public void notifyExit(){ setChanged();notifyObservers( true); }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public static Checkout getInstance() {
        if (instance == null) {
            instance = new Checkout();
        }
        return instance;
    }

}
