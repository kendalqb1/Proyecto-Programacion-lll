package model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao implements UserDaoInterface {
    Database db = new Database();

    @Override
    public ResultSet read() throws SQLException {
        Statement st = db.getConnection().createStatement();
        String query = "SELECT * FROM users";
        return st.executeQuery(query);
    }

    @Override
    public boolean create() {
        return false;
    }

    @Override
    public boolean delete() {
        return false;
    }

    @Override
    public boolean update() {
        return false;
    }
}
