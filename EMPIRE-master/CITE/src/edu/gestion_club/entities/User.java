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
public class User {
    private int id;
    private String nom;
    private String prenom;
      private String adress;
       private int telephone;

    public User() { 
    }

    public User(int id, String nom, String prenom, String adress, int telephone) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adress = adress;
        this.telephone = telephone;
    }

    User(String string, String string0, String string1, int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adress=" + adress + ", telephone=" + telephone + '}';
    }

    public User(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }
       

}