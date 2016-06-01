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
public abstract class Student implements Entiteit{
    
    private String studentNummer;
    private String naam;
    private char geslacht;
    private String email;
    private ArrayList<String> telefoonNummers;
    
    public Student(String studentNr, String naam, char geslacht, String email, String telNr) {
        this.studentNummer = studentNr;
        this.naam = naam;
        this.geslacht = geslacht;
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
    
    public String InsertStudentSQL() {
        return "INSERT INTO Student VALUES('" + 
                this.getStudentNummer() + "', '" +
                this.getNaam() + "', '" +
                this.getGeslacht() + "', '" +
                this.getEmail() + "');";
    }
}
