package controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public static void writeData(String desc, double amt) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-factura", "root", "admin");
            PreparedStatement pst = connection.prepareStatement("INSERT INTO orders values(?,?,?,?)");
            pst.setString(1, "0");
            pst.setString(2, desc);
            pst.setDouble(3, amt);
            pst.setString(4, "Pending");
            pst.executeUpdate();

        }
        catch (Exception e) {
            System.out.println("database error");
        }
    }



    public List<String> readDescription() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-factura", "root", "admin");
            PreparedStatement pst = connection.prepareStatement("SELECT * FROM orders where status = ?");
            pst.setString(4,"Pending");

            List<String> descList = new ArrayList<>();
            ResultSet rs = pst.executeQuery();

            while(rs.next()){
                descList.add(rs.getString("description"));

            }return descList;
        }
        catch (Exception e) { return null;}
    }


}
