/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.events.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

/**
 *
 * @author atefk
 */
public class EventsServices {
    MyConnection myCnx= MyConnection.getInstance();
    Connection cnx=MyConnection.getInstance().getConnection();
    public void ajouterEvent(Events e) {
        String requette = "INSERT INTO events (nom_event,localisation_event,prix_event,date_event) VALUES (?,?,?,?)";
        try {
            PreparedStatement pst = cnx.prepareStatement(requette);
            pst.setString(1, e.getNom_event());
            pst.setString(2, e.getLocalisation_event());
            pst.setInt(3, e.getPrix_event());
            System.out.println(e.getDate_event().getTime());
            pst.setTimestamp(4, new java.sql.Timestamp( e.getDate_event().getTime()));
            pst.executeUpdate();
            System.out.println("personne ajouté");
        } catch (SQLException ex) {
            System.out.println("erreur d insertion");
        }
    }
     public void affAll() {
        try {
            String sql = "SELECT * FROM events";
            
            PreparedStatement pst = cnx.prepareStatement(sql);
            ResultSet result = pst.executeQuery();
            
            while (result.next()){
                int i =result.getInt(1);
                String nom = result.getString(2);
                String localisation = result.getString(3);
                int prix =result.getInt(4);
                Time date=result.getTime(5);
                
                String output = "User %d:%s - %s - %d - %s ";
                System.out.println(String.format(output, i, nom, localisation, prix, date));
            }       } catch (SQLException ex) {
            System.out.println("error");
            }
}
     public void affEvents(int id) {
        try {
            String sql = "SELECT * FROM events where id_event= ?";
            
            PreparedStatement pst = cnx.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet result = pst.executeQuery();
            
            while (result.next()){
                int i =result.getInt(1);
                String nom = result.getString(2);
                String localisation = result.getString(3);
                int prix =result.getInt(4);
                Time date=result.getTime(5);
                
                String output = "User %d:%s - %s - %d - %s ";
                System.out.println(String.format(output, i, nom, localisation, prix, date));
            }       } catch (SQLException ex) {
            System.out.println(ex);
            }
     
}
      public void suppEvent( int id) {
        String requette = "DELETE FROM events where id_event=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(requette);
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("delet success");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
     
}
       public void modifierEvent(Events e, int id) {
        try {
            String requette = "UPDATE events SET nom_event=?,localisation_event=?,prix_event=?,date_event=?  WHERE id_event=?";
            PreparedStatement pst = cnx.prepareStatement(requette);
            pst.setString(1, e.getNom_event());
            pst.setString(2, e.getLocalisation_event());
            pst.setInt(3, e.getPrix_event());
            pst.setTimestamp(4, new java.sql.Timestamp( e.getDate_event().getTime()));
            pst.setInt(5, id);
            pst.executeUpdate();
            System.out.println("update done");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
}
    
}
