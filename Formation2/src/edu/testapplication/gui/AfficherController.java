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
public class AfficherController implements Initializable {
    @FXML
    private TableColumn<Formation, String> idcol;
    @FXML
    private TableColumn<Formation, String> sujcol;
    @FXML
    private TableColumn<Formation, String> formationcol;
    @FXML
    private TableColumn<Formation, String> formateurcol;
    @FXML
    private TableColumn<Formation, Date> datecol;
    @FXML
    private TableColumn<Formation, String> localisationcol;
    @FXML
    private TableColumn<Formation, String> placecol;
    @FXML
    private TableView<Formation> table_formation;
    @FXML
    private Button ok;
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
    private void ok(ActionEvent event) {
    
  
         FormationCRUD cc = new FormationCRUD();
        
        ArrayList<Formation> fr = (ArrayList<Formation>) cc.displayFormation();
        ObservableList<Formation> obs = FXCollections.observableArrayList(fr);
        table_formation.setItems(obs);
        idcol.setCellValueFactory(new PropertyValueFactory<>("id_formation"));
        sujcol.setCellValueFactory(new PropertyValueFactory<>("sujet_formation"));
        formationcol.setCellValueFactory(new PropertyValueFactory<>("nom_formation"));
        formateurcol.setCellValueFactory(new PropertyValueFactory<>("nom_formateur"));
        datecol.setCellValueFactory(new PropertyValueFactory<>("date_formation"));
        localisationcol.setCellValueFactory(new PropertyValueFactory<>("salle"));
        placecol.setCellValueFactory(new PropertyValueFactory<>("nombre_place_formation"));
        
    }

    @FXML
    private void exit(ActionEvent event) {
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
               
          
           table_formation.getScene().setRoot(root);
           
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
