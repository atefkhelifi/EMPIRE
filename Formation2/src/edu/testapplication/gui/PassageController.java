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
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author amir
 */
public class PassageController implements Initializable {
    @FXML
    private Button affiche;
    @FXML
    private Button inscire;
    @FXML
    private TableColumn<Formation, Integer> id_formation;
    @FXML
    private TableColumn<Formation, String> nom_formation;
    @FXML
    private TableColumn<Formation, String> sujet_formation;
    @FXML
    private TableColumn<Formation, String> nom_formateur;
    @FXML
    private TableColumn<Formation, String> nombre_place_formation;
    @FXML
    private TableColumn<Formation, Date> date_formation;
    @FXML
    private TableColumn<Formation, String> localisation;
    @FXML
    private TableView<Formation> table_formation_user;
    @FXML
    private Button acceuil;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void affiche(ActionEvent event) {
         FormationCRUD cc = new FormationCRUD();
        
        ArrayList<Formation> fr = (ArrayList<Formation>) cc.displayFormation();
        ObservableList<Formation> obs = FXCollections.observableArrayList(fr);
        table_formation_user.setItems(obs);
        id_formation.setCellValueFactory(new PropertyValueFactory<>("id_formation"));
        sujet_formation.setCellValueFactory(new PropertyValueFactory<>("sujet_formation"));
        nom_formation.setCellValueFactory(new PropertyValueFactory<>("nom_formation"));
        nom_formateur.setCellValueFactory(new PropertyValueFactory<>("nom_formateur"));
        date_formation.setCellValueFactory(new PropertyValueFactory<>("date_formation"));
        localisation.setCellValueFactory(new PropertyValueFactory<>("salle"));
        nombre_place_formation.setCellValueFactory(new PropertyValueFactory<>("nombre_place_formation"));
    }

    @FXML
    private void inscrire(ActionEvent event) {
         FXMLLoader loader=new FXMLLoader(getClass().getResource("User.fxml"));
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
               
          
           affiche.getScene().setRoot(root);
           
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void acceuil(ActionEvent event) {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("interface.fxml"));
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
               
          
            acceuil.getScene().setRoot(root);
           
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
