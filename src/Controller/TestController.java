/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import Model.BuitenlandseStudent;
import java.awt.*;
import java.sql.Date;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.*;


/**
 *
 * @author Joep
 */
public class TestController {
    
    public static void main(String[] args) {      
    
        BuitenlandseStudent student = new BuitenlandseStudent("15132345", "Joep Mulder", 'm', "joep1995@gmail.com", 
              "0610454701", "0612345678", "Vinkelaan 54", "Nederland", "University of Queensland", 1);
        Bedrijf bedrijf = new Bedrijf(2, "Dunder Mifflin", " 13927 Saticoy", "Panorama City", "USA");
        DatabaseManager DBM = new DatabaseManager();
        BinnenlandseStudent student2 = new BinnenlandseStudent("12345", "Kees Mulder", 'm', "joep1995@gmail.com", 
              "0610454701", "061234567", "uitgaandeUni", 1);
        //Onderwijseenheid OndEh = new Onderwijseenheid(4, 15, "Summer schools", -1, "Stage", 1);
        Periode periode = new Periode(1, "09012016", "20170603"); 
        Contactpersoon contact = new Contactpersoon(1, "Contactpersoon", "Contactemail", "Contactnummer" );
        Opleiding opl = new Opleiding(1, 1, "HBO-C&M");
               
        
        try {         
            
            ArrayList<String> list = DBM.getPeriodes();
            System.out.println(DBM.getPeriodeID(list.get(1)));
            
        } catch(Exception e) {
            e.printStackTrace();
            
        }     
    }
    
}
