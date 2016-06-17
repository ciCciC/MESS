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
public class Opleiding implements Entiteit{

    private int ID;
    private int contact_id;
    private String naam;
    

    public Opleiding() {};
    
    public Opleiding(int ID, int contact_id, String naam) {
        this.ID = ID;
        this.naam = naam;
        this.contact_id = contact_id;
    }

    public int getOpleidingID() {
        return ID;
    }
    
    public String getOpleidingNaam() {
        return naam;
    }

    public String InsertOpleiding() {
        return "INSERT INTO Opleiding VALUES('"
                + this.getOpleidingID() + "', '"
                + this.getOpleidingNaam() + "');";
    }
    
    public String getInsertSQL() {
        return "INSERT INTO Opleiding (contact_id, naam) VALUES (?, ?);";
    }
   
    public PreparedStatement getInsertStatement(PreparedStatement stmt, Connection con) throws SQLException {
        stmt.setInt(1, this.contact_id);
        stmt.setString(2, this.naam);
        return stmt;
    }
    
    public String getUpdateSQL() {
        return "UPDATE Opleiding SET naam = ?, contact_id = ? WHERE opleiding_id = ?";
    }
  
    public PreparedStatement getUpdateStatement(PreparedStatement stmt, Connection con) throws SQLException {
        stmt.setString(1, this.naam);
        stmt.setInt(2, this.contact_id);
        stmt.setInt(3, this.ID);
        return stmt;
    }
    
    public String getDeleteSQL() {
        return "DELETE from Opleiding WHERE opleiding_id = ?";
    }
   
    public PreparedStatement getDeleteStatement(PreparedStatement stmt, Connection con, int keyValue) throws SQLException {
        stmt.setInt(1, keyValue);
        return stmt;
    }
    
    public String getSelectSQL(String columnName) {
        String SQL = "";
        if (columnName.isEmpty()) {
            SQL = "SELECT O.naam, C.naam as contactpersoon, C.emailadres as contactemail, C.telefoonnummer as Contactnummer " 
                    + "FROM Opleiding O join Contactpersoon C on O.contact_id = C.contact_id";
        } else {
            SQL = "SELECT O.naam, C.naam as contactpersoon, C.emailadres as contactemail, C.telefoonnummer as Contactnummer " 
                    + "FROM Opleiding O join Contactpersoon C on O.contact_id = C.contact_id " 
                    + "WHERE O." + columnName + " LIKE ?";
        }
        return SQL;
    }
    
    public PreparedStatement getSelectStatement(PreparedStatement stmt, String columnInput) throws SQLException {
        stmt.setString(1, "%" + columnInput + "%");
        return stmt;
    }
}
