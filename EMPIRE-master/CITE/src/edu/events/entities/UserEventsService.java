/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.events.entities;

import java.sql.Connection;
import java.sql.Date;
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
public class UserEventsService {

    public UserEventsService() {
    }
    
    User u=new User();
    UserEvent ue=new UserEvent();
    MyConnection myCnx= MyConnection.getInstance();
    Connection cnx=MyConnection.getInstance().getConnection();
   /* public void aff() throws SQLException{
     String requette="select iduser from userevent where idevent=? ";    
        PreparedStatement pst = cnx.prepareStatement(requette);
            ResultSet result = pst.executeQuery();
            
            while (result.next()){
                int i =result.getInt(1);
                
                System.out.println();
   
    }
    }*/
    public List<User> displayUser(int x){
  String requette="SELECT user.nom,user.prenom,user.email,user.num_tel  FROM user JOIN userevent ON user.idUser=userevent.idUser AND userevent.idEvent="+x;
Events ee=new Events();
  List<User> list=new ArrayList<>();
        try {
            
            Statement st=cnx.createStatement();
            
            ResultSet rs=st.executeQuery(requette);
            while (rs.next()) {
               list.add(new User(rs.getString("nom"),rs.getString("prenom"),rs.getString("email"),rs.getInt("num_tel")));
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
  return list;
  }     
    //new
    public List<Events> displayEvents(int y){
  String requette="SELECT events.nom_event  FROM events JOIN userevent ON events.id_event=userevent.idEvent AND userevent.idUser="+y;
//User ee=new User();
  List<Events> list=new ArrayList<>();
        try {
            
            Statement st=cnx.createStatement();
            
            ResultSet rs=st.executeQuery(requette);
            while (rs.next()) {
               list.add(new Events(rs.getString("nom_event")));
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
  return list;
  }     
    
}
