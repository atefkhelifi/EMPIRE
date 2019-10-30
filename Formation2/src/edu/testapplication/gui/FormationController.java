/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.testapplication.gui;

import edu.testapplication.entities.Formation;
import edu.testapplication.entities.FormationCRUD;
import static edu.testapplication.entities.MyConnection.cnx;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import sun.nio.cs.ext.PCK;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author amir
 */
public class FormationController implements Initializable  {
    @FXML
    private TextField fid;
    @FXML
    private TextField fsujet;
    @FXML
    private DatePicker fdate;
    @FXML
    private TextField fhoraire;
    @FXML
    private Button btnajouter;
    @FXML
    private Button btnmodifier;
    @FXML
    private Button btnsupprimer;
    @FXML
    private Button btnafficher;
   
    @FXML
    private TextField fformateur;
    @FXML
    private TextField fformation;
    @FXML
    private TextField flocalisation;
    @FXML
    private Button fattestation;
    @FXML
    private Button fstatistique;
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
    private void ajouter(ActionEvent event) {
         Formation f = new Formation();
        f.setId_formation(Integer.parseInt(fid.getText()));
        f.setSujet_formation(fsujet.getText());
        f.setDate_formation(Date.valueOf(fdate.getValue()));
        f.setLocalisation(flocalisation.getText());
        f.setNom_formateur(fformateur.getText());
        f.setNom_formation(fformation.getText());
        f.setNombre_place_formation(fhoraire.getText());
        
        FormationCRUD pc = new FormationCRUD();
        pc.ajouterFormation(f);
        
    }

    @FXML
    private void modifier(ActionEvent event) {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("Modifier.fxml"));
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
               
          
           fid.getScene().setRoot(root);
           
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void supprimer(ActionEvent event) {
        Formation f = new Formation();
        f.setId_formation(Integer.parseInt(fid.getText()));
        FormationCRUD pc = new FormationCRUD();
        pc.supprimerFormation (f);
        
    }

    @FXML
    private void afficher(ActionEvent event) {
       FXMLLoader loader=new FXMLLoader(getClass().getResource("Afficher.fxml"));
       try {
            Parent root =loader.load();
            
         //   ModifierController modif =loader.getController();
         //  modif.setTtid(""+f.getId());
          // modif.setTtsujet(f.getSujet());
          //  modif.setTtformateur(f.getNom_formateur());
           //  modif.setTtformation(f.getNom_formation());
           //   modif.setTthoraire(f.getDate_formation());
            //   modif.setTtlocalisation(f.getLocalisation());
               
          
           fid.getScene().setRoot(root);
           
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
     
               
          
          
        
    }

    @FXML
    private void attestation(ActionEvent event) {
          FXMLLoader loader=new FXMLLoader(getClass().getResource("Attestation.fxml"));
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
               
          
           fid.getScene().setRoot(root);
           
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void statistique(ActionEvent event) {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("Statistique.fxml"));
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
               
          
           fid.getScene().setRoot(root);
           
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
               
          
           fid.getScene().setRoot(root);
           
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    
     

    
    
}

    

