/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestionbib.entities;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class Emprunt {
    private int id_emprunt;
    private int id_livre;
    private int id_user;
    private Date date_debut;
    private Date date_fin;

    public Emprunt(int id_livre, int id_user, Date date_debut, Date date_fin) {
        this.id_livre = id_livre;
        this.id_user = id_user;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }

    public int getId_emprunt() {
        return id_emprunt;
    }

    public void setId_emprunt(int id_emprunt) {
        this.id_emprunt = id_emprunt;
    }

    public int getId_livre() {
        return id_livre;
    }

    public void setId_livre(int id_livre) {
        this.id_livre = id_livre;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public Emprunt() {
    }

    public Emprunt(int id_emprunt, int id_livre, int id_user, Date date_debut, Date date_fin) {
        this.id_emprunt = id_emprunt;
        this.id_livre = id_livre;
        this.id_user = id_user;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }

    @Override
    public String toString() {
        return "Emprunt{" + "id_emprunt=" + id_emprunt + ", id_livre=" + id_livre + ", id_user=" + id_user + ", date_debut=" + date_debut + ", date_fin=" + date_fin + '}';
    }
    
    
    
}
