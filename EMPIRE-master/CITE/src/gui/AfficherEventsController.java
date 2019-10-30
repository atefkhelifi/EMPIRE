/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import edu.events.entities.ErrorLabel;
import edu.events.entities.Events;
import edu.events.entities.EventsServices;
import edu.events.entities.MyConnection;
import static edu.events.entities.MyConnection.cnx;
import edu.events.entities.QRCodeGenerator;
import edu.events.entities.RequiredField;
import edu.events.entities.UserEvent;
import java.awt.Desktop;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.FileSystems;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static java.time.zone.ZoneRulesProvider.refresh;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import static javafx.scene.input.KeyCode.C;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.util.StringConverter;

/**
 * FXML Controller class
 *
 * @author atefk
 */
public class AfficherEventsController implements Initializable {
public static int idE;


    @FXML
    private TableView<Events> table;
    @FXML
    private TableColumn<Events, Integer> id_event;
    @FXML
    private TableColumn<Events, String> nom_event;
    @FXML
    private Button add;
    @FXML
    private Button delet;
    @FXML
    private TextField id;
    @FXML
    private TextField nom;
    
    @FXML
    private TextField localisation;
    @FXML
    private TextField prix;
    @FXML
    private DatePicker date;
    @FXML
    private Button update;
    @FXML
    private TextField search;
    @FXML
    private Button mail;
    @FXML
    private TableColumn<Events, String> localisation_colum;
    @FXML
    private TableColumn<Events, Integer> prix_colum;
    @FXML
    private TableColumn<Events, Date> date_colum;
    @FXML
    private Label dd;
    @FXML
    private Button refreshi;
    @FXML
    private ImageView img;
    @FXML
    private Button qr;
    @FXML
    private TableColumn<Events, Integer> placedispo_colum;
    @FXML
    private TextField place_dispo;
    @FXML
    private Button consulter;
    @FXML
private  RequiredField requiredField1;
    @FXML 
      private RequiredField requiredField2;
    @FXML 
      private RequiredField requiredField3;
    @FXML 
      private RequiredField requiredField4;
    @FXML 
      private RequiredField requiredField5;
    
    EventsServices es=new EventsServices();
 ArrayList<Events>evs=(ArrayList<Events>)es.displayEvent();
    @FXML
    private Button quit;
 public void filtredData(ArrayList<Events>evs){
        ObservableList<Events> obs=FXCollections.observableArrayList(evs);
 		table.setItems(obs);

 }
 
 
    /**
     * Initializes the controller class.
     */
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
    EventsServices es=new EventsServices();
    Timer timer = new Timer();
timer.schedule(new NewClass(), 0, 5000);
        ArrayList<Events>evs=(ArrayList<Events>)es.displayEvent();
        ObservableList<Events> obs=FXCollections.observableArrayList(evs);
        
        System.out.println("*****");
        
        
        
         // Wrap the ObservableList in a FilteredList (initially display all data).
		
		// 2. Set the filter Predicate whenever the filter changes.
		search.textProperty().addListener((observable, oldValue, newValue) -> {
                    ArrayList<Events>e=(ArrayList<Events>)es.displayEvent();
        ObservableList<Events> ob=FXCollections.observableArrayList(e);
                    es.displayEvent();
                            FilteredList<Events> filteredData = new FilteredList<>(ob, b -> true);

			filteredData.setPredicate(ev-> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (ev.getNom_event().toLowerCase().contains(lowerCaseFilter)  ) {
					return true; // Filter matches first name.
				} 
				       
				    	 return false; // Does not match.
                                         
			});
                        // 3. Wrap the FilteredList in a SortedList. 
		SortedList<Events> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(table.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		table.setItems(sortedData);
                //
		});
		table.setItems(obs);
		
        
        
        System.out.println("*****");
        
        table.setItems(obs);
        
        id_event.setCellValueFactory(new PropertyValueFactory<>("id_event"));
        nom_event.setCellValueFactory(new PropertyValueFactory<>("nom_event"));
        localisation_colum.setCellValueFactory(new PropertyValueFactory<>("localisation_event"));
        prix_colum.setCellValueFactory(new PropertyValueFactory<>("prix_event"));
        date_colum.setCellValueFactory(new PropertyValueFactory<>("date_event"));
        placedispo_colum.setCellValueFactory(new PropertyValueFactory<>("place_dispo"));
        
        
        
   
      /* 
        id_event.setSortType(TableColumn.SortType.DESCENDING);
        nom_event.setSortType(TableColumn.SortType.DESCENDING);
        */
        
