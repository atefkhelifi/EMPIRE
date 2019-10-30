/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestion_club.tests;

import edu.gestion_club.entities.MyConnection;
import edu.gestion_club.entities.User;
import edu.gestion_club.entities.UserServices;

/**
 *
 * @author Asus
 */
public class UserMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         UserServices us  = new UserServices();
         us.INSCRIT(2, 2);
        
        // TODO code application logic here
    }
    
}
