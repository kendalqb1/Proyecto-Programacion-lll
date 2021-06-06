package controller;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class EspressoController {
    @FXML
    private AnchorPane anchorPane;

    @FXML
    void closeWindow() {
        ((Stage) anchorPane.getScene().getWindow()).close();
    }

    @FXML
    void completeOrder() {

    }
}
