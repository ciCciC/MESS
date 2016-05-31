/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Joep
 */
public class BuitenlandseStudent extends Student {

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
    
    public String insertBuitenlandseStudentSQL() {
        return "INSERT INTO BuitenlandseStudent VALUES('" + 
                this.getStudentNummer() + "', '" +                
                this.getAdres() + "', '" + 
                this.getLand() + "', '" + 
                this.getHerkomstUni() + "')";               
            
    }
    
    public String selectAllBuitenlandseStudentSQL() {
        return "SELECT S.studentnummer, S.naam, S.geslacht, S.emailadres,"
                + "B.adres, B.land, B.herkomst_uni"
                + "FROM Student S JOIN BuitenlandseStudent B"
                + "ON S.studentnummer = B.studentnummer";
                
    }
    
   
    
}
