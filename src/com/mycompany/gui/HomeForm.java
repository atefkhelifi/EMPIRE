/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.mycompany.Service.ServiceClub;
import com.mycompany.Entite.Club;

/**
 *
 * @author bhk
 */
public class HomeForm extends Form {

    Form f;
    TextField tnom;
     TextField tdomaine;
    TextField tplaceDisponible;
    Button btnajout,btnaff;

    public HomeForm() {
        f = new Form("Welcome");
        tnom = new TextField("","nom_club");
        tdomaine = new TextField("","domaine_club");
         tplaceDisponible = new TextField("","placeDisponible");
        btnajout = new Button("Ajouter");
        btnaff=new Button("Affichage");
        
        f.add(tnom);
        f.add(tdomaine);
        f.add(tplaceDisponible);
        f.add(btnajout);
        f.add(btnaff);
        
        btnajout.addActionListener((e) -> {
            ServiceClub ser = new ServiceClub();
             if (tnom.getText().isEmpty() || tdomaine.getText().isEmpty() || tplaceDisponible.getText().isEmpty()){
                  Dialog.show("Alert", "remplir les champs", "ok", null);
             }else{
            Club c = new Club(0, tnom.getText(), tdomaine.getText(),Integer.parseInt(tplaceDisponible.getText()));
            
            ser.ajoutClub(c);
            
           Dialog.show("Alert", "club "+" Ajouté", "ok", null);
           
             
            

             }});
        btnaff.addActionListener((e)->{
        Affichage a=new Affichage();
       
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

    public TextField getTdomaine() {
        return tdomaine;
    }

    public void setTdomaine(TextField tdomaine) {
        this.tdomaine = tdomaine;
    }

    public TextField getTplaceDisponible() {
        return tplaceDisponible;
    }

    public void setTplaceDisponible(TextField tplaceDisponible) {
        this.tplaceDisponible = tplaceDisponible;
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
