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
import com.mycompany.Entite.Club;
import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class ViewListClub  {
     Form form;
    public ViewListClub(ArrayList<Club> clubs) {
      
        form = new Form("Liste des clubs", new BoxLayout(BoxLayout.Y_AXIS));
         
        for (Club club: clubs) {
            // ajouter label
            Label clubLabel = new Label("nom_club: "+club.getNom_club());
            clubLabel.addPointerPressedListener(
                    new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    new AfficherClub(club).afficher();
                }
            }
            );
            
            form.add(clubLabel);
            HomeForm b=new HomeForm();
             form.getToolbar().addCommandToRightBar("back", null, e->b.getF().show());
          
          
         
            
        }
         }
    
    public void afficher() {
        this.form.show();
    }
    
}

    
