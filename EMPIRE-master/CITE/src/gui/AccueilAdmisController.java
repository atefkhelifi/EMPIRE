/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author atefk
 */
public class AccueilAdmisController implements Initializable {

    @FXML
    private Button bibliotheque;
    @FXML
    private Button events;
    @FXML
    private Button clubs;
    @FXML
    private Button formation;
    @FXML
    private Button deconnexion;
    @FXML
    private Button comptes;
    @FXML
    private Button actualite;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void bibliotheque(ActionEvent event) {
    }

    @FXML
    private void events(ActionEvent event) throws IOException {
          Parent root;
            root=FXMLLoader.load(getClass().getResource("afficherEvents.fxml"));
            events.getScene().setRoot(root);
    }

    @FXML
    private void clubs(ActionEvent event) {
    }

    @FXML
    private void formation(ActionEvent event) {
    }

    @FXML
    private void deconnexion(ActionEvent event) {
    }

    @FXML
    private void comptes(ActionEvent event) {
    }

    @FXML
    private void actualite(ActionEvent event) {
    }
    
}
