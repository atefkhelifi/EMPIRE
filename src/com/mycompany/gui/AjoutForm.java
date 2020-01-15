/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.mycompany.Entitie.Livre;
import com.mycompany.service.ServiceAjout;

/**
 *
 * @author ASUS
 */
public class AjoutForm extends Form {

    Form f;
    TextField tnom;
    TextField tauteur;
    TextField tetat;
    TextField tdomaine;
    TextField tnbrexemplaire;
    Button btnajout, btnaff;

    public AjoutForm() {
        f = new Form("home");
        tnom = new TextField("", "nom_livre");
        tauteur = new TextField("", "auteur_livre");
        tetat = new TextField("", "état_livre");
        tdomaine = new TextField("", "domaine_livre");
        tnbrexemplaire = new TextField("", "nombreExemplaire", 20, TextArea.NUMERIC);
        btnajout = new Button("ajouter");
        btnaff = new Button("Affichage");

        f.add(tnom);
        f.add(tauteur);
        f.add(tetat);
        f.add(tdomaine);
        f.add(tnbrexemplaire);
        f.add(btnajout);
        f.add(btnaff);

        btnajout.addActionListener((e) -> {
            ServiceAjout ser = new ServiceAjout();
            if (tnom.getText().isEmpty() || tauteur.getText().isEmpty() || tetat.getText().isEmpty() || tdomaine.getText().isEmpty() || tnbrexemplaire.getText().isEmpty()) {
                Dialog.show("Alert", "il faut remplir tout les champs", "ok", null);

            } /*else if (!tnom.getText().matches("^[a-z A-Z\\\\s]*$") || !tauteur.getText().matches("^[a-z A-Z\\\\s]*$") || !tetat.getText().matches("^[a-z A-Z\\\\s]*$") || !tdomaine.getText().matches("^[a-z A-Z\\\\s]*$")) {
                Dialog.show("Alert", "le nom ,  l'auteur   l'etat et le doamine sont des chaines de caractéres", "ok", null);

            } else if (!tnbrexemplaire.getText().matches("^[0-9\\\\s]*$")) {
                Dialog.show("Alert", "le nombre d'exemplaire est un nombre", "ok", null);

            } */ else {
                Livre t = new Livre(0, tnom.getText(), tauteur.getText(), tetat.getText(), tdomaine.getText(), Integer.parseInt(tnbrexemplaire.getText()));
                ser.ajoutLivre(t);
                Dialog.show("Alert", "livre "+t.getNom_livre()+"ajouté avec succé", "ok", null);

            }
        });

        btnaff.addActionListener((e) -> {
            Affichage a = new Affichage();

        });
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public TextField getTnom() {
        return tnom;
    }

    public void setTnom(TextField tnom) {
        this.tnom = tnom;
    }

    public TextField getTauteur() {
        return tauteur;
    }

    public void setTauteur(TextField tauteur) {
        this.tauteur = tauteur;
    }

    public TextField getTetat() {
        return tetat;
    }

    public void setTetat(TextField tetat) {
        this.tetat = tetat;
    }

    public TextField getTdomaine() {
        return tdomaine;
    }

    public void setTdomaine(TextField tdomaine) {
        this.tdomaine = tdomaine;
    }

    public TextField getTnbrexemplaire() {
        return tnbrexemplaire;
    }

    public void setTnbrexemplaire(TextField tnbrexemplaire) {
        this.tnbrexemplaire = tnbrexemplaire;
    }

    public Button getBtnajout() {
        return btnajout;
    }

    public void setBtnajout(Button btnajout) {
        this.btnajout = btnajout;
    }

    public Button getBtnaff() {
        return btnaff;
    }

    public void setBtnaff(Button btnaff) {
        this.btnaff = btnaff;
    }

}
