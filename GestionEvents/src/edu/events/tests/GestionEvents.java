/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.events.tests;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import edu.events.entities.Events;
import edu.events.entities.EventsServices;
import edu.events.entities.MyConnection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author atefk
 */
public class GestionEvents {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          Date parsedDate = null;

        // TODO code application logic here
                EventsServices myCnx=new EventsServices();
                DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            parsedDate=formatter.parse("2020-01-18 09:30:00");
        } catch (ParseException ex) {
            Logger.getLogger(GestionEvents.class.getName()).log(Level.SEVERE, null, ex);
        }
                Events j=new Events("genie logeciel","s05",15,parsedDate);
                //myCnx.ajouterEvent(j);
                //myCnx.affAll();
                //myCnx.affEvents(23);
                //myCnx.suppEvent(23);
                Events j1=new Events("sport","s03",12,parsedDate);
                //myCnx.modifierEvent(j1, 21);
                myCnx.suppEvent(21);
    }
    

    
}
