package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {

    public ResultSet readData() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectoldb", "root", "");
            Statement statement = connection.createStatement();
            String sentSQL = "SELECT * FROM users";
            return statement.executeQuery(sentSQL);
        }
        catch (Exception e) {
            return null;
        }
    }




}
