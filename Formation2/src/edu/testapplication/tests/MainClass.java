/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.testapplication.tests;

import edu.testapplication.entities.Formation;
import edu.testapplication.entities.FormationCRUD;
import edu.testapplication.entities.MyConnection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author House
 */
public class MainClass {
    public static void main(String[] args) {
       FormationCRUD pcrud = new FormationCRUD();
         Formation f;
         final DateFormat df =new SimpleDateFormat("yyyyMMdd");
         Date d;
        try {
            d=df.parse("2019-01-15");
        
        f = new Formation(2, "stage",d,"aaaaaa","22","JHG","bardo");
        } catch (ParseException ex) {
            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
