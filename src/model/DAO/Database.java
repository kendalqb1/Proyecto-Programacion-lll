package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    static final String url = "jdbc:mysql://localhost:3306/proyectoldb";
    static final String username = "root";
    static final String password = "";

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(url, username, password);
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
