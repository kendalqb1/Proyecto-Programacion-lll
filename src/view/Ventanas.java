package view;

import controller.DecoratorController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.decorator.Beverage;
import model.decorator.HouseBlend;

import java.util.Observable;

public class Ventanas {
    public void crearVentana(String fxml, String title ){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle(title);
            scene.getStylesheets().add("assets/css/style.css");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.getIcons().add(new Image("assets/img/coffe-cup.png"));
            stage.show();

        }catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public void crearVentanaDecorador(String fxml, String title, Beverage bev ){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle(title);
            scene.getStylesheets().add("assets/css/style.css");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.getIcons().add(new Image("assets/img/coffe-cup.png"));
            stage.show();
            DecoratorController controller = loader.getController();
            controller.setBeverage(bev);

        }catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public void crearVentanaObservable(String fxml, String title, Observable obs){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle(title);
            scene.getStylesheets().add("assets/css/style.css");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.getIcons().add(new Image("assets/img/coffe-cup.png"));
            stage.show();

            obs.addObserver(loader.getController());

        }catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
