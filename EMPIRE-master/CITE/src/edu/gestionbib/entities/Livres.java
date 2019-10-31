/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestionbib.entities;

/**
 *
 * @author ASUS
 */
public class Livres {
    private int id_livre;
    private String nom_livre;
    private String auteur_livre;
    private String etat_livre;
    private String domaine_livre;
    private int nombreExemplaire;

    public Livres(int id_livre, String nom_livre, String auteur_livre, String etat_livre, String domaine_livre, int nombreExemplaire) {
        this.id_livre = id_livre;
        this.nom_livre = nom_livre;
        this.auteur_livre = auteur_livre;
        this.etat_livre = etat_livre;
        this.domaine_livre = domaine_livre;
        this.nombreExemplaire = nombreExemplaire;
    }

    public Livres(String nom_livre, String auteur_livre, String etat_livre, String domaine_livre, int nombreExemplaire) {
        this.nom_livre = nom_livre;
        this.auteur_livre = auteur_livre;
        this.etat_livre = etat_livre;
        this.domaine_livre = domaine_livre;
        this.nombreExemplaire = nombreExemplaire;
    }

    public Livres() {
    }

    public Livres(int id_livre, String nom_livre) {
        this.id_livre = id_livre;
        this.nom_livre = nom_livre;
    }

   

    public int getId_livre() {
        return id_livre;
    }

    public void setId_livre(int id_livre) {
        this.id_livre = id_livre;
    }

    public String getNom_livre() {
        return nom_livre;
    }

    public void setNom_livre(String nom_livre) {
        this.nom_livre = nom_livre;
    }

    public String getAuteur_livre() {
        return auteur_livre;
    }

    public void setAuteur_livre(String auteur_livre) {
        this.auteur_livre = auteur_livre;
    }

    public String getEtat_livre() {
        return etat_livre;
    }

    public void setEtat_livre(String etat_livre) {
        this.etat_livre = etat_livre;
    }

    public String getDomaine_livre() {
        return domaine_livre;
    }

    public void setDomaine_livre(String domaine_livre) {
        this.domaine_livre = domaine_livre;
    }

    public int getNombreExemplaire() {
        return nombreExemplaire;
    }

    public void setNombreExemplaire(int nombreExemplaire) {
        this.nombreExemplaire = nombreExemplaire;
    }

    @Override
    public String toString() {
        return "Livres{" + "id_livre=" + id_livre + ", nom_livre=" + nom_livre + ", auteur_livre=" + auteur_livre + ", etat_livre=" + etat_livre + ", domaine_livre=" + domaine_livre + ", nombreExemplaire=" + nombreExemplaire + '}';
    }
    
    
}
