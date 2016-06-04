/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

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
        
        DatabaseManager DBM = new DatabaseManager();
        
        //System.out.println(DBM.buildDeleteSQL("student", "15132392"));
        //System.out.println(DBM.buildDeleteSQL("buitenlands", "15132392"));
                
        
        try {
            //DBM.addRecord("Student", new String[] {"15132395", "Joep", "M", "joepmulder1995@gmail.com"});
            //DBM.addRecord("Buitenlands", new String[] {"15132395", "Vinkelaan 54", "Belgie", "HHS"});
            //DBM.updateRecord("Student", new String[] {"15132392", "Kees", "M", "kees1995@gmail.com"});
            //DBM.updateRecord("Buitenlands", new String[] {"15132392", "Bloemenlaan", "Duitsland", "HHS"});
            //DBM.deleteRecord("buitenlands", "15132392");
            //DBM.deleteRecord("student", "15132392");
            
            DBM.insertEntity(student);
            
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
