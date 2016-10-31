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

    private Button bouton_Annuler;

    /**
     * Initializes the controller class.
     */
    
    @FXML 
    public void boutouAnnuler (ActionEvent event) throws IOException {
        Parent interface_acceuil_Parent = FXMLLoader.load (getClass().getResource("Interface_accueil.fxml"));
        Scene interface_acceuil_scene= new Scene (interface_acceuil_Parent);
        Stage window = (Stage) bouton_Annuler.getScene().getWindow();
        window.setScene(interface_acceuil_scene);
        window.show();
    
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


 
 
}