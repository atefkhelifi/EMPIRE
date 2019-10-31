/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestionbib.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Date;

/**
 *
 * @author Admin
 */
public class EmpruntCrud {

    MyConnection myc = MyConnection.getInstance();
    Connection cnx = myc.getConnection();

    public void ajouterEmprunt(Emprunt e) {
        String requete = "insert into emprunts (id_livre,id_user,date_debut,date_fin) VALUES(?,?,?,?)";
        
        
        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
             
            pst.setInt(1, e.getId_livre());
            pst.setInt(2, e.getId_user());
            System.out.println("6666666");
            pst.setDate(3, e.getDate_debut());
            pst.setDate(4, e.getDate_fin());
            pst.executeUpdate();
           
           
            System.out.println("emrunt ajouter");
            int x =e.getId_livre();
            String r = "UPDATE livres set nombreExemplaire =nombreExemplaire-1 where livres.id_livre="+x; 
            PreparedStatement ps = cnx.prepareStatement(r);
             ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("erreur d'insertion" + ex.getMessage());
        }
    }
    
    
     public List<Emprunt> displayEmprunt() {
        List<Emprunt> myList = new ArrayList<>();
        try {
            String requete = "SELECT * FROM emprunts";
            
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){
                Emprunt p =new Emprunt();
                p.setId_emprunt(rs.getInt("id_emprunt"));
                p.setId_livre(rs.getInt("id_livre"));
                p.setId_user(rs.getInt("id_user"));
                p.setDate_debut(rs.getDate("date_debut"));
                p.setDate_fin(rs.getDate("date_fin"));
                
                myList.add(p);
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("erreur d'affichage");
        }
        return myList;
    }
     
      public boolean suprrimerEmprunt(Emprunt p, int id_Emprunt) {
        boolean b = false;

        try {
            String requete = "delete from emprunts where id_emprunt=?";
            PreparedStatement std = cnx.prepareStatement(requete);
            std.setInt(1, id_Emprunt);
            std.executeUpdate();

            System.out.println("emprunt supprimer ...");
            b = true;
            int x =p.getId_livre();
            String r = "UPDATE livres set nombreExemplaire =nombreExemplaire+1 where livres.id_livre="+x; 
            PreparedStatement ps = cnx.prepareStatement(r);
             ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("probleme  ...");
        }
        return b;
    }

}
