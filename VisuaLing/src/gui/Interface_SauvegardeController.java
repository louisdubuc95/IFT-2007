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
    
    private Enregistrement m_Enregistrement = new Enregistrement();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
        m_Enregistrement.serialize();
        Stage stage = (Stage) boutonSauvegarder.getScene().getWindow();
        stage.close();
    }
    
}
