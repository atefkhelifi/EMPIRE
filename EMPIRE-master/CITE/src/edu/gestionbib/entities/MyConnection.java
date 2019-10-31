package edu.gestionbib.entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ASUS
 */
public class MyConnection {

    public String url = "jdbc:mysql://localhost:3306/pidev";
    public String login = "root";
    public String pwd = "";
     public static Connection cnx;
    public static MyConnection myc;

    public MyConnection() {
        try {
            cnx = DriverManager.getConnection(url, login, pwd);
            System.out.println("connextion etablie!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("cnx non etablie");
        }
    }

   

    
     public static MyConnection getInstance(){
        if (myc==null){
            myc = new MyConnection();
        }
        return myc;
    }
    
    public static Connection getConnection(){
        return cnx;
    }

}
