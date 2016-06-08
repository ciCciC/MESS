/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import Model.BuitenlandseStudent;
import java.awt.*;

import java.sql.SQLException;
import javax.swing.*;


/**
 *
 * @author Joep
 */
public class TestController {
    
    public static void main(String[] args) {      
    
        BuitenlandseStudent student = new BuitenlandseStudent("15132335", "Joep Mulder", 'm', "joep1995@gmail.com", 
              "0610454701", "Vinkelaan 54", "Nederland", "University of Queensland");
        Bedrijf bedrijf = new Bedrijf(2, "Dunder Mifflin", " 13927 Saticoy", "Panorama City", "USA");
        DatabaseManager DBM = new DatabaseManager();
        BinnenlandseStudent student2 = new BinnenlandseStudent("15132342", "Kees Mulder", 'm', "joep1995@gmail.com", 
              "0610454701", "uitgaandeUni", 1);
               
        try {
            
            
            DBM.updateEntity(student2);
            
        } catch(Exception e) {
            if(e.getMessage().startsWith("Duplicate")) {
                System.out.println("studentnummer bestaat al! gebruik andere");
            } else {
                System.out.println("SQL error");
                e.printStackTrace();
            }
            
        }     
    }
    
}
