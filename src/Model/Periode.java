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
public class Periode {
    
    private int ID;
    private String beginDatum;
    private String eindDatum;
    
    public Periode(int ID, String beginDatum, String eindDatum) {
        this.ID = ID;
        this.beginDatum = beginDatum;
        this.eindDatum = eindDatum;
    }
    
    public int getPeriodeID() {
        return ID;
    }
    
    public String getBeginDatum() {
        return beginDatum;
    }
    
    public String getEindDatum() {
        return eindDatum;
    }
    
    public String insertPeriode() {
        return "INSERT INTO Periode VALUES('" + 
                this.getPeriodeID() + "', '" +
                this.getBeginDatum() + "', '" +
                this.getEindDatum() + "');";
    }
}
