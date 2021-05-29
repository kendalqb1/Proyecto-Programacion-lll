package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.util.Objects;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../view/Login.fxml")));
            Scene scene = new Scene(root);
            stage.setTitle("Login");
            stage.setResizable(false);
            stage.setScene(scene);
            scene.getStylesheets().add("assets/css/style.css");
            stage.getIcons().add(new Image("assets/img/coffe-cup.png"));
            stage.setTitle("StarBuzz Login");
            stage.show();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
