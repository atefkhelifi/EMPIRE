/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.testapplication.entities;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author amir
 */
public class Formation {
    private int id_formation;
    private String sujet_formation;
    private Date date_formation;
    
    private String nombre_place_formation ;
    private String nom_formation;
    private String nom_formateur;
    private String localisation;
    

    public Formation() {
    }

    public Formation(int id_formation, String sujet_formation,Date date_formation,String nombre_place_formation,String nom_formation,String nom_formateur,String localisation) {
        this.id_formation = id_formation;
        this.sujet_formation = sujet_formation;
         this.date_formation = date_formation;
          this.nombre_place_formation = nombre_place_formation;
           this.nom_formation = nom_formation;
            this.nom_formateur = nom_formateur;
             this.localisation = localisation;
    }

    public int getId_formation() {
        return id_formation;
    }

    public void setId_formation(int id_formation) {
        this.id_formation = id_formation;
    }

    public String getSujet_formation() {
        return sujet_formation;
    }

    public void setSujet_formation(String sujet_formation) {
        this.sujet_formation = sujet_formation;
    }

    public Date getDate_formation() {
        return date_formation;
    }

    public void setDate_formation(Date date_formation) {
        this.date_formation = date_formation;
    }

    public String getNombre_place_formation() {
        return nombre_place_formation;
    }

    public void setNombre_place_formation(String nombre_place_formation) {
        this.nombre_place_formation = nombre_place_formation;
    }

    public String getNom_formation() {
        return nom_formation;
    }

    public void setNom_formation(String nom_formation) {
        this.nom_formation = nom_formation;
    }

    public String getNom_formateur() {
        return nom_formateur;
    }

    public void setNom_formateur(String nom_formateur) {
        this.nom_formateur = nom_formateur;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    @Override
    public String toString() {
        return "Formation{" + "id_formation=" + id_formation + ", sujet_formation=" + sujet_formation + ", date_formation=" + date_formation + ", nombre_place_formation=" + nombre_place_formation + ", nom_formation=" + nom_formation + ", nom_formateur=" + nom_formateur + ", localisation=" + localisation + '}';
    }

  

   

   
    }


