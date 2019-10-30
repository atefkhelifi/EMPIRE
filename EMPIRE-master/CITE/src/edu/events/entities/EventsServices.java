/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.events.entities;


import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import javafx.event.Event;

/**
 *
 * @author atefk
 */
public class EventsServices {
    MyConnection myCnx= MyConnection.getInstance();
    Connection cnx=MyConnection.getInstance().getConnection();
    public void ajouterEvent(Events e) {
        String requette = "INSERT INTO events (nom_event,localisation_event,prix_event,date_event,place_dispo) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement pst = cnx.prepareStatement(requette);
            pst.setString(1, e.getNom_event());
            pst.setString(2, e.getLocalisation_event());
            pst.setInt(3, e.getPrix_event());
            pst.setDate(4,e.getDate_event());
            pst.setInt(5, e.getPlace_dispo());
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
                Date date=result.getDate(5);
                int place_dispo =result.getInt(6);
                String output = "User %d:%s - %s - %d - %s - %d ";
                System.out.println(String.format(output, i, nom, localisation, prix, date,place_dispo));
            }       } catch (SQLException ex) {
            System.out.println("error");
            }
}
       public Events affichEvent(int id) {
                   Events e=null;

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
                Date date=result.getDate(5);
                int place_dispo =result.getInt(6);
                
                String output = "User %d:%s - %s - %d - %s -%d";
                 e=new Events( nom, localisation, prix, date, place_dispo);

                System.out.println(String.format(output, i, nom, localisation, prix, date,place_dispo));
            }       } catch (SQLException ex) {
            System.out.println(ex);
            }

        return e;
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
                Date date=result.getDate(5);
                int place_dispo =result.getInt(6);
                String output = "User %d:%s - %s - %d - %s -%d";
                System.out.println(String.format(output, i, nom, localisation, prix, date,place_dispo));
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
            String requette = "UPDATE events SET nom_event=?,localisation_event=?,prix_event=?,date_event=?,place_dispo=? WHERE id_event=?";
            PreparedStatement pst = cnx.prepareStatement(requette);
            pst.setString(1, e.getNom_event());
            pst.setString(2, e.getLocalisation_event());
            pst.setInt(3, e.getPrix_event());
            pst.setDate(4, e.getDate_event());
            pst.setInt(5, e.getPlace_dispo());
            pst.setInt(6, id);
            
            pst.executeUpdate();
            System.out.println("update done");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
}
     
  public List<Events> displayEvent(){
  String requette="select * from events";
  List<Events> list=new ArrayList<>();
        try {
            Statement st=cnx.createStatement();
            ResultSet rs=st.executeQuery(requette);
            while (rs.next()) {
               list.add(new Events(rs.getInt("id_event"),rs.getString("nom_event"),rs.getString("localisation_event"),rs.getInt("prix_event"),rs.getDate("date_event"),rs.getInt("place_dispo")));
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
  return list;
  }     
}
