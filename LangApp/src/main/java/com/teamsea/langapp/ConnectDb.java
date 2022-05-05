package com.teamsea.langapp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gerg2
 */
public class ConnectDb {
    /**
    * Handles the connection and creates the required database if missing.
    * @author gerg2
    * @return connection session
    */
    public static Connection getConnection() {
        try {
            Class.forName("org.sqlite.JDBC"); //loads the driver
            String url = "jdbc:sqlite:langapp.db"; // will create this database if it does not exist
            Connection con = DriverManager.getConnection(url); //establishes the connection
            return con; //returns the connection
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}
