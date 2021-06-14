package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Facture;
import model.FileRW;
import model.decorator.Beverage;
import view.Dialog;
import view.Ventanas;

import java.util.ArrayList;

public class ViewOrderController {

    FileRW rw = new FileRW();
    Ventanas v = new Ventanas();

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TableView<Facture> tableOrders;

    @FXML
    private TableColumn<Facture, String> columnClient;

    @FXML
    private TableColumn<Facture, ArrayList<Beverage>> columnBeverages;

    @FXML
    private TableColumn<Facture, String> columnState;

    @FXML
    private TableColumn<Facture, Double> columnSub;

    @FXML
    private TableColumn<Facture, Double> columnTotal;

    @FXML
    void initialize() {
        columnClient.setCellValueFactory(new PropertyValueFactory<>("clientName"));
        columnBeverages.setCellValueFactory(new PropertyValueFactory<>("arrayBeverages"));
        columnState.setCellValueFactory(new PropertyValueFactory<>("stateOrder"));
        columnSub.setCellValueFactory(new PropertyValueFactory<>("subTotal"));
        columnTotal.setCellValueFactory(new PropertyValueFactory<>("totalCost"));

        String data = rw.readData();

        for (int i = 0; i < data.length(); i++) {

        }

//        if (rw.readData() == "") {
//            textArea.setText("No hay ordenes");
//        } else {
//            textArea.setText(rw.readData());
//        }
    }

    @FXML
    void saveOrders() {
//        String data = textArea.getText();
//        if(rw.writeDataOrders(data)) {
//            Dialog dialog = new Dialog();
//            Alert d = dialog.createInformationDialog("Save Successful");
//            d.showAndWait();
//            textArea.setText(rw.readData());
//        }
//        else {
//            Dialog dialog = new Dialog();
//            Alert d = dialog.createInformationDialog("Save unsuccessful");
//            d.showAndWait();
//        }
//        textArea.setText(rw.readData());
    }

    @FXML
    void goToMenu() {
//        v.crearVentana("Menu.fxml", "Main Menu");
//        ((Stage) anchorPane.getScene().getWindow()).close();
    }
}
