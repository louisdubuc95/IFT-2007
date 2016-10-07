/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualing;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;

/**
 * FXML Controller class
 *
 * @author louis
 */
public class Interface_creer_sport_TRController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML private javafx.scene.control.Button boutonInterfaceTempsReel ;
    @FXML
    //Accéder a l'interface pour créer une séquence en temps réel
    public void bouton_InterfaceTempsReelAction (ActionEvent event)throws IOException {
        Parent interface_TR_parent = FXMLLoader.load (getClass().getResource("Interface_temps_reel.fxml"));
        Scene interface_imageparimage_scene = new Scene (interface_TR_parent); 
        Stage window = (Stage) boutonInterfaceTempsReel.getScene().getWindow();
        window.setScene(interface_imageparimage_scene);
        window.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
