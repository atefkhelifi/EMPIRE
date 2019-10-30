/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestionclub.gui;

import edu.gestion_club.entities.Club;
import edu.gestion_club.entities.ClubCrud;
import edu.gestion_club.entities.User;
import edu.gestion_club.entities.UserServices;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class InscriptionController implements Initializable {

    @FXML
    private TableView<Club> tablei;
    @FXML
    private TableColumn<Club, String> nom_club;
    @FXML
    private TableColumn<Club, String> domaine_club;
    @FXML
    private TableColumn<Club, Integer> placeDesponible_club;
    @FXML
    private Button Inscription;
    @FXML
    private Button video;
    @FXML
    private Button Actualise;
    private Button FERMER;
    @FXML
    private Button fermer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Actualise.setOnAction((event) -> {

            ClubCrud cc = new ClubCrud();

            ArrayList<Club> nper = (ArrayList<Club>) cc.displayclub();
            ObservableList<Club> nobs = FXCollections.observableArrayList(nper);
            tablei.setItems(nobs);
            nom_club.setCellValueFactory(new PropertyValueFactory<>("nom_club"));
            domaine_club.setCellValueFactory(new PropertyValueFactory<>("domaine_club"));
            placeDesponible_club.setCellValueFactory(new PropertyValueFactory<>("placeDesponible_club"));

        });

        ClubCrud cc = new ClubCrud();

        ArrayList<Club> pers = (ArrayList<Club>) cc.displayclub();
        ObservableList<Club> obs = FXCollections.observableArrayList(pers);
        tablei.setItems(obs);

        nom_club.setCellValueFactory(new PropertyValueFactory<>("nom_club"));
        domaine_club.setCellValueFactory(new PropertyValueFactory<>("domaine_club"));
        placeDesponible_club.setCellValueFactory(new PropertyValueFactory<>("placeDesponible_club"));

    }

    // TODO
    @FXML
    private void Inscription(ActionEvent event) throws SQLException, IOException {
        UserServices us = new UserServices();
        User user = new User();
        Club c = (Club) tablei.getSelectionModel().getSelectedItem();
        if (c != null) {
            int idc = c.getId_club();

            int idu = user.getId();
            us.INSCRIT(idc, idu);

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

            alert.setTitle("WELCOME");
            alert.setHeaderText("INSCRIPTION DONE !");
            Optional<ButtonType> result1 = alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Warnning");
            alert.setHeaderText("INSCRIPTION FAILED  SELECT YOUR CLUB!");
            Optional<ButtonType> result1 = alert.showAndWait();
        }

    }

    @FXML
    private void video(ActionEvent event) {
       if(tablei.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Warnning");
            alert.setHeaderText("SELECT YOUR CLUB");
            Optional<ButtonType> result1 = alert.showAndWait();}
       else{
            try {
                Parent root;

                root = FXMLLoader.load(getClass().getResource("media.fxml"));

                video.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(ClubController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    @FXML
    private void click1(MouseEvent event) {

        Club c = (Club) tablei.getSelectionModel().getSelectedItem();

        MediaController.videoName = null;
        MediaController.videoName = c.getNom_club();
    }

   
    

    @FXML
    private void fermer(ActionEvent event) {
         Stage stage = (Stage) fermer.getScene().getWindow();
         stage.close();
    }
    }


