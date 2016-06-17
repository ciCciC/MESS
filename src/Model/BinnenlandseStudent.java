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
public class BinnenlandseStudent extends Student implements Entiteit{
    
    private String uitgaans_uni;
    private int opleiding_id;
    
    public BinnenlandseStudent(String studentNr, String naam, char geslacht, String email, String vastTel, String mobielTel) {
        super(studentNr, naam, geslacht, email, vastTel, mobielTel);
    }

    public BinnenlandseStudent(String studentNr, String naam, char geslacht, String email, 
            String vastTel, String mobielTel, String uitgaans_uni, int opleiding_id) {
        super(studentNr, naam, geslacht, email, vastTel, mobielTel);
        this.uitgaans_uni = uitgaans_uni;
        this.opleiding_id = opleiding_id;
    }
    
    public String getUitgaansUni() {
        return uitgaans_uni;
    }
    
    public String getInsertSQL() {
        return "INSERT INTO Binnenlands VALUES (?, ?, ?);"; 
    }
    
    public PreparedStatement getInsertStatement(PreparedStatement stmt, Connection con) throws SQLException {
        super.insertStudent(con);        
        stmt.setString(1, super.getStudentNummer());
        stmt.setString(2, this.uitgaans_uni);
        stmt.setInt(3, this.opleiding_id);        
        return stmt;
    }
    
    public String getUpdateSQL() {
        return "UPDATE Binnenlands SET uitgaans_uni = ?, opleiding_id = ? WHERE studentnummer = ?";
    }
    
    public PreparedStatement getUpdateStatement(PreparedStatement stmt, Connection con) throws SQLException {
        super.updateStudent(con);        
        stmt.setString(1, this.uitgaans_uni);
        stmt.setInt(2, this.opleiding_id);
        stmt.setString(3, super.getStudentNummer());      
        return stmt;
    }
    
    public String getDeleteSQL() {
        return "DELETE FROM Binnenlands WHERE studentnummer = ?";      
    }

    public PreparedStatement getDeleteStatement(PreparedStatement stmt, Connection con, int keyValue) throws SQLException {                           
        stmt.setString(1,  Integer.toString(keyValue));     
        return stmt;
    }
    
    public void deleteStudent(Connection con, int keyValue) throws SQLException{
        super.deleteStudent(con, keyValue);
    }
    
    public String getSelectSQL(String columnName) {
        String SQL = "";
        if(columnName.isEmpty()) {
            SQL = "SELECT S.studentnummer, S.naam, S.geslacht, S.emailadres, S.vasttel, "
                    + "S.mobieltel , B.uitgaans_uni, O.naam as opleiding, C.naam as contactnaam, "
                    + "C.emailadres as contactemailadres, C.telefoonnummer as contacttelefoonnummer "
                    + "FROM Student S, Binnenlands B, Opleiding O, Contactpersoon C "
                    + "WHERE S.studentnummer = B.studentnummer "
                    + "AND B.opleiding_id = O.opleiding_id "
                    + "AND O.contact_id = C.contact_id";
        } else {
            columnName = columnName.toLowerCase();
            if(columnName.equals("naam") || columnName.equals("geslacht") || columnName.equals("adres")
                    || columnName.equals("vasttel") || columnName.equals("mobieltel")) {
                SQL = "SELECT S.studentnummer, S.naam, S.geslacht, S.emailadres, S.vasttel, "
                    + "S.mobieltel, B.uitgaans_uni, O.naam as opleiding, C.naam as contactnaam, "
                    + "C.emailadres as contactemailadres, C.telefoonnummer as contacttelefoonnummer "
                    + "FROM Student S, Binnenlands B, Opleiding O, Contactpersoon C "
                    + "WHERE S.studentnummer = B.studentnummer "
                    + "AND B.opleiding_id = O.opleiding_id "
                    + "AND O.contact_id = C.contact_id " 
                    + "AND S." + columnName + " LIKE ?";
            }
            else if(columnName.equals("opleiding")) {
                SQL = "SELECT S.studentnummer, S.naam, S.geslacht, S.emailadres, S.vasttel, "
                    + "S.mobieltel, B.uitgaans_uni, O.naam as opleiding, C.naam as contactnaam, "
                    + "C.emailadres as contactemailadres, C.telefoonnummer as contacttelefoonnummer "
                    + "FROM Student S, Binnenlands B, Opleiding O, Contactpersoon C "
                    + "WHERE S.studentnummer = B.studentnummer "
                    + "AND B.opleiding_id = O.opleiding_id "
                    + "AND O.contact_id = C.contact_id " 
                    + "AND O.naam LIKE ?";
            }
            else if(columnName.equals("contactnaam") || columnName.equals("contactemailadres") || 
                    columnName.equals("contacttelefoonnummer")) {
                columnName = columnName.substring(7, columnName.length());
                SQL = "SELECT S.studentnummer, S.naam, S.geslacht, S.emailadres, S.vasttel, "
                    + "S.mobieltel, B.uitgaans_uni, O.naam as opleiding, C.naam as contactnaam, "
                    + "C.emailadres as contactemailadres, C.telefoonnummer as contacttelefoonnummer "
                    + "FROM Student S, Binnenlands B, Opleiding O, Contactpersoon C "
                    + "WHERE S.studentnummer = B.studentnummer "
                    + "AND B.opleiding_id = O.opleiding_id "
                    + "AND O.contact_id = C.contact_id " 
                    + "AND C." + columnName + " LIKE ?";
            }
            else
            {
                SQL = "SELECT S.studentnummer, S.naam, S.geslacht, S.emailadres, S.vasttel, "
                    + "S.mobieltel, B.uitgaans_uni, O.naam as opleiding, C.naam as contactnaam, "
                    + "C.emailadres as contactemailadres, C.telefoonnummer as contacttelefoonnummer "
                    + "FROM Student S, Binnenlands B, Opleiding O, Contactpersoon C "
                    + "WHERE S.studentnummer = B.studentnummer "
                    + "AND B.opleiding_id = O.opleiding_id "
                    + "AND O.contact_id = C.contact_id " 
                    + "AND B." + columnName + " LIKE ?";
            }            
        }        
        return SQL;
    }
    
    public PreparedStatement getSelectStatement(PreparedStatement stmt, String columnInput) throws SQLException {
        stmt.setString(1, "%" + columnInput + "%");
        return stmt;
    }
    
    public String toString() {
        return "binnenlands";
    }
    
    
}
