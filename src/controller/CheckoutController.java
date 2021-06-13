package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Checkout;
import model.FileRW;
import model.Order;
import view.Dialog;

import java.util.Observable;
import java.util.Observer;

public class CheckoutController implements Observer {
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

    Order order = checkout.getOrder();

    FileRW rw = new FileRW();

    Dialog dialog = new Dialog();

    @FXML
    void initialize() {
        double price = 0;
        textArea.clear();subTotal.clear();totalIVA.clear();totalPrice.clear();
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
        ((Stage) anchorPane.getScene().getWindow()).close();
    }

    @FXML
    void payOrder() {
        if (checkout.getOrder().isClear()) {
            Alert d = dialog.createErrorDialog("Add some coffee to pay");
            d.showAndWait();
        }
        else {
            //TODO: Save order
            String data = "*-*-*- Factura -*-*-*-\n";
            double price = 0;
            for (int i = 0; i < order.sizeBeverages(); i++) {
                price += order.getBeverages(i).cost();
                textArea.appendText(order.getBeverages(i).getDescription() + "\nCost Coffe: " +
                        order.getBeverages(i).cost() + "\n------------------------------\n");
                data += order.getBeverages(i).getDescription() + "\nCost Coffe: " +
                        order.getBeverages(i).cost() + "\n------------------------------\n";
            }
            data += "Subtotal: " + price + "\n";
            data += "Total: " + (price + (price * 0.13))  + "\n";
            data += "Estado: Pendiente\n";
            data += "--- Fin ---\n\n";
            if(rw.writeData(data)) {
                textArea.setText("");
                Alert d = dialog.createInformationDialog("Process Order Successful");
                d.showAndWait();
                checkout.getOrder().clearList();
                ((Stage) anchorPane.getScene().getWindow()).close();
            }
            else {
                Alert d = dialog.createInformationDialog("Process Order unsuccessful try again");
                d.showAndWait();
            }
        }
    }

    //prevents free coffe
    @Override
    public void update(Observable o, Object arg) {
        if (arg != null){closeWindow();}
        else{initialize();}
    }
}
