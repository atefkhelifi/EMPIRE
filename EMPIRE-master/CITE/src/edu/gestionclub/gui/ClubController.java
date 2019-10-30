/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestionclub.gui;

import edu.gestion_club.entities.Club;
import edu.gestion_club.entities.ClubCrud;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class ClubController implements Initializable {

    @FXML
    private TableColumn<Club, Integer> id_club;
    @FXML
    private TableColumn<Club, String> nom_club;
    @FXML
    private TextField domaine_clubn;
    @FXML
    private TextField placeDesponible_clubn;
    @FXML
    private TableView<Club> table;

    @FXML
    private Button add;
    @FXML
    private Button delete;
    @FXML
    private Button update;

    @FXML
    private TextField nom_clubn;
    @FXML
    private TextField id_clubn;
    @FXML
    private TableColumn<Club, String> domaine_club;
    @FXML
    private TableColumn<Club, Integer> placeDesponible_club;
    @FXML
    private Button search;
    @FXML
    private TextField nomnn;

    @FXML
    private AnchorPane a;
    private Button abonné;
    private Button showvideo;
    @FXML
    private Button showplace;
    @FXML
    private Button consulter;
    public static int idclubisc;
    ClubCrud ce = new ClubCrud();

    ArrayList<Club> per = (ArrayList<Club>) ce.displayclub();

    public void filtredDAta(ArrayList<Club> per) {
        ObservableList<Club> ob = FXCollections.observableArrayList(per);
        table.setItems(ob);

        FilteredList<Club> filteredData = new FilteredList<>(ob, p -> true);
        nomnn.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(club -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (club.getNom_club().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches first name.

                }
                return false; // Does not match.

            });

            SortedList<Club> sortedData = new SortedList<>(filteredData);
            sortedData.comparatorProperty().bind(table.comparatorProperty());
            table.setItems(sortedData);
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.filtredDAta(per);

        ClubCrud cc = new ClubCrud();
        ArrayList<Club> pers = (ArrayList<Club>) cc.displayclub();
        ObservableList<Club> obs = FXCollections.observableArrayList(pers);
        table.setItems(obs);
        id_club.setCellValueFactory(new PropertyValueFactory<>("id_club"));
        nom_club.setCellValueFactory(new PropertyValueFactory<>("nom_club"));
        domaine_club.setCellValueFactory(new PropertyValueFactory<>("domaine_club"));
        placeDesponible_club.setCellValueFactory(new PropertyValueFactory<>("placeDesponible_club"));
        placeDesponible_club.setSortType(TableColumn.SortType.ASCENDING);

        // TODO
        add.setOnAction((ActionEvent e) -> {

            if (nom_clubn.getText().isEmpty() || domaine_clubn.getText().isEmpty() || placeDesponible_clubn.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);

                alert.setTitle("Warnning");
                alert.setHeaderText("Remplir les champs !");
                Optional<ButtonType> result1 = alert.showAndWait();
            } else if (!nom_clubn.getText().matches("^[a-z A-Z\\\\s]*$")) {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Warnning");
                alert.setHeaderText(null);
                alert.setContentText("le nom doit etre une chaine de charactére");
                alert.showAndWait();
            } else if (!domaine_clubn.getText().matches("^[a-z A-Z\\\\s]*$")) {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Warnning");
                alert.setHeaderText(null);
                alert.setContentText("le domaine doit etre une chaine de charactére");
                alert.showAndWait();
            } else if (!placeDesponible_clubn.getText().matches("^[0-9\\\\s]*$")) {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Warnning");
                alert.setHeaderText(null);
                alert.setContentText("le placeDisponible doit etre des numero ");
                alert.showAndWait();
            } else {
                Club c = new Club(Integer.parseInt(id_clubn.getText()), nom_clubn.getText(), domaine_clubn.getText(), Integer.parseInt(placeDesponible_clubn.getText()));

                cc.ajouterclub(c);
                pers.clear();
                ArrayList<Club> nper = (ArrayList<Club>) cc.displayclub();
                ObservableList<Club> nobs = FXCollections.observableArrayList(nper);
                table.setItems(nobs);

                id_club.setCellValueFactory(new PropertyValueFactory<>("id_club"));
                nom_club.setCellValueFactory(new PropertyValueFactory<>("nom_club"));
                domaine_club.setCellValueFactory(new PropertyValueFactory<>("domaine_club"));
                placeDesponible_club.setCellValueFactory(new PropertyValueFactory<>("placeDesponible_club"));

                Alert alert = new Alert(Alert.AlertType.INFORMATION);

                alert.setTitle("WELCOME");
                alert.setHeaderText("ADD DONE !");
                Optional<ButtonType> result1 = alert.showAndWait();
            }

        });
        delete.setOnAction((ActionEvent e) -> {

            Club c = (Club) table.getSelectionModel().getSelectedItem();
            if (c != null) {
                int a = c.getId_club();

                cc.supprimerclub(a);
                ArrayList<Club> nper = (ArrayList<Club>) cc.displayclub();
                ObservableList<Club> nobs = FXCollections.observableArrayList(nper);
                table.setItems(nobs);
                this.per = (ArrayList<Club>) cc.displayclub();
                this.filtredDAta(per);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("CONFIRMATION dELETE");
                alert.setHeaderText("DELETE DONE");
                Optional<ButtonType> result = alert.showAndWait();

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("CONFIRMATION dELETE");
                alert.setHeaderText("Select club");
                Optional<ButtonType> result = alert.showAndWait();

            }

        });

        update.setOnAction((ActionEvent e) -> {
            if (nom_clubn.getText().isEmpty() || domaine_clubn.getText().isEmpty() || placeDesponible_clubn.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);

                alert.setTitle("Warnning");
                alert.setHeaderText("Remplir les champs a modifier !");
                Optional<ButtonType> result1 = alert.showAndWait();
            } else if (!nom_clubn.getText().matches("^[a-z A-Z\\\\s]*$")) {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Warnning");
                alert.setHeaderText(null);
                alert.setContentText("le nom doit etre une chaine de charactére");
                alert.showAndWait();
            } else if (!domaine_clubn.getText().matches("^[a-z A-Z\\\\s]*$")) {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Warnning");
                alert.setHeaderText(null);
                alert.setContentText("le domaine doit etre une chaine de charactére");
                alert.showAndWait();
            } else if (!placeDesponible_clubn.getText().matches("^[0-9\\\\s]*$")) {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Warnning");
                alert.setHeaderText(null);
                alert.setContentText("le placeDisponible doit etre des numero ");
                alert.showAndWait();
            } else {
                Club c = new Club(Integer.parseInt(id_clubn.getText()), nom_clubn.getText(), domaine_clubn.getText(), Integer.parseInt(placeDesponible_clubn.getText()));

                cc.modifierclub(c, c.getId_club());
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("CONFIRMATION update");
                alert.setHeaderText("UPDATING");
                Optional<ButtonType> result = alert.showAndWait();

                pers.clear();
                ArrayList<Club> nper = (ArrayList<Club>) cc.displayclub();
                ObservableList<Club> nobs = FXCollections.observableArrayList(nper);
                table.setItems(nobs);

                id_club.setCellValueFactory(new PropertyValueFactory<>("id_club"));
                nom_club.setCellValueFactory(new PropertyValueFactory<>("nom_club"));
                domaine_club.setCellValueFactory(new PropertyValueFactory<>("domaine_club"));
                placeDesponible_club.setCellValueFactory(new PropertyValueFactory<>("placeDesponible_club"));

            }
        });

    }

    @FXML
    private void click(MouseEvent event) {

        Club c = (Club) table.getSelectionModel().getSelectedItem();
          idclubisc=c.getId_club();
        id_clubn.setText(String.valueOf(c.getId_club()));
        nom_clubn.setText(c.getNom_club());
        domaine_clubn.setText(c.getDomaine_club());
        MediaController.videoName = null;
        MediaController.videoName = c.getNom_club();
        placeDesponible_clubn.setText(String.valueOf(c.getPlaceDesponible_club()));

    }

    private void abonné(ActionEvent event) {
        try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("abonné.fxml"));
            abonné.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ClubController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void showplace(ActionEvent event) {
        try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("graphic.fxml"));
            showplace.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ClubController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void consulter(ActionEvent event) throws IOException {
        try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("abonné.fxml"));
            showplace.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ClubController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
