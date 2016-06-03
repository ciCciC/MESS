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
public class Bedrijf {
    
    private int ID;
    private String naam;
    private String adres;
    private String stad;
    private String land;
    
    public Bedrijf(int ID, String naam, String adres, String stad, String land) {
        this.ID = ID;
        this.naam = naam;
        this.adres = adres;
        this.stad = stad;
        this.land = land;
    }
    
    public int getBedrijfID() {
        return ID;
    }
    
    public String getBedrijfsNaam() {
        return naam;
    }
    
    public String getBedrijfsAdres() {
        return adres;
    }
    
    public String getBedrijfStad() {
        return stad;
    }
    
    public String getBedrijfLand() {
        return land;
    }
    
    public String insertBedrijf() {
        return "INSERT INTO Bedrijf VALUES('" + 
                this.getBedrijfID() + "', '" +
                this.getBedrijfsNaam() + "', '" +
                this.getBedrijfsAdres() + "', '" +
                this.getBedrijfStad() + "', '" +
                this.getBedrijfLand() + "');";
    }
    
}
