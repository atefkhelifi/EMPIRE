/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import edu.events.entities.Events;
import edu.events.entities.User;
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
public class ListEController implements Initializable {

    @FXML
    private TableView<Events> table;
    @FXML
    private TableColumn<Events,String > colum;
    @FXML
    private Button ret;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        UserEventsService es=new UserEventsService();
        
        //Events p = (Events) table.getSelectionModel().getSelectedItem();
            
               // String.valueOf(p.getId_event());
        ArrayList<Events>evs=(ArrayList<Events>)es.displayEvents(UserEController.idUser);
        System.out.println(UserEController.idUser);
        ObservableList<Events> obs=FXCollections.observableArrayList(evs);
        table.setItems(obs);
        
        colum.setCellValueFactory(new PropertyValueFactory<>("nom_event"));
        
    }    

    @FXML
    private void retourner(ActionEvent event) throws IOException {
     Parent root;
            root=FXMLLoader.load(getClass().getResource("userE.fxml"));
            ret.getScene().setRoot(root);   
    }
    
}
