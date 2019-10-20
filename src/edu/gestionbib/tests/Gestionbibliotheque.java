/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestionbib.tests;

import edu.gestionbib.entities.LivreCrud;
import edu.gestionbib.entities.Livres;
import edu.gestionbib.entities.MyConnection;

/**
 *
 * @author ASUS
 */
public class Gestionbibliotheque {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LivreCrud lcrud = new LivreCrud();
        Livres L = new Livres("tunis", "ibnkholdoun", "disponible", "khfff", 41);
        Livres p = new Livres("info", "atef", "disponible", "java", 20);
        Livres m = new Livres("phy", "khaled", "disponible", "chimie", 30);
       // lcrud.ajouterLivres(L);
        //lcrud.ajouterLivres(p);
        //lcrud.ajouterLivres(m);
       //lcrud.modifierLivre(m, 2);
     // lcrud.suprrimerLivre(6);
       lcrud.affLivre(4);
    }
    
}
