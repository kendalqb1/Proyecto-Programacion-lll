package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.FileRW;
import view.Dialog;
import view.Ventanas;

public class ViewOrderController {

    FileRW rw = new FileRW();
    Ventanas v = new Ventanas();
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TextArea textArea;

    @FXML
    void initialize() {
        if (rw.readData() == "") {
            textArea.setText("No hay ordenes");
        } else {
            textArea.setText(rw.readData());
        }
    }

    @FXML
    void saveOrders() {
        String data = textArea.getText();
        if(rw.writeDataOrders(data)) {
            Dialog dialog = new Dialog();
            Alert d = dialog.createInformationDialog("Save Successful");
            d.showAndWait();
            textArea.setText(rw.readData());
        }
        else {
            Dialog dialog = new Dialog();
            Alert d = dialog.createInformationDialog("Save unsuccessful");
            d.showAndWait();
        }
        textArea.setText(rw.readData());
    }

    @FXML
    void goToMenu() {
        v.crearVentana("Menu.fxml", "Main Menu");
        ((Stage) anchorPane.getScene().getWindow()).close();
    }
}
