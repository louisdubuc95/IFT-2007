/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.sun.java.swing.plaf.windows.resources.windows;
import controller.VisuaLigueController;
import domain.equipe.Equipe;
import java.awt.Point;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import javax.xml.bind.DatatypeConverter;
import gui.Interface_image_par_imageController;
import java.awt.event.ItemEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import javafx.scene.Parent;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import gui.Interface_CreerJoueurController;
import gui.Interface_creerPositionController;



/**
 * FXML Controller class
 *
 * @author stlau
 */
public class Interface_CreerJoueurController implements Initializable {
    
    @FXML private ComboBox cbRole;
    @FXML private ComboBox cbPosition;
    @FXML private ComboBox cbEquipe;
    
    @FXML private TextField txtOrientation;

    @FXML private Button btnAnnuler;
    @FXML private Button btnEnregistrer;
    @FXML private Button btnAddRole;
    @FXML private Button btnAddPosition;
    
    //@FXML private ComboBox cbEquipe;
    //@FXML private ComboBox rolePreceCrees;
    //@FXML private AnchorPane anchorPane;
    //@FXML private TextField txtRole;
    //@FXML private TextField txtPosition;
    
    @FXML private Point t ; 
    
    private List<String> listeRoles = new ArrayList<>();
    private List<String> listePositions = new ArrayList<>();
    private List<Equipe> listeEquipe = new ArrayList<>();
    
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
        txtOrientation.setText("0");
    }
    
    //IPI
    public void initialize(Interface_image_par_imageController controller) {
        parentController = controller;
        m_controller = parentController.m_controller;
        txtOrientation.setText("0");
    }
    
    @FXML
    public void btnAnnulerAction(ActionEvent event) {
        Stage stage = (Stage) btnAnnuler.getScene().getWindow();
        stage.close();        
    } 

    @FXML
    public void setListRole(List<String> p_listeRole)
    {
        listeRoles = p_listeRole;
        if(!(listeRoles.isEmpty()))
        {
            ObservableList<String> OlisteRoles = FXCollections.observableList(listeRoles);
            cbRole.getItems().addAll(OlisteRoles);
            cbRole.getSelectionModel().selectFirst();
        }
    }
    
    @FXML
    public void setListPosition(List<String> p_listePosition)
    {
        listePositions = p_listePosition;
        if(!(listePositions.isEmpty()))
        {
            ObservableList<String> OlisteRoles = FXCollections.observableList(listePositions);
            cbPosition.getItems().addAll(OlisteRoles);
            cbPosition.getSelectionModel().selectFirst();
        } 
    }
    
    @FXML 
    public void setListeEquipe(List<Equipe> p_listeEquipe) throws UnsupportedEncodingException {
        Iterator<Equipe> iterateur = p_listeEquipe.iterator();
        while(iterateur.hasNext())
        {
            Equipe equipe = iterateur.next();
            String nomEquipe = equipe.getNom();
            cbEquipe.getItems().add(nomEquipe);
        }
        cbEquipe.getSelectionModel().selectFirst();
    }
    
    public void addRoleComboBox(String role)
    {
        cbRole.getItems().add(role);
        cbRole.getSelectionModel().selectFirst();
    }
    
    public void addPositionComboBox(String position)
    {
        cbPosition.getItems().add(position);
        cbPosition.getSelectionModel().selectFirst();
    }
    
    @FXML
    public void btnAddRoleAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Interface_creerRole.fxml"));
        Parent parent = (Parent) fxmlLoader.load();

        Scene scene = new Scene(parent);
        stage.setScene(scene);

        Interface_creerRoleController controller = fxmlLoader.<Interface_creerRoleController>getController();
        controller.initialize(this, m_controller);
        stage.show();
    }
    
    @FXML
    public void btnAddPositionAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Interface_creerPosition.fxml"));
        Parent parent = (Parent) fxmlLoader.load();

        Scene scene = new Scene(parent);
        stage.setScene(scene);

        Interface_creerPositionController controller = fxmlLoader.<Interface_creerPositionController>getController();
        controller.initialize(this, m_controller);
        stage.show();
    }
    
    @FXML
    public void btnEnregistrerAction(ActionEvent event) throws IOException {
        if(cbRole.getSelectionModel().getSelectedItem() == null)
        {
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Erreur");
                        alert.setHeaderText("Erreur sur la création de joueur");
                        alert.setContentText("Vous devez entrer un role de joueur!");
                        alert.showAndWait();
        }
        else
            if(cbPosition.getSelectionModel().getSelectedItem() == null){
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Erreur");
                        alert.setHeaderText("Erreur sur la création de joueur");
                        alert.setContentText("Vous devez entrer une poisition de joueur!");
                        alert.showAndWait();
            }
            else
            {
                String role = cbRole.getSelectionModel().getSelectedItem().toString();
                String position = cbPosition.getSelectionModel().getSelectedItem().toString();
                String equipe = cbEquipe.getSelectionModel().getSelectedItem().toString();
                
                String orientation = txtOrientation.getText();
                float orientation_float = orientation_conversion(orientation);
                if (orientation_float != -1000)
                {
                    Stage window = (Stage) btnEnregistrer.getScene().getWindow();
                    try
                    {
                        try{


                        parentController.setEquipe(equipe);
                        parentController.setRole(role);
                        parentController.setPosition(position);
                        parentController.setOrientation(360-orientation_float);
                        window.close();
                        }
                        catch(NullPointerException e)
                        {
                        parentControllerTR.setEquipe(equipe);
                        parentControllerTR.setRole(role);
                        parentControllerTR.setPosition(position);
                        parentControllerTR.setOrientation(360-orientation_float);
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
    }
    
    public float orientation_conversion(String orientation)
    {
        try {
            float orientation_float = Float.parseFloat(orientation);
            if (orientation_float < 0 || orientation_float > 360)
                throw new Exception();
            return orientation_float;
        }
        catch(Exception e)
        {
            String message = e.getMessage();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Vous devez entrer une orientation comprise entre 0 et 360");
            alert.showAndWait();
        }
        
        return -1000;
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {    

    }
}
