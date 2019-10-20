/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.events.entities;

import java.util.Date;

/**
 *
 * @author atefk
 */
public class Events {
    
private int id_event;
private String nom_event;
private String localisation_event;
private int prix_event;
private  Date date_event;



    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public String getNom_event() {
        return nom_event;
    }

    public void setNom_event(String nom_event) {
        this.nom_event = nom_event;
    }

    public String getLocalisation_event() {
        return localisation_event;
    }

    public void setLocalisation_event(String localisation_event) {
        this.localisation_event = localisation_event;
    }

    public int getPrix_event() {
        return prix_event;
    }

    public void setPrix_event(int prix_event) {
        this.prix_event = prix_event;
    }

    public Date getDate_event() {
        return date_event;
    }

    public void setDate_event(Date date_event) {
        this.date_event = date_event;
    }

    public Events() {
    }

    public Events(int id_event, String nom_event, String localisation_event, int prix_event, Date date_event) {
        this.id_event = id_event;
        this.nom_event = nom_event;
        this.localisation_event = localisation_event;
        this.prix_event = prix_event;
        this.date_event = date_event;
    }

    public Events(String nom_event, String localisation_event, int prix_event, Date date_event) {
        this.nom_event = nom_event;
        this.localisation_event = localisation_event;
        this.prix_event = prix_event;
        this.date_event = date_event;
    }

    @Override
    public String toString() {
        return "Events{" + "id_event=" + id_event + ", nom_event=" + nom_event + ", localisation_event=" + localisation_event + ", prix_event=" + prix_event + ", date_event=" + date_event + '}';
    }
 
}
