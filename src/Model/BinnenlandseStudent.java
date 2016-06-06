/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Ruben
 */
public class BinnenlandseStudent extends Student implements Entiteit{
    
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

    @Override
    public String getUpdateSQL() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PreparedStatement getUpdateStatement(PreparedStatement stmt) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDeleteSQL() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PreparedStatement getDeleteStatement(PreparedStatement stmt) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSelectSQL(String columnName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PreparedStatement getSelectStatement(PreparedStatement stmt, String columnInput) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
