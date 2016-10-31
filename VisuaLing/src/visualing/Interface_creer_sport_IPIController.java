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
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.io.File;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
/**
 * FXML Controller class
 *
 * @WL 
 */



public class Interface_creer_sport_IPIController implements Initializable {
    /**
     * Initializes the controller class.
     */
    
    @FXML //  fx:id= "boutonInterfaceImageParImage
    private javafx.scene.control.Button boutonCreerSportsIPI ;
    
    @FXML //  fx:id="boutonParcourirIPI"
    private javafx.scene.control.Button boutonParcourirIPI;
    
    @FXML //  fx:id="boutonParcourirIPI"
    private javafx.scene.control.Button boutonAnnulerSportsIMI;
    
    @FXML //  fx:id="boutonParcourirIPI"
    private TextField txtNomIPI;
    @FXML
    private Label lblCheminImage;
    @FXML
    private TextField txtDimensionX;
    @FXML
    private TextField txtDimensionY;
    
    //Accéder a l'interface image par image 
    @FXML
      public void bouton_InterfaceImageParImageAction (ActionEvent event)throws IOException {
        Parent interface_imageparimage_parent = FXMLLoader.load (getClass().getResource("Interface_image_par_image.fxml"));
        Scene interface_imageparimage_scene = new Scene (interface_imageparimage_parent); 
        Stage window = (Stage) boutonCreerSportsIPI.getScene().getWindow();
        window.setScene(interface_imageparimage_scene);
        window.show();
      }
    
    //Accèdre au module parcourir image
    @FXML
      public void bouton_parcourirAction (ActionEvent event)throws IOException {
           Stage window = (Stage) boutonParcourirIPI.getScene().getWindow();
           FileChooser fileChooser = new FileChooser();
           fileChooser.setTitle("Choisir une image");
           fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Fichier image", "*.png", "*.jpg"));
           
           File selectedFile = fileChooser.showOpenDialog(window);
           if (selectedFile != null) {
               lblCheminImage.setText(selectedFile.toString());
           }
      }
      
    //Accèdre a l'interface précédante (choisir Mode)
    @FXML
    private void bouton_AnnulerAction (ActionEvent event) throws IOException {
        Parent interface_choix_mode_parent = FXMLLoader.load (getClass().getResource("Interface_choix_mode.fxml"));
        Scene interface_choix_mode_scene = new Scene (interface_choix_mode_parent); 
        Stage window = (Stage) boutonAnnulerSportsIMI.getScene().getWindow();
        window.setScene(interface_choix_mode_scene);
        window.show();
    }
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO
    }   
    
}
