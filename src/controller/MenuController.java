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

        try {
            //TODO :Login
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Choose_Order.fxml"));
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

}
