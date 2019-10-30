/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.events.entities;

import static edu.events.entities.MyConnection.cnx;
import gui.AfficherEventsController;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author atefk
 */
class NewClass extends TimerTask {

    public NewClass() {
    }
 public void run() {
     try {
         String   requet="delete * from events WHERE date_event < DATE(NOW())";
         Statement st=cnx.createStatement(); 
         ResultSet rs=st.executeQuery(requet);
         System.out.println("hi");
     } catch (SQLException ex) {
         Logger.getLogger(AfficherEventsController.class.getName()).log(Level.SEVERE, null, ex);
     }}}