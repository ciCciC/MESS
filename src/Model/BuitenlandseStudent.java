/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.DatabaseManager;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Joep
 */
public class BuitenlandseStudent extends Student implements Entiteit{
    

    private String adres;
    private String land;
    private String herkomstUni;
    private int opleiding_id;
    
    public BuitenlandseStudent(String studentNr, String naam, char geslacht, String email, String vastTel, String mobielTel) {
        super(studentNr, naam, geslacht, email, vastTel, mobielTel);
    }
        
    public BuitenlandseStudent(String studentNr, String naam, char geslacht, String email, String vastTel, String mobielTel, 
            String adres, String land, String herkomstUni, int opleiding_id) {
        
        super(studentNr, naam, geslacht, email, vastTel, mobielTel);
        this.adres = adres;
        this.land = land;
        this.herkomstUni = herkomstUni;        
    }
    
    public String getAdres() {
        return this.adres;
    }
    
    public String getLand() {
        return this.land;
    }
    
    public String getHerkomstUni() {
        return this.herkomstUni;
    }
    
    
    public String getInsertSQL() {        
        return "INSERT INTO Buitenlands VALUES (?, ?, ?, ?, ?);";            
    }   
    
    public PreparedStatement getInsertStatement(PreparedStatement stmt, Connection con) throws SQLException{        
        
        super.insertStudent(con);        
        stmt.setString(1, super.getStudentNummer());
        stmt.setString(2, this.adres);
        stmt.setString(3, this.land);
        stmt.setString(4, this.herkomstUni);
        stmt.setInt(5, this.opleiding_id);
        
        return stmt;
    }
    
    public String getUpdateSQL() {        
        return "UPDATE Buitenlands SET adres = ?, land = ?, herkomst_uni = ?, opleiding_id = ? WHERE studentnummer = ?";          
    }
    
    
    public PreparedStatement getUpdateStatement(PreparedStatement stmt, Connection con) throws SQLException{        
        
        super.updateStudent(con);        
        stmt.setString(1, this.adres);
        stmt.setString(2, this.land);
        stmt.setString(3, this.herkomstUni);
        stmt.setInt(4, this.opleiding_id);
        stmt.setString(5, super.getStudentNummer());
        
        return stmt;
    }
    
    public String getDeleteSQL() {        
        return "DELETE FROM Buitenlands WHERE studentnummer = ?";            
    }
    
    
    public PreparedStatement getDeleteStatement(PreparedStatement stmt, Connection con, int keyValue) throws SQLException{                     
        stmt.setString(1, Integer.toString(keyValue));     
        return stmt;
    }
    
    public void deleteStudent(Connection con, int keyValue) throws SQLException{
        super.deleteStudent(con, keyValue);
    }
    
    public String getSelectSQL(String columnName) {
        String SQL = "";
        if(columnName.isEmpty()) {
            SQL = "SELECT S.studentnummer, S.naam, S.geslacht, S.emailadres, S.vasttel, "
                    + "S.mobieltel, B.adres, B.land, B.herkomst_uni, O.naam as opleiding "
                    + "FROM Buitenlands B join Student ON B.studentnummer = S.studentnummer "
                    + "left join Opleiding O on B.opleiding_id = O.opleiding_id ";
        } else {
            columnName = columnName.toLowerCase();
            if(columnName.equals("naam") || columnName.equals("geslacht") || columnName.equals("adres") || 
                    columnName.equals("vasttel") || columnName.equals("mobieltel")) {
                SQL = "SELECT S.studentnummer, S.naam, S.geslacht, S.emailadres, " +
                        "S.vasttel, S.mobieltel, B.adres, B.land, B.herkomst_uni, " 
                        + "O.naam as opleiding FROM Buitenlands B join Student ON B.studentnummer = S.studentnummer "
                        + "left join Opleiding O on B.opleiding_id = O.opleiding_id "
                        + "WHERE S." + columnName + " LIKE ?";
            } else if(columnName.equals("opleiding")) {
                SQL =   "SELECT S.studentnummer, S.naam, S.geslacht, S.emailadres, " +
                        "S.vasttel, S.mobieltel, B.adres, B.land, B.herkomst_uni, " 
                        + "O.naam as opleiding FROM Buitenlands B join Student ON B.studentnummer = S.studentnummer "
                        + "left join Opleiding O on B.opleiding_id = O.opleiding_id "
                        + "WHERE O.opleiding_id = B.opleiding_id ";
            }
            else 
            {
            SQL = "SELECT S.studentnummer, S.naam, S.geslacht, S.emailadres, " +
                        "S.vasttel, S.mobieltel, B.adres, B.land, B.herkomst_uni " 
                        + "FROM Student S join Buitenlands B ON S.studentnummer = B.studentnummer " +
                        "WHERE B." + columnName + " LIKE ?";
            }            
        }        
        return SQL;
    }
    
    public PreparedStatement getSelectStatement(PreparedStatement stmt, String columnInput) throws SQLException {
        stmt.setString(1, "%" + columnInput + "%");
        return stmt;
    }
    
    public String toString() {
        return "buitenlands";
    }
    
    
}
   