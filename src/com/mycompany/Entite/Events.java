/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

import java.util.Date;

/**
 *
 * @author bhk
 */
public class Events {
   private int id;
   private int placeDispo;
   private int prix;
   private String localisation;
   private String nom;
   private Date dt;

    public Events(int placeDispo, int prix, String localisation, String nom, Date dt) {
        this.placeDispo = placeDispo;
        this.prix = prix;
        this.localisation = localisation;
        this.nom = nom;
        this.dt = dt;
    }

    public Events(int id, int placeDispo, int prix, String localisation, String nom, Date dt) {
        this.id = id;
        this.placeDispo = placeDispo;
        this.prix = prix;
        this.localisation = localisation;
        this.nom = nom;
        this.dt = dt;
    }

    public Events() {
    }

    public Events(int id, int placeDispo, int prix, String localisation, String nom) {
        this.id = id;
        this.placeDispo = placeDispo;
        this.prix = prix;
        this.localisation = localisation;
        this.nom = nom;
    }

    public Events(int placeDispo, int prix, String localisation, String nom) {
        this.placeDispo = placeDispo;
        this.prix = prix;
        this.localisation = localisation;
        this.nom = nom;
    }

    public Date getDt() {
        return dt;
    }

    public void setDt(Date dt) {
        this.dt = dt;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlaceDispo() {
        return placeDispo;
    }

    public void setPlaceDispo(int placeDispo) {
        this.placeDispo = placeDispo;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Events{" + "id=" + id + ", placeDispo=" + placeDispo + ", prix=" + prix + ", localisation=" + localisation + ", nom=" + nom + '}';
    }

    public Events(int id, int placeDispo, String localisation) {
        this.id = id;
        this.placeDispo = placeDispo;
        this.localisation = localisation;
    }

    public Events(int id, String localisation, String nom) {
        this.id = id;
        this.localisation = localisation;
        this.nom = nom;
    }
   

    
           
}
