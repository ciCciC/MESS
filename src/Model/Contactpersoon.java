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
public class Contactpersoon implements Entiteit {

    private int ID;
    private String naam;
    private String email;
    private String telNr;

    public Contactpersoon() {
    }

    ;
    
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
        return "INSERT INTO Contactpersoon VALUES('"
                + this.getContactID() + "', '"
                + this.getContactNaam() + "', '"
                + this.getContactEmail() + "', '"
                + this.getContactTelNr() + "');";
    }

    @Override
    public String getInsertSQL() {
        return "INSERT INTO Contactpersoon (naam, emailadres, telefoonnummer) VALUES (?, ? , ?);";
    }

    @Override
    public PreparedStatement getInsertStatement(PreparedStatement stmt, Connection con) throws SQLException {
        stmt.setString(1, this.naam);
        stmt.setString(2, this.email);
        stmt.setString(3, this.telNr);
        return stmt;
    }

    @Override
    public String getUpdateSQL() {
        return "UPDATE Contactpersoon SET naam = ?, emailadres = ?, telefoonnummer = ? WHERE contact_id = ?";
    }

    @Override
    public PreparedStatement getUpdateStatement(PreparedStatement stmt, Connection con) throws SQLException {
        stmt.setString(1, this.naam);
        stmt.setString(2, this.email);
        stmt.setString(3, this.telNr);
        stmt.setInt(4, this.ID);
        return stmt;
    }

    @Override
    public String getDeleteSQL() {
        return "DELETE from Contactpersoon WHERE contact_id = ?";
    }

    @Override
    public PreparedStatement getDeleteStatement(PreparedStatement stmt, Connection con, int keyValue) throws SQLException {
        stmt.setInt(1, keyValue);
        return stmt;
    }

    @Override
    public String getSelectSQL(String columnName) {
        String SQL = "";
        if (columnName.isEmpty()) {
            SQL = "SELECT * FROM Contactpersoon";
        } else {
            SQL = "SELECT * FROM Contactpersoon WHERE " + columnName + " LIKE ?";
        }
        return SQL;
    }

    @Override
    public PreparedStatement getSelectStatement(PreparedStatement stmt, String columnInput) throws SQLException {
        stmt.setString(1, "%" + columnInput + "%");
        return stmt;
    }
}
