/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestionclub.gui;

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
 * @author Asus
 */
public class MediaController implements Initializable {

    @FXML
    private MediaView mediaview;
    private MediaPlayer mediaplayer;
    private Media media;
    @FXML
    private Button pause;

    @FXML
    private Slider volume;
    @FXML
    private Button play;
    public static String videoName;
    @FXML
    private Button Retour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        String path = new File("src/video/" + videoName + ".mp4").getAbsolutePath();
        media = new Media(new File(path).toURI().toString());
        mediaplayer = new MediaPlayer(media);
        mediaview.setMediaPlayer(mediaplayer);
        volume.setValue(mediaplayer.getVolume() * 100);
        volume.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                mediaplayer.setVolume(volume.getValue() / 100);

                // TODO    }    
            }

        });
    }

    @FXML
    private void play(ActionEvent event) {
        mediaplayer.play();
    }

    @FXML
    private void pause(ActionEvent event) {
        mediaplayer.pause();
    }

    private void stop(ActionEvent event) {
        mediaplayer.seek(mediaplayer.getStartTime());
        mediaplayer.stop();
    }

    @FXML
    private void click(MouseEvent event) {
    }

    @FXML
    private void Retour(ActionEvent event) {
        try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("Inscription.fxml"));
            Retour.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ClubController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
