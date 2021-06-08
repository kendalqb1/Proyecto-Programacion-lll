package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Checkout;
import model.decorator.DarkRoast;
import model.decorator.Decaf;
import model.decorator.Espresso;
import model.decorator.HouseBlend;
import view.Dialog;
import view.Ventanas;

import java.util.Optional;


public class ChooseOrderController {

    Dialog dialog = new Dialog();
    Ventanas v = new Ventanas();
    @FXML
    private AnchorPane anchorPane;
    private Checkout checkout = Checkout.getInstance();

    @FXML
    void houseBlendDecorator() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/ExtraHouseBlend.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("House Blend");
            scene.getStylesheets().add("assets/css/style.css");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.getIcons().add(new Image("assets/img/coffe-cup.png"));
            stage.show();
            DecoratorController controller = loader.getController();
            controller.setBeverage(new HouseBlend());

        }catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @FXML
    void darkRoastDecorator() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/ExtraDarkRoast.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Dark Roast");
            scene.getStylesheets().add("assets/css/style.css");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.getIcons().add(new Image("assets/img/coffe-cup.png"));
            stage.show();
            DecoratorController controller = loader.getController();
            controller.setBeverage(new DarkRoast());

        }catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @FXML
    void decafDecorator() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/ExtraDecaf.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Decaf");
            scene.getStylesheets().add("assets/css/style.css");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.getIcons().add(new Image("assets/img/coffe-cup.png"));
            stage.show();
            DecoratorController controller = loader.getController();
            controller.setBeverage(new Decaf());

        }catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @FXML
    void espressoDecorator() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/ExtraEspresso.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Espresso");
            scene.getStylesheets().add("assets/css/style.css");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.getIcons().add(new Image("assets/img/coffe-cup.png"));
            stage.show();
            DecoratorController controller = loader.getController();
            controller.setBeverage(new Espresso());

        }catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @FXML
    void openCheckOut() {
        v.crearVentana("Checkout.fxml", "Chekout");
    }

    @FXML
    void outMenu() {
        Alert d = dialog.createConfirmationDialog("Are you sure want to exit?");
        Optional<ButtonType> result = d.showAndWait();
        if (result.get() == ButtonType.OK) {
            v.crearVentana("Menu.fxml", "Main Menu");
            checkout.getOrder().clearList();
            ((Stage)anchorPane.getScene().getWindow()).close();
        }
    }

}
