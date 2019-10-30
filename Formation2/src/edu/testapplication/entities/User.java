/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.testapplication.entities;

/**
 *
 * @author amir
 */
public class User {
     private int id_formation;
     private int id ;
    private String phone_number;
    private String adresse;
    private String user_name;
    private String password;
    private String email;
    
    private int banne;
    public User() {
    }

    public User(int id, String phone_number, String adresse, String user_name, String password, int banne,String email,int id_formation) {
        this.id = id;
        this.phone_number = phone_number;
        this.adresse = adresse;
        this.user_name = user_name;
        this.password = password;
        this.banne = banne;
        this.email=email;
        this.id_formation=id_formation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public int getId_formation() {
        return id_formation;
    }

    public void setId_formation(int id_formation) {
        this.id_formation = id_formation;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBanne() {
        return banne;
    }

    public void setBanne(int banne) {
        this.banne = banne;
    }

    @Override
    public String toString() {
        return "User{" + "id_formation=" + id_formation + ", id=" + id + ", phone_number=" + phone_number + ", adresse=" + adresse + ", user_name=" + user_name + ", password=" + password + ", email=" + email + '}';
    }

   
    
}
