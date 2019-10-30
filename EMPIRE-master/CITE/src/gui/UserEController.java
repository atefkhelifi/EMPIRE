/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.sun.deploy.uitoolkit.impl.fx.ui.FXUIFactory;
import edu.events.entities.Events;
import edu.events.entities.EventsServices;
import edu.events.entities.UEServices;
import edu.events.entities.User;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author atefk
 */
public class UserEController implements Initializable {
public static int idUser;
    @FXML
    private TableColumn<Events, String> event_colum;
    @FXML
    private TableColumn<Events, String> localisation_event;
    @FXML
    private TableColumn<Events, Integer> prix_colum;
    @FXML
    private TableColumn<Events, Date> date_colum;
    @FXML
    private Button inscription;
    @FXML
    private TableView<Events> table;
    @FXML
    private TextField event;
    @FXML
    private TableColumn<Events, Integer> place_colum;
    @FXML
    private Button consulterListEvent;
    @FXML
    private Button ref;
    @FXML
    private Button quit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ref.setOnAction((event) -> {
            
        UEServices us=new UEServices();

        
        
        
            ArrayList<Events>nper=(ArrayList<Events>)us.displayEvent1();
            ObservableList<Events> nobs = FXCollections.observableArrayList(nper);
            table.setItems(nobs);
            event_colum.setCellValueFactory(new PropertyValueFactory<>("nom_event"));
        localisation_event.setCellValueFactory(new PropertyValueFactory<>("localisation_event"));
        prix_colum.setCellValueFactory(new PropertyValueFactory<>("prix_event"));
        date_colum.setCellValueFactory(new PropertyValueFactory<>("date_event"));
        place_colum.setCellValueFactory(new PropertyValueFactory<>("place_dispo"));

        }); 
        
        // TODO
        UEServices us=new UEServices();
        ArrayList<Events>evs=(ArrayList<Events>)us.displayEvent1();
        ObservableList<Events> obs=FXCollections.observableArrayList(evs);
        table.setItems(obs);
        
        event_colum.setCellValueFactory(new PropertyValueFactory<>("nom_event"));
        localisation_event.setCellValueFactory(new PropertyValueFactory<>("localisation_event"));
        prix_colum.setCellValueFactory(new PropertyValueFactory<>("prix_event"));
        date_colum.setCellValueFactory(new PropertyValueFactory<>("date_event"));
        place_colum.setCellValueFactory(new PropertyValueFactory<>("place_dispo"));
        
       
        
        event_colum.setSortType(TableColumn.SortType.DESCENDING);
        
    }    

    @FXML
    private void iscription(ActionEvent ev) throws IOException {
        Events c=new Events();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Confirmation Inscription");
            alert.setHeaderText("Look, Inscription");
            alert.setContentText("You are now in");
                    Optional<ButtonType> result = alert.showAndWait();

                UEServices us=new UEServices();
                User user=new User();
                Events event =(Events) table.getSelectionModel().getSelectedItem();
               int e= event.getId_event() ; 
               //7amma
      int u = user.getIdUser();
            us.iscEvent(u, e);
    
    }

    @FXML
    private void show(MouseEvent a) {
         Events e=(Events) table.getSelectionModel().getSelectedItem();
        event.setText(String.valueOf(e.getNom_event()));

    }

    @FXML
    private void Consulter_event(ActionEvent event) throws IOException {
        
        
        
        Parent root;
                
        FXMLLoader loader = new FXMLLoader(
    getClass().getResource(
        "listE.fxml"
    )
);
            root=FXMLLoader.load(getClass().getResource("listE.fxml"));
            consulterListEvent.getScene().setRoot(root);
    }

    @FXML
    private void quit(ActionEvent event) throws IOException {
         Parent root;
 
                     root=FXMLLoader.load(getClass().getResource("accueil_1.fxml"));
            quit.getScene().setRoot(root);
    }

    
    
}
