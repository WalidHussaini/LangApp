package com.teamsea.langapp;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;/*
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author gerg2012
 */
public class Application{
    /**
    * @param args the command line arguments
    */
    public static Integer sessionUser;
    
    public static void main(String[] args) {
        //ConnectDb.getConnection();
        CreateDb connect = new CreateDb();
        //CreateTable.createUserTable();
        String[] arguments = new String[] {"123"};
        Login_Form.main(arguments);
    }
}

class CreateDb {
    private String urlSQLite;
    private Driver driverSQLite;
    private Connection con;
    
    public CreateDb() {
        urlSQLite = "jdbc:sqlite:langapp.db";
        try {
            driverSQLite = new org.sqlite.JDBC();
            DriverManager.registerDriver(driverSQLite);
            System.out.println("Driver for SQLite downloaded.");
        } catch (Exception e) {
            System.out.println("Problem with download driver for SQLite: " +
            e.getMessage());
        }
        try {
            con = DriverManager.getConnection(urlSQLite);
            System.out.println("Connection to SQLite is done.");
        } catch (Exception e) {
            System.out.println("Problem with connection to SQLite: " +
            e.getMessage());
        }
        try {
            if (!con.isClosed()) {
            con.close();
            System.out.println("Connection to SQLite closed.");
            }
        } catch (Exception e) {
            System.out.println("Problem with close connection of SQLite");
        }
    }
}
