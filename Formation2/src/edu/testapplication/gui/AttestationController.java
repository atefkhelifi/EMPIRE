/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.testapplication.gui;

import edu.testapplication.entities.JavaMailUtil;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author amir
 */
public class AttestationController implements Initializable {
    @FXML
    private Button aaenvoyer;
    @FXML
    private TextField address;
    @FXML
    private Button exit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void envoyer(ActionEvent event)  {
        try {
            JavaMailUtil mail=new JavaMailUtil();
            mail.sendMail(address.getText());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
      
    }

    @FXML
    private void exit(ActionEvent event) {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("Formation.fxml"));
      //  Formation f=new Formation();
     //  f.setId(Integer.parseInt(fid.getText()));
      //f.setSujet(fsujet.getText());
       
        //f.setDate_formation(Date.valueOf(fdate.getValue()));
        //f.setLocalisation(flocalisation.getText());
        //f.setNom_formateur(fformateur.getText());
        //f.setNom_formation(fformation.getText());
        //f.setNombre_place(fhoraire.getText());
     
        try {
            Parent root =loader.load();
         //   ModifierController modif =loader.getController();
         //  modif.setTtid(""+f.getId());
          // modif.setTtsujet(f.getSujet());
          //  modif.setTtformateur(f.getNom_formateur());
           //  modif.setTtformation(f.getNom_formation());
           //   modif.setTthoraire(f.getDate_formation());
            //   modif.setTtlocalisation(f.getLocalisation());
               
          
           address.getScene().setRoot(root);
           
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
