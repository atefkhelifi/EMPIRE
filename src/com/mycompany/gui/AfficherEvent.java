/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.Entite.Events;
import com.mycompany.Service.ServiceTask;

/**
 *
 * @author atefk
 */
public class AfficherEvent {
      Form form;
    Label nom;
    Label localisation;
     Label prix;
    Label place;
    Button delete=new Button("delete");
   
    
    public  AfficherEvent(Events event) {
        form = new Form("Mon event:", new BoxLayout(BoxLayout.Y_AXIS));
        nom = new Label("nom club: "+event.getNom());
      
        localisation = new Label("localisation: " +event.getLocalisation());
        prix = new Label("prix: " + Integer.toString(event.getPrix()));
        place = new Label("placeDesponible: " + Integer.toString(event.getPlaceDispo()));
        form.add(nom);
               form.add(localisation);
                form.add(prix);
       
        form.add(place);
     form.getToolbar().addCommandToRightBar("back", null, (ev)->{Affichage h=new Affichage();
          
          });
              form.add(delete);
              delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
ServiceTask ser = new ServiceTask();
                ser.Supprimer(event.getId());
                Dialog.show("Alert", "Evenement "+event.getNom()+" supprimé", "ok", null);            }

                
    });}

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }
    
    public void afficher() {  
            this.form.show();
    }
}
    

