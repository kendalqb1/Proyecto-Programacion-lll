package controller;

import controller.decorator.*;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HouseBlendController {

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
    void initialize() {


    }

    @FXML
    void closeWindow() {
        ((Stage) anchorPane.getScene().getWindow()).close();
    }

    @FXML
    void completeOrder() {
        Beverage beverage = new HouseBlend();
        boolean milk = boxMilk.isSelected();
        boolean whip = boxWhip.isSelected();
        boolean moka = boxMoka.isSelected();
        boolean soy = boxSoy.isSelected();

        if (!boxNone.isSelected()) {
            if (milk) { beverage = new Milk(beverage); }
            if (whip) { beverage = new Whip(beverage); }
            if (moka) { beverage = new Moka(beverage); }
            if (soy) { beverage = new Soy(beverage); }
        }
        System.out.println(beverage.getDescription() + " ₡" +  beverage.cost());
        closeWindow();
    }

    @FXML
    void pressedBox() {
        if(boxNone.isSelected()) {
            boxMilk.setDisable(true);
            boxWhip.setDisable(true);
            boxMoka.setDisable(true);
            boxSoy.setDisable(true);
        }
        else {
            boxMilk.setDisable(false);
            boxWhip.setDisable(false);
            boxMoka.setDisable(false);
            boxSoy.setDisable(false);
        }

        boxNone.setDisable(boxMilk.isSelected() || boxWhip.isSelected() || boxMoka.isSelected() || boxSoy.isSelected());
    }


}
