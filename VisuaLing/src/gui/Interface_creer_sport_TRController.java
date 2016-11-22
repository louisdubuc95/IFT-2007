/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
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
    private ScrollPane sp;
    
    //Accéder a l'interface pour créer une séquence en temps réel
    public void bouton_InterfaceTempsReelAction (ActionEvent event)throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("Interface_temps_reel.fxml"));
          Stage stage = new Stage(StageStyle.DECORATED);
          if(txtNomSportsTR.getText().trim().isEmpty())
          {
              stage.setTitle("Sans nom - mode Temps Reel");
          }
          else
          {
              stage.setTitle(txtNomSportsTR.getText() + " - mode Temps Reel");
          }
          stage.setScene(new Scene((AnchorPane) loader.load()));
          Interface_temps_reelController TRcontrolleur = loader.<Interface_temps_reelController>getController();
          
          //Appel la classe qui set l'image
          TRcontrolleur.setImageInterface(lblCheminImage.getText());
          
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
    
    

    @FXML
    private void afficherSauvegardes()
    {
    File folder = new File("src/savedSports/ImageParImage");
    File[] listOfFiles = folder.listFiles();
    VBox content = new VBox();
    
   
    for (File file : listOfFiles) {
      String extension = ".txt";
      //if (file.getAbsolutePath().endsWith(extension)) {
      if (file.isFile()) {
          try {
              BufferedReader Buff = new BufferedReader(new FileReader(file));
              String text = Buff.readLine();
              String[] parts = text.split(",");
              String nom = parts[0];
              String path = parts[4];
              Image imageSport = new Image("file:"+path);
              ImageView IV = new ImageView();
              IV.setImage(imageSport);
              IV.setFitHeight(80.0);
              IV.setFitWidth(100.0);



              ToggleButton TB = new ToggleButton(file.getName());

              TB.setContentDisplay(ContentDisplay.RIGHT);
              
              TB.setMinHeight(100);
              TB.setMinWidth(625);
              SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/DD HH:mm:ss");
              TB.setText("\tNom du fichier  :  "+ file.getName() + "\n" + "\tNom du sport : " + nom + "\n" + "\tDerniere modification  :  "
                      +sdf.format(file.lastModified())
                      + "\n" + "\tTaille  :  " + file.length() + " octets");
              Insets insets = new Insets(0,200,0,0);
              TB.setPadding(insets);
              TB.setGraphic(IV);
              TB.setGraphicTextGap(200);
              
              content.setPrefHeight(content.getPrefHeight() + TB.getPrefHeight());
              content.getChildren().add(TB);
              sp.setContent(content);
          }
          catch (IOException ex) {
              Logger.getLogger(Interface_creer_sport_IPIController.class.getName()).log(Level.SEVERE, null, ex);
          }
              
      }
    }
    }
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficherSauvegardes();
    }    
    
}
