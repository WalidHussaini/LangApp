/* createTable.java code */
package com.teamsea.langapp;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
/**
*
* @author gerg2012
*/
public class CreateTable {
    public static void createUserTable() {
        Connection con = ConnectDb.getConnection();
        Statement stmt = null;
        String createString;
        createString = "CREATE TABLE if not exists User (id INTEGER PRIMARY KEY, username VARCHAR (200), email VARCHAR (200),password VARCHAR (200));";
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(createString);
            con.commit();
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.err.println("SQLException:" + e.getMessage());
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println("SQLException:" + e.getMessage());
                }
            }
        }
    }
}