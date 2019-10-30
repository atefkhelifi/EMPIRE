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
public class UserServices {

    User u = new User();
    UserClub uc = new UserClub();
    Club c = new Club();

    MyConnection myc = MyConnection.getInstance();
    Connection cnx = myc.getConnection();

    public void INSCRIT(int idc, int idu) {
        String requete = "INSERT INTO userclub(idClub,idUser) VALUES (?,?)";
        String r = "UPDATE club SET placeDesponible_club=placeDesponible_club -1 WHERE id_club=? AND placeDesponible_club -1>0 ";

        {
            try {
                PreparedStatement pst = cnx.prepareStatement(requete);
                PreparedStatement pt = cnx.prepareStatement(r);

                pst.setInt(1, idc);
                pst.setInt(2, idu);
                pt.setInt(1, idc);
                pst.executeUpdate();
                pt.executeUpdate();

                System.out.println("Inscription validé");
            } catch (SQLException ex) {
                System.out.println(ex);
            }

        }
    }

    public List<User> displayUser(int x) {
        String requette = "SELECT * FROM user JOIN userclub ON user.idUser=userclub.idUser AND userclub.idclub=" + x;
        Club c = new Club();
        List<User> list = new ArrayList<>();
        try {

            Statement st = cnx.createStatement();

            ResultSet rs = st.executeQuery(requette);
            while (rs.next()) {
                list.add(new User(rs.getInt("idUser"),rs.getString("nom"), rs.getString("prenom"), rs.getString("adress"), rs.getInt("telephone")));
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;
    }
      public void supprimeruser(int x) {
        try {
            String requete = "DELETE  FROM userclub WHERE id_user=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, x);
            pst.executeUpdate();
            System.out.println("validééééé");
        } catch (SQLException ex) {
            System.out.println("erreur");
        }}}


