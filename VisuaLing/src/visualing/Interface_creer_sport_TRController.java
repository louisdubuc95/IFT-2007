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
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.StageStyle;

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
          FXMLLoader loader = new FXMLLoader(getClass().getResource("Interface_image_par_image.fxml"));
          Stage stage = new Stage(StageStyle.DECORATED);
          stage.setTitle(txtNomSportsTR.getText() + " - mode Temps Reel");
          stage.setScene(new Scene((AnchorPane) loader.load()));
          Interface_image_par_imageController IPIController = loader.<Interface_image_par_imageController>getController();
          
          //Appel la classe qui set l'image
          IPIController.setImageInterface(lblCheminImage.getText());
          
          //Show la nouvelle window
          stage.show();
          
          //Ferme le window actuel
          stage = (Stage) boutonInterfaceTempsReel.getScene().getWindow();
          stage.close();
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
