/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.BuitenlandseStudent;
import java.sql.SQLException;

/**
 *
 * @author Joep
 */
public class TestController {
    
    public static void main(String[] args) {      
    
        BuitenlandseStudent student = new BuitenlandseStudent("15132392", "Joep Mulder", 'm', "joep1995@gmail.com", 
                "0610454701", "Vinkelaan 54", "Nederland", "University of Queensland");
        DatabaseManager DBM = new DatabaseManager();
        
        try { 
            DBM.addBuitenlandseStudent(student);
        } catch(SQLException e) {
            if(e.getMessage().startsWith("Duplicate")) {
                System.out.println("studentnummer bestaat al! gebruik andere");
            } else {
                System.out.println("SQL error");
            }
            
        }
        
    }
}
