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
 * @author 
 */



public class Interface_creer_sport_IPIController implements Initializable {
    /**
     * Initializes the controller class.
     */
    
    @FXML private javafx.scene.control.Button boutonInterfaceImageParImage ;
    
    //Accéder a l'interface image par image 
    
    
    @FXML
      public void bouton_InterfaceImageParImageAction (ActionEvent event)throws IOException {
        Parent interface_imageparimage_parent = FXMLLoader.load (getClass().getResource("Interface_image_par_image.fxml"));
        Scene interface_imageparimage_scene = new Scene (interface_imageparimage_parent); 
        Stage window = (Stage) boutonInterfaceImageParImage.getScene().getWindow();
        window.setScene(interface_imageparimage_scene);
        window.show();
      }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
