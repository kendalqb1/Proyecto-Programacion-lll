package model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface UserDaoInterface {

    boolean create();
    ResultSet read() throws SQLException;
    boolean delete();
    boolean update();

}
