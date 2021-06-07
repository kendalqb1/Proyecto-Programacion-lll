package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import model.Checkout;
import model.Order;

public class CheckoutController {
    @FXML
    private TextArea textArea;

    @FXML
    void initialize() {
        Checkout checkout = Checkout.getInstance();
        Order order = checkout.getOrder();

        for (int i = 0; i < order.sizeBeverages(); i++) {
            textArea.appendText(
                    order.getBeverages(i).getDescription() + "\nCost Coffe: " +
                            order.getBeverages(i).cost() + "\n------------------------------\n"
            );
        }


    }

    @FXML
    void payOrder() {

    }


}
