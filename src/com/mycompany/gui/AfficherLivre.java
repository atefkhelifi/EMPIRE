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
import com.mycompany.Entitie.Livre;
import com.mycompany.service.ServiceAjout;

/**
 *
 * @author ASUS
 */
public class AfficherLivre {

    Form form;
    Label nom;
    Label auteur;
    Label etat;
    Label domaine;
    Label nombreExemplaire;
    Button suprimer = new Button("Supprimer");

    public AfficherLivre(Livre livre) {
        form = new Form("Mon livre:", new BoxLayout(BoxLayout.Y_AXIS));
        nom = new Label("NOM : " + livre.getNom_livre());
        auteur = new Label("AUTEUR: " + livre.getAuteur_livre());
        etat = new Label("ETAT : " + livre.getEtat_livre());
        domaine = new Label("DOMAINE : " + livre.getDomaine_livre());
        nombreExemplaire = new Label("NOMBRE EXEMPLAIRE: " + Integer.toString(livre.getNombreExemplaire()));
        form.add(nom);
        form.add(auteur);
        form.add(domaine);
        form.add(etat);
        form.add(nombreExemplaire);
        form.getToolbar().addCommandToRightBar("back", null, (ev) -> {
            Affichage h = new Affichage();

        });

        form.add(suprimer);

        suprimer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                ServiceAjout ser = new ServiceAjout();
                ser.Supprimer(livre.getId_livre());
                Dialog.show("Alert", "livre "+livre.getNom_livre()+" supprimé", "ok", null);

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
