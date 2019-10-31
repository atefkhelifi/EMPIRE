/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestionbib.tests;

import edu.gestionbib.entities.Emprunt;
import edu.gestionbib.entities.EmpruntCrud;
import edu.gestionbib.entities.LivreCrud;
import edu.gestionbib.entities.Livres;
import edu.gestionbib.entities.MyConnection;
import java.sql.SQLException;
import javax.swing.JFrame;



/**
 *
 * @author ASUS
 */
public class Gestionbibliotheque {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, Exception {
       // LivreCrud lcrud = new LivreCrud();
       // Livres L = new Livres("tunis", "ibnkholdoun", "disponible", "khfff", 41);
       // Livres p = new Livres("info", "atef", "disponible", "java", 20);
       // Livres m = new Livres("phy", "khaled", "disponible", "chimie", 30);
       // lcrud.ajouterLivres(L);
        //lcrud.ajouterLivres(p);
        //lcrud.ajouterLivres(m);
       //lcrud.modifierLivre(m, 2);
     // lcrud.suprrimerLivre(6);
      // lcrud.displayLiivre();
      //String s="info";
      //lcrud.filtrerLivre(s);
        EmpruntCrud ec =new EmpruntCrud();
        Emprunt e = new Emprunt( 1, 2, new java.sql.Date(2015, 02, 24), new java.sql.Date(2017, 02, 25));
        ec.ajouterEmprunt(e);
    }
    
}
