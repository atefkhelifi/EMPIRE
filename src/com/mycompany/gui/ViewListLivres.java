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
import com.mycompany.Entitie.Livre;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class ViewListLivres extends Form {

    Form form;
    

    public ViewListLivres( ArrayList<Livre> livres) {
        form = new Form("Liste des livres", new BoxLayout(BoxLayout.Y_AXIS));
        for (Livre livre : livres) {
            // ajouter label
            Label livreLabel = new Label("NOM LIVRE: " + livre.getNom_livre());
            livreLabel.addPointerPressedListener(
                    new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    new AfficherLivre(livre).afficher();
                }
            }
            );
            form.add(livreLabel);

        }
        form.getToolbar().addCommandToSideMenu("Home", null, null);
        form.getToolbar().addCommandToSideMenu("Ajouter livre", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                AjoutForm a = new AjoutForm();
                a.getF().show();
            }
        });

    }

    public void afficher() {
        this.form.show();
    }

}
