/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Form;
import com.mycompany.Service.ServiceClub;

/**
 *
 * @author bhk
 */
public class Affichage {

    Form f;
    SpanLabel lb;//retour a la ligne
  
    public Affichage() {
        
        f = new Form();
        lb = new SpanLabel("");
        f.add(lb);
        ServiceClub serviceClub=new ServiceClub();
          ViewListClub viewListClub = new ViewListClub(serviceClub.getList2());
        viewListClub.afficher();
       // lb.setText(serviceClub.getList2().toString());
        
          f.getToolbar().addCommandToRightBar("back", null, (ev)->{HomeForm h=new HomeForm();
          h.getF().show();
          });
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

}
