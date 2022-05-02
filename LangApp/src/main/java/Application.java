import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;/*
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gerg2012
 */
public class Application {
    public static void main(String args[]){
        System.out.println("Static method");
        Connection conn1 = null;

        try {
            System.out.println("trying to login");
            String url1 = "jdbc:mysql://23.251.129.101:3306/langapp";
            String user = "root";
            String password = "rootroot2020";
            conn1 = DriverManager.getConnection(url1, user, password);
            System.out.println("success");
        }
        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("exep");
        }
    }  
}
