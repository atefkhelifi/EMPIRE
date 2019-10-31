/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestionbib.gui;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class Mp3Controller implements Initializable {

    @FXML
    private MediaView mediaview;
    private Media media;
    private MediaPlayer mediaplayer;
    @FXML
    private Button lecture;
    @FXML
    private Button pause;
    @FXML
    private Slider volume;
    public static String audioNom;
    @FXML
    private Button accueil;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        String path = new File("src/audio/"+audioNom+".mp3").getAbsolutePath();
        media = new Media(new File(path).toURI().toString());
        mediaplayer = new MediaPlayer(media);
        mediaview.setMediaPlayer(mediaplayer);
        volume.setValue(mediaplayer.getVolume()*100);
        volume.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                    mediaplayer.setVolume(volume.getValue()/100);
            }
        });
        
        
        accueil.setOnAction((event) -> {
            Parent root;

            try {
                root = FXMLLoader.load(getClass().getResource("affiche.fxml"));
                accueil.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(EmpruntController.class.getName()).log(Level.SEVERE, null, ex);
            }

                
        });
        // TODO
    }

    @FXML
    private void lecture(ActionEvent event) {
        mediaplayer.play();
    }

    @FXML
    private void pause(ActionEvent event) {
         mediaplayer.pause();
    }

    @FXML
    private void click(MouseEvent event) {
    }
    
   
}
