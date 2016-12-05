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
import java.util.Arrays;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author antoinehudon
 */
public class Interface_CreerObstacleController implements Initializable {

    @FXML private Button boutonAnnuler;
    @FXML private Button boutonParcourir;
    @FXML private Button boutonOk;
    @FXML private ImageView ivImage;
    @FXML private ListView listviewList;
    @FXML private TextField txtNom;
    @FXML private TextField txtHauteur;
    @FXML private TextField txtLargeur;
    
    @FXML private String m_path = "";
    
    private Interface_image_par_imageController parentController;
    private Interface_temps_reelController parentControllerTR;
    public VisuaLigueController m_controller;
    
    
    /**
     * Initializes the controller class.
     */
        //TR
    public void initializeTR(Interface_temps_reelController controller) {
        parentControllerTR = controller;
        m_controller = parentControllerTR.m_controller;
        
        String image = "src/Photo/cone.jpg";
        File imageFile = new File(image);
        String imagePath = null;
        try {
            imagePath = imageFile.toURI().toURL().toString();
        } catch (MalformedURLException ex) {
            Logger.getLogger(Interface_image_par_imageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Image ImageCone = new Image(imagePath);
        ivImage.setImage(ImageCone);        
    }
    
    //IPI
    public void initialize(Interface_image_par_imageController controller) {
        parentController = controller;
        m_controller = parentController.m_controller;
        
        String image = "src/Photo/cone.jpg";
        File imageFile = new File(image);
        String imagePath = null;
        try {
            imagePath = imageFile.toURI().toURL().toString();
        } catch (MalformedURLException ex) {
            Logger.getLogger(Interface_image_par_imageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Image ImageCone = new Image(imagePath);
        ivImage.setImage(ImageCone);         
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML 
    public void boutonOkAction(ActionEvent event) throws MalformedURLException{
          if(!txtHauteur.getText().matches("^[1-9][0-9]*$"))
          {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Information sur la création du sports");
            alert.setContentText("La hauteur doit être un nombre entier et ne peut commencer par 0!");
            alert.showAndWait();
          }
          else
              if(!txtLargeur.getText().matches("^[1-9][0-9]*$"))
              {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText("Information sur la création du sports");
                alert.setContentText("La largeur doit être un nombre entier et ne peut commencer par 0!");
                alert.showAndWait();
              }
          else
              {
                parentController.setImageObstacle(ivImage.getImage());
                int x = Integer.parseInt(txtLargeur.getText());
                int y = Integer.parseInt(txtHauteur.getText());
                parentController.setDimensionObstacle(x,y);
                parentController.setImagePathObstacle(m_path);
                Stage stage = (Stage) boutonOk.getScene().getWindow();
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
         m_path = selectedFile.getPath();
         System.out.println(m_path);
         File imageFile = new File(m_path);
            if (imageFile.exists()) {
                String imagepath = imageFile.toURI().toURL().toString();
                Image image = new Image(imagepath);
                ivImage.setImage(image);
         }
    }
}
