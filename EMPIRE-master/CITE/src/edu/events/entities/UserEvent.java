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
public class UserEvent {
    private int idUser;
    private int idEvent;
    private int idUE;

    public UserEvent() {
    }

    public UserEvent(int idUser, int idEvent, int idUE) {
        this.idUser = idUser;
        this.idEvent = idEvent;
        this.idUE = idUE;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public int getIdUE() {
        return idUE;
    }

    public void setIdUE(int idUE) {
        this.idUE = idUE;
    }
    


   
    
}
