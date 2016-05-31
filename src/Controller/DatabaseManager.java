package Controller;

import java.sql.*;
import Model.*;
import javax.swing.JTable;

/**
 *
 * @author Joep
 */
public class DatabaseManager {
    
     
    public DatabaseManager() {
        try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		System.out.println("Driver not found");
		e.printStackTrace();		
	}
    }
    
    public Connection getConnection() throws SQLException {
        
	String url    = "jdbc:mysql://meru.hhs.nl:3306/15132390";
	String username = "15132390";
	String password = "zaiquai4Xi";
        
        return DriverManager.getConnection(url, username, password);
    }
    
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

    /*public JTable getBuitenlandseStudenten() throws SQLException{
        
        
        /*Connection con = this.getConnection();
        Statement stmt = con.createStatement();
        String sql = "SELECT S.studentnummer, S.naam, S.geslacht, S.emailadres,"
                + "B.adres, B.land, B.herkomst_uni"
                + "FROM Student S JOIN BuitenlandseStudent B"
                + "ON S.studentnummer = B.studentnummer";
        ResultSet rs = stmt.executeQuery(sql);
        JTable table = new JTable(buildTableModel(rs));
        System.out.println("Student Added!");
        
        con.close();
        stmt.close();
    }*/
}
