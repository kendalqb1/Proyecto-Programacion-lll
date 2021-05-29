package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Login {

    Database db = new Database();

    @FXML
    private TextField fieldUsername;

    @FXML
    private PasswordField fieldPassword;

    @FXML
    private Button btnLogin;

    @FXML
    void loginManagement() throws SQLException {
        if (!searchUser()) {
            System.out.println("denied");
        } else {
            System.out.println("successful");
        }
    }

    Boolean searchUser() throws SQLException {
        String username = fieldUsername.getText();
        String password = fieldPassword.getText();
        ResultSet result = db.readData();
        if (result != null) {
            while (result.next()) {
                if (result.getString("username").equals(username) && result.getString("password").equals(password)) {
                    return true;
                }
            }
        }
        else {
            System.out.println("Error al conectar a la database");
            return false;
        }
        return false;
    }
}
