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
public class AccueilAdmis1Controller implements Initializable {

    @FXML
    private Button eventsUser;
    @FXML
    private Button clubsUser;
    @FXML
    private Button formationUser;
    @FXML
    private Button deconnexionUser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void eventsUser(ActionEvent event) throws IOException {
        Parent root;
            root=FXMLLoader.load(getClass().getResource("UserE.fxml"));
            eventsUser.getScene().setRoot(root);
    }

    @FXML
    private void clubsUser(ActionEvent event) {
    }

    @FXML
    private void formationUser(ActionEvent event) {
    }

    @FXML
    private void deconnexionUser(ActionEvent event) {
    }
    
}
