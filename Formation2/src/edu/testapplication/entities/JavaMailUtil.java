/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.testapplication.entities;


import java.util.Properties;  

import javax.mail.*;  
import javax.mail.internet.*;  
  
public class JavaMailUtil {
    private String recepient;
    public static void sendMail(String recepient) throws Exception{
        System.out.println("Preparing to send email");
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        
        String myAccountEmail ="akariamir324@gmail.com";
        String password="Amirakari97";
        
        Session session=Session.getInstance(properties, new Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail,password) ; //To change body of generated methods, choose Tools | Templates.
            }
        
        });
                Message message=prepareMessage(session,myAccountEmail,recepient);
                Transport.send(message);
                System.out.println("Message send sucessfully");
            }

    private static Message prepareMessage(Session session, String myAccountEmail, String recepient) {
        try {
            Message message=new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(recepient));
            message.setSubject("Attestation de formation");
            message.setText("Hey there,\n look my email");
            return message;
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;    }

    public String getRecepient() {
        return recepient;
    }

    public void setRecepient(String recepient) {
        this.recepient = recepient;
    }
        
        
    }

