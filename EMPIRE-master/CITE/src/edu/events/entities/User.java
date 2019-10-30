/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.events.entities;

/**
 *
 * @author atefk
 */
public class User {
    private int idUser;
    private String nom;
    private String prenom;
    private String email;
    private int num_tel;

    public User(String nom, String prenom, String email, int num_tel) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.num_tel = num_tel;
    }

    public int getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(int num_tel) {
        this.num_tel = num_tel;
    }

    public User(int idUser, String nom, String prenom, String email, int num_tel) {
        this.idUser = idUser;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.num_tel = num_tel;
    }

    public User(String nom, String prenom, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }
    

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public User(int idUser, String nom, String prenom, String email) {
        this.idUser = idUser;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        
    }

   
    
    public User() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserEvent{" + "nom=" + nom + ", prenom=" + prenom + ", email=" + email +  '}';
    }

   

   
    
}
