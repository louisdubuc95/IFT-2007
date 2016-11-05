/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualing;

import java.awt.Point;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;



/**
 * FXML Controller class
 *
 * @author stlau
 */
public class Interface_CreerJoueurController implements Initializable {
    
    @FXML private Button boutonAnnuler;
    @FXML private Button boutonAttaquant;
    @FXML private Button boutonDefenseur;
    @FXML private Button boutonGuardien;
    private Point t ; 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    @FXML 
    public void boutonAttaquantAction(ActionEvent event) throws MalformedURLException{
        Stage stage = (Stage) boutonAttaquant.getScene().getWindow();
        stage.close();
    }
    
    @FXML 
    public void boutonDefenseurAction(ActionEvent event) throws MalformedURLException{
        Stage stage = (Stage) boutonDefenseur.getScene().getWindow();
        stage.close();
    }
    
    @FXML 
    public void boutonGuardienAction(ActionEvent event) throws MalformedURLException{
        Stage stage = (Stage) boutonGuardien.getScene().getWindow();
        stage.close();
    }
    
    public void boutonAnnulerAction(ActionEvent event) {
          Stage stage = (Stage) boutonAnnuler.getScene().getWindow();
          stage.close();
    }  
    
    
    
}
