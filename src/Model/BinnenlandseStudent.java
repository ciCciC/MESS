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

    public BinnenlandseStudent(String studentNr, String naam, char geslacht, String email, String telNr, 
            String uitgaans_uni, int opleiding_id) {
        super(studentNr, naam, geslacht, email, telNr);
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

    public PreparedStatement getDeleteStatement(PreparedStatement stmt, Connection con) throws SQLException {                           
        stmt.setString(1, super.getStudentNummer());     
        return stmt;
    }
    
    public void deleteStudent(Connection con) throws SQLException{
        super.deleteStudent(con);
    }
    
    public String getSelectSQL(String columnName) {
        String SQL = "";
        if(columnName.isEmpty()) {
            SQL = "SELECT S.studentnummer, S.naam, S.geslacht, S.emailadres, " +
                    "B.uitgaans_uni, B.opleiding_id FROM Student S join Binnenlands B " + 
                    "ON S.studentnummer = B.studentnummer";
        } else {
            columnName = columnName.toLowerCase();
            if(columnName.equals("naam") || columnName.equals("geslacht") || columnName.equals("adres")) {
                SQL = "SELECT S.studentnummer, S.naam, S.geslacht, S.emailadres, " +
                        "B.uitgaans_uni, B.opleiding_id FROM Student S join Buitenlands B " +
                        "ON S.studentnummer = B.studentnummer WHERE S." + columnName + " LIKE ?";
            } else 
            {
            SQL = "SELECT S.studentnummer, S.naam, S.geslacht, S.emailadres, " +
                    "B.uitgaans_uni, B.opleiding_id FROM Student S join Buitenlands B " + 
                    "ON S.studentnummer = B.studentnummer WHERE B." + columnName + " LIKE ?";
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
