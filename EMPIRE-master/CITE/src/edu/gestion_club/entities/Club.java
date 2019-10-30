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
public class Club{ 

   
    private int id_club;
    private String nom_club;
    private String domaine_club;
      private int placeDesponible_club;

    public Club(int id_club, String nom_club, String domaine_club, int placeDesponible_club) {
        this.id_club = id_club;
        this.nom_club = nom_club;
        this.domaine_club = domaine_club;
        this.placeDesponible_club = placeDesponible_club;
    }

    public Club(String nom_club, String domaine_club, int placeDesponible_club) {
        this.nom_club = nom_club;
        this.domaine_club = domaine_club;
        this.placeDesponible_club = placeDesponible_club;
    }

   
    public int getId_club() {
        return id_club;
    }

    public void setId_club(int id_club) {
        this.id_club = id_club;
    }

    public String getNom_club() {
        return nom_club;
    }

    public void setNom_club(String nom_club) {
        this.nom_club = nom_club;
    }

    public String getDomaine_club() {
        return domaine_club;
    }

    public void setDomaine_club(String domaine_club) {
        this.domaine_club = domaine_club;
    }

    public int getPlaceDesponible_club() {
        return placeDesponible_club;
    }

    public void setPlaceDesponible_club(int placeDesponible_club) {
        this.placeDesponible_club = placeDesponible_club;
    }

    @Override
    public String toString() {
        return "Club{" + "id_club=" + id_club + ", nom_club=" + nom_club + ", domaine_club=" + domaine_club + ", placeDesponible_club=" + placeDesponible_club + '}';
    }

    public Club() {
    }

    
      

    
}
