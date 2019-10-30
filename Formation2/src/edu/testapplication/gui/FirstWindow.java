/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.testapplication.gui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;








import java.util.Arrays;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.stage.Stage;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/**
 *
 * @author House
 */
public class FirstWindow extends Application {
    
    @Override
    public  void start(Stage primaryStage) {
        
        
        try {
            Parent root =
                    FXMLLoader.load(getClass().getResource("interface.fxml"));
            Scene scene = new Scene(root);
            
            primaryStage.setTitle("welcome");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
       
        
        } 
    
    /**
     * @param args the command line arguments
     */
    
    
    /**
    @Override
   public void start(Stage stage) {    
      //Defining the axes              
      CategoryAxis xAxis = new CategoryAxis();  
      xAxis.setCategories(FXCollections.<String>
      observableArrayList(Arrays.asList("Speed", "User rating", "Milage", "Safety")));
      xAxis.setLabel("category");
       
      NumberAxis yAxis = new NumberAxis();
      yAxis.setLabel("score");
     
      //Creating the Bar chart
      BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis); 
      barChart.setTitle("Comparison between various cars");
        
      //Prepare XYChart.Series objects by setting data       
      XYChart.Series<String, Number> series1 = new XYChart.Series<>();
      series1.setName("Fiat");
      series1.getData().add(new XYChart.Data<>("Speed", 1.0));
      series1.getData().add(new XYChart.Data<>("User rating", 3.0));
      series1.getData().add(new XYChart.Data<>("Milage", 5.0));
      series1.getData().add(new XYChart.Data<>("Safety", 5.0));
        
      XYChart.Series<String, Number> series2 = new XYChart.Series<>();
      series2.setName("Audi");
      series2.getData().add(new XYChart.Data<>("Speed", 5.0));
      series2.getData().add(new XYChart.Data<>("User rating", 6.0));
      series2.getData().add(new XYChart.Data<>("Milage", 10.0));
      series2.getData().add(new XYChart.Data<>("Safety", 4.0));

      XYChart.Series<String, Number> series3 = new XYChart.Series<>();
      series3.setName("Ford");
      series3.getData().add(new XYChart.Data<>("Speed", 4.0));
      series3.getData().add(new XYChart.Data<>("User rating", 2.0));
      series3.getData().add(new XYChart.Data<>("Milage", 3.0));
      series3.getData().add(new XYChart.Data<>("Safety", 6.0));
              
      //Setting the data to bar chart       
      barChart.getData().addAll(series1, series2, series3);
        
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
   } */
   
     public static void main(String args[]){
      launch(args);
   }
}
