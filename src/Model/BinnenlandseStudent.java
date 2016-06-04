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
public class BinnenlandseStudent extends Student{
    
    private String uitgaansUni;

    public BinnenlandseStudent(String studentNr, String naam, char geslacht, String email, String telNr, String uitgaansUni) {
        super(studentNr, naam, geslacht, email, telNr);
        this.uitgaansUni = uitgaansUni;
    }
    
    public String getUitgaansUni() {
        return uitgaansUni;
    }
    
    public String[] getAttribuut() {
        return new String[]{"uitgaans_uni"};   
    }
    
    public String insertBinnenlandseStudent() {
        return "INSERT INTO BinnenlandseStudent VALUES('" + 
                this.getStudentNummer() + "', '" +                
                this.getUitgaansUni() + "')";               
            
    }
}
