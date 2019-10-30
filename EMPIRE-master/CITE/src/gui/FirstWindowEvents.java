/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author atefk
 */
public class FirstWindowEvents extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
        
          Parent root=FXMLLoader.load(getClass().getResource("accueil.fxml"));
            
            
            
            Scene scene = new Scene(root);
            
            primaryStage.setTitle("accueil");
            primaryStage.setScene(scene);
            primaryStage.show();
    }/*
  public void second(Stage stage) throws Exception {
        // TODO Auto-generated method stub
         Parent root=FXMLLoader.load(getClass().getResource("mailing.fxml"));
        
        Scene scene = new Scene(root);
        stage.setTitle("Mail");
        stage.setScene(scene);
        stage.show();
         
    }*/
  
     
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
