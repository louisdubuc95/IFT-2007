/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author louis
 */
public class Interface_image_par_imageController implements Initializable {

    @FXML private ImageView imgSurface;
    @FXML private Button boutonQuitter ;
    @FXML private Button boutonAjouterJoueur; 
    @FXML private Button boutonAjouterObstacle;
    @FXML private Button boutonSauvegarder;
    @FXML private Button boutonChangerSports;
    @FXML MenuBar menuBarSport;
    
    //coordonée
    @FXML private Label labelcoordonneeI;
    @FXML private Label  coordoneeI ;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    
    public void nouveauSportAction(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("Interface_choix_mode.fxml"));
          Stage stage = new Stage(StageStyle.DECORATED);
          stage.setTitle("Nouveau Sport");
          stage.setScene(new Scene((AnchorPane) loader.load()));
          //Show la nouvelle window
          stage.show();
    }
    
    
    public void ChargerAction(ActionEvent event) throws IOException {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("Interface_liste_complete_enregistrement.fxml"));
      Stage stage = new Stage(StageStyle.DECORATED);
      stage.setTitle("Charger Jeu");
      stage.setScene(new Scene((AnchorPane) loader.load()));
      //Show la nouvelle window
      stage.show();
    }
    
      public void OuvrirInfoAction(ActionEvent event) throws IOException {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("Interface_InfoBox.fxml"));
      Stage stage = new Stage(StageStyle.DECORATED);
      stage.setTitle("Informations");
      stage.setScene(new Scene((AnchorPane) loader.load()));
      //Show la nouvelle window
      stage.show();
    }

    public void setImageInterface(String imageSurface) {
        try {
        if(!imageSurface.equals("chemin"))
        {
            File imageFile = new File(imageSurface);
            if (imageFile.exists()) {
                
                    String imagepath = imageFile.toURI().toURL().toString();
                    Image image = new Image(imagepath);
                    imgSurface.setImage(image);
                    }
        }
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Interface_image_par_imageController.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    
        //Accèdre au module parcourir image
    @FXML
      public void bouton_ChangerSports (ActionEvent event)throws IOException {
        System.out.println("test");
        Stage window = (Stage) menuBarSport.getScene().getWindow();
           FileChooser fileChooser = new FileChooser();
           fileChooser.setTitle("Choisir une image");
           fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Fichier image", "*.png", "*.jpg"));
           
           File selectedFile = fileChooser.showOpenDialog(window);
           if (selectedFile != null) {
               String path = selectedFile.getPath();
               setImageInterface(path);
           }

      }
    
    @FXML 
    private void quitterJeu (final ActionEvent event){
        Platform.exit();
        
    }
    
    @FXML
    private void ajouterJoueurAction(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("Interface_CreerJoueur.fxml"));
          Stage stage = new Stage(StageStyle.DECORATED);
          stage.setTitle("Ajout Joueur");
          stage.setScene(new Scene((AnchorPane) loader.load()));
          
          //Show la nouvelle window
          stage.show();
    }
    
    @FXML
    private void ajouterObstacleAction(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifObstacle.fxml"));
          Stage stage = new Stage(StageStyle.DECORATED);
          stage.setTitle("Ajout obstacle");
          stage.setScene(new Scene((AnchorPane) loader.load()));
          
          //Show la nouvelle window
          stage.show();
    }
    
    @FXML
    private void sauvegarderAction(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("Interface_Sauvegarde.fxml"));
          Stage stage = new Stage(StageStyle.DECORATED);
          stage.setTitle("Sauvegarder");
          stage.setScene(new Scene((AnchorPane) loader.load()));
          
          //Show la nouvelle window
          stage.show();
    }

    /**
     *
     */
    @FXML
    public void coordonnee_interfaceI (){
        coordoneeI.setOnMouseMoved(new EventHandler<MouseEvent>() {
      @Override public void handle(MouseEvent event) {
          // 1056 (nb de pixel de largeur) / 18.57 = 60.96m (grandeur patinoire nhl) 
          // 537  (nb de pixel de hauteur  / 20.73 = 25.8m (grandeur patinoire ngl)
          // on va remplacer la grandeur par les parametres entré par l'utilisateur.
          //je suis pas certain si je peux mettre ca ici ou il faut que ce soit dans le controleur de larman. 
          // et je sais pas trop comment limité au centième...ca reste a voir
        String msg1 = "X : "       + event.getX()/17.32      + " Y : "       + event.getY()/20.73;
        labelcoordonneeI.setText(msg1);
       
        }
    });
    }
    //Lamnbda expression "->" c'est la même chose que la fonction coordonee_interface. C'est juste plus rapide codé comme ça 
    //lorsque l'utilisateur sort la souris de l'interface de jeu, remet le conteur a zero. 
   
    /**
     *
     */
   @FXML
   public void sortieInterfaceI () {
      coordoneeI.setOnMouseExited((MouseEvent) -> {
          String msg = "X : 0"+", Y : 0";
          labelcoordonneeI.setText(msg);
      });
    }

}    


