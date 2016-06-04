/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Joep
 */
public class SqlBuilder {
    
    //Builds SQL to insert record in Table
    /*public String buildInsertSQL(String tableName, String[] values){
        String SQL = "INSERT INTO " + tableName + " VALUES('";
        for(int i=0; i<values.length -1; i++) {
            SQL += values[i] + "', '";
        }
        SQL += values[values.length -1] + "')";
        return SQL;           
    }
    
    
    //Builds SQL to update record in Table
    public String buildUpdateSQL(String tableName, String[] values) {
        String[] attributes = this.getTableAttributes(tableName);
        
        String SQL = "UPDATE " + tableName + " SET ";
        for(int i=1; i<values.length; i++) {
            
            if(i == values.length - 1) {
                SQL += attributes[i] + "='" + values[i] + "'";
            } else {
                SQL += attributes[i] + "='" + values[i] + "',";
            }            
        }
        SQL += " WHERE " + attributes[0] + " ='" + values[0] + "'";
        return SQL;
                
    }
    
    //Builds SQL to Delete record from Table
    public String buildDeleteSQL(String tableName, String key) {
        String keyAttribute = this.getTableAttributes(tableName)[0];
        String SQL = "DELETE FROM " + tableName + " WHERE " +
                keyAttribute + " ='" + key + "'";
        return SQL;
    }
    
    //Builds SQL to Delete record from Table
    public String buildSearchSQL(String tableName, String columnName, String columnValue) {
        String SQL = "SELECT * FROM " + tableName + " WHERE " +
                columnName + " LIKE'" + columnValue + "'";
        return SQL;
    }
    
    public String buildSearchBuitenlandseStudentSQL(String columnName, String columnValue) {
        String SQL = "SELECT S.studentnummer, S.naam, S.geslacht, S.emailadres,"
                + "B.adres, B.land, B.herkomst_uni "
                + "FROM Student S JOIN Buitenlands B "
                + "ON S.studentnummer = B.studentnummer"
                + " WHERE " + columnName + " LIKE '" + columnValue + "'";
        return SQL;
        
    }
    */
}
