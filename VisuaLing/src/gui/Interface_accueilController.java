/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author stlau
 */
public class Interface_accueilController implements Initializable {

    @FXML
    private Button boutonNouveau;
    @FXML
    private Button boutonCharger;
    @FXML
    private Button boutonQuitter;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    //test commentaire
    @FXML
    private void boutonNouveauAction(ActionEvent event)throws IOException {
        Parent Interface_choix_mode_parent = FXMLLoader.load (getClass().getResource("Interface_choix_mode.fxml"));
        Scene Interface_choix_mode_scene = new Scene (Interface_choix_mode_parent); 
        Stage window = (Stage) boutonNouveau.getScene().getWindow();
        window.setScene(Interface_choix_mode_scene);
        window.show();
    }

    @FXML
    private void boutonChargerAction(ActionEvent event)throws IOException {
        Parent Interface_liste_complete_enregistrement_parent = FXMLLoader.load (getClass().getResource("Interface_liste_complete_enregistrement.fxml"));
        Scene Interface_liste_complete_enregistrement_scene = new Scene (Interface_liste_complete_enregistrement_parent); 
        Stage window = (Stage) boutonCharger.getScene().getWindow();
        window.setScene(Interface_liste_complete_enregistrement_scene);
        window.show();
    }

    //Quitter la scene
    @FXML
    private void boutonQuitterAction(ActionEvent event) {
        Stage window = (Stage) boutonQuitter.getScene().getWindow();
        window.close();
    }
    
    
    
}
