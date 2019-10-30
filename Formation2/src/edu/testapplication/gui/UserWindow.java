/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.testapplication.gui;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author amir
 */
public class UserWindow extends Application {
    @Override
    public  void start(Stage primaryStage) {
        
        
        try {
            Parent root =
                    FXMLLoader.load(getClass().getResource("passage.fxml"));
            Scene scene = new Scene(root);
            
            primaryStage.setTitle("Hello World!");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
       
        
        } 
    
     public static void main(String args[]){
      launch(args);
   }
}
