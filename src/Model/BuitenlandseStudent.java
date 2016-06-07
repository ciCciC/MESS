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
    
    public BuitenlandseStudent(String studentNr, String naam, char geslacht, String email, String telNr, String adres, String land, String herkomstUni) {
        
        super(studentNr, naam, geslacht, email, telNr);
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
        return super.getInsertSQL() + "INSERT INTO Buitenlands VALUES (?, ?, ?, ?);";            
    }
    
    
    public PreparedStatement getInsertStatement(PreparedStatement stmt) throws SQLException{         
        
        stmt = super.getInsertStatement(stmt);        
        stmt.setString(5, super.getStudentNummer());
        stmt.setString(6, this.adres);
        stmt.setString(7, this.land);
        stmt.setString(8, this.herkomstUni);
        
        return stmt;        
    }
    
    
    
      /*
    public String[] getAttributen() {
        return new String[]{"adres", "land", "herkomst_uni"};   
    }
    
    public String insertBuitenlandseStudentSQL() {
        return "INSERT INTO BuitenlandseStudent VALUES('" + 
                this.getStudentNummer() + "', '" +                
                this.getAdres() + "', '" + 
                this.getLand() + "', '" + 
                this.getHerkomstUni() + "')";               
            
    }*/

    
    
   
    
}
