/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controller.VisuaLigueController;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
    private Button boutonConfirmer;
    @FXML
    private Button boutonParcourir;
    @FXML
    private ImageView ivImage;
    @FXML
    private ComboBox cbType;

    
    @FXML
    private String m_path = "src/Photo/rondelle.jpg";
    
    private Interface_image_par_imageController parentController;
    private Interface_temps_reelController parentControllerTR;
    public VisuaLigueController m_controller;
    

    
    //TR
    public void initializeTR(Interface_temps_reelController controller) {
        parentControllerTR = controller;
        m_controller = parentControllerTR.m_controller;
        cbType.valueProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                updateImage(newValue);
        }

        }); 
        
        cbType.getItems().add("Rondelle");
        cbType.getItems().add("Balle");
        cbType.getItems().add("Ballon");
        cbType.getSelectionModel().selectFirst();
        
        String image = "src/Photo/rondelle.jpg";
        File imageFile = new File(image);
        String imagePath = null;
        try {
            imagePath = imageFile.toURI().toURL().toString();
        } catch (MalformedURLException ex) {
            Logger.getLogger(Interface_image_par_imageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Image ImageRondelle = new Image(imagePath);
        ivImage.setImage(ImageRondelle);
    }
    
    //IPI
    public void initialize(Interface_image_par_imageController controller) {
        parentController = controller;
        m_controller = parentController.m_controller;
        cbType.valueProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                updateImage(newValue);
        }

        }); 
        
        cbType.getItems().add("Rondelle");
        cbType.getItems().add("Balle");
        cbType.getItems().add("Ballon");
        cbType.getSelectionModel().selectFirst();
        
        String image = "src/Photo/rondelle.jpg";
        File imageFile = new File(image);
        String imagePath = null;
        try {
            imagePath = imageFile.toURI().toURL().toString();
        } catch (MalformedURLException ex) {
            Logger.getLogger(Interface_image_par_imageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Image ImageRondelle = new Image(imagePath);
        ivImage.setImage(ImageRondelle);
    }
    
    @FXML 
    public void boutonOKAction(ActionEvent event) throws MalformedURLException{
        if(cbType.getSelectionModel().getSelectedItem() == "Rondelle")
        {
            parentController.setObjeticAjoueter("Rondelle");
            parentController.setOjbectifImage(ivImage.getImage());
            parentController.setImagePathObjectif(m_path);
            Stage stage = (Stage) boutonConfirmer.getScene().getWindow();
            stage.close();
        }      
        else
            if(cbType.getSelectionModel().getSelectedItem() == "Balle")
            {
                parentController.setObjeticAjoueter("Balle");
                parentController.setOjbectifImage(ivImage.getImage());
                parentController.setImagePathObjectif(m_path);
                Stage stage = (Stage) boutonConfirmer.getScene().getWindow();
                stage.close();
            }
            else
                if(cbType.getSelectionModel().getSelectedItem() == "Ballon")
                {
                    parentController.setObjeticAjoueter("Ballon");
                    parentController.setOjbectifImage(ivImage.getImage());
                    parentController.setImagePathObjectif(m_path);
                    Stage stage = (Stage) boutonConfirmer.getScene().getWindow();
                    stage.close();
                }
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
         if(selectedFile != null)
         {
            m_path = selectedFile.getPath();
         }
            File imageFile = new File(m_path);
            if (imageFile.exists()) {
                String imagepath = imageFile.toURI().toURL().toString();
                Image image = new Image(imagepath);
                ivImage.setImage(image);
         }
    }
    private void updateImage(String newValue) {
        switch (newValue){
            case ("Rondelle"):
                String imageRondelle = "src/Photo/rondelle.jpg";
                m_path = "src/Photo/rondelle.jpg";
                File imageFileRondelle = new File(imageRondelle);
                String imagepathRondelle = null;
                try {
                    imagepathRondelle = imageFileRondelle.toURI().toURL().toString();
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Interface_image_par_imageController.class.getName()).log(Level.SEVERE, null, ex);
                }
                Image ImageRondelle = new Image(imagepathRondelle);
                ivImage.setImage(ImageRondelle);
                break;
            case ("Balle"):
                String imageBalle = "src/Photo/balle.jpg";
                m_path = "src/Photo/balle.jpg";
                File imageFileBalle = new File(imageBalle);
                String imagepathBalle = null;
                try {
                    imagepathBalle = imageFileBalle.toURI().toURL().toString();
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Interface_image_par_imageController.class.getName()).log(Level.SEVERE, null, ex);
                }
                Image ImageBalle = new Image(imagepathBalle);
                ivImage.setImage(ImageBalle);                
                break;
            case("Ballon"):
                String imageBallon = "src/Photo/ballon.png";
                m_path = "src/Photo/ballon.png";
                File imageFileBallon = new File(imageBallon);
                String imagepathBallon = null;
                try {
                    imagepathBallon = imageFileBallon.toURI().toURL().toString();
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Interface_image_par_imageController.class.getName()).log(Level.SEVERE, null, ex);
                }
                Image ImageBallon = new Image(imagepathBallon);
                ivImage.setImage(ImageBallon);
                break;
        }
    }  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    } 
   
    
}