    delet.setOnAction((ActionEvent e)->{
        
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete");
            alert.setHeaderText("Look, a Confirmation delete");
            alert.setContentText("Are you ok with this?");
            
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                Events ev=(Events)table.getSelectionModel().getSelectedItem();
                int a=ev.getId_event();
                table.getItems();
                Events ee=es.affichEvent(a);
                obs.remove(ee);
                                es.suppEvent(a);

             //   SortedList<Events> sortedData = new SortedList<>(filteredData);
		
		 ArrayList<Events>evst=(ArrayList<Events>)es.displayEvent();
         table.setItems(obs);
        
        
            } else {
       Events ev=(Events)table.getSelectionModel().getSelectedItem();
               
        id.setText(String.valueOf(ev.getId_event())); 
        nom.setText(String.valueOf(ev.getNom_event()));
        localisation.setText(String.valueOf(ev.getLocalisation_event()));
        prix.setText(String.valueOf(ev.getPrix_event()));
        place_dispo.setText(String.valueOf(ev.getPlace_dispo()));
        date.setValue(null );
        /*LocalDate value = date.getValue();*/
        dd.setText(String.valueOf(ev.getDate_event()));
                
            }
        
 
        
            
    });   
   
    

update.setOnAction((ActionEvent e)->{
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Update");
            alert.setHeaderText("Look, a Confirmation Update");
            alert.setContentText("Are you ok with this?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
        
        java.sql.Date d = java.sql.Date.valueOf(date.getValue());
    
           Events ee=new Events(Integer.parseInt(id.getText()),nom.getText(),localisation.getText(),Integer.parseInt(prix.getText()),d,Integer.parseInt(id.getText()));
        
           
           es.modifierEvent(ee, ee.getId_event());
           evs.clear();
           ArrayList<Events>nper=(ArrayList<Events>)es.displayEvent();
        ObservableList<Events> nobs=FXCollections.observableArrayList(nper);
        table.setItems(nobs);
        
        id_event.setCellValueFactory(new PropertyValueFactory<>("id_event"));
        nom_event.setCellValueFactory(new PropertyValueFactory<>("nom_event"));
        localisation_colum.setCellValueFactory(new PropertyValueFactory<>("localisation_event"));
        prix_colum.setCellValueFactory(new PropertyValueFactory<>("prix_event"));
        date_colum.setCellValueFactory(new PropertyValueFactory<>("date_event"));
        placedispo_colum.setCellValueFactory(new PropertyValueFactory<>("place_dispo"));
        }
        else{Events ev=(Events)table.getSelectionModel().getSelectedItem();
               
        id.setText(String.valueOf(ev.getId_event())); 
        nom.setText(String.valueOf(ev.getNom_event()));
        localisation.setText(String.valueOf(ev.getLocalisation_event()));
        prix.setText(String.valueOf(ev.getPrix_event()));
        place_dispo.setText(String.valueOf(ev.getPlace_dispo()));
        date.setValue(null );
        /*LocalDate value = date.getValue();*/
        dd.setText(String.valueOf(ev.getDate_event()));}
        
        });


   refreshi.setOnAction((event) -> {
            
table.setItems(obs);
        
        
        
            ArrayList<Events>nper=(ArrayList<Events>)es.displayEvent();
            ObservableList<Events> nobs = FXCollections.observableArrayList(nper);
            table.setItems(nobs);
            id.setText("");
            nom.setText("");
            localisation.setText("");
            prix.setText("");
            dd.setText("");
            place_dispo.setText("");
            id_event.setCellValueFactory(new PropertyValueFactory<>("id_event"));
        nom_event.setCellValueFactory(new PropertyValueFactory<>("nom_event"));
        localisation_colum.setCellValueFactory(new PropertyValueFactory<>("localisation_event"));
        prix_colum.setCellValueFactory(new PropertyValueFactory<>("prix_event"));
        date_colum.setCellValueFactory(new PropertyValueFactory<>("date_event"));
        placedispo_colum.setCellValueFactory(new PropertyValueFactory<>("place_dispo"));

        }); 
   
