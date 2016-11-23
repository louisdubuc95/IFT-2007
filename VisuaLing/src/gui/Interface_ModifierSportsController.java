/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author willl
 */
public class Interface_ModifierSportsController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TextField txtNomIPI;
    @FXML
    private TextField txtNbEquipe;
    @FXML
    private Label lblCheminImage;
    @FXML
    private TextField txtDimensionX;
    @FXML
    private TextField txtDimensionY;
    @FXML
    public static String image;
    @FXML
    public Button btnModifier;
    @FXML
    public Button btnAnnuler;
    @FXML
    public Button btnParcourir;
    
    private Interface_image_par_imageController parentController;
    private String m_nom;
    private int m_nombreEquipe;
    private double m_x;
    private double m_y;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void initialize(Interface_image_par_imageController controller) {
        parentController = controller;
    }
    
    public void setTitle(String p_nom){
        m_nom = p_nom;
        txtNomIPI.setText(p_nom);
    }
    
    public void setNombreEquipe(int p_nombreEquipe){
        m_nombreEquipe = p_nombreEquipe;
        txtNbEquipe.setText(Integer.toString(p_nombreEquipe));
    }
    
    public void setX(double p_x){
        m_x = p_x;
        txtDimensionX.setText(Double.toString(p_x));
    }
    
    public void setY(double p_y){
        m_y = p_y;
        txtDimensionY.setText(Double.toString(p_y));
    }
    
    public void setImagePath(String p_imagePath)
    {
        lblCheminImage.setText(p_imagePath);
    }
    
    public void bouton_ModifierAction (ActionEvent event)throws IOException {
        Stage stage = (Stage) btnModifier.getScene().getWindow();
          if(txtNomIPI.getText().trim().isEmpty())
          {
              parentController.setTitle("Sans nom - mode Image par Image");
          }
          else
          {
              parentController.setTitle(txtNomIPI.getText() + " - mode Image par Image");
          }
          
          if(!txtNbEquipe.getText().matches("^[1-9][0-9]*$"))
          {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Information sur la création du sports");
            alert.setContentText("Le nombre d'équipe doit être un nombre entier et ne peut commencer par 0!");
            alert.showAndWait();
          }
          else
              if(!txtDimensionX.getText().matches("^[0-9]{1,10}([.,][0-9]{1,4})?$") && !txtDimensionY.getText().matches("^[0-9]{1,10}([.,][0-9]{1,4})?$") )
              {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText("Information sur la création du sports");
                alert.setContentText("Les dimensions doivent être des nombre décimaux (4 décimal après la virgule maximum)!");
                alert.showAndWait();
              }
                else
                  if(m_nombreEquipe > Integer.parseInt(txtNbEquipe.getText()))
                  {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information");
                    alert.setHeaderText("Information sur la création du sports");
                    alert.setContentText("Le nombre d'équipe maximum NE PEUT être inférieur aux nombre d'équipe précédament spécifier!");
                    alert.showAndWait();
                  }
                else
                {
                    //Appel la classe qui set l'image
                    parentController.setImageInterface(lblCheminImage.getText());
                    
                    int i = Integer.parseInt(txtNbEquipe.getText());
                    parentController.setNombreEquipeInterface(i);
                    
                    parentController.getX(txtDimensionX.getText());
                    parentController.getY(txtDimensionY.getText());

                    //Show la nouvelle window
                    stage.show();

                    //Ferme le window actuel
                    stage = (Stage) btnModifier.getScene().getWindow();
                    stage.close();
                }

    }
    
    //Accèdre au module parcourir image
    @FXML
      public void bouton_parcourirAction (ActionEvent event)throws IOException {
           Stage window = (Stage) btnParcourir.getScene().getWindow();
           FileChooser fileChooser = new FileChooser();
           fileChooser.setTitle("Choisir une image");
           fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Fichier image", "*.png", "*.jpg"));
           
           File selectedFile = fileChooser.showOpenDialog(window);
           if (selectedFile != null) {
               lblCheminImage.setText(selectedFile.toString());
           }
      }
    
    public void bouton_AnnluerAction (ActionEvent event){
        Stage window = (Stage) btnAnnuler.getScene().getWindow();
        window.close();
    }
    
}
