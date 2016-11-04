/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualing;

import java.awt.event.*; //MouseEvent
import java.io.IOException;
import javafx.scene.Parent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.MenuItem;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.*;
import javafx.scene.input.MouseEvent;
/**
 * FXML Controller class
 *
 * @author louis
 */
public class Interface_temps_reelController implements Initializable {

    
    private MenuItem exit ;
    
    
    //coordonée
    @FXML private Label labelcoordonnee;
    @FXML private Label  coordonee ;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void setImageInterface(String imageSurface){
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
    private void quitterJeu (ActionEvent event){
        Platform.exit();
    }
    
    @FXML 
    private void sauvegarderJeu (ActionEvent event){
        
    }
    
    @FXML
    private void chargerJeu (ActionEvent event){
        
    }
   
    @FXML
    public void coordonnee_interface (){
        coordonee.setOnMouseMoved(new EventHandler<MouseEvent>() {
      @Override public void handle(MouseEvent event) {
          // 1056 (nb de pixel de largeur) / 18.57 = 60.96m (grandeur patinoire nhl) 
          // 537  (nb de pixel de hauteur  / 20.73 = 25.8m (grandeur patinoire ngl)
          // on va remplacer la grandeur par les parametres entré par l'utilisateur.
          //je suis pas certain si je peux mettre ca ici ou il faut que ce soit dans le controleur de larman. 
          // et je sais pas trop comment limité au centième...ca reste a voir
        String msg = "X : "       + event.getX()/17.32      + " Y : "       + event.getY()/20.73;
        labelcoordonnee.setText(msg);
        }
    });
    }
    //Lamnbda expression "->" c'est la même chose que la fonction coordonee_interface. C'est juste plus rapide codé comme ça 
    //lorsque l'utilisateur sort la souris de l'interface de jeu, remet le conteur a zero. 
   @FXML
   public void sortieInterface () {
      coordonee.setOnMouseExited((MouseEvent) -> {
          String msg = "X : 0"+", Y : 0";
          labelcoordonnee.setText(msg);
      });
              }
}
