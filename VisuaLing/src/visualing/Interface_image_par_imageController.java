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
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
 import javafx.scene.image.Image;
 import javafx.scene.image.ImageView;
import javafx.scene.control.Button; 
import javafx.scene.control.MenuItem;
import javafx.scene.control.MenuBar;
/**
 * FXML Controller class
 *
 * @author louis
 */
public class Interface_image_par_imageController implements Initializable {

    //@FXML
    private ImageView imgSurface;
    private Button boutonQuitter ;
    private MenuItem exit ;
    
    //private String memImage;

    public void getImageInterface(String imageSurface){
        System.out.println (imageSurface);
//        if(!imageSurface.equals("chemin"))
//        {
//            //File imageFile = new File(imageSurface);
//            //if (imageFile.exists()) {
//            Image image = new Image(imageSurface);
//            imgSurface.setImage(image);
//            }
      }
    
    @FXML 
    private void quitterJeu (final ActionEvent event){
        Platform.exit();
        
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    
    } 

    @FXML
    private void sauvegarderJeu(ActionEvent event) {
    }

    @FXML
    private void chargerJeu(ActionEvent event) {
    }
    }    


