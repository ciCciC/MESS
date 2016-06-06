/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Ruben
 */
public class Contactpersoon implements Entiteit {
    
    private int ID;
    private String naam;
    private String email;
    private String telNr;
    
    public Contactpersoon(int ID, String naam, String email, String telNr) {
        this.ID = ID;
        this.naam = naam;
        this.email = email;
        this.telNr = telNr;
    }
    
    public int getContactID() {
        return ID;
    }
    
    public String getContactNaam() {
        return naam;
    }
    
    public String getContactEmail() {
        return email;
    }
    
    public String getContactTelNr() {
        return telNr;
    }
    
    public String InsertContactpersoon() {
        return "INSERT INTO Contactpersoon VALUES('" + 
                this.getContactID() + "', '" +
                this.getContactNaam() + "', '" +
                this.getContactEmail() + "', '" +
                this.getContactTelNr() + "');";
}

    @Override
    public String getInsertSQL() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PreparedStatement getInsertStatement(PreparedStatement stmt) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getUpdateSQL() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PreparedStatement getUpdateStatement(PreparedStatement stmt) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDeleteSQL() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PreparedStatement getDeleteStatement(PreparedStatement stmt) throws SQLException {
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