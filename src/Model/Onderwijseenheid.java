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
 * @author Joep
 */
public class Onderwijseenheid implements Entiteit{
    private int ond_id;
    private int studiepunten; 
    private String soort_studie;
    private int bedrijf_id;
    private String typeonderwijseenheid;
    
    public Onderwijseenheid() {};
    
    public Onderwijseenheid(int ond_id, int studiepunten, String soort_studie, int bedrijf_id, String typeonderwijseenheid) {
        this.ond_id = ond_id;
        this.studiepunten = studiepunten;
        this.soort_studie = soort_studie; //Minon/european summer school etc;
        this.bedrijf_id = bedrijf_id;
        this.typeonderwijseenheid = typeonderwijseenheid;
    }

    public String getInsertSQL() {
        return "INSERT INTO Onderwijseenheid (studiepunten, soort_studie, bedrijf_id, typeonderwijseenheid)"
                + " VALUES (?, ?, ?, ?);";
    }

    public PreparedStatement getInsertStatement(PreparedStatement stmt, Connection con) throws SQLException {
        stmt.setInt(1, this.studiepunten);
        stmt.setString(2, this.soort_studie);
        stmt.setInt(3, this.bedrijf_id);
        stmt.setString(4, this.typeonderwijseenheid);
        return stmt;
    }
    
    public String getUpdateSQL() {
        return "UPDATE Onderwijseenheid SET studiepunten = ?, soort_studie = ?, bedrijf_id = ?, typeonderwijseenheid= ?"
                + "WHERE ond_id = ?";
                
    }    
    public PreparedStatement getUpdateStatement(PreparedStatement stmt, Connection con) throws SQLException {
        stmt.setInt(1, this.studiepunten);
        stmt.setString(2, this.soort_studie);
        stmt.setInt(3, this.bedrijf_id);
        stmt.setString(4, this.typeonderwijseenheid);
        stmt.setInt(5, this.ond_id);
        return stmt;
    }
    
    public String getDeleteSQL() {
        return "DELETE FROM Onderwijseenheid WHERFE ond_id = ?";
    }

    public PreparedStatement getDeleteStatement(PreparedStatement stmt, Connection con, int keyValue) throws SQLException {
        stmt.setInt(1, keyValue);
        return stmt;
    }
    
    public String getSelectSQL(String columnName) {
        String SQL = "";
        if(columnName.isEmpty()) {
            SQL = "SELECT * FROM Onderwijseenheid";
        }else{
            SQL = "SELECT * FROM Onderwijseenheid WHERE " + columnName + " LIKE ?";
        }
        return SQL;
    }

    public PreparedStatement getSelectStatement(PreparedStatement stmt, String columnInput) throws SQLException {
        stmt.setString(1, columnInput);
        return stmt;
    }
    
}
