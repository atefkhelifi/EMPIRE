/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Form;
import com.mycompany.Service.ServiceTask;

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
        ServiceTask serviceTask=new ServiceTask();
         ViewListEvents viewListEvents = new ViewListEvents(serviceTask.getList2());
        viewListEvents.afficher();
        
          f.getToolbar().addCommandToRightBar("back", null, (ev)->{AjoutEvent h=new AjoutEvent();
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
