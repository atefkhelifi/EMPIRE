/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestion_club.tests;

import edu.gestion_club.entities.Club;
import edu.gestion_club.entities.ClubCrud;
import edu.gestion_club.entities.MyConnection;
import java.sql.SQLException;

/**
 *
 * @author Asus
 */
public class Gestion_club {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
         //MyConnection mycnx = new MyConnection();
       //  Club c  = new Club("majeur","sport",22);
         //Club b  = new Club("amine","foot",11);
      //Club a = mycnx.ajouterclub(c);
    //  Club h =mycnx.modifierclub( b,1);
      //mycnx.supprimerclub(b, 1);
       //mycnx.afficherclub(2);
       
        ClubCrud mycnx = new ClubCrud();
        Club c = new Club("css","sp",22);
        
       mycnx.ajouterclub(c);
      // mycnx.supprimerclub(c, 7);
       //mycnx.modifierclub(c, 6);
     // mycnx.afficherclub(8);
    // mycnx.displayclub();
   //  mycnx.filtrerclub();
   
    }
    
}
