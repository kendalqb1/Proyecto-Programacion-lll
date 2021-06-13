package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Checkout;
import model.decorator.*;

public class DecoratorController {
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
    private Button btnNext;
    private Beverage beverage;


    public Beverage getBeverage() {
        return beverage;
    }

    public void setBeverage(Beverage bv) {
        beverage = bv;
    }

    @FXML
    void closeWindow() {
        ((Stage) anchorPane.getScene().getWindow()).close();
    }

    @FXML
    void completeOrder() {
        Beverage beverage = getBeverage();
        boolean milk = boxMilk.isSelected();
        boolean whip = boxWhip.isSelected();
        boolean moka = boxMoka.isSelected();
        boolean soy = boxSoy.isSelected();

        if (!boxNone.isSelected()) {
            if (milk) {
                beverage = new Milk(beverage);
            }
            if (whip) {
                beverage = new Whip(beverage);
            }
            if (moka) {
                beverage = new Moka(beverage);
            }
            if (soy) {
                beverage = new Soy(beverage);
            }
        }
        Checkout checkout = Checkout.getInstance();
        checkout.getOrder().addBeverage(beverage);
        checkout.observeChanged(); //to update the checkout
        closeWindow();
    }

    @FXML
    void pressedBox() {
        if (boxNone.isSelected()) {
            boxMilk.setDisable(true);
            boxWhip.setDisable(true);
            boxMoka.setDisable(true);
            boxSoy.setDisable(true);
        } else {
            boxMilk.setDisable(false);
            boxWhip.setDisable(false);
            boxMoka.setDisable(false);
            boxSoy.setDisable(false);
        }
        boxNone.setDisable(boxMilk.isSelected() || boxWhip.isSelected() || boxMoka.isSelected() || boxSoy.isSelected());
        btnNext.setDisable(!boxMilk.isSelected() && !boxWhip.isSelected() && !boxMoka.isSelected() && !boxSoy.isSelected() && !boxNone.isSelected());
    }

}
