package Controller;

import Libraries.ResultToTable;
import java.sql.*;
import Model.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Joep
 */
public class DatabaseManager {
    ResultToTable conv = new ResultToTable();
    
    //Arrays to store table attributes, these are used for the UPDATE method
    String[] studentAttributes = new String[] {"studentnummer", "naam", "geslacht", "emailadres"};
    String[] buitenlandsAttributes = new String[] {"studentnummer", "adres", "land", "herkomst_uni"};
    String[] binnenlandsAttributes = new String[] {"studentnummer", "uitgaans_uni", "opleiding_id"};
    
    
    //Constructor
    public DatabaseManager() {
        
        try {
		Class.forName("com.mysql.jdbc.Driver"); //Load MySQL driver
	} catch (ClassNotFoundException e) {
		System.out.println("Driver not found");
		e.printStackTrace();		
	}
    }
    
    //Maakt verbinding met database indien mogelijk   
    public Connection getConnection() throws SQLException {
        
	String url    = "jdbc:mysql://meru.hhs.nl:3306/15068145"; //meru.hhs.nl
	String username = "15068145";                             //15132390
	String password = "aehaePoo3o";                           //zaiquai4Xi
        
        return DriverManager.getConnection(url, username, password);
    }
    
    public void insertEntity(Entiteit entiteit) throws SQLException { 
        Connection con = this.getConnection();
        PreparedStatement stmt = con.prepareStatement(entiteit.getInsertSQL());
        stmt = entiteit.getInsertStatement(stmt);
        System.out.println(stmt.toString());
        stmt.execute();      
        
        con.close();
        stmt.close();
    }
    
}
    

    /*
    
    public void addRecord(String tableName, String[] values) 
        Connection con = this.getConnection();
        Statement stmt = con.createStatement();
        String sql = this.buildInsertSQL(tableName, values);
        stmt.executeUpdate(sql);
        
        System.out.println("Added!");
        
        con.close();
        stmt.close();
    }
    
    public void updateRecord(String tableName, String[] values) throws SQLException {
        Connection con = this.getConnection();
        Statement stmt = con.createStatement();
        String sql = this.buildUpdateSQL(tableName, values);
        stmt.executeUpdate(sql);
        
        System.out.println("UPDATED!");
        
        con.close();
        stmt.close();
    }
    
    public void deleteRecord(String tableName, String key) throws SQLException{
        Connection con = this.getConnection();
        Statement stmt = con.createStatement();
        String sql = this.buildDeleteSQL(tableName, key);
        stmt.executeUpdate(sql);
        
        System.out.println("DELETED");
        
        con.close();
        stmt.close();
    }
    
    //Voeg BuitenlandseStudent toe aan database
    //SHOULD BE UNNECESAIRY
    public void addBuitenlandseStudent(BuitenlandseStudent buiStudent) throws SQLException {
        
        Connection con = this.getConnection();
        Statement stmt = con.createStatement();
        String sql = buiStudent.insertBuitenlandseStudentSQL();
        stmt.executeUpdate(sql);
        sql = buiStudent.InsertStudentSQL();
        stmt.executeUpdate(sql);
        System.out.println("Student Added!");
        
        con.close();
        stmt.close();
    }

    //Returns TableModel containing all BuitenlandseStudenten
    public DefaultTableModel getBuitenlandseStudenten() throws SQLException{
        
        
        Connection con = this.getConnection();
        Statement stmt = con.createStatement();
        String sql = "SELECT S.studentnummer, S.naam, S.geslacht, S.emailadres,"
                + "B.adres, B.land, B.herkomst_uni "
                + "FROM Student S JOIN Buitenlands B "
                + "ON S.studentnummer = B.studentnummer";
        
        
        ResultSet rs = stmt.executeQuery(sql);
        DefaultTableModel res = conv.buildTableModel(rs);
        
        con.close();
        stmt.close();     
                
        return res;       
    }
    
    public DefaultTableModel search(String tableName, String columnName, String columnValue) throws SQLException{
        
        
        Connection con = this.getConnection();
        Statement stmt = con.createStatement();
        String sql = "";
        
        if(!columnValue.equals("")) {
            sql = this.buildSearchSQL(tableName, columnName, columnValue);
        } else {
            sql = "SELECT * FROM " + tableName;
        }
        
        ResultSet rs = stmt.executeQuery(sql);
        DefaultTableModel res = conv.buildTableModel(rs);
        
        con.close();
        stmt.close();     
                
        return res;       
    }
    
    public DefaultTableModel searchStudent(String columnName, String columnValue) throws SQLException{
        
        
        Connection con = this.getConnection();
        Statement stmt = con.createStatement();
        String sql = this.buildSearchBuitenlandseStudentSQL(columnName, columnValue);
       
        ResultSet rs = stmt.executeQuery(sql);
        DefaultTableModel res = conv.buildTableModel(rs);
        
        con.close();
        stmt.close();     
                
        return res;       
    }
    
    
    
    //Returns all attributes from given Table
    public String[] getTableAttributes(String tableName) {
        if(tableName.toLowerCase().equals("student")) {
            return this.studentAttributes;
        } else if(tableName.toLowerCase().equals("buitenlands")) {
            return this.buitenlandsAttributes;
        }
        else return new String[]{};
    }
}*/
