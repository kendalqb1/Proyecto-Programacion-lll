package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.DAO.UserDao;
import view.Dialog;
import view.Ventanas;

import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginController {

    Dialog dialog = new Dialog();
    Ventanas v = new Ventanas();
    UserDao dao = new UserDao();

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TextField fieldUsername;

    @FXML
    private PasswordField fieldPassword;

    private int counter = 1;

    @FXML
    void loginManagement() throws SQLException {
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
            v.crearVentana("../view/Choose_Order.fxml", "Choose Order");
            ((Stage)anchorPane.getScene().getWindow()).close();
            Alert d = dialog.createInformationDialog("Correct user and password");
            d.showAndWait();

        }
    }

    Boolean searchUser() throws SQLException {
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
