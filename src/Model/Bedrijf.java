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
public class Bedrijf implements Entiteit{
    
    private int ID;
    private String naam;
    private String adres;
    private String stad;
    private String land;
    
    public Bedrijf() {};
    
    public Bedrijf(int ID, String naam, String adres, String stad, String land) {
        this.ID = ID;
        this.naam = naam;
        this.adres = adres;
        this.stad = stad;
        this.land = land;
    }
    
    
    
    public int getBedrijfID() {
        return ID;
    }
    
    public String getBedrijfsNaam() {
        return naam;
    }
    
    public String getBedrijfsAdres() {
        return adres;
    }
    
    public String getBedrijfStad() {
        return stad;
    }
    
    public String getBedrijfLand() {
        return land;
    }
    
    public String insertBedrijf() {
        return "INSERT INTO Bedrijf VALUES('" + 
                this.getBedrijfID() + "', '" +
                this.getBedrijfsNaam() + "', '" +
                this.getBedrijfsAdres() + "', '" +
                this.getBedrijfStad() + "', '" +
                this.getBedrijfLand() + "');";
    }

    
    public String getInsertSQL() {
        return "INSERT INTO Bedrijf (bedrijfsnaam, adres, stad, land) VALUES (?, ?, ?, ?);";
    }
    
    public PreparedStatement getInsertStatement(PreparedStatement stmt, Connection con) throws SQLException {
              
        stmt.setString(1, this.naam);
        stmt.setString(2, this.adres );
        stmt.setString(3, this.stad);
        stmt.setString(4, this.land);      
        return stmt;    
    }
    
    public String getUpdateSQL() {
        return "UPDATE Bedrijf SET bedrijfsnaam = ?, adres = ?, stad = ?, land = ? WHERE bedrijf_id = ?";
    }
    
    public PreparedStatement getUpdateStatement(PreparedStatement stmt, Connection con) throws SQLException {
        stmt.setString(1, this.naam);
        stmt.setString(2, this.adres );
        stmt.setString(3, this.stad);
        stmt.setString(4, this.land);
        stmt.setInt(5, this.ID);
        return stmt;    
    }
    
    public String getDeleteSQL() {
        return "DELETE FROM Bedrijf WHERE bedrijf_id = ?";
    }
    
    public PreparedStatement getDeleteStatement(PreparedStatement stmt, Connection con, int keyValue) throws SQLException {
        stmt.setInt(1, keyValue);
        return stmt;
    }
    
    public String getSelectSQL(String columnName) {
        String SQL = "";
        if(columnName.isEmpty()) {
            SQL = "SELECT * FROM Bedrijf";
        }else{
            SQL = "SELECT * FROM Bedrijf WHERE " + columnName + " LIKE ?";
        }
        return SQL;
    }
    
    @Override
    public PreparedStatement getSelectStatement(PreparedStatement stmt, String columnInput) throws SQLException {       
       stmt.setString(1, "%" + columnInput + "%");        
       return stmt;
    }
}

    