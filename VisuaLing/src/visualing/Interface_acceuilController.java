/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualing;

import java.io.IOException;
import javafx.scene.Parent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;



/**
 * FXML Controller class
 *
 * @author louis
 */
public class Interface_acceuilController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML private javafx.scene.control.Button boutonListeComplet ;
    @FXML private javafx.scene.control.Button boutonNouveauJeu ;
    
    //Action du bouton qui permet d'accèder a la liste complet des jeu enregistré 
     @FXML
    public void bouton_liste_completAction (ActionEvent event)throws IOException {
        Parent interface_liste_enregistrement_parent = FXMLLoader.load (getClass().getResource("Interface_liste_complete_enregistrement.fxml"));
        Scene interface_liste_enregistrement_scene = new Scene (interface_liste_enregistrement_parent); 
        Stage window = (Stage) boutonNouveauJeu.getScene().getWindow();
        window.setScene(interface_liste_enregistrement_scene);
        window.show();
    
    }
    
    //Action du bouton qui permet de créer une nouvelle séquence (choix_mode)
    @FXML
    public void bouton_NouveauJeuAction (ActionEvent event)throws IOException {
        Parent interface_choix_mode_parent = FXMLLoader.load (getClass().getResource("Interface_choix_mode.fxml"));
        Scene interface_choix_mode_scene = new Scene (interface_choix_mode_parent); 
        Stage app_stage = (Stage) boutonListeComplet.getScene().getWindow();
        app_stage.setScene(interface_choix_mode_scene);
        app_stage.show();
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
