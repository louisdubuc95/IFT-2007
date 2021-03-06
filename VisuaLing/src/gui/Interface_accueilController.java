/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controller.VisuaLigueController;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.File;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.ToggleButton;
import java.text.SimpleDateFormat;
import javafx.scene.text.TextAlignment;
import java.util.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.StageStyle;
/**
 * FXML Controller class
 *
 * @author stlau
 */
public class Interface_accueilController implements Initializable {

    @FXML
    private Button boutonNouveau;
    @FXML
    private Button boutonCharger;
    @FXML
    private Button boutonQuitter;
    @FXML
    private List<ToggleButton> listTB = new ArrayList<ToggleButton>();
    
    @FXML
    private Label info;
    
    @FXML 
    private Button boutonCourriel;
    
    @FXML
    private VBox content;
    
    public String typeUtilisateur;
    private String pathVerif = "src/savedUtilisateurs/connecte.txt";


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficherSauvegardes();
        
        try 
        (BufferedReader br = new BufferedReader(new FileReader(pathVerif))) {
            String line;
            while ((line = br.readLine()) != null) {
                typeUtilisateur = line;
            }
        }   
        catch (IOException ex) {
            Logger.getLogger(Interface_image_par_imageController.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (!typeUtilisateur.equals("entraineur"))
        {
            boutonNouveau.setDisable(true);
        }
    }    
    
    //test commentaire
    @FXML
    private void boutonNouveauAction(ActionEvent event)throws IOException {
        Parent Interface_choix_mode_parent = FXMLLoader.load (getClass().getResource("Interface_choix_mode.fxml"));
        Scene Interface_choix_mode_scene = new Scene (Interface_choix_mode_parent); 
        Stage window = (Stage) boutonNouveau.getScene().getWindow();
        window.setScene(Interface_choix_mode_scene);
        window.show();
    }

    @FXML
    private void boutonChargerAction(ActionEvent event)throws IOException {
            for(ToggleButton TB: listTB)
            {
                if(TB.isSelected())
                {
                    String s = TB.getText();
                    String[] partiesPath = s.split("\n");
                    String pathFichier = partiesPath[0];
                    pathFichier = pathFichier.replaceAll("Nom du fichier  :  ", "");
                    String extension = pathFichier.replaceAll(".*\\.", "");
                    pathFichier = "src/savedStrategies/"+pathFichier;
                    
                   
                    if(extension.equals("IPI"))
                    {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("Interface_image_par_image.fxml"));
                        Stage stage = new Stage(StageStyle.DECORATED);
                        stage.setTitle( "- mode Image par Images");
                        stage.setScene(new Scene((AnchorPane) loader.load()));
                        stage.setMaximized(true);
                        Interface_image_par_imageController IPIController = loader.<Interface_image_par_imageController>getController();

                        VisuaLigueController controller = IPIController.m_enregistrement.deSerialize(pathFichier);
                        IPIController.setController(controller);
                        IPIController.setImageInterface(controller.getImageSurface());
                        IPIController.setStateMaxJoueur();
                        IPIController.setStateAfficherPosition();
                        IPIController.setJoueurMax();
                        IPIController.setStateOrientation();
                        
                        //Ajoute les joueurs
                        IPIController.setJoueur();
                        
                        //Ajouter les obstacle
                        IPIController.setObstacle();
                        
                        //Ajouter lse objectifs
                        IPIController.setObjectif();
                    
                        //Show la nouvelle window
                        stage.show();
                        
                        stage = (Stage) boutonCharger.getScene().getWindow();
                        stage.close();
                    }
                    else
                        if(extension.equals("TR"))
                        {
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("Interface_temps_reel.fxml"));
                            Stage stage = new Stage(StageStyle.DECORATED);
                            stage.setTitle( "- mode Temps Reel");
                            stage.setScene(new Scene((AnchorPane) loader.load()));
                            stage.setMaximized(true);
                            Interface_temps_reelController TRController = loader.<Interface_temps_reelController>getController();

                            VisuaLigueController controller = TRController.m_enregistrement.deSerialize(pathFichier);
                            TRController.setController(controller);
                            TRController.setImageInterface(controller.getImageSurface());
                            TRController.setStateMaxJoueur();
                            TRController.setStateAfficherPosition();
                            TRController.setJoueurMax();
                            TRController.setStateOrientation();

                            //Ajoute les joueurs
                            TRController.setJoueur();

                            //Ajouter les obstacle
                            TRController.setObstacle();

                            //Ajouter lse objectifs
                            TRController.setObjectif();

                            //Show la nouvelle window
                            stage.show();

                            stage = (Stage) boutonCharger.getScene().getWindow();
                            stage.close();                            
                        }
                }
            } 
    }
    
    
    @FXML
    private void boutonCourriel(ActionEvent event)throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Interface_ConnexionEmail.fxml"));
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene((AnchorPane) loader.load()));
        Interface_ConnexionEmailController ConnexionEmailController = loader.<Interface_ConnexionEmailController>getController();
        
   

            for(ToggleButton TB: listTB)
            {
                if(TB.isSelected())
                {   
                    String s = TB.getText();
                    String[] partiesPath = s.split("\n");
                    String pathFichier = partiesPath[0];
                    pathFichier = pathFichier.replaceAll("Nom du fichier  :  ", "");
                    String extension = pathFichier.replaceAll(".*\\.", "");
                    pathFichier = "src/savedStrategies/"+pathFichier;
                    TB.setSelected(false);
                    info = new Label("");
                    stage.show();
                    ConnexionEmailController.setFile(pathFichier);
                    
                    
                }
                
                info.setText("Vous devez selectionner une strategie pour continuer!");
                
                
                

            }
}

    //Quitter la scene
    @FXML
    private void boutonQuitterAction(ActionEvent event) {
        Stage window = (Stage) boutonQuitter.getScene().getWindow();
        window.close();
    }
 
    
    
    //Afficher strategies sauvegardee
    @FXML
    private void afficherSauvegardes() 
    {
    
    File folder = new File("src/savedStrategies");
    File[] listOfFiles = folder.listFiles();

    
    for (File file : listOfFiles) {
      String extensionIPI = ".IPI";
      String extensionTR = ".TR";
      if (file.getAbsolutePath().endsWith(extensionIPI) || file.getAbsolutePath().endsWith(extensionTR)) {
        ToggleButton TB = new ToggleButton("Label " + file.getName());
        
        
        TB.setMinHeight(200);
        TB.setMinWidth(625);
        TB.setOnAction(updateButtonHandler);
        
        
        
        
        File folderCapture = new File("src/Captures");
        File[] listOfFilesCapture = folderCapture.listFiles();
        
        //
        String[] parts = file.getAbsolutePath().split("\\\\");
        
        String nom = parts[parts.length-1];
        String[] parts2 = nom.split("\\.");
        nom = parts2[0] + "." + parts2[1];
        
        String pathPhoto="src/Captures/noPreviewFound.png";
        
       for(File fileCapture : listOfFilesCapture)
       {
            String[] partsCapture = fileCapture.getAbsolutePath().split("\\\\");
            String nomCapture = partsCapture[partsCapture.length-1];
            String[] partsCapture2 = nomCapture.split("\\.");
            nomCapture = partsCapture2[0] + "." + partsCapture2[1];
            System.out.println(nomCapture);
            
            if(nomCapture.equals(nom))
            {
                pathPhoto = partsCapture[partsCapture.length-3] + "\\" +
                        partsCapture[partsCapture.length-2] + "\\" +
                        partsCapture[partsCapture.length-1];
                
            }
           
       }
        
       
        
        Image imagePreview = new Image("file:" + pathPhoto);
        ImageView IV = new ImageView();
        IV.setImage(imagePreview);
        IV.setFitHeight(180.0);
        IV.setFitWidth(250.0);
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/DD HH:mm:ss");
        TB.setText("Nom du fichier  :  "+ file.getName() + "\n" + "Derniere modification  :  " 
                +sdf.format(file.lastModified())
                + "\n" + "Taille  :  " + file.length() + " octets");
        TB.setTextAlignment(TextAlignment.JUSTIFY);
        Insets insets = new Insets(0,0,0,0);
        TB.setPadding(insets);
        TB.setGraphic(IV);
        TB.setGraphicTextGap(-570);
        listTB.add(TB);
               
        content.setPrefHeight(content.getPrefHeight() + TB.getPrefHeight());
        content.getChildren().add(TB);
        
      }
    }
    }
    
    
    
    
    //Afficher strategies sauvegardee
    @FXML
    private void deleteSauvegardes() 
    {
    
    File folder = new File("src/savedStrategies");
    File[] listOfFiles = folder.listFiles();

    for (File file : listOfFiles) {
        file.delete();
    }
    content.getChildren().clear();
    }
    
    
    EventHandler<ActionEvent> updateButtonHandler = new EventHandler<ActionEvent>() 
    {
        @Override
        public void handle(ActionEvent event) {
            ToggleButton source = (ToggleButton)event.getSource();
            if(!source.isSelected())
            {
                for (ToggleButton button : listTB) 
                {
                    button.setDisable(false);
                }
            }
            else{
                for (ToggleButton button : listTB) 
                {
                 button.setDisable(!button.isSelected());
                }
            }

        }
    };

   
   
}
    
    