add.setOnAction(((event ) -> {
    
                          
          this.requiredField1.eval();
          this.requiredField2.eval2();
          this.requiredField4.eval();
          this.requiredField3.eval2();

          this.requiredField5.evaldate(date);
          
          if(this.requiredField5.getHasErrors()||this.requiredField1.getHasErrors()||this.requiredField2.getHasErrors()||this.requiredField3.getHasErrors()||this.requiredField4.getHasErrors()){
              if(this.requiredField2.getHasErrors()){
    
                   prix.setStyle("-fx-prompt-text-fill: red;");
                   prix.clear();
                    prix.setPromptText("saisie des chiffre");
              }
             
              
               if(this.requiredField5.getHasErrors()){
    
                   dd.setStyle("-fx-text-fill: red;") ;
                   dd.setText("saisie une date");
              }if(!this.requiredField5.getHasErrors()){
              dd.setText("");
              }
               if(this.requiredField1.getHasErrors()){

                   nom.setStyle("-fx-prompt-text-fill: red;");
                   nom.setText("");
                    nom.setPromptText("ne saisie pas des chiffres");
              }
                if(this.requiredField4.getHasErrors()){
    
                   localisation.setStyle("-fx-prompt-text-fill: red;");
                   localisation.clear();
                    localisation.setPromptText("saisie votre emplacement");
              }  
              if(this.requiredField3.getHasErrors()){
    
                   place_dispo.setStyle("-fx-prompt-text-fill: red;");
                   place_dispo.clear();
                    place_dispo.setPromptText("saisir des chiffres");
              }
              
          }else
          {

              java.sql.Date d = java.sql.Date.valueOf(date.getValue());  
Events e = new Events(/*Integer.parseInt(id.getText()),*/ nom.getText(), localisation.getText(),
                    Integer.parseInt(prix.getText()), d,Integer.parseInt(place_dispo.getText()));
       this.QCcode(e);

                es.ajouterEvent(e);
          }


            ArrayList<Events> nper = (ArrayList<Events>) es.displayEvent();
            ObservableList<Events> nobs = FXCollections.observableArrayList(nper);
            table.setItems(nobs);
 id_event.setCellValueFactory(new PropertyValueFactory<>("id_event"));
            nom_event.setCellValueFactory(new PropertyValueFactory<>("nom_event"));
            localisation_colum.setCellValueFactory(new PropertyValueFactory<>("localisation_event"));
            prix_colum.setCellValueFactory(new PropertyValueFactory<>("prix_event"));
           date_colum.setCellValueFactory(new PropertyValueFactory<>("date_event"));
            placedispo_colum.setCellValueFactory(new PropertyValueFactory<>("place_dispo"));
            
            
       
}));
        qr.setOnAction((ActionEvent e)->{
        Image image = new Image("src/img/bbb.jpg") ;
        img.setImage(image);
        });
        
 
    }

    public void QCcode(Events e){
   try {
            QRCodeGenerator kk=new QRCodeGenerator();
            
            kk.generateQRCodeImage("event "+e.getNom_event()+" créer a la date"+e.getDate_event()+"!" ,255,255,"src/img/bbb.jpg");
        } catch (WriterException ex) {
            Logger.getLogger(AfficherEventsController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AfficherEventsController.class.getName()).log(Level.SEVERE, null, ex);
        }}
    @FXML
    private void onMouseClick(MouseEvent event) {
         Events e=(Events) table.getSelectionModel().getSelectedItem();
            idE=e.getId_event();
            
        id.setText(String.valueOf(e.getId_event())); 
        nom.setText(String.valueOf(e.getNom_event()));
        localisation.setText(String.valueOf(e.getLocalisation_event()));
        prix.setText(String.valueOf(e.getPrix_event()));
        place_dispo.setText(String.valueOf(e.getPlace_dispo()));
        date.setValue(null );
        /*LocalDate value = date.getValue();*/
        dd.setText(String.valueOf(e.getDate_event()));
    }

    @FXML
    private void keyBoardClick(KeyEvent event) {
        Events e=(Events) table.getSelectionModel().getSelectedItem();
            

        id.setText(String.valueOf(e.getId_event())); 
        nom.setText(String.valueOf(e.getNom_event()));
        localisation.setText(String.valueOf(e.getLocalisation_event()));
        prix.setText(String.valueOf(e.getPrix_event()));
        place_dispo.setText(String.valueOf(e.getPlace_dispo()));
        date.setValue(null );
        
        
    }

    @FXML
    private void mailing(ActionEvent event) throws IOException {
        Parent root;
            root=FXMLLoader.load(getClass().getResource("mailing.fxml"));
            mail.getScene().setRoot(root);
    }

    @FXML
    private void consulter(ActionEvent event) throws IOException {
        
               
                        

if(table.getSelectionModel().isEmpty()){
 Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Confirmation ");
            alert.setHeaderText("select champ");
            alert.setContentText("choose Event");
                    Optional<ButtonType> result = alert.showAndWait();
                           Parent root;
 
                     root=FXMLLoader.load(getClass().getResource("afficherEvents.fxml"));
            consulter.getScene().setRoot(root);
}
        
        
        Parent root;
                
        FXMLLoader loader = new FXMLLoader(
    getClass().getResource(
        "listPer.fxml"
    )
);
            root=FXMLLoader.load(getClass().getResource("listPer.fxml"));
            consulter.getScene().setRoot(root);
    }

    @FXML
    private void place_saisie(ActionEvent event) {
        
    }

    @FXML
    private void quit(ActionEvent event) throws IOException {
     Parent root;
 
                     root=FXMLLoader.load(getClass().getResource("accueil.fxml"));
            quit.getScene().setRoot(root);
    }

   

    
    private static class NewClass extends TimerTask {
 public void run() {
     try {
         String   requet="delete from events WHERE date_event < DATE(NOW())";
         PreparedStatement pst = cnx.prepareStatement(requet); 
         pst.executeUpdate();
        // System.out.println("hi");
     } catch (SQLException ex) {
         Logger.getLogger(AfficherEventsController.class.getName()).log(Level.SEVERE, null, ex);
     }
 }
        public NewClass() {
        }
    }

   
    

}


