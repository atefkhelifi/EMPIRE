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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author atefk
 */
public class UEServices {

    public UEServices() {
    }
    
     MyConnection myCnx= MyConnection.getInstance();
    Connection cnx=MyConnection.getInstance().getConnection();
    
   // UserEvent ue=new UserEvent();
    Events e =new Events();
    User ue =new User();
    
    public void iscEvent(int ue, int e){
        String requette = "INSERT INTO userevent (idUser, idEvent) VALUES (?,?)";
        String req ="UPDATE events SET place_dispo= place_dispo -1 WHERE id_event=? AND place_dispo -1>0 ";
        try {
            PreparedStatement pst = cnx.prepareStatement(requette);
            PreparedStatement ps = cnx.prepareStatement(req);

            pst.setInt(1, ue);
            pst.setInt(2, e);
           ps.setInt(1, e);
          
            //ue.setIdE(e.getId_event());
            //pst.setInt(4,ue.getIdE());
             //pst.setString(4, ue.getEmail());
            
            pst.executeUpdate();
            ps.executeUpdate();
            System.out.println("personne ajouté");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
       // ue.setIdE(e.getId_event());
      public List<Events> displayEvent1(){
  String requette="select * from events";
  List<Events> list=new ArrayList<>();
        try {
            Statement st=cnx.createStatement();
            ResultSet s=st.executeQuery(requette);
            while (s.next()) {
               list.add(new Events(s.getInt("id_event"),s.getString("nom_event"),s.getString("localisation_event"),s.getInt("prix_event"),s.getDate("date_event"),s.getInt("place_dispo")));
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
  return list;
          
  }     



}
    

