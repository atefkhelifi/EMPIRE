/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.testapplication.gui;

import edu.testapplication.entities.Formation;
import edu.testapplication.entities.FormationCRUD;
import static edu.testapplication.entities.MyConnection.cnx;
import edu.testapplication.entities.User;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
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
 * @author amir
 */
public class UserController implements Initializable {
    @FXML
    private TextField nomformation;
    @FXML
    private Button inscrir;
    @FXML
    private TextField email;
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
    private void insrir(ActionEvent event) {
        FormationCRUD fc =new FormationCRUD();
        User us=new User();
         int i =idform();
         String ch=mailform();
         System.out.println(i+ch);
         String requete ="UPDATE user SET id_formation=? WHERE email=?";
        try {
            PreparedStatement pst =cnx.prepareStatement(requete);
            pst.setInt(1,i);
            
            pst.setString(2, ch);
           
            pst.executeUpdate();
            System.out.println("user changé");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
        public int idform(){
            int id;
            FormationCRUD fc =new FormationCRUD();
        ArrayList<Formation> li=(ArrayList<Formation>) fc.displayFormation();
        for(int i=0;i<li.size();i++){
            if(li.get(i).getNom_formation().equals(nomformation.getText())){
                 id=li.get(i).getId_formation();
                 return id;
            }}
        return 0;
        }
        public String mailform(){
             FormationCRUD fc =new FormationCRUD();
             String mail;
         ArrayList<User> lt=(ArrayList<User>) fc.displayUser();
         
        for(int j=0;j<lt.size();j++){
            if(lt.get(j).getEmail().equals(email.getText())){
                mail=lt.get(j).getEmail();
                return mail;
            }}
        return null;
        }

    @FXML
    private void exit(ActionEvent event) {
         FXMLLoader loader=new FXMLLoader(getClass().getResource("passage.fxml"));
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
               
        
    

