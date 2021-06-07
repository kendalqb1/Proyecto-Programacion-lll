package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Checkout;
import model.Order;
import model.decorator.Beverage;

public class CheckoutController {

    @FXML
    private TableView<Beverage> tableOrder;

    @FXML
    private TableColumn<Beverage, String> name;

    @FXML
    private TableColumn<Beverage, Double> cost;

    @FXML
    void initialize() {
        assert tableOrder != null : "fx:id=\"tableOrder\" was not injected: check your FXML file 'Checkout.fxml'.";
        Checkout checkout = Checkout.getInstance();
        Order order = checkout.getOrder();
        for (int i = 1; i <= order.sizeBeverages(); i++) {
            //tableOrder.getColumns().add(i, name, "Hola");

        }
        System.out.println(checkout.getOrder());
        
        
    }

    @FXML
    void payOrder() {

    }



}
