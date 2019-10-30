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
public class Participant {
    private int nbre_participant;
     private String nom_formation ;
      
    public Participant() {
    }

    public Participant(int nbre_participant, String nom_formation) {
        this.nbre_participant = nbre_participant;
        this.nom_formation = nom_formation;
    }

    public int getNbre_participant() {
        return nbre_participant;
    }

    public void setNbre_participant(int nbre_participant) {
        this.nbre_participant = nbre_participant;
    }

    public String getNom_formation() {
        return nom_formation;
    }

    public void setNom_formation(String nom_formation) {
        this.nom_formation = nom_formation;
    }

    @Override
    public String toString() {
        return "Participant{" + "nbre_participant=" + nbre_participant + ", nom_formation=" + nom_formation + '}';
    }
    
}
