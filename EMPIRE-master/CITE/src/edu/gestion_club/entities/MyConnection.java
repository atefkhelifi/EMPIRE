/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestion_club.entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Asus
 */
public class MyConnection {

    private String url = "jdbc:mysql://localhost:3306/pidev";
    private String login = "root";
    private String pwd = "";
    
      public static Connection cnx;
        public static MyConnection myc;

   private MyConnection() {
        try {
            cnx = DriverManager.getConnection(url, login, pwd);
            System.out.println("Connexion établie!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("connexion non établie");
        }

    }
    public static MyConnection getInstance(){
                if(myc ==null){
                    myc = new MyConnection();
                }
                return myc;
            
        }
             public static Connection getConnection(){
                 return cnx;
             }

 
}
