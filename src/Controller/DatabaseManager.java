package Controller;

import java.sql.*;
import Model.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
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
        
	String url    = "jdbc:mysql://meru.hhs.nl:3306/15068145"; //meru.hhs.nl
	String username = "15068145";                             //15068145
	String password = "aehaePoo3o";                           //aehaePoo3o
        
        return DriverManager.getConnection(url, username, password);
    }
    
    public void insertEntity(Entiteit entiteit) throws SQLException { 
        Connection con = this.getConnection();
        PreparedStatement stmt = con.prepareStatement(entiteit.getInsertSQL());
        stmt = entiteit.getInsertStatement(stmt, con);
        System.out.println(stmt.toString());
        stmt.execute();      
        
        con.close();
        stmt.close();
    }
    
    public void updateEntity(Entiteit entiteit) throws SQLException { 
        Connection con = this.getConnection();
        PreparedStatement stmt = con.prepareStatement(entiteit.getUpdateSQL());
        stmt = entiteit.getUpdateStatement(stmt, con);
        System.out.println(stmt.toString());
        stmt.execute();      
        
        con.close();
        stmt.close();
    }
     
    public void deleteEntity(String tableName, int keyValue) throws SQLException {
        Entiteit entiteit = this.getEntity(tableName);
        
        Connection con = this.getConnection();
        PreparedStatement stmt = con.prepareStatement(entiteit.getDeleteSQL());
        stmt = entiteit.getDeleteStatement(stmt, con, keyValue);
        System.out.println(stmt.toString());
        stmt.execute();      
        
        System.out.println(entiteit.getClass());
        if(entiteit.toString().equals("buitenlands")) {
            System.out.println("aa");
            BuitenlandseStudent student = (BuitenlandseStudent) entiteit;
            student.deleteStudent(con, keyValue);
        }
        if(entiteit.toString().equals("binnenlands")) {
            BinnenlandseStudent student = (BinnenlandseStudent) entiteit;
            student.deleteStudent(con, keyValue);
        }
        con.close();
        stmt.close();
    }
    
    public DefaultTableModel selectEntity(String tableName, String columnName, String columnInput) throws SQLException { 
        Connection con = this.getConnection();
        String sql = "";
        PreparedStatement stmt = null;        
        Entiteit entiteit = this.getEntity(tableName);
        if(columnInput.isEmpty()) {
            sql = entiteit.getSelectSQL("");
            stmt = con.prepareStatement(sql);            
        } else {
            sql = entiteit.getSelectSQL(columnName);
            stmt = con.prepareStatement(sql);
            stmt.setString(1, "%" + columnInput + "%");
        }
        System.out.println(stmt.toString());
        ResultSet rs = stmt.executeQuery();
        
        DefaultTableModel table = this.buildTableModel(rs);
        
        con.close();
        stmt.close();       
        
        return table;       
    }
    
    public void schrijfIn(String studentnummer, int onderwijsID) throws SQLException{
        Connection con = this.getConnection();
        
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        Date date = Date.valueOf(LocalDate.now());
        String dateStr = df.format(date);
        
        String SQL = "INSERT INTO Schrijft_in VALUES(?, ?, ?)";
        PreparedStatement stmt = con.prepareStatement(SQL);
        stmt.setString(1, studentnummer);
        stmt.setInt(2, onderwijsID);
        stmt.setString(3, dateStr);
        
        stmt.execute();
        
        stmt.close();
        con.close();                   
    }
    
    public DefaultTableModel getInschrijvingen() throws SQLException{
        Connection con = this.getConnection();
        
        String SQL = "SELECT S.studentnummer, S.naam, OE.typeonderwijseenheid, O.naam as opleiding, SI.inschrijfdatum "
                + "FROM Schrijft_in SI JOIN Student S ON SI.studentnummer = S.studentnummer "
                + "JOIN Onderwijseenheid OE on SI.ond_id = OE.ond_id, Opleiding O "
                + "WHERE OE.opleiding = O.opleiding_id ";
        PreparedStatement stmt = con.prepareStatement(SQL);
        ResultSet rs = stmt.executeQuery();      
        stmt.execute();
        
        DefaultTableModel table = this.buildTableModel(rs);
        
        stmt.close();
        con.close();  
        
        return table;                
    }
    
    public ArrayList<String> getOpleidingNamen() throws SQLException{
        ArrayList<String> opleidingNamen = new ArrayList<String>();
        Connection con = this.getConnection();
        String sql = "SELECT naam FROM Opleiding";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()) {
            opleidingNamen.add(rs.getString("naam"));
        }  
        rs.close();
        con.close();
        
        return opleidingNamen;
    }
    
    public int getOpleidingID(String opleidingNaam) throws SQLException{
        int opleidingID = -1;
        Connection con = this.getConnection();
        String sql = "SELECT opleiding_id FROM Opleiding WHERE naam LIKE ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, "%" + opleidingNaam + "%");
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()) {
            opleidingID = rs.getInt("opleiding_id");
        }   
        rs.close();
        con.close();
        
        return opleidingID;
    }
    
    public ArrayList<String> getBedrijfsNamen() throws SQLException{
        ArrayList<String> bedrijfsNamen = new ArrayList<String>();
        Connection con = this.getConnection();
        String sql = "SELECT DISTINCT bedrijfsnaam FROM Bedrijf";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()) {
            bedrijfsNamen.add(rs.getString("bedrijfsnaam"));
        } 
        rs.close();
        con.close();
        
        return bedrijfsNamen;
    }
    
    public int getBedrijfID(String bedrijfsNaam) throws SQLException{
        int opleidingID = -1;
        Connection con = this.getConnection();
        String sql = "SELECT bedrijf_id FROM Bedrijf WHERE bedrijfsnaam LIKE ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, "%" + bedrijfsNaam + "%");
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()) {
            opleidingID = rs.getInt("bedrijf_id");
            break;
        }    
        rs.close();
        con.close();
        return opleidingID;
    }
    
    public ArrayList<String> getContactpersoonNamen() throws SQLException{
        ArrayList<String> contactpersoonNamen = new ArrayList<String>();
        Connection con = this.getConnection();
        String sql = "SELECT DISTINCT naam FROM Contactpersoon";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()) {
            contactpersoonNamen.add(rs.getString("naam"));
        }
        rs.close();
        con.close();
        return contactpersoonNamen;
    }
    
    public int getContactpersoonID(String contactpersoonNaam) throws SQLException{
        int contactpersoonID = -1;
        Connection con = this.getConnection();
        String sql = "SELECT contact_id FROM Contactpersoon WHERE naam LIKE ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, "%" + contactpersoonNaam + "%");
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()) {
            contactpersoonID = rs.getInt("contact_id");
            break;
        }
        
        rs.close();
        con.close();
        return contactpersoonID;
    }
    
    public ArrayList<String> getPeriodes() throws SQLException{
        ArrayList<String> periodes = new ArrayList<String>();
        
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        Date date = Date.valueOf(LocalDate.now());
        String dateStr = df.format(date);
        
        Connection con = this.getConnection();
        String sql = "SELECT P.begindatum, P.einddatum FROM Periode P WHERE DATEDIFF(P.begindatum, ?) > -200 "
                + "ORDER BY begindatum ASC";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, dateStr);        
        ResultSet rs = stmt.executeQuery();
        
        
        while(rs.next()) {
            String beginDate = rs.getString("begindatum");
            String endDate = rs.getString("einddatum");
            String dates = beginDate + "/" + endDate;
            periodes.add(dates);
            
        }        
        rs.close();
        con.close();
        
        
        return periodes;
    }
    
    public Entiteit getEntity(String entityStr) {
        entityStr = entityStr.toLowerCase();
        Entiteit enti = null;
        switch (entityStr) {
            case "bedrijf":
                enti = new Bedrijf();
                break;
            case "buitenlands":
                enti = new BuitenlandseStudent("", "", 'm', "", "", "");
                break;
            case "binnenlands":
                enti =  new BinnenlandseStudent("", "", 'm', "", "", "");
                break;
            case "contactpersoon":
                enti = new Contactpersoon();
                break;
            case "onderwijseenheid":
                enti = new Onderwijseenheid();
                break;
            case "opleiding":
                enti = new Opleiding();
                break;
            case "periode":
                enti = new Periode();
                break;               
        }
        return enti;
    }
    
    public DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {
        

        ResultSetMetaData metaData = rs.getMetaData();
        
        // names of columns
        Vector<String> columnNames = new Vector<>();
        int columnCount = metaData.getColumnCount();
        for (int i = 1;  i <= columnCount; i++) {
            columnNames.add(metaData.getColumnLabel(i));
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
  
