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
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
  
/**
 * FXML Controller class
 *
 * @author louis
 */
public class Interface_image_par_imageController implements Initializable {

    @FXML private ImageView imgSurface;
    @FXML private Button boutonQuitter ;
    @FXML private ToggleButton boutonAjouterJoueur; 
    @FXML private ToggleButton boutonObjectif;
   
    //@FXML private Boolean VerifAjoutJoueur = false;

   
    @FXML private ToggleButton boutonAjouterObstacle;
    @FXML private Button boutonSauvegarder;
    @FXML private Button boutonChangerSports;
    @FXML MenuBar menuBarSport;
    @FXML Canvas canevasInterface;
    
    //coordonée
    @FXML private Label labelcoordonneeI;
    @FXML private Label  coordoneeI ;
    
    @FXML private String imagePath;
    @FXML private Color color;
    
     @FXML private ToggleGroup group ;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       // boutonAjouterJoueur.setToggleGroup(group);
       // boutonObjectif.setToggleGroup(group);
       // boutonAjouterJoueur.setToggleGroup(group);
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
      FXMLLoader loader = new FXMLLoader(getClass().getResource("Interface_accueil.fxml"));
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
        imagePath = imageSurface;
        
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
        Stage window = (Stage) menuBarSport.getScene().getWindow();
           FileChooser fileChooser = new FileChooser();
           fileChooser.setTitle("Choisir une image");
           fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Fichier image", "*.png", "*.jpg"));
           
           File selectedFile = fileChooser.showOpenDialog(window);
           if (selectedFile != null) {
               String path = selectedFile.getPath();
               imagePath = path;
               setImageInterface(path);
           }
      }
      
    @FXML
    public void bouton_changerMode (ActionEvent event)throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("Interface_temps_reel.fxml"));
          Stage Window = (Stage) menuBarSport.getScene().getWindow();
          Stage stage = new Stage(StageStyle.DECORATED);
          String titreWindow = Window.getTitle();
          titreWindow = titreWindow.replaceAll(" - mode Image par Image", "");
          titreWindow = titreWindow + " - mode Temps Reel";
          stage.setTitle(titreWindow);
          stage.setScene(new Scene((AnchorPane) loader.load()));
          Interface_temps_reelController TRcontrolleur = loader.<Interface_temps_reelController>getController();
          
          //Appel la classe qui set l'image
          TRcontrolleur.setImageInterface(imagePath);
          
          //Show la nouvelle window
          stage.show();
          
          //Ferme le window actuel
          stage = (Stage) menuBarSport.getScene().getWindow();
          stage.close();
      }
    
    @FXML 
    private void quitterJeu (final ActionEvent event){
        Platform.exit();
        
    }
    
    @FXML
    public void ajouterJoueurAction(ActionEvent event) throws IOException {
        Stage stage = new Stage(StageStyle.DECORATED);
        FXMLLoader loader ;
        loader = new FXMLLoader(getClass().getResource("Interface_CreerJoueur.fxml"));
        stage.setTitle("Ajout Joueur");
        stage.setScene(new Scene((AnchorPane) loader.load()));
        if (boutonAjouterJoueur.isSelected()){
          stage.show();
          boutonObjectif.setDisable(true);
          boutonAjouterObstacle.setDisable(true);
        }
        if (!boutonAjouterJoueur.isSelected()){
           boutonObjectif.setDisable(false);
           boutonAjouterObstacle.setDisable(false);
           stage.close();
        }  
        
    }
    
    @FXML
    public void ajouterObstacleAction(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifObstacle.fxml"));
          Stage stage = new Stage(StageStyle.DECORATED);
          stage.setTitle("Ajout obstacle");
          stage.setScene(new Scene((AnchorPane) loader.load()));
         if (boutonAjouterObstacle.isSelected()){
          stage.show();
          boutonObjectif.setDisable(true);
          boutonAjouterJoueur.setDisable(true);
        }
        if (!boutonAjouterObstacle.isSelected()){
           boutonObjectif.setDisable(false);
           boutonAjouterJoueur.setDisable(false);
           stage.close();
        }  
         
    }
    @FXML
    public void ajouterObstacleInterface (){
        
    }
          
    @FXML
    public void ajouterObjectifButton(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("Interface_CreerObjectif.fxml"));
          Stage stage = new Stage(StageStyle.DECORATED);
          stage.setTitle("Ajout objectif");
          stage.setScene(new Scene((AnchorPane) loader.load()));
         if (boutonObjectif.isSelected()){
          stage.show();
          boutonAjouterJoueur.setDisable(true);
          boutonAjouterObstacle.setDisable(true);
        }
        if (!boutonObjectif.isSelected()){
           boutonAjouterJoueur.setDisable(false);
            boutonAjouterObstacle.setDisable(false);
            stage.close();
        }  
    }
    
    @FXML
    public void ajouterObjectifInterface (){
        
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
    
    @FXML 
    public void ajouterJoueurInterface()  {
        
        
        canevasInterface.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override public void handle(MouseEvent event){
                   if(boutonAjouterJoueur.isSelected()){
                    GraphicsContext gc = canevasInterface.getGraphicsContext2D();
                    gc.setFill(color);
                    gc.fillOval(event.getX(),event.getY(),20,20);
                   }  
                }
            
         });
        
    }
                
    
    @FXML 
    public void setColor(Color colorparam){
        color = colorparam;
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


