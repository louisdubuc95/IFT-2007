/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import domain.equipe.Equipe;
import java.awt.Point;
import java.io.IOException;
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
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;



/**
 * FXML Controller class
 *
 * @author stlau
 */
public class Interface_CreerJoueurController implements Initializable {
    
    @FXML private Button boutonAnnuler;
    @FXML private Button boutonAccepter;
    @FXML private ComboBox cbEquipe;
    @FXML private AnchorPane anchorPane;
    
    @FXML private Color color;
    @FXML private Point t ; 
    
    private Interface_image_par_imageController parentController;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        List<Equipe> listeEquipe = parentController.m_controller.getListEquipe();
//        int compteurEquipe = 0;
//         
//        Iterator<Equipe> iterateur = listeEquipe.iterator();
//        while(iterateur.hasNext())
//        {
//            Equipe equipe = iterateur.next();
//            String nomEquipe = equipe.getNom();
//            String couleurEquipe = equipe.getCouleur().toString();
//            cbEquipe.getItems().addAll(nomEquipe + "(" + couleurEquipe +")");
//        } 
    }
    
    public void initialize(Interface_image_par_imageController controller) {
        parentController = controller;

    }
    
    @FXML
    public void boutonAnnulerAction(ActionEvent event) {
          Stage stage = (Stage) boutonAnnuler.getScene().getWindow();
          stage.close();
          //Interface_image_par_imageController.boutonObjectif.setDisable(false);         
    } 
    
    @FXML
    public void boutonAccepterAction(ActionEvent event) throws IOException {
        
        Stage window = (Stage) boutonAccepter.getScene().getWindow();
        window.close();
    }
    
    @FXML public void setListeEquipe(List<Equipe> p_listeEquipe){
        
    }
//    @FXML
//    public void ouvertureWindow(){
//        Stage stage = (Stage) anchorPane.getScene().getWindow();
//        stage.addEventHandler(WindowEvent.WINDOW_SHOWING, new  EventHandler<WindowEvent>()
//        {
//            public void handle(WindowEvent window)
//            {
//                System.out.println("test");
//            }
//        });
//    }
}
