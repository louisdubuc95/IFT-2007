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
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.control.MenuItem;
import javafx.scene.control.MenuBar;
/**
 * FXML Controller class
 *
 * @author louis
 */
public class Interface_temps_reelController implements Initializable {
  private MenuItem exit ;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML 
    private void quitterJeu (ActionEvent event){
        Platform.exit();
    }
    
    @FXML 
    private void sauvegarderJeu (ActionEvent event){
        
    }
    
    @FXML
    private void chargerJeu (ActionEvent event){
        
    }
    
    
    
}
