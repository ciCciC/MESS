/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.DatabaseManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Joep
 */
public class Student{
    
    private String studentNummer;
    private String naam;
    private char geslacht;
    private String email;
    private ArrayList<String> telefoonNummers;
    
    public Student(String studentNr, String naam, char geslacht, String email, String telNr) {
        this.studentNummer = studentNr;
        this.naam = naam;
        this.geslacht = Character.toUpperCase(geslacht);
        this.email = email;
        telefoonNummers = new ArrayList<String>();
        telefoonNummers.add(telNr);
    }
    
    public String getStudentNummer() {
        return this.studentNummer;
    }
    
    public String getNaam() {
        return this.naam;
    }
    
    public char getGeslacht() {
        return this.geslacht;
    }
    
    public String getEmail() {
        return this.email;
    }
    public ArrayList<String> getTelefoonNummers() {
        return this.telefoonNummers;
    }
    
    public String getStudentInsertSQL() {
        return "INSERT INTO Student VALUES (?, ?, ?, ?); ";
       
    }
    
    public PreparedStatement getInsertStudentStatement(PreparedStatement stmt) throws SQLException {
        
        stmt.setString(1, this.studentNummer);
        stmt.setString(2, this.naam);
        stmt.setString(3, "" + this.geslacht);
        stmt.setString(4, this.email);
        return stmt;       
    }
    
    
    public void insertStudent(Connection con) throws SQLException {
        //System.out.println(this.getStudentInsertSQL());
        String SQL = this.getStudentInsertSQL();
        PreparedStatement stmt = con.prepareStatement(SQL);
        stmt = this.getInsertStudentStatement(stmt);
        System.out.println(stmt.toString());
        stmt.execute();
        System.out.println("insertStudent reached");
        stmt.close();
    }
    
    public String getUpdateStudentSQL() {
        return "UPDATE Student SET naam = ?, geslacht = ?, emailadres = ? WHERE studentnummer = ?";       
    }
    
    public PreparedStatement getUpdateStudentStatement(PreparedStatement stmt) throws SQLException {        
        stmt.setString(1, this.naam);
        stmt.setString(2, "" + this.geslacht);
        stmt.setString(3, this.email);
        stmt.setString(4, this.studentNummer);
        return stmt;       
    }
    
    public void updateStudent(Connection con) throws SQLException {
        String SQL = this.getUpdateStudentSQL();
        PreparedStatement stmt = con.prepareStatement(SQL);
        stmt = this.getUpdateStudentStatement(stmt);
        
        stmt.execute();       
        stmt.close();
    }
    
    public String getDeleteStudentSQL() {
        return "DELETE FROM Student WHERE studentnummer = ?";       
    }
    
    public PreparedStatement getDeleteStudentStatement(PreparedStatement stmt, int keyValue) throws SQLException {     
        stmt.setString(1, Integer.toString(keyValue));
        return stmt;       
    }
    
    public void deleteStudent(Connection con, int keyValue) throws SQLException {
        String SQL = this.getDeleteStudentSQL();
        PreparedStatement stmt = con.prepareStatement(SQL);
        stmt = this.getDeleteStudentStatement(stmt, keyValue);
        
        stmt.execute();
        
        con.close();
        stmt.close();
    }
    
    
}
