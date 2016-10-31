/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualing;

import java.io.File;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author louis
 */
public class Interface_creer_sport_TRController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML 
    private javafx.scene.control.Button boutonInterfaceTempsReel ;
    @FXML
    private Button boutonAnnulerTR;
    @FXML
    private TextField txtNomSportsTR;
    @FXML
    private TextField txtDimensionX;
    @FXML
    private TextField txtDimensionY;
    @FXML
    private Button boutonParcourirTR;
    @FXML
    private Label lblCheminImage;
    @FXML
    
    //Accéder a l'interface pour créer une séquence en temps réel
    public void bouton_InterfaceTempsReelAction (ActionEvent event)throws IOException {
        Parent interface_TR_parent = FXMLLoader.load (getClass().getResource("Interface_temps_reel.fxml"));
        Scene interface_imageparimage_scene = new Scene (interface_TR_parent); 
        Stage window = (Stage) boutonInterfaceTempsReel.getScene().getWindow();
        window.setScene(interface_imageparimage_scene);
        window.show();
    }
    
    //Accèdre au module parcourir image
    @FXML
    public void bouton_parcourirAction (ActionEvent event)throws IOException {
         Stage window = (Stage) boutonParcourirTR.getScene().getWindow();
         FileChooser fileChooser = new FileChooser();
         fileChooser.setTitle("Choisir une image");
         fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Fichier image", "*.png", "*.jpg"));
           
         File selectedFile = fileChooser.showOpenDialog(window);
         if (selectedFile != null) {
             lblCheminImage.setText(selectedFile.toString());
         }
    }
    
    //Retourner a la fenêtre précédente
    @FXML
    private void bouton_AnnulerAction (ActionEvent event) throws IOException {
        Parent Interface_choix_mode_parent = FXMLLoader.load (getClass().getResource("Interface_choix_mode.fxml"));
        Scene Interface_choix_mode_scene = new Scene (Interface_choix_mode_parent); 
        Stage window = (Stage) boutonAnnulerTR.getScene().getWindow();
        window.setScene(Interface_choix_mode_scene);
        window.show();
    }
      
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
