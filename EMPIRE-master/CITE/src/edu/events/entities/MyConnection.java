/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.events.entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

/**
 *
 * @author atefk
 */
public class MyConnection {
    public String url = "jdbc:mysql://localhost:3306/pidev";
    public String login = "root";
    public String pwd = "";
    public static Connection cnx;
    public static MyConnection myCnx;
    private MyConnection() {
        try {
            cnx = DriverManager.getConnection(url, login, pwd);
            System.out.println("connection etablie");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("connection failed");
        }

    }
public static MyConnection getInstance()
{
    if(myCnx ==null){
    myCnx= new MyConnection();
    }
        return myCnx;
}
public static Connection getConnection()
{
    return cnx;
}

}