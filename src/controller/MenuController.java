package controller;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import view.Ventanas;

public class MenuController {

    Ventanas v = new Ventanas();
    @FXML
    AnchorPane anchorPane;

    @FXML
    void loginPage() {
        v.crearVentana("Login.fxml", "Login");
        ((Stage) anchorPane.getScene().getWindow()).close();
    }

    @FXML
    void viewOrders() {
        v.crearVentana("ViewOrders.fxml", "View Orders");
        ((Stage) anchorPane.getScene().getWindow()).close();
    }

    @FXML
    void exitApp() {
        ((Stage) anchorPane.getScene().getWindow()).close();
    }
}
