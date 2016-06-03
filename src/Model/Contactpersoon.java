/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Ruben
 */
public class Contactpersoon {
    
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
}