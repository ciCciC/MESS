package Controller;

import java.sql.*;
import Model.*;
import java.util.Vector;
import javax.swing.table.*;


/**
 *
 * @author Joep
 */
public class DatabaseManager {
    
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
        
	String url    = "jdbc:mysql://localhost:3306/15132390"; //meru.hhs.nl
	String username = "root";                             //15068145
	String password = "root";                           //aehaePoo3o
        
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
    
    public void updateEntity(Entiteit entiteit) throws SQLException { 
        Connection con = this.getConnection();
        PreparedStatement stmt = con.prepareStatement(entiteit.getUpdateSQL());
        stmt = entiteit.getUpdateStatement(stmt);
        System.out.println(stmt.toString());
        stmt.execute();      
        
        con.close();
        stmt.close();
    }
     
    public void deleteEntity(Entiteit entiteit) throws SQLException { 
        Connection con = this.getConnection();
        PreparedStatement stmt = con.prepareStatement(entiteit.getDeleteSQL());
        stmt = entiteit.getDeleteStatement(stmt);
        System.out.println(stmt.toString());
        stmt.execute();      
        
        con.close();
        stmt.close();
    }
    
    public DefaultTableModel selectEntity(Entiteit entiteit, String columnName, String columnInput) throws SQLException { 
        Connection con = this.getConnection();
        PreparedStatement stmt = con.prepareStatement(entiteit.getSelectSQL(columnName));
        stmt = entiteit.getSelectStatement(stmt, columnInput);
        System.out.println(stmt.toString());
        
        ResultSet rs = stmt.executeQuery();
        DefaultTableModel table = this.buildTableModel(rs);
        
        con.close();
        stmt.close();
        
        
        return table;
       
    }
    
    public DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {
        

        ResultSetMetaData metaData = rs.getMetaData();
        
        // names of columns
        Vector<String> columnNames = new Vector<>();
        int columnCount = metaData.getColumnCount();
        for (int i = 1;  i <= columnCount; i++) {
            columnNames.add(metaData.getColumnName(i));
        }

        // data of the table
        Vector<Vector<Object>> data = new Vector<>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<>();
            for (int i = 1; i <= columnCount; i++) {
                vector.add(rs.getObject(i));
            }
            data.add(vector);
        }

        return new DefaultTableModel(data, columnNames);
    }
    
    
}
  
