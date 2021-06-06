package model;

public class Checkout {

    private Order order = new Order(-1);
    private static Checkout instance;

    private Checkout() {

    }

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
