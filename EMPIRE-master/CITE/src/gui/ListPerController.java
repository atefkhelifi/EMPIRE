/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import edu.events.entities.Events;
import edu.events.entities.EventsServices;
import edu.events.entities.User;
import edu.events.entities.UserEvent;
import edu.events.entities.UserEventsService;
import java.io.IOException;
import java.net.URL;
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
 * @author atefk
 */
public class ListPerController implements Initializable {

    @FXML
    private TableView<User> table;
    @FXML
    private TableColumn<User, String> nom;
    @FXML
    private TableColumn<User, String> prenom;
    @FXML
    private TableColumn<User, String> mail;
    @FXML
    private Button aff;
    @FXML
    private TableColumn<User, Integer> phone;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        UserEventsService es=new UserEventsService();
        //Events p = (Events) table.getSelectionModel().getSelectedItem();
            
               // String.valueOf(p.getId_event());
        ArrayList<User>evs=(ArrayList<User>)es.displayUser(AfficherEventsController.idE);
        System.out.println(AfficherEventsController.idE);
        
        ObservableList<User> obs=FXCollections.observableArrayList(evs);
        table.setItems(obs);
        
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        mail.setCellValueFactory(new PropertyValueFactory<>("email"));
        phone.setCellValueFactory(new PropertyValueFactory<>("num_tel"));
        
        
    }    

    @FXML
    private void reternto(ActionEvent event) throws IOException {
        Parent root;
            root=FXMLLoader.load(getClass().getResource("afficherEvents.fxml"));
            aff.getScene().setRoot(root);
  
    }
    
}
