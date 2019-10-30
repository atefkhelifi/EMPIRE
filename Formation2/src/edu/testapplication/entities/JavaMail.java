/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.testapplication.entities;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author amir
 */
public class JavaMail {
    public static void main(String[] args)  {
        try {
            JavaMailUtil.sendMail("akariamir324@gmail.com");
        } catch (Exception ex) {
            Logger.getLogger(JavaMail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
