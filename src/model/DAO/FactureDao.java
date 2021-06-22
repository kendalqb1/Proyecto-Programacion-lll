package model.DAO;

import model.Facture;

import java.sql.*;
import java.util.Date;

public class FactureDao implements FactureDaoInterface{

    Database db = new Database();

    @Override
    public ResultSet read() {
        try {
            Statement st = db.getConnection().createStatement();
            String query = "SELECT * FROM orders";
            return st.executeQuery(query);
        }catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean create(Facture f) {
        try {
            Connection c = db.getConnection();
            String query = "INSERT INTO orders values(?,?,?,?,?,?)";
            PreparedStatement ps = c.prepareStatement(query);
            String data = "";
            for (int i = 0; i < f.getArrayBeverages().size(); i++) {
                data += f.getArrayBeverages().get(i).getDescription() + "\n";
            }
            String id = buscarUltimoID();
            ps.setString(1, id);
            ps.setString(2, f.getClientName());
            ps.setString(3, data);
            ps.setString(4, "Pendiente");
            ps.setString(5, new Date().toString());
            ps.setString(6, String.valueOf(f.getTotalCost()));
            ps.executeUpdate();
            return true;
        }
        catch (Exception e) {
            return false;
        }

    }

    public String buscarUltimoID() throws SQLException {
        String id = "";
        int conversion = 0;
        Statement st = db.getConnection().createStatement();
        String query = "SELECT * FROM orders ORDER BY id DESC LIMIT 1";
        ResultSet r = st.executeQuery(query);
        while (r.next()) {
            id = r.getString("id");
        }
        conversion = Integer.parseInt(id) + 1;
        return String.valueOf(conversion);
    }
}

//    FactureDao fdao = new FactureDao();
//    ResultSet resultSet = fdao.read();
//        while (resultSet.next()) {
//                System.out.println(
//                resultSet.getString("id") + "\t" +
//                resultSet.getString("cliente") + "\t" +
//                resultSet.getString("contenido") + "\t" +
//                resultSet.getString("estado") + "\t" +
//                resultSet.getString("fecha") + "\t" +
//                resultSet.getString("costo") + "\n"
//                );
//                }

