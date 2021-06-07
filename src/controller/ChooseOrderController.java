package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Checkout;
import model.Order;
import model.decorator.DarkRoast;
import model.decorator.Decaf;
import model.decorator.Espresso;
import model.decorator.HouseBlend;
import view.Dialog;

import java.util.Optional;


public class ChooseOrderController {

    Dialog dialog = new Dialog();

    @FXML
    private AnchorPane anchorPane;

    private Checkout checkout = Checkout.getInstance();

    @FXML
    void initialize() {

    }

    @FXML
    void houseBlendDecorator() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/ExtraHouseBlend.fxml"));
            Parent root = loader.load();
            DecoratorController controller = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("House Blend");
            scene.getStylesheets().add("assets/css/style.css");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.getIcons().add(new Image("assets/img/coffe-cup.png"));
            controller.setBeverage(new HouseBlend());
            stage.show();

        }catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @FXML
    void darkRoastDecorator() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/ExtraDarkRoast.fxml"));
            Parent root = loader.load();
            DecoratorController controller = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Dark Roast");
            scene.getStylesheets().add("assets/css/style.css");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.getIcons().add(new Image("assets/img/coffe-cup.png"));
            controller.setBeverage(new DarkRoast());
            stage.show();

        }catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @FXML
    void decafDecorator() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/ExtraDecaf.fxml"));
            Parent root = loader.load();
            DecoratorController controller = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Decaf");
            scene.getStylesheets().add("assets/css/style.css");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.getIcons().add(new Image("assets/img/coffe-cup.png"));
            controller.setBeverage(new Decaf());
            stage.show();

        }catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @FXML
    void espressoDecorator() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/ExtraEspresso.fxml"));
            Parent root = loader.load();
            DecoratorController controller = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Espresso");
            scene.getStylesheets().add("assets/css/style.css");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.getIcons().add(new Image("assets/img/coffe-cup.png"));
            controller.setBeverage(new Espresso());
            stage.show();

        }catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @FXML
    void openCheckOut() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Checkout.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Checkout");
            scene.getStylesheets().add("assets/css/style.css");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.getIcons().add(new Image("assets/img/coffe-cup.png"));
            stage.show();

        }catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @FXML
    void outMenu() {
        Alert d = dialog.createConfirmationDialog("Are you sure want to exit?");
        Optional<ButtonType> result = d.showAndWait();
        if (result.get() == ButtonType.OK) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Menu.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setTitle("Main Menu");
                scene.getStylesheets().add("assets/css/style.css");
                stage.setResizable(false);
                stage.setScene(scene);
                stage.getIcons().add(new Image("assets/img/coffe-cup.png"));
                stage.show();

            }catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
            checkout.getOrder().clearList();
            ((Stage)anchorPane.getScene().getWindow()).close();
        }
    }

}
