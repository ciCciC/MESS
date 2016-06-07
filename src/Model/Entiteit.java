/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.*;

/**
 *
 * @author Joep
 */
public interface Entiteit {
    
    public String getInsertSQL();
    public PreparedStatement getInsertStatement(PreparedStatement stmt, Connection con) throws SQLException;
    
    public String getUpdateSQL();
    public PreparedStatement getUpdateStatement(PreparedStatement stmt, Connection con) throws SQLException;
    
    public String getDeleteSQL();
    public PreparedStatement getDeleteStatement(PreparedStatement stmt, Connection con) throws SQLException;
    
    public String getSelectSQL(String columnName);
    public PreparedStatement getSelectStatement(PreparedStatement stmt, String columnInput) throws SQLException;
    
    
    
    
   
   
    
    
}
