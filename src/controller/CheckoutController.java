package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Checkout;
import model.Order;

public class CheckoutController {
    @FXML
    private TextArea textArea;

    @FXML
    private TextField totalPrice;

    @FXML
    void initialize() {
        Checkout checkout = Checkout.getInstance();
        Order order = checkout.getOrder();
        double price = 0;
        for (int i = 0; i < order.sizeBeverages(); i++) {
            price += order.getBeverages(i).cost();
            textArea.appendText(
                    order.getBeverages(i).getDescription() + "\nCost Coffe: " +
                            order.getBeverages(i).cost() + "\n------------------------------\n"
            );
        }
        textArea.appendText("Total Order: " + price);
        totalPrice.appendText(String.valueOf(price));

    }

    @FXML
    void payOrder() {

    }


}
