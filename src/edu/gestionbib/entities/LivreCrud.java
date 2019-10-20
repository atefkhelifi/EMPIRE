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

/**
 *
 * @author ASUS
 */
public class LivreCrud {
    MyConnection myc= MyConnection.getInstance();
    Connection cnx=myc.getConnection();
    
     public void ajouterLivres(Livres l) {
        String requete = "INSERT INTO livres(nom_livre ,auteur_livre, etat_livre, domaine_livre, nombreExemplaire)"
                + "VALUES ('" + l.getNom_livre() + "','" + l.getAuteur_livre() + "','" + l.getEtat_livre() + "','" + l.getDomaine_livre() + "','" + l.getNombreExemplaire() + "')";
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(requete);
            System.out.println("livre ajouter");

        } catch (SQLException ex) {
            System.out.println("erreur d'insertion");
        }

    }

    public void modifierLivre(Livres l, int id_livre) {
        String requete = "UPDATE livres SET nom_livre=? ,auteur_livre=?, etat_livre=?, domaine_livre=?, nombreExemplaire=? WHERE id_livre=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, l.getNom_livre());
            pst.setString(2, l.getAuteur_livre());
            pst.setString(3, l.getEtat_livre());
            pst.setString(4, l.getDomaine_livre());
            pst.setInt(5, l.getNombreExemplaire());

            pst.setInt(6, id_livre);

            pst.executeUpdate();
            System.out.println("livre modifier");
        } catch (SQLException ex) {
            System.out.println("erreur de modification");
        }

    }
    public boolean suprrimerLivre( int id_livre) {
        boolean b = false;

        try {
            String requete = "delete from livres where id_livre=?";
            PreparedStatement std = cnx.prepareStatement(requete);
            std.setInt(1, id_livre);
            std.executeUpdate();

            System.out.println("livre supprimer ...");
            b = true;

        } catch (Exception e) {
            System.out.println("probleme  ...");
        }
        return b;
    }
    public void affLivre(int id_livre ) {
        try {
            String sql = "SELECT * FROM livres where id_livre= ?";

            PreparedStatement pst = cnx.prepareStatement(sql);
            pst.setInt(1, id_livre);
            ResultSet result = pst.executeQuery();

            while (result.next()) {
                int i = result.getInt(1);
                String nom_livre = result.getString(2);
                String auteur_livre = result.getString(3);
                String etat_livre = result.getString(4);
                String domaine_livre = result.getString(5);
                int nombreExemplaire = result.getInt(6);

                String output = "Livre : %d - %s - %s - %s - %s - %d ";
                System.out.println(String.format(output, i, nom_livre, auteur_livre,etat_livre,domaine_livre,nombreExemplaire));
            }
        } catch (SQLException ex) {
            System.out.println("error");
        }

    }

    
}
