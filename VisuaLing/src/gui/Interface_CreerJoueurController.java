/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import domain.equipe.Equipe;
import java.awt.Point;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import javax.xml.bind.DatatypeConverter;



/**
 * FXML Controller class
 *
 * @author stlau
 */
public class Interface_CreerJoueurController implements Initializable {
    
    @FXML private Button boutonAnnuler;
    @FXML private Button boutonAccepter;
    @FXML private ComboBox cbEquipe;
    @FXML private AnchorPane anchorPane;
    @FXML private TextField txtRole;
    @FXML private TextField txtPosition;
    @FXML private TextField txtOrientation;
    
    @FXML private Point t ; 
    
    private Interface_image_par_imageController parentController;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO
    }
    
    public void initialize(Interface_image_par_imageController controller) {
        parentController = controller;
    }
    
    @FXML
    public void boutonAnnulerAction(ActionEvent event) {
          Stage stage = (Stage) boutonAnnuler.getScene().getWindow();
          stage.close();
          //Interface_image_par_imageController.boutonObjectif.setDisable(false);         
    } 
    
    @FXML
    public void boutonAccepterAction(ActionEvent event) throws IOException {
        String equipe = cbEquipe.getSelectionModel().getSelectedItem().toString();
        if(equipe.isEmpty())
        {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Information sur la création de joueur");
            alert.setContentText("Le joueur n'a pas d'équipe assigner ");
;
            alert.showAndWait();
        }
        else
        {
            parentController.setCouleur(equipe);
            Stage window = (Stage) boutonAccepter.getScene().getWindow();
            window.close();
        }
    }
    
    @FXML public void setListeEquipe(List<Equipe> p_listeEquipe) throws UnsupportedEncodingException{
        Iterator<Equipe> iterateur = p_listeEquipe.iterator();
        while(iterateur.hasNext())
        {
            Equipe equipe = iterateur.next();
            String nomEquipe = equipe.getNom();
            cbEquipe.getItems().addAll(nomEquipe);
        } 
    }
}
