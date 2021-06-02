package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ChooseOrderController {

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

        }catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
