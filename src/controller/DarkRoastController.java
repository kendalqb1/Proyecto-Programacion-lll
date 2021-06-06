package controller;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class DarkRoastController {
    @FXML
    private AnchorPane anchorPane;

    @FXML
    private CheckBox boxMilk;

    @FXML
    private CheckBox boxSoy;

    @FXML
    private CheckBox boxWhip;

    @FXML
    private CheckBox boxMoka;

    @FXML
    private CheckBox boxNone;

    @FXML
    void closeWindow() {
        ((Stage) anchorPane.getScene().getWindow()).close();
    }

    @FXML
    void completeOrder() {



    }



}
