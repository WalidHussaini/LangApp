/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.teamsea.langapp;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author gerg2
 */
public class UseTable {
    public static void insertUser(String username, String email, String password) {
        Connection con = ConnectDb.getConnection();
        Statement stmt = null;
        String sqlString = ("INSERT INTO User (username, email, password) VALUES ('"+ username +"', '"+ email +"', '"+ password +"')");
        try {
            con.setAutoCommit(false);
            stmt = con.createStatement();
            stmt.executeUpdate(sqlString);
            stmt.close();
            con.commit();
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
        }
    }

    public static ArrayList<String> getAll(String tablename, String key,  String filterKey, String value) {
        System.out.println("here");
        Connection con = ConnectDb.getConnection();
        Statement stmt = null;
        try {
            ArrayList<String> results = new ArrayList<>();
            stmt = con.createStatement();
            ResultSet rs;
            if(filterKey.equals("") || value.equals("")){
                rs = stmt.executeQuery("Select "+ key +" from "+ tablename);
            } else {
                rs = stmt.executeQuery("Select "+ key +" from "+ tablename +" WHERE "+ filterKey +" = '"+ value +"'");
            }
            int n = 0;
            while (rs.next()) {
                int numColumns = rs.getMetaData().getColumnCount();
                n++;
                for (int i = 1; i <= numColumns; i++) {
                    System.out.println(String.valueOf(rs.getObject(i)));
                    results.add(String.valueOf(rs.getObject(i)));
                }
            }
            rs.close();
            return results;
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
        }
        return new ArrayList<String>();
    }
    
    public static String get(String tablename, String key, String value, int column) {
        Connection con = ConnectDb.getConnection();
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            System.out.println("Select * from "+ tablename +" WHERE "+ key +" = '"+ value +"'");
            ResultSet rs = stmt.executeQuery("Select * from "+ tablename +" WHERE "+ key +" = '"+ value +"'");
            String resstr = String.valueOf(rs.getObject(column));
            return resstr;
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
        }
        return null;
    }
//    public static void main(String[] args) {
//        insertEmp();
//        showAll();
//    }
}
