/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.testapplication.entities;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author amir
 */
public class MyConnection {
     public String url="jdbc:mysql://localhost:3306/cité";
    public String login="root";
    public String pwd="";
    public static Connection cnx;
    public static MyConnection myc;
    
    private MyConnection(){
        try {
            cnx=DriverManager.getConnection(url, login, pwd);
            System.out.println("Connextion établie!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Connexion non établie!");
        }
    }
      public void ajouterFormation(Formation f){
        String requete = "INSERT INTO formation (id_formation,nom_formation,sujet_formation,nom_formateur,nombre_place_formation,date_formation,localisation)"
                + "VALUES ('"+f.getId_formation()+"','"+f.getNom_formation()+"','"+f.getSujet_formation()+"','"+f.getNom_formateur()+"','"+f.getNombre_place_formation()+"','"+f.getDate_formation()+"','"+f.getLocalisation()+"')";
        
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(requete);
            System.out.println("formation ajouté");
        } catch (SQLException ex) {
            System.out.println("Erreur d'insertion");
        }
    }
    
    public void modifierFormation(Formation f,int id_formation){
        String requete = "UPDATE formation SET nom_formation=?,sujet_formation=?,nom_formateur=?,nombre_place_formation=?,date_formation=?,localisation=? WHERE id_formation=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(7, f.getLocalisation());
            pst.setString(4, f.getNom_formateur());
            pst.setString(5, f.getNom_formation());
            pst.setString(2, f.getSujet_formation());
            pst.setDate(3, (Date) f.getDate_formation());
            pst.setString(6, f.getNombre_place_formation());
            pst.setInt(1, id_formation);
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void supprimerPersonne(Formation f ){
        try {
            String requete = "DELETE FROM formation WHERE id_formation=?";
            
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, f.getId_formation());
            pst.executeUpdate();
            System.out.println("formation supprimé");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    public List<Formation> displayPersons(){
        List<Formation> myList = new ArrayList<>();
        try {
            String requete = "SELECT * FROM formation";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){
                Formation f = new Formation();
                f.setId_formation(rs.getInt("id_formation"));
                f.setSujet_formation(rs.getString("sujet_formation"));
                f.setDate_formation(rs.getDate("date_formation"));
                f.setLocalisation(rs.getString("localisation"));
                f.setNom_formateur(rs.getString("nom_formateur"));
                f.setNom_formation(rs.getString("nom_formateur"));
                f.setNombre_place_formation(rs.getString("nombre_place_formation"));
                myList.add(f);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myList;
    }
     public List<User> displayUser(){
       String requete ="SELECT * FROM user";
       List<User> mylist=new ArrayList<>();
       try{
       Statement st =cnx.createStatement();
           ResultSet rs = st.executeQuery(requete);
           while(rs.next()){
           User us =new User();
           us.setId(rs.getInt("idUser"));
           us.setAdresse(rs.getString("adresse"));
           us.setPassword(rs.getString("password"));
           us.setPhone_number(rs.getString("num_tel"));
           us.setUser_name(rs.getString("nom"));
           us.setId_formation(rs.getInt("id_formation"));
           us.setEmail(rs.getString("email"));
           
           mylist.add(us);
           }
       }
              
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
}
return mylist;  
       }
  
    public static Connection getConnection(){
        return cnx;
    }
    
   public static MyConnection getInstance(){
       if(myc ==null){
           myc = new MyConnection();
       }
       return myc;
   }
}
