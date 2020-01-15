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
import com.mycompany.Entite.Club;
import com.mycompany.Service.ServiceClub;

/**
 *
 * @author Asus
 */
public class AfficherClub {
     Form form;
    Label nom;
    Label domaine;
    Label place;
    Button supprimer =  new Button("supprimer");
   
    
    public  AfficherClub(Club club) {
        form = new Form("Mon club:", new BoxLayout(BoxLayout.Y_AXIS));
        nom = new Label("nom club: "+club.getNom_club());
      
        domaine = new Label("domaine_club: " +club.getDomaine_club());
        place = new Label("placeDesponible: " + Integer.toString(club.getPlaceDesponible_club()));
        form.add(nom);
               form.add(domaine);
       
        form.add(place);
     form.getToolbar().addCommandToRightBar("back", null, (ev)->{Affichage h=new Affichage();
          
          });
              form.add(supprimer);
              supprimer.addActionListener(new ActionListener() {
                   @Override
         public void actionPerformed(ActionEvent evt) {
                ServiceClub ser = new ServiceClub();
                ser.Supprimer(club.getId_club());
                Dialog.show("Alert", "club "+club.getNom_club()+" supprimé", "ok", null);

            }

           
           
        });



    }

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


