/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controller.VisuaLigueController;
import domain.Enregistrement;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
        m_parentController.m_enregistrement.serialize(txtNomSauvegarde.getText());
        Stage stage = (Stage) boutonSauvegarder.getScene().getWindow();
        stage.close();
    }
}
