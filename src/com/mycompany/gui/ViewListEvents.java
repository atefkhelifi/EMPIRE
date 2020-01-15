/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.Entite.Events;
import java.util.ArrayList;

/**
 *
 * @author atefk
 */
public class ViewListEvents {
     Form form;
     
    public ViewListEvents(ArrayList<Events> events) {
        form = new Form("Liste des events", new BoxLayout(BoxLayout.Y_AXIS));
         form.getToolbar().addCommandToLeftSideMenu("logout", null, null);
          form.getToolbar().addCommandToLeftSideMenu("AjouterEvent", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                  AjoutEvent a=new AjoutEvent();
                  a.getF().show();            }
        });
        for (Events event : events) {
            // ajouter label
            Label eventLabel = new Label("Event: "+event.getNom());
            eventLabel.addPointerPressedListener(
                    new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    new AfficherEvent(event).afficher();
                }
            
                    
                    } );
            form.add(eventLabel);
         
            
        }
    }
    
    public void afficher() {
        this.form.show();
    }
    
}

    

