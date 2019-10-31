/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestionbib.entities;

/**
 *
 * @author Admin
 */
public class User {
    private int id_user;
    private String nom_user;
    private String address_user;
    private int phone_user;

    public User(int id_user, String nom_user, String address_user, int phone_user) {
        this.id_user = id_user;
        this.nom_user = nom_user;
        this.address_user = address_user;
        this.phone_user = phone_user;
    }

    public User(int id_user, String nom_user) {
        this.id_user = id_user;
        this.nom_user = nom_user;
    }

    

    public int getPhone_user() {
        return phone_user;
    }

    public void setPhone_user(int phone_user) {
        this.phone_user = phone_user;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getNom_user() {
        return nom_user;
    }

    public void setNom_user(String nom_user) {
        this.nom_user = nom_user;
    }

    public String getAddress_user() {
        return address_user;
    }

    public void setAddress_user(String address_user) {
        this.address_user = address_user;
    }
    
    
}
