/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Ruben
 */
public class Periode implements Entiteit {
    
    private int ID;
    private String beginDatum;
    private String eindDatum;
    
    public Periode(int ID, String beginDatum, String eindDatum) {
        this.ID = ID;
        this.beginDatum = beginDatum;
        this.eindDatum = eindDatum;
    }
    
    public int getPeriodeID() {
        return ID;
    }
    
    public String getBeginDatum() {
        return beginDatum;
    }
    
    public String getEindDatum() {
        return eindDatum;
    }
    
    public String insertPeriode() {
        return "INSERT INTO Periode VALUES('" + 
                this.getPeriodeID() + "', '" +
                this.getBeginDatum() + "', '" +
                this.getEindDatum() + "');";
    }

    @Override
    public String getInsertSQL() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PreparedStatement getInsertStatement(PreparedStatement stmt, Connection con) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getUpdateSQL() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PreparedStatement getUpdateStatement(PreparedStatement stmt, Connection con) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDeleteSQL() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PreparedStatement getDeleteStatement(PreparedStatement stmt, Connection con) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSelectSQL(String columnName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PreparedStatement getSelectStatement(PreparedStatement stmt, String columnInput) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
