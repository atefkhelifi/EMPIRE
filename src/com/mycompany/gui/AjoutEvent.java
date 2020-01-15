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
import com.codename1.ui.spinner.Picker;
import com.mycompany.Entite.Events;
import com.mycompany.Service.ServiceTask;

/**
 *
 * @author atefk
 */
public class AjoutEvent {
    Form f;
    TextField tnom;
    TextField tlocalisation;
    TextField tprix;
    TextField tplaceDispo;
    Button btnajout, btnaff;
    public AjoutEvent() {
     f = new Form("home");
        tnom = new TextField("", "Nom");
        tlocalisation = new TextField("", "Localisation");
        tprix = new TextField("", "Prix");
        tplaceDispo = new TextField("", "Place_dispo");
       // Picker p = new Picker();
        
        
        btnajout = new Button("ajouter");
        btnaff = new Button("Affichage");

        f.add(tnom);
        f.add(tprix);
        f.add(tlocalisation);
        f.add(tplaceDispo);
        //f.add(p);
        f.add(btnajout);
        f.add(btnaff);
    
         btnajout.addActionListener((e) -> {
             ServiceTask ser = new ServiceTask();
             if (tnom.getText().isEmpty() || tprix.getText().isEmpty() || tplaceDispo.getText().isEmpty()||tlocalisation.getText().isEmpty()){
                  Dialog.show("Alert", "remplir les champs", "ok", null);
             }else{
            Events  t= new Events(Integer.parseInt(tplaceDispo.getText()),Integer.parseInt(tprix.getText()), tlocalisation.getText(), tnom.getText());
            ser.ajoutTask(t);
             Dialog.show("Alert", "Evenement "+" Ajouté", "ok", null);   
             }
         });
         
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

    public TextField getTlocalisation() {
        return tlocalisation;
    }

    public void setTlocalisation(TextField tlocalisation) {
        this.tlocalisation = tlocalisation;
    }

    public TextField getTprix() {
        return tprix;
    }

    public void setTprix(TextField tprix) {
        this.tprix = tprix;
    }

    public TextField getTplaceDispo() {
        return tplaceDispo;
    }

    public void setTplaceDispo(TextField tplaceDispo) {
        this.tplaceDispo = tplaceDispo;
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
