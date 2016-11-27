/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controller.VisuaLigueController;
import domain.Enregistrement;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author willl
 */
public class Interface_SauvegardeController implements Initializable {
    @FXML Button boutonAnnuler;
    @FXML Button boutonSauvegarder;
    @FXML Button boutonExporter;
    @FXML Button boutonCharger;
    @FXML TextField txtNomSauvegarde;
    
    private Interface_image_par_imageController m_parentController;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void initialize(Interface_image_par_imageController p_controller) {
       m_parentController = p_controller;
    }
    
    @FXML
    public void boutonAnnulerAction(ActionEvent event) {
          Stage stage = (Stage) boutonAnnuler.getScene().getWindow();
          stage.close();
    }
    
    @FXML
    public void boutonExporterAction(ActionEvent event) {
        Stage stage = (Stage) boutonExporter.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    public void boutonEnregistrerAction(ActionEvent even){
        String validateDot = txtNomSauvegarde.getText();
        if(validateDot.isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Information sur la sauvegarde");
            alert.setContentText("Le fichier de sauvegarde doit avoir un nom!!");
            alert.showAndWait();
        }
        else
        {
            if(validateDot.contains("."))
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText("Information sur la sauvegarde");
                alert.setContentText("Le nom de la sauvegarde ne peut contenir de POINT");
                alert.showAndWait();
            }

            m_parentController.m_enregistrement.serialize(validateDot, m_parentController.m_controller.getController());
            Stage stage = (Stage) boutonSauvegarder.getScene().getWindow();
            stage.close();    
        }
    }
    
    public void setMaxJoueur(int p_nbJoueurMax)
    {
        m_parentController.m_controller.setJoueurMax(p_nbJoueurMax);
    }
}
