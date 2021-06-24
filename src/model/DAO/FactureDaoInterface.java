package model.DAO;

import model.Facture;
import model.FactureRecovery;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface FactureDaoInterface {

    public ResultSet read();
    public boolean create(Facture f);
    public boolean update(FactureRecovery f) throws SQLException;





}
