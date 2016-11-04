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
import javafx.event.EventHandler;
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
import javafx.scene.control.*;// 
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author louis
 */
public class Interface_image_par_imageController implements Initializable {

    //@FXML
    private ImageView imgSurface;
    private Button boutonQuitter ;
    
    
    //coordonée
    @FXML private Label labelcoordonneeI;
    @FXML private Label  coordoneeI ;
    
    //private String memImage;
      @Override
    public void initialize(URL location, ResourceBundle resources) {
    } 

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
     @FXML
    private void sauvegarderJeu(ActionEvent event) {
    }

    @FXML
    private void chargerJeu(ActionEvent event) {
    }
    @FXML
    public void coordonnee_interfaceI (){
        coordoneeI.setOnMouseMoved(new EventHandler<MouseEvent>() {
      @Override public void handle(MouseEvent event) {
          // 1056 (nb de pixel de largeur) / 18.57 = 60.96m (grandeur patinoire nhl) 
          // 537  (nb de pixel de hauteur  / 20.73 = 25.8m (grandeur patinoire ngl)
          // on va remplacer la grandeur par les parametres entré par l'utilisateur.
          //je suis pas certain si je peux mettre ca ici ou il faut que ce soit dans le controleur de larman. 
          // et je sais pas trop comment limité au centième...ca reste a voir
        String msg = "X : "       + event.getX()/17.32      + " Y : "       + event.getY()/20.73;
        labelcoordonneeI.setText(msg);
        System.out.println(msg);
        }
    });
    }
    //Lamnbda expression "->" c'est la même chose que la fonction coordonee_interface. C'est juste plus rapide codé comme ça 
    //lorsque l'utilisateur sort la souris de l'interface de jeu, remet le conteur a zero. 
   @FXML
   public void sortieInterfaceI () {
      coordoneeI.setOnMouseExited((MouseEvent) -> {
          String msg = "X : 0"+", Y : 0";
          labelcoordonneeI.setText(msg);
      });
              }
    
    
    
   
    }    


