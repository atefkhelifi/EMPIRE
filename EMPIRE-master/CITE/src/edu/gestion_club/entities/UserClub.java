/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestion_club.entities;

/**
 *
 * @author Asus
 */
public class UserClub{ 
        private int idUser;
       private int idClub;
       private int idUc;

    public UserClub() {
    }

    public UserClub(int idUser, int idClub, int idUc) {
        this.idUser = idUser;
        this.idClub = idClub;
        this.idUc = idUc;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdClub() {
        return idClub;
    }

    public void setIdClub(int idClub) {
        this.idClub = idClub;
    }

    public int getIdUc() {
        return idUc;
    }

    public void setIdUc(int idUc) {
        this.idUc = idUc;
    }
    
}
