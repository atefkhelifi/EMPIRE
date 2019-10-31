/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestionbib.gui;

import edu.gestionbib.entities.Emprunt;
import edu.gestionbib.entities.EmpruntCrud;
import edu.gestionbib.entities.Livres;
import edu.gestionbib.entities.MyConnection;
import edu.gestionbib.entities.User;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class EmpruntController implements Initializable {

    @FXML
    private ComboBox<Livres> idlivre;
    @FXML
    private ComboBox<User> iduser;
    @FXML
    private DatePicker datedebut;
    @FXML
    private DatePicker datefin;
    @FXML
    private Button ajouter;

    /**
     * Initializes the controller class.
     */
    MyConnection myc = MyConnection.getInstance();
    Connection cnx = myc.getConnection();

    Livres l = new Livres();
    EmpruntCrud ae = new EmpruntCrud();
    @FXML
    private TableView<Emprunt> table;
    @FXML
    private TableColumn<Emprunt, Integer> livre;
    @FXML
    private TableColumn<Emprunt, Integer> emprunteur;
    @FXML
    private TableColumn<Emprunt, Date> debut;
    @FXML
    private TableColumn<Emprunt, Date> fin;
    @FXML
    private Button supprimer;
    @FXML
    private TableColumn<Emprunt, Integer> idemprunt;
    @FXML
    private Button acceuil;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<Emprunt> npe = (ArrayList<Emprunt>) ae.displayEmprunt();
        ObservableList<Emprunt> nob = FXCollections.observableArrayList(npe);
        table.setItems(nob);
        
        idemprunt.setCellValueFactory(new PropertyValueFactory<>("id_emprunt"));
        livre.setCellValueFactory(new PropertyValueFactory<>("id_livre"));
        emprunteur.setCellValueFactory(new PropertyValueFactory<>("id_user"));
        debut.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
        fin.setCellValueFactory(new PropertyValueFactory<>("date_fin"));

        List<Livres> list = new ArrayList();
        String requete = "select * from livres ";
        PreparedStatement pst;
        try {

            pst = cnx.prepareStatement(requete);
            ResultSet result = pst.executeQuery();
            while (result.next()) {
                int id_livre = result.getInt(1);
                String nom_livre = result.getString(2);
                list.add(new Livres(id_livre, nom_livre));
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmpruntController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObservableList<Livres> li = FXCollections.observableArrayList(list);

        li.addAll(list);

       idlivre.getItems().addAll(list);
        // Set Converter to the ComboBox
       idlivre.setConverter(new LivresConverter());

        List<User> liss = new ArrayList();
        String req = "select * from users ";
        PreparedStatement ps;
        try {
            ps = cnx.prepareStatement(req);
            ResultSet resulte = ps.executeQuery();
            while (resulte.next()) {

                int id_user = resulte.getInt(1);
                String nom_user = resulte.getString(2);
                liss.add(new User(id_user, nom_user));
            }
        } catch (SQLException ex) {
            System.out.println("eroorr "+ex.getMessage());
        }
        ObservableList<User> le = FXCollections.observableArrayList(liss);
        
        le.addAll(liss);

        iduser.getItems().addAll(liss);
        // Set Converter to the ComboBox
        iduser.setConverter(new UserConverter());
        

        ajouter.setOnAction((ActionEvent event) -> {
            java.sql.Date d = java.sql.Date.valueOf(datedebut.getValue());
            java.sql.Date f = java.sql.Date.valueOf(datefin.getValue());
            int id = idlivre.getSelectionModel().getSelectedItem().getId_livre();
           int ide = iduser.getSelectionModel().getSelectedItem().getId_user();
            
         if(d.compareTo(f)>0){
            
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("il faut que la date debut inferieur a date fin!");
                alert.showAndWait();
           
         }else if(LocalDate.now().isAfter(datedebut.getValue())){
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("vous avez saisi une date ancienne !");
                alert.showAndWait();    
             
         }
         else{
            Emprunt p = new Emprunt(id, ide, d, f);
            ae.ajouterEmprunt(p);

            ArrayList<Emprunt> nper = (ArrayList<Emprunt>) ae.displayEmprunt();
            ObservableList<Emprunt> nobs = FXCollections.observableArrayList(nper);
            table.setItems(nobs);

            livre.setCellValueFactory(new PropertyValueFactory<>("id_livre"));
            emprunteur.setCellValueFactory(new PropertyValueFactory<>("id_user"));
            debut.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
            fin.setCellValueFactory(new PropertyValueFactory<>("date_fin"));
            idemprunt.setCellValueFactory(new PropertyValueFactory<>("id_emprunt"));
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Emprunt ajouter avec succé!");
                alert.showAndWait();
         }});

        supprimer.setOnAction((ActionEvent e) -> {
            //  TableView<Livres> tbl_elev=new TableView<Livres>();
            Emprunt p = (Emprunt) table.getSelectionModel().getSelectedItem();
            if (p != null) {
                int a = p.getId_emprunt();

                ae.suprrimerEmprunt(p,a);
                ArrayList<Emprunt> nper = (ArrayList<Emprunt>) ae.displayEmprunt();
                ObservableList<Emprunt> nobs = FXCollections.observableArrayList(nper);
                table.setItems(nobs);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("supprission terminé avec succé!");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("il faut selectinner un emprunt!");
                alert.showAndWait();
            }

        });
        acceuil.setOnAction((event) -> {
            Parent root;

            try {
                root = FXMLLoader.load(getClass().getResource("affiche.fxml"));
                acceuil.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(EmpruntController.class.getName()).log(Level.SEVERE, null, ex);
            }

                
        });

        // TODO
    }

}
