package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.FileRW;
import view.Dialog;


public class ViewOrderController {

    FileRW rw = new FileRW();

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TextArea textArea;

    @FXML
    void initialize() {
        assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file 'ViewOrders.fxml'.";
        assert textArea != null : "fx:id=\"textArea\" was not injected: check your FXML file 'ViewOrders.fxml'.";

        if (rw.readData() == "") {
            textArea.setText("No hay ordenes");
        } else {
            textArea.setText(rw.readData());
        }
    }

    @FXML
    void saveOrders() {
        String data = textArea.getText();
        if(rw.writeDataOrders(data)) {
            Dialog dialog = new Dialog();
            Alert d = dialog.createInformationDialog("Save Successful");
            d.showAndWait();
            textArea.setText(rw.readData());
        }
        else {
            Dialog dialog = new Dialog();
            Alert d = dialog.createInformationDialog("Save unsuccessful");
            d.showAndWait();
        }
        textArea.setText(rw.readData());
    }

    @FXML
    void goToMenu() {
        try {
            //TODO :Login
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
            ((Stage) anchorPane.getScene().getWindow()).close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
