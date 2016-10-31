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
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author louis
 */
public class Interface_liste_complete_enregistrementController implements Initializable {

    @FXML
    private Button boutonOuvrir;
    @FXML
    private Button boutonAnnuler;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void boutonOuvrirAction(ActionEvent event) {
    }

    @FXML
    private void boutonAnnulerAction(ActionEvent event)throws IOException {
        Parent Interface_accueil_parent = FXMLLoader.load (getClass().getResource("Interface_accueil.fxml"));
        Scene Interface_accueil_scene = new Scene (Interface_accueil_parent); 
        Stage window = (Stage) boutonAnnuler.getScene().getWindow();
        window.setScene(Interface_accueil_scene);
        window.show();
    }
    
}
