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
    private String naam;
    private int contact_id;

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

    @Override
    public String getInsertSQL() {
        return "INSERT INTO Opleiding (naam) VALUES (?);";
    }

    @Override
    public PreparedStatement getInsertStatement(PreparedStatement stmt, Connection con) throws SQLException {
        stmt.setString(1, this.naam);
        return stmt;
    }

    @Override
    public String getUpdateSQL() {
        return "UPDATE Opleiding SET naam = ?, contact_id = ? WHERE opleiding_id = ?";
    }

    @Override
    public PreparedStatement getUpdateStatement(PreparedStatement stmt, Connection con) throws SQLException {
        stmt.setString(1, this.naam);
        stmt.setInt(2, this.contact_id);
        stmt.setInt(3, this.ID);
        return stmt;
    }

    @Override
    public String getDeleteSQL() {
        return "DELETE from Opleiding WHERE opleiding_id = ?";
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
            SQL = "SELECT * FROM Opleiding";
        } else {
            SQL = "SELECT * FROM Opleiding WHERE " + columnName + " LIKE ?";
        }
        return SQL;
    }

    @Override
    public PreparedStatement getSelectStatement(PreparedStatement stmt, String columnInput) throws SQLException {
        stmt.setString(1, "%" + columnInput + "%");
        return stmt;
    }
}
