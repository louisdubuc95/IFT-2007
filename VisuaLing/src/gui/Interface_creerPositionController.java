/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controller.VisuaLigueController;
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
 * @author antoinehudon
 */
public class Interface_creerPositionController implements Initializable {

    @FXML
    private TextField txtNom;
    @FXML
    private Button btnEnregistrer;
    @FXML
    private Button btnAnnuler;
    
    private Interface_CreerJoueurController parentController;
    public VisuaLigueController m_controller;

    
    public void initialize(Interface_CreerJoueurController parentController, VisuaLigueController m_controller)
    {
        this.parentController = parentController;
        this.m_controller = m_controller;
    }

    @FXML
    private void btnEnregistrerAction(ActionEvent event) {
        String nom_Position = txtNom.getText();
        Stage window = (Stage) btnEnregistrer.getScene().getWindow();
        try
        {
            m_controller.addPosition(nom_Position);
            parentController.addPositionComboBox(nom_Position);
            window.close();
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

    @FXML
    private void btnAnnulerAction(ActionEvent event) {
        Stage window = (Stage) btnAnnuler.getScene().getWindow();
        window.close();
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
