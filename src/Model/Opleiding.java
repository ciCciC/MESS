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
public class Opleiding {

    private int ID;
    private String naam;

    public Opleiding(int ID, String naam) {
        this.ID = ID;
        this.naam = naam;
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
}
