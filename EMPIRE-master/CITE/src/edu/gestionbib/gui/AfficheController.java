/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestionbib.gui;

import edu.gestionbib.entities.LivreCrud;
import edu.gestionbib.entities.Livres;
import java.awt.Event;
import static java.awt.SystemColor.menu;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import static jdk.nashorn.internal.objects.NativeArray.some;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AfficheController implements Initializable {

    @FXML
    private TableView<Livres> table;
    @FXML
    private TableColumn<Livres, Integer> idlivre;
    @FXML
    private TableColumn<Livres, String> nomlivre;
    @FXML
    private TableColumn<Livres, String> auteur;
    @FXML
    private TableColumn<Livres, String> etat;
    @FXML
    private TableColumn<Livres, String> domaine;
    @FXML
    private TableColumn<Livres, Integer> nbrexemplaire;
    @FXML
    private Button ajouter;
    @FXML
    private Button show;
    @FXML
    private Button update;
    @FXML
    private Button delete;
    @FXML
    private TextField newid;
    @FXML
    private TextField newnom;
    @FXML
    private TextField newauteur;
    @FXML
    private TextField newetat;
    @FXML
    private TextField newdomaine;
    @FXML
    private TextField newnbrexemp;
    @FXML
    private TextField recherche;
    @FXML
    private Button actualiser;
    @FXML
    private Button pdf;
    @FXML
    private Button mp3;
    @FXML
    private Button emrunt;

    /**
     * Initializes the controller class.
     */
    // ObservableList<Livres> datalist = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        LivreCrud ps = new LivreCrud();
        
        
         ArrayList<Livres> perss = (ArrayList<Livres>) ps.displayLiivre();
        ObservableList<Livres> ob = FXCollections.observableArrayList(perss);
         
        
        recherche.textProperty().addListener((observable, oldValue, newValue) -> {
            ArrayList<Livres> per = (ArrayList<Livres>) ps.displayLiivre();
        ObservableList<Livres> datalist = FXCollections.observableArrayList(per);
        ps.displayLiivre();
        FilteredList<Livres> filterdData = new FilteredList<>(datalist, p -> true);
            filterdData.setPredicate((Liv) -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String LowerCaseFilter = newValue.toLowerCase();

                if (Liv.getNom_livre().toLowerCase().contains(LowerCaseFilter)) {
                    return true;

                }  
                    return false;
                

            });
            SortedList<Livres> sortedData = new SortedList<>(filterdData);
            sortedData.comparatorProperty().bind(table.comparatorProperty());
            table.setItems(sortedData);
           
        });
        table.setItems(ob);
         

        ArrayList<Livres> pers = (ArrayList<Livres>) ps.displayLiivre();
        ObservableList<Livres> obs = FXCollections.observableArrayList(pers);
        table.setItems(obs);

        idlivre.setCellValueFactory(new PropertyValueFactory<>("id_livre"));
        nomlivre.setCellValueFactory(new PropertyValueFactory<>("nom_livre"));
        auteur.setCellValueFactory(new PropertyValueFactory<>("auteur_livre"));
        etat.setCellValueFactory(new PropertyValueFactory<>("etat_livre"));
        domaine.setCellValueFactory(new PropertyValueFactory<>("domaine_livre"));
        nbrexemplaire.setCellValueFactory(new PropertyValueFactory<>("nombreExemplaire"));

        idlivre.setSortType(TableColumn.SortType.DESCENDING);
        nomlivre.setSortType(TableColumn.SortType.DESCENDING);

        ajouter.setOnAction(((event) -> {

            if (newnom.getText().isEmpty() || newauteur.getText().isEmpty() || newetat.getText().isEmpty() || newdomaine.getText().isEmpty() || newnbrexemp.getText().isEmpty()) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("il faut remplir tous les champs");
                alert.showAndWait();
            } else if (!newnom.getText().matches("^[a-z A-Z\\\\s]*$") ||!newauteur.getText().matches("^[a-z A-Z\\\\s]*$")||!newetat.getText().matches("^[a-z A-Z\\\\s]*$")||!newdomaine.getText().matches("^[a-z A-Z\\\\s]*$"))
            {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("le nom , l'auteur,l'etat ,le domaine  doivent etre des chaines de characteres");
                alert.showAndWait();
            }else if(!newid.getText().matches("^[0-9\\\\s]*$")||!newnbrexemp.getText().matches("^[0-9\\\\s]*$")){
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("l'id , le nombre d'exemplaire,  doivent etre des nombres");
                alert.showAndWait();
            
            }else {
                Livres p = new Livres(Integer.parseInt(newid.getText()), newnom.getText(), newauteur.getText(),
                        newetat.getText(), newdomaine.getText(), Integer.parseInt(newnbrexemp.getText()));
                ps.ajouterLivres(p);
                ArrayList<Livres> nper = (ArrayList<Livres>) ps.displayLiivre();
                ObservableList<Livres> nobs = FXCollections.observableArrayList(nper);
                table.setItems(nobs);

                idlivre.setCellValueFactory(new PropertyValueFactory<>("id_livre"));
                nomlivre.setCellValueFactory(new PropertyValueFactory<>("nom_livre"));
                auteur.setCellValueFactory(new PropertyValueFactory<>("auteur_livre"));
                etat.setCellValueFactory(new PropertyValueFactory<>("etat_livre"));
                domaine.setCellValueFactory(new PropertyValueFactory<>("domaine_livre"));
                nbrexemplaire.setCellValueFactory(new PropertyValueFactory<>("nombreExemplaire"));
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("livre " + p.getNom_livre() + " ajouteé");
                alert.showAndWait();

            }
        }));
        // TODO

        delete.setOnAction((ActionEvent e) -> {
            //  TableView<Livres> tbl_elev=new TableView<Livres>();
            Livres p = (Livres) table.getSelectionModel().getSelectedItem();
            if (p != null) {
                int a = p.getId_livre();

                ps.suprrimerLivre(a);
                ArrayList<Livres> nper = (ArrayList<Livres>) ps.displayLiivre();
                ObservableList<Livres> nobs = FXCollections.observableArrayList(nper);
                table.setItems(nobs);
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("supprission terminé avec succé!");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("il faut selectinner un livre!");
                alert.showAndWait();
            }

        });

        show.setOnAction(((event) -> {
            Livres p = (Livres) table.getSelectionModel().getSelectedItem();
            if (p != null) {
                newid.setText(String.valueOf(p.getId_livre()));
                newnom.setText(String.valueOf(p.getNom_livre()));
                Mp3Controller.audioNom = null;
                Mp3Controller.audioNom = p.getNom_livre();
                newauteur.setText(String.valueOf(p.getAuteur_livre()));
                newetat.setText(String.valueOf(p.getEtat_livre()));
                newdomaine.setText(String.valueOf(p.getDomaine_livre()));
                newnbrexemp.setText(String.valueOf(p.getNombreExemplaire()));
            } else {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("il faut selectinner un livre!");
                alert.showAndWait();
            }

        }));
        update.setOnAction((ActionEvent e) -> {

            if (newnom.getText().isEmpty() || newauteur.getText().isEmpty() || newetat.getText().isEmpty() || newdomaine.getText().isEmpty() || newnbrexemp.getText().isEmpty()) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("il faut selectionner un livre et remplir tous les champs");
                alert.showAndWait();
            }  else if (!newnom.getText().matches("^[a-z A-Z\\\\s]*$") ||!newauteur.getText().matches("^[a-z A-Z\\\\s]*$")||!newetat.getText().matches("^[a-z A-Z\\\\s]*$")||!newdomaine.getText().matches("^[a-z A-Z\\\\s]*$"))
            {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("le nom , l'auteur,l'etat ,le domaine  doivent etre des chaines de characteres");
                alert.showAndWait();
            }else if(!newid.getText().matches("^[0-9\\\\s]*$")||!newnbrexemp.getText().matches("^[0-9\\\\s]*$")){
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("l'id , le nombre d'exemplaire,  doivent etre des nombres");
                alert.showAndWait();
            
            }
            
            else {

                Livres p = new Livres(Integer.parseInt(newid.getText()), newnom.getText(), newauteur.getText(),
                        newetat.getText(), newdomaine.getText(), Integer.parseInt(newnbrexemp.getText()));

                ps.modifierLivre(p, p.getId_livre());
                pers.clear();
                ArrayList<Livres> nper = (ArrayList<Livres>) ps.displayLiivre();
                ObservableList<Livres> livu = FXCollections.observableArrayList(nper);
                table.setItems(livu);

                idlivre.setCellValueFactory(new PropertyValueFactory<>("id_livre"));
                nomlivre.setCellValueFactory(new PropertyValueFactory<>("nom_livre"));
                auteur.setCellValueFactory(new PropertyValueFactory<>("auteur_livre"));
                etat.setCellValueFactory(new PropertyValueFactory<>("etat_livre"));
                domaine.setCellValueFactory(new PropertyValueFactory<>("domaine_livre"));
                nbrexemplaire.setCellValueFactory(new PropertyValueFactory<>("nombreExemplaire"));
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("livre modifier!");
                alert.showAndWait();

            }
        });

        actualiser.setOnAction((event) -> {
            ArrayList<Livres> nper = (ArrayList<Livres>) ps.displayLiivre();
            ObservableList<Livres> nobs = FXCollections.observableArrayList(nper);
            table.setItems(nobs);
            newid.setText("");
            newnom.setText("");
            newauteur.setText("");
            newetat.setText("");
            newdomaine.setText("");
            newnbrexemp.setText("");

        });
    }

    @FXML
    private void pdf(ActionEvent event) throws IOException {

        Livres p = (Livres) table.getSelectionModel().getSelectedItem();
        String c;
        newnom.setText(String.valueOf(p.getNom_livre()));
        c = newnom.getText();

        Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + "C:\\Users\\Admin\\Documents\\NetBeansProjects\\gestionbibliotheque\\" + c + ".pdf");
         
            
        
    }

    @FXML
    private void mp3(ActionEvent event) {
        {
            try {
                Parent root;

                root = FXMLLoader.load(getClass().getResource("Mp3.fxml"));

                mp3.getScene().setRoot(root);
            } catch (IOException ex) {
                System.out.println("error" + ex.getMessage());
            }

        }
    }

    @FXML
    private void emprunt(ActionEvent event) throws IOException {
        {

            Parent root;

            root = FXMLLoader.load(getClass().getResource("Emprunt.fxml"));

            emrunt.getScene().setRoot(root);

        }
    }

}
