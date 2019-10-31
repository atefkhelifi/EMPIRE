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
    public void affLivre(String nom ) {
        try {
            String sql = "SELECT * FROM livres where nom_livre= ?";

            PreparedStatement pst = cnx.prepareStatement(sql);
            pst.setString(1, nom);
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
     public List<Livres> displayLiivre() {
        List<Livres> myList = new ArrayList<>();
        try {
            String requete = "SELECT * FROM livres";
            
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){
                Livres p =new Livres();
                p.setId_livre(rs.getInt("id_livre"));
                p.setNom_livre(rs.getString("nom_livre"));
                p.setAuteur_livre(rs.getString("auteur_livre"));
                p.setEtat_livre(rs.getString("etat_livre"));
                p.setDomaine_livre(rs.getString("domaine_livre"));
                p.setNombreExemplaire(rs.getInt("nombreExemplaire"));
                myList.add(p);
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("erreur d'affichage");
        }
        return myList;
    }

    public List<Livres> filtrerLivre(String s) throws SQLException {
        List<Livres> livre = new ArrayList<>();
        String rq = "SELECT * FROM livres where  nom_livre like'"+s+"' ";

        Statement st = cnx.createStatement();
        ResultSet rst = st.executeQuery(rq);

        while (rst.next()) {
            Livres g=new Livres(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getInt(6));
            livre.add(g);
        }

        return livre;
    }
    
}
