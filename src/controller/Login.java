package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Login {

    Database db = new Database();

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TextField fieldUsername;

    @FXML
    private PasswordField fieldPassword;

    @FXML
    private Button btnLogin;

    private int contador = 0;

    @FXML
    void loginManagement() throws SQLException, IOException {
        if (!searchUser()) {
            System.out.println("denied");
            contador++;
            if(contador == 3) {
                //TODO: Close window
                System.out.println("Close window");
            }
        } else {
            //TODO: Open dashboard
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Homepage.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Dashboard");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.getIcons().add(new Image("assets/img/coffe-cup.png"));
            stage.show();

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
