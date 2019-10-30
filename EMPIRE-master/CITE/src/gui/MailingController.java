/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import edu.events.entities.Mail;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author atefk
 */
public class MailingController implements Initializable {

    @FXML
    private TextField adress;
    @FXML
    private TextField objet;
    @FXML
    private Button send;
    @FXML
    private TextField message;
    @FXML
    private Button retour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      send.setOnAction((ActionEvent e)->{
            Mail m=new Mail();
            try {
                m.sendMail(adress.getText(),objet.getText() ,message.getText());
            } catch (Exception ex) {
                System.out.println(ex);
            }
        });  
    }    

    @FXML
    private void retourVer(ActionEvent event) throws IOException {
         Parent root;
            root=FXMLLoader.load(getClass().getResource("afficherEvents.fxml"));
            retour.getScene().setRoot(root);
    }
    
}
