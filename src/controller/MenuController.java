package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MenuController {

    @FXML
    AnchorPane anchorPane;

    @FXML
    void loginPage() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Login.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Login");
            scene.getStylesheets().add("assets/css/style.css");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.getIcons().add(new Image("assets/img/coffe-cup.png"));
            stage.show();
            ((Stage)anchorPane.getScene().getWindow()).close();
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    @FXML
    void viewOrders() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/ViewOrders.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("View Orders");
            scene.getStylesheets().add("assets/css/style.css");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.getIcons().add(new Image("assets/img/coffe-cup.png"));
            stage.show();
            ((Stage)anchorPane.getScene().getWindow()).close();
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

     @FXML
    void exitApp() {
         ((Stage)anchorPane.getScene().getWindow()).close();
    }

}
