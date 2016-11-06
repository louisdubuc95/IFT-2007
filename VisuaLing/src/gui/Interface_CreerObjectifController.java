/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author stlau
 */
public class Interface_CreerObjectifController implements Initializable {
    
    @FXML
    private Button boutonAnnuler;
    @FXML
    private Button boutonOk;
    @FXML
     private Button boutonParcourir;
    @FXML
    private ImageView ivImage;
    

    
    
        @FXML 
    public void boutonOkAction(ActionEvent event) throws MalformedURLException{
        Stage stage = (Stage) boutonOk.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    public void boutonAnnulerAction(ActionEvent event) {
          Stage stage = (Stage) boutonAnnuler.getScene().getWindow();
          stage.close();
    }  
    
    @FXML 
    public void boutonParcourirAction(ActionEvent event) throws MalformedURLException{
         Stage window = (Stage) boutonParcourir.getScene().getWindow();
         FileChooser fileChooser = new FileChooser();
         fileChooser.setTitle("Choisir une image");
         fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Fichier image", "*.png", "*.jpg"));
         File selectedFile = fileChooser.showOpenDialog(window);
         String path = selectedFile.getPath();
         File imageFile = new File(path);
            if (imageFile.exists()) {
                String imagepath = imageFile.toURI().toURL().toString();
                Image image = new Image(imagepath);
                ivImage.setImage(image);
         }
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
   
    
}
