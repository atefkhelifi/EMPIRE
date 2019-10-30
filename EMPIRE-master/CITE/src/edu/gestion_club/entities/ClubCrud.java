/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestion_club.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class ClubCrud {

    MyConnection myc = MyConnection.getInstance();
    Connection cnx = myc.getConnection();

    public void ajouterclub(Club c) {
        String requete = "INSERT INTO club(nom_club,domaine_club,placeDesponible_club) VALUES (?,?,?)";

        {
            try {
                PreparedStatement pst = cnx.prepareStatement(requete);

                pst.setString(1, c.getNom_club());
                pst.setString(2, c.getDomaine_club());
                pst.setInt(3, c.getPlaceDesponible_club());
                pst.executeUpdate();
                System.out.println("club ajouté");
            } catch (SQLException ex) {
                System.out.println("club non ajouté");
            }

        }

    }

    public void modifierclub(Club j, int id_club) {
        try {
            String requete = "UPDATE club SET nom_club=?,domaine_club=?,placeDesponible_club=? WHERE id_club=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, j.getNom_club());
            pst.setString(2, j.getDomaine_club());
            pst.setInt(3, j.getPlaceDesponible_club());
            pst.setInt(4, id_club);
            pst.executeUpdate();
            System.out.println("MODIFIé C'est BON");
        } catch (SQLException ex) {
            System.out.println("erreur");
        }

    }

    public void supprimerclub(int id_club) {
        try {
            String requete = "DELETE  FROM club WHERE id_club=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, id_club);
            pst.executeUpdate();
            System.out.println("validééééé");
        } catch (SQLException ex) {
            System.out.println("erreur");
        }

    }

    public void afficherclub(int id_club) {

        try {
            String sql = "SELECT * FROM club where id_club= ?";

            PreparedStatement pst = cnx.prepareStatement(sql);
            pst.setInt(1, id_club);
            ResultSet result = pst.executeQuery();

            while (result.next()) {
                String nom_club = result.getString(2);
                String domaine_club = result.getString(3);
                int placeDesponible_club = result.getInt(4);

                String output = "User : %s - %s - %d ";
                System.out.println(String.format(output, nom_club, domaine_club, placeDesponible_club));
            }
        } catch (SQLException ex) {
            System.out.println("error");
        }
    }

    /**
     *
     * @return
     */
    public List<Club> displayclub() {

        String sql = "SELECT * FROM club ";
        List<Club> myList = new ArrayList<>();

        try {

            Statement st = cnx.createStatement();

            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
               
                myList.add(new Club(rs.getInt("id_club"), rs.getString("nom_club"), rs.getString("domaine_club"), rs.getInt("placeDesponible_club")));

            }
        } catch (SQLException ex) {
            System.out.println("erreur");
        }

        return myList;
    }

}

    

    
