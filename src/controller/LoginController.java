package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.DAO.UserDao;
import view.Dialog;
import view.Ventanas;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginController {

    Dialog dialog = new Dialog();

    Ventanas v = new Ventanas();

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TextField fieldUsername;

    @FXML
    private PasswordField fieldPassword;

    private int counter = 1;

    @FXML
    void loginManagement() throws IOException, SQLException {
        if (!searchUser()) {
             if(counter == 3) {
                Alert d = dialog.createErrorDialog("Incorrect user or password, Three failed attempts");
                d.showAndWait();
                ((Stage)anchorPane.getScene().getWindow()).close();
                return;
            }
            Alert d = dialog.createErrorDialog("Incorrect user or password");
            d.showAndWait();
            counter++;

        }
        else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Choose_Order.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            scene.getStylesheets().add("assets/css/style.css");
            stage.setTitle("Choose Order");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.getIcons().add(new Image("assets/img/coffe-cup.png"));
            stage.show();
            ((Stage)anchorPane.getScene().getWindow()).close();
            Alert d = dialog.createInformationDialog("Correct user and password");
            d.showAndWait();

        }
    }

    Boolean searchUser() throws SQLException {
        UserDao dao = new UserDao();
        String username = fieldUsername.getText();
        String password = fieldPassword.getText();
        ResultSet result = dao.read();
        if (result != null) {
            while (result.next()) {
                if (result.getString("username").equals(username) && result.getString("password").equals(password)) {
                    return true;
                }
            }
        }
        else {
            System.out.println("Error in databae");
            return false;
        }
        return false;
    }
}
