package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Checkout;
import model.Order;
import view.Dialog;

import java.text.DecimalFormat;

public class CheckoutController {
    @FXML
    private TextArea textArea;

    @FXML
    private TextField totalPrice;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TextField totalIVA;

    @FXML
    private TextField subTotal;

    private Checkout checkout = Checkout.getInstance();

    @FXML
    void initialize() {
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
        subTotal.appendText(String.valueOf(price));
        totalIVA.appendText(String.valueOf(price * 0.13));
        totalPrice.appendText(String.valueOf(price + (price * 0.13)));

    }

    @FXML
    void closeWindow() {
        ((Stage)anchorPane.getScene().getWindow()).close();
    }

    @FXML
    void payOrder() {
        Dialog dialog = new Dialog();
        Alert d = dialog.createInformationDialog("Process Order Successful");
        d.showAndWait();

        //TODO: Save order








        checkout.getOrder().clearList();
        ((Stage)anchorPane.getScene().getWindow()).close();
    }


}
