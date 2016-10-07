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
public class Interface_choix_modeController implements Initializable {

    /**
     * Initializes the controller class.
     * 
     */
    //Accéder a l'interface de création de sport temps réel
    
    @FXML private javafx.scene.control.Button boutonTempsReel ;
    @FXML private javafx.scene.control.Button boutonImageParImage ;
    
    @FXML
     public void bouton_TempsReelAction (ActionEvent event)throws IOException {
        Parent tempsreel_parent = FXMLLoader.load (getClass().getResource("Interface_creer_sport_TR.fxml"));
        Scene tempsreel_scene = new Scene (tempsreel_parent); 
        Stage window = (Stage) boutonTempsReel.getScene().getWindow();
        window.setScene(tempsreel_scene);
        window.show();
     }
      //Accéder  a l'interface de création de sport image par image
      @FXML
        public void bouton_ImageParImageAction (ActionEvent event)throws IOException {
        Parent imageparimage_parent = FXMLLoader.load (getClass().getResource("Interface_creer_sport_IPI.fxml"));
        Scene imageparimage_scene = new Scene (imageparimage_parent); 
        Stage window = (Stage) boutonImageParImage.getScene().getWindow();
        window.setScene(imageparimage_scene);
        window.show();
      }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
