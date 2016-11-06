/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Point;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
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
    @FXML private ColorPicker colorPicker;
    private Point t ; 
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    @FXML
    public void boutonAnnulerAction(ActionEvent event) {
          Stage stage = (Stage) boutonAnnuler.getScene().getWindow();
          stage.close();
          //Interface_image_par_imageController.boutonObjectif.setDisable(false);         
    } 
    
    @FXML
    public void boutonAccepterAction(ActionEvent event) throws IOException {
        //color = colorPicker.getValue();
        Color color  = Color.BLUE;
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Interface_image_par_image.fxml"));
        //Stage stage = new Stage(StageStyle.DECORATED);
        //stage.setScene(new Scene((AnchorPane) fxmlLoader.load()));
        
        Interface_image_par_imageController IPIController = fxmlLoader.<Interface_image_par_imageController>getController();
        IPIController.setColor(color);
        
        Stage window = (Stage) boutonAnnuler.getScene().getWindow();
        window.close();
    }
}
