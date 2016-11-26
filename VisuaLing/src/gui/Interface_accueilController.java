/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controller.VisuaLigueController;
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
import javafx.event.EventHandler;
import javafx.scene.control.ButtonBase;
import javafx.scene.layout.AnchorPane;
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
    private VBox content;


    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficherSauvegardes();
        
        
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Interface_image_par_image.fxml"));

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
                        Stage stage = new Stage(StageStyle.DECORATED);
                        stage.setTitle( "- mode Image par Images");
                        stage.setScene(new Scene((AnchorPane) loader.load()));
                        stage.setMaximized(true);
                        Interface_image_par_imageController IPIController = loader.<Interface_image_par_imageController>getController();

                        VisuaLigueController controller = IPIController.m_enregistrement.deSerialize(pathFichier);
                        IPIController.setController(controller);
                        IPIController.setImageInterface(controller.getImageSurface());
                        IPIController.setJoueur();
                    
                        //Show la nouvelle window
                        stage.show();
                        
                        stage = (Stage) boutonCharger.getScene().getWindow();
                        stage.close();
                    }
                }
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
        listTB.add(TB);
        TB.setMinHeight(100);
        TB.setMinWidth(625);
        TB.setOnAction(updateButtonHandler);
        
        
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/DD HH:mm:ss");
        TB.setText("Nom du fichier  :  "+ file.getName() + "\n" + "Derniere modification  :  " 
                +sdf.format(file.lastModified())
                + "\n" + "Taille  :  " + file.length() + " octets");
        TB.setTextAlignment(TextAlignment.JUSTIFY);
        Insets insets = new Insets(0,350,0,0);
        TB.setPadding(insets);
               
        content.setPrefHeight(content.getPrefHeight() + TB.getPrefHeight());
        content.getChildren().add(TB);
        
      }


    }
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
    
    
