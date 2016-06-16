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
    
    public Periode() {};
    
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
        
    public String getInsertSQL() {
        return "INSERT INTO Periode (begindatum, einddatum) VALUES(?, ?)";
    }

    public PreparedStatement getInsertStatement(PreparedStatement stmt, Connection con) throws SQLException {
        stmt.setString(1, this.beginDatum);
        stmt.setString(2, this.eindDatum);
        return stmt;
    }

    public String getUpdateSQL() {
        return "UPDATE Periode SET begindatum = ?, einddatum = ? WHERE per_id = ?";
        
    }

    public PreparedStatement getUpdateStatement(PreparedStatement stmt, Connection con) throws SQLException {
        stmt.setString(1, this.beginDatum);
        stmt.setString(2, this.eindDatum);
        stmt.setInt(3, this.ID);
        return stmt;
    }
    
    public String getDeleteSQL() {
        return "DELETE FROM Periode WHERE per_id = ?";
    }

    public PreparedStatement getDeleteStatement(PreparedStatement stmt, Connection con, int keyValue) throws SQLException {
        stmt.setInt(1, keyValue);
        return stmt;
    }

    public String getSelectSQL(String columnName) {
        String SQL = "";
        if(columnName.isEmpty()) {
            SQL = "SELECT * FROM Periode";
        }else{
            SQL = "SELECT * FROM Periode WHERE " + columnName + " LIKE ?";
        }
        return SQL;
    }

    public PreparedStatement getSelectStatement(PreparedStatement stmt, String columnInput) throws SQLException {
        stmt.setString(1, "%" + columnInput + "%");
        return stmt;
    }
}
