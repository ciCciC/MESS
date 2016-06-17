/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Joep
 */
public class Onderwijseenheid implements Entiteit{
    private int ond_id;
    private int studiepunten; 
    private String soort_studie;
    private int bedrijf_id;
    private String typeonderwijseenheid;
    private String land;
    private String stad;
    private int opleiding;
    
    public Onderwijseenheid() {};
    
    public Onderwijseenheid(int ond_id, int studiepunten, String soort_studie, int bedrijf_id, String typeonderwijseenheid
                                ,String land, String stad, int opleiding) {
        this.ond_id = ond_id;
        this.studiepunten = studiepunten;
        this.soort_studie = soort_studie; //Minon/european summer school etc;
        this.bedrijf_id = bedrijf_id;
        this.typeonderwijseenheid = typeonderwijseenheid;
        this.land = land;
        this.stad = stad;
        this.opleiding = opleiding;
    }

    public String getInsertSQL() {
        String SQL = "INSERT INTO Onderwijseenheid (studiepunten, ";
        if(!this.soort_studie.isEmpty()) {
            SQL += "soort_studie, ";
        } else if(this.bedrijf_id > 0) {
            SQL += "bedrijf_id, ";
        }
        SQL += "typeonderwijseenheid, land, stad, opleiding)"
                + " VALUES (?, ?, ?, ?, ?, ?);";
        return SQL;
    }

    public PreparedStatement getInsertStatement(PreparedStatement stmt, Connection con) throws SQLException {
        stmt.setInt(1, this.studiepunten);
        if(!this.soort_studie.isEmpty()) {
            stmt.setString(2, this.soort_studie);
        } else {
            stmt.setInt(2, this.bedrijf_id);
        }        
        stmt.setString(3, this.typeonderwijseenheid);
        stmt.setString(4, this.land);
        stmt.setString(5, this.stad);
        stmt.setInt(6, this.opleiding);
        return stmt;
    }
    
    public String getUpdateSQL() {
         String SQL = "UPDATE Onderwijseenheid SET studiepunten = ?, ";
        if(!this.soort_studie.isEmpty()) {
            SQL += "soort_studie = ?, ";
        } else if(this.bedrijf_id > 0) {
            SQL += "bedrijf_id = ?, ";
        }
        SQL += "typeonderwijseenheid= ?, land = ?, stad = ?, opleiding = ? WHERE ond_id = ?";
        return SQL;
    }              
        
    public PreparedStatement getUpdateStatement(PreparedStatement stmt, Connection con) throws SQLException {
        stmt.setInt(1, this.studiepunten);
        if(!this.soort_studie.isEmpty()) {
            stmt.setString(2, this.soort_studie);
        } else {
            stmt.setInt(2, this.bedrijf_id);
        }     
        stmt.setString(3, this.typeonderwijseenheid);
        stmt.setString(4, this.land);
        stmt.setString(5, this.stad);
        stmt.setInt(6, this.opleiding);
        stmt.setInt(7, this.ond_id);
        return stmt;
    }
    
    public String getDeleteSQL() {
        return "DELETE FROM Onderwijseenheid WHERFE ond_id = ?";
    }

    public PreparedStatement getDeleteStatement(PreparedStatement stmt, Connection con, int keyValue) throws SQLException {
        stmt.setInt(1, keyValue);
        return stmt;
    }
    
    public String getSelectSQL(String columnName) {
        String SQL = "";
        
        if(columnName.isEmpty()) {
            SQL = "SELECT OE.ond_id, OE.studiepunten, OE.soort_studie, B.bedrijfsnaam, OE.typeonderwijseenheid, "
                    + "O.naam as opleiding FROM Onderwijseenheid OE left join Bedrijf B on OE.bedrijf_id = B.bedrijf_id "
                    + "join Opleiding O on OE.opleiding = O.opleiding_id ";
        }else{
            SQL = "SELECT OE.ond_id, OE.studiepunten, OE.soort_studie, B.bedrijfsnaam, OE.typeonderwijseenheid, "
                    + "O.naam FROM Onderwijseenheid OE left join Bedrijf B on OE.bedrijf_id = B.bedrijf_id "
                    + "join Opleiding O on OE.opleiding = O.opleiding_id  WHERE " + columnName + " LIKE ?";
        }
        return SQL;
    }

    public PreparedStatement getSelectStatement(PreparedStatement stmt, String columnInput) throws SQLException {
        stmt.setString(1, columnInput);
        return stmt;
    }
    
}
