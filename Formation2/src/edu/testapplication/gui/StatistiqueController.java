/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.testapplication.gui;

import edu.testapplication.entities.Formation;
import edu.testapplication.entities.MyConnection;
import static edu.testapplication.entities.MyConnection.cnx;
import edu.testapplication.entities.Participant;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import java.util.Arrays;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.stage.Stage;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
/**
 * FXML Controller class
 *
 * @author amir
 */
public class StatistiqueController implements Initializable {
    @FXML
    private Button eeok;
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
       
       Stage stage=new Stage();
       Formation f=new Formation();
       ArrayList<Participant> lp=displayPart();
       //String requete="Select(nom_formation) from formation"+ "VALUES ('"+f.getId_formation()+"')";
        CategoryAxis xAxis = new CategoryAxis();  
         NumberAxis yAxis = new NumberAxis();
   //   xAxis.setCategories(FXCollections.<String>
    //  observableArrayList(Arrays.asList(requete)));
      xAxis.setLabel("formation");
       
      
      yAxis.setLabel("l'inscrit");
     
      //Creating the Bar chart
      BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis); 
      
        
     // Prepare XYChart.Series objects by setting data       
      XYChart.Series<String, Number> series1 = new XYChart.Series<>();
      series1.setName("le statistique d'inscription des utilisateurs par formation");
      for(int i=0;i<lp.size();i++){
          
      int nbre=lp.get(i).getNbre_participant();
      String nomp=lp.get(i).getNom_formation();
         System.out.println(nbre+"///"+nomp);
      
      series1.getData().add(new XYChart.Data(nomp,nbre));  
      
      
     
              
      //Setting the data to bar chart       
      barChart.getData().add(series1);
        
      //Creating a Group object 
      Group root = new Group(barChart);
        
      //Creating a scene object
      Scene scene = new Scene(root, 600, 400);

      //Setting title to the Stage
      stage.setTitle("Bar Chart");
        
      //Adding scene to the stage
      stage.setScene(scene);
        
      //Displaying the contents of the stage
      stage.show();        
    }}
    public ArrayList<Participant> displayPart(){
    String req="SELECT nom_formation ,count(*) as 'nbre' FROM `formation` JOIN `user` ON formation.id_formation=user.id_formation WHERE 1 GROUP BY nom_formation ";
    ArrayList<Participant> mylist=new ArrayList<Participant>();
    Statement st = null;
       try{
       st =MyConnection.getInstance().cnx.createStatement();
       
           ResultSet rs = st.executeQuery(req);
           
           while(rs.next()){
           Participant pt =new Participant();
           pt.setNom_formation(rs.getString("nom_formation"));
           pt.setNbre_participant(rs.getInt("nbre"));
               System.out.println();
           mylist.add(pt);
           }
       }  
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        catch (NullPointerException ex) {
           ex.printStackTrace();
            System.out.println(st != null ? "AAAAAAAAAAAAAAAAAAAA" : "BBBBBBBBBBBBBBBB");
        }
return mylist;  
    }
    

    @FXML
    private void exit(ActionEvent event) {
           FXMLLoader loader=new FXMLLoader(getClass().getResource("Formation.fxml"));
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
               
          
           exit.getScene().setRoot(root);
           
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    }
    

