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

   @FXML private Button butonAnnuler; 

    /**
     * Initializes the controller class.
     */
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

        @FXML
        public void btnAnnuler (ActionEvent event)throws IOException {
        Parent btn_Annuler_parent = FXMLLoader.load (getClass().getResource("Interface_accueil.fxml"));
        Scene btn_Annuler_scene = new Scene (btn_Annuler_parent); 
        Stage window = (Stage)  butonAnnuler.getScene().getWindow();
        window.setScene(btn_Annuler_scene);
        window.show();
      }
    @FXML
        public void btnCharger (ActionEvent event)throws IOException {
        
      }
  
    
 
}