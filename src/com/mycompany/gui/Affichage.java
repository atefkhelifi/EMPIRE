/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Form;
import com.mycompany.service.ServiceAjout;


/**
 *
 * @author bhk
 */
public class Affichage {

    Form f;
    SpanLabel lb;
  
    public Affichage() {
                
        f = new Form();
        lb = new SpanLabel("");
        f.add(lb);
        ServiceAjout service=new ServiceAjout();
        ViewListLivres viewListLivres = new ViewListLivres(service.getList2());
        viewListLivres.afficher();
        //lb.setText(service.getList2().toString());
           f.getToolbar().addCommandToRightBar("back", null, (ev)->{AjoutForm h=new AjoutForm();
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
