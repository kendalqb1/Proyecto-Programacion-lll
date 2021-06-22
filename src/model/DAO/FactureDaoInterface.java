package model.DAO;

import model.Facture;

import java.sql.ResultSet;

public interface FactureDaoInterface {

    public ResultSet read();
    public boolean create(Facture f);





}
