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
 *
 * @author louis
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML private Label label;
    @FXML private javafx.scene.control.Button boutonAnnuler;
    @FXML private javafx.scene.control.Button buttonConnexion ;
    
    //Bouton pour aller a la prochaine scene, soit l'interface d'acceuil
    @FXML
    public void bouton_connexionAction (ActionEvent event)throws IOException {
        Parent interface_acceuil_parent = FXMLLoader.load (getClass().getResource("Interface_acceuil.fxml"));
        Scene interface_acceuil_scene = new Scene (interface_acceuil_parent); 
        Stage window = (Stage) buttonConnexion.getScene().getWindow();
        window.setScene(interface_acceuil_scene);
        window.show();
  
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
   
    @FXML
    private void bouton_AnnulerAction (ActionEvent event) throws IOException {
       Stage window = (Stage) boutonAnnuler.getScene().getWindow();
       window.close(); 
    }
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
