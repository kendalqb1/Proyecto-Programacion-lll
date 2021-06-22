package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Checkout;
import model.DAO.FactureDao;
import model.Facture;
import model.Order;
import model.decorator.Beverage;
import view.Dialog;
import view.Ventanas;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Observable;
import java.util.Observer;
import java.util.Optional;

public class CheckoutController implements Observer {

    @FXML
    private TextField totalPrice;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TextField totalIVA;
    @FXML
    private TextField subTotal;
    @FXML
    private TableView<Beverage> tableOrders;
    @FXML
    private TableColumn<Beverage, String> ColumnBeverage;
    @FXML
    private TableColumn<Beverage, Double> ColumnCost;
    private final Checkout checkout = Checkout.getInstance();
    private Ventanas v = new Ventanas();
    Order order = checkout.getOrder();
    Dialog dialog = new Dialog();

    @FXML
    void initialize() {
        ColumnBeverage.setCellValueFactory(new PropertyValueFactory<>("description"));
        ColumnCost.setCellValueFactory(new PropertyValueFactory<>("cost"));
        Double priceBeverages = 0.0;
        subTotal.clear();totalIVA.clear();totalPrice.clear();tableOrders.getItems().clear();
        for (int i = 0; i < order.sizeBeverages(); i++) {
            priceBeverages += order.getBeverages(i).getCost();
            tableOrders.getItems().add(order.getBeverages(i));
        }
        subTotal.setText("₡ " + priceBeverages);
        totalIVA.appendText("₡ " + (priceBeverages * 0.13));
        totalPrice.appendText("₡ " + (priceBeverages + (priceBeverages * 0.13)));
    }

    @FXML
    void closeWindow() {
        ((Stage) anchorPane.getScene().getWindow()).close();
    }

    @FXML
    void deleteBeverage() {
        for (int i = 0; i < tableOrders.getItems().size(); i++) {
            if (tableOrders.getSelectionModel().isSelected(i)) {
                Alert d = dialog.createConfirmationDialog("Remove selected drink?");
                Optional<ButtonType> result = d.showAndWait();
                if (result.get() == ButtonType.OK) {
                    checkout.getOrder().removeBeverage(i);
                    checkout.observeChanged();
                }
                return;
            }
        }
        Alert d = dialog.createErrorDialog("Select a drink");
        d.showAndWait();
    }

    @FXML
    void editOrder() {
        Beverage beverage = beverageSelect();
        if (!(beverage == null)){
            //TODO: editar orden
            System.out.println(beverage.getDescription());

            checkout.observeChanged();
        }
        else {
            Alert d = dialog.createErrorDialog("Select a drink");
            d.showAndWait();
        }
    }

    @FXML
    void payOrder() {
        FactureDao fdao = new FactureDao();
        if (checkout.getOrder().isClear()) {
            Alert d = dialog.createErrorDialog("Add some coffee to pay");
            d.showAndWait();
        }
        else {
            double price = 0;
            for (int i = 0; i < order.sizeBeverages(); i++) {
                price += order.getBeverages(i).cost();
            }
            fdao.create(new Facture("Jorge", order.getBeverages(), "Pendiente", price, price +(price*0.13)));
            Alert d = dialog.createInformationDialog("Process Order Successful");
            d.showAndWait();
            checkout.getOrder().clearList();
            ((Stage) anchorPane.getScene().getWindow()).close();
        }
    }

    Beverage beverageSelect() {
        for (int i = 0; i < tableOrders.getItems().size(); i++) {
            if(tableOrders.getSelectionModel().isSelected(i)){
                return tableOrders.getItems().get(i);
            }
        }
        return null;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg != null){closeWindow();}
        else{ initialize(); }
    }
}
