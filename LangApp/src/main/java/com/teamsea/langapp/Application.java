package com.teamsea.langapp;
import java.awt.Color;
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
public class Application {
    /**
    * @param args the command line arguments
    */
    public static void main(String[] args) {
        JFrame frame = new JFrame("LangApp");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(414, 896);
        JPanel loginGrid = new JPanel(new GridLayout(4,4,4,4));
        JButton registerButton = new JButton("Register");
        registerButton.setPreferredSize(new Dimension(40, 100));
        loginGrid.add(registerButton); // Adds Button to content pane of frame
        JButton loginButton = new JButton("Login");
        loginButton.setBackground(Color.decode("#f8c200"));
        loginButton.setOpaque(true);
        loginButton.setPreferredSize(new Dimension(40, 100));
        loginGrid.add(loginButton); // Adds Button to content pane of frame
        frame.setContentPane(loginGrid);
        frame.setResizable(false);
        frame.setVisible(true);
        //ConnectDb.getConnection();
        CreateDb connect = new CreateDb();
        //CreateTable.createUserTable();
        
        registerButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                String[] arguments = new String[] {"123"};
                Register_Form.main(arguments);
            } 
        } );
        
        loginButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                //UseTable.showAll("Language", "name");
                String res = UseTable.get("Language", 2, 2);
                System.out.println(res);
                //UseTable.insertUser("name", "email", "password");
                String[] arguments = new String[] {"123"};
                Login_Form.main(arguments);
            } 
        } );
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
