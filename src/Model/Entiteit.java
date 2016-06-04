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
    public String getUpdateSQL();
    public String getDeleteSQL();
    public String getSelectSQL();
    
    public PreparedStatement getInsertStatement(PreparedStatement stmt) throws SQLException;
    public PreparedStatement getUpdateStatement(PreparedStatement stmt) throws SQLException;
    public PreparedStatement getDeleteStatement(PreparedStatement stmt) throws SQLException;
    public PreparedStatement getSelectStatement(PreparedStatement stmt) throws SQLException;
    
    
}
