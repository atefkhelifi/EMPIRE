/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.testapplication.gui;

import edu.testapplication.entities.Formation;
import edu.testapplication.entities.FormationCRUD;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author amir
 */
public class ModifierController implements Initializable {
    @FXML
    private TextField ttid;
    @FXML
    private Button ttpasser;
    
    @FXML
    private TextField ttsujet;
    @FXML
    private DatePicker ttdate;
    
    @FXML
    private TextField ttformation;
    @FXML
    private TextField ttformateur;
    @FXML
    private TextField ttplace;
    @FXML
    private TextField ttlocalisation;
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
    private void passer(ActionEvent event) {
        Formation f = new Formation();
        f.setId_formation(Integer.parseInt(ttid.getText()));
        f.setSujet_formation(ttsujet.getText());
        f.setDate_formation(Date.valueOf(ttdate.getValue()));
        f.setLocalisation(ttlocalisation.getText());
        f.setNom_formateur(ttformateur.getText());
        f.setNom_formation(ttformation.getText());
        f.setNombre_place_formation(ttplace.getText());
        FormationCRUD pc = new FormationCRUD();
        pc.modifierFormation(f, (Integer.parseInt(ttid.getText())));
    }

    public void setTtid(TextField ttid) {
        this.ttid = ttid;
    }

    public void setTtpasser(Button ttpasser) {
        this.ttpasser = ttpasser;
    }

   

    public void setTtsujet(TextField ttsujet) {
        this.ttsujet = ttsujet;
    }

    public void setTtdate(DatePicker ttdate) {
        this.ttdate = ttdate;
    }

    

   

    public void setTtformation(TextField ttformation) {
        this.ttformation = ttformation;
    }

    public void setTtformateur(TextField ttformateur) {
        this.ttformateur = ttformateur;
    }

    public void setTtplace(TextField ttplace) {
        this.ttplace = ttplace;
    }

    public void setTtlocalisation(TextField ttlocalisation) {
        this.ttlocalisation = ttlocalisation;
    }

    @FXML
    private void retour(ActionEvent event) {
         FXMLLoader loader=new FXMLLoader(getClass().getResource("formation.fxml"));
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
               
          
           ttid.getScene().setRoot(root);
           
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
