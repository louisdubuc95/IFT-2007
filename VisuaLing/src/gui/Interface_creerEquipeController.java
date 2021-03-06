/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.sun.java.swing.plaf.windows.resources.windows;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.*;
import gui.Interface_image_par_imageController;
import gui.Interface_temps_reelController;

/**
 * FXML Controller class
 *
 * @author antoinehudon
 */
public class Interface_creerEquipeController implements Initializable {

    @FXML
    private ColorPicker color_choix;
    @FXML
    private TextField txt_nom;
    @FXML
    private Button btn_enregistrer;
    @FXML
    private Button btn_annuler;
    
    private Interface_image_par_imageController parentController;
    private Interface_temps_reelController parentControllerTR;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    
    public void initialize(Interface_image_par_imageController controller) {
        parentController = controller;
    }
    
    public void initializeTR(Interface_temps_reelController controller) {
        parentControllerTR = controller;
    }

    @FXML
    private void enregistrer_equipe(ActionEvent event) {
        if(txt_nom.getText().isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Information sur l'équipe");
            alert.setContentText("L'équipe doit avoir un nom!");
            alert.showAndWait();
        }
        else
        {
        String nom_equipe = txt_nom.getText();
        Color couleur_equipe = color_choix.getValue();
        Stage window = (Stage) btn_enregistrer.getScene().getWindow();
            try
            {
                java.awt.Color awtColor = new java.awt.Color((float) couleur_equipe.getRed(),
                (float) couleur_equipe.getGreen(),
                (float) couleur_equipe.getBlue(),
                (float) couleur_equipe.getOpacity());
                try
                {
                parentController.m_controller.addEquipe(nom_equipe, awtColor);
                window.close();
              
                }
                catch(NullPointerException e)
                {
                    parentControllerTR.m_controller.addEquipe(nom_equipe, awtColor);
                    window.close();
                }
                
            }
            catch(Exception e)
            {
                String message = e.getMessage();
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText(null);
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        }
    }

    @FXML
    private void annuler_(ActionEvent event) {
        Stage window = (Stage) btn_annuler.getScene().getWindow();
        window.close();
    }
    
}
