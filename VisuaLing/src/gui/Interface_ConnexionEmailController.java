/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.security.Security;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;

/**
 * FXML Controller class
 *
 * @author stlau
 */
public class Interface_ConnexionEmailController implements Initializable {
    @FXML
    public TextField email;
    
    @FXML
    public Label fileLabel;
    @FXML
    public PasswordField mdp;
    
    @FXML
    public Button connexion;
    
    
    public String id;
    public String passwd;
    
    public String pathConnexion;
    
    @FXML
    private Label erreur;
   
    
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    
    public void setFile(String fichier)throws IOException {
        pathConnexion = fichier;
    }
    
    private void smtp() throws NoSuchProviderException, MessagingException      
    {   
    String host = "smtp.live.com";
    String username = email.getText();
    String password = mdp.getText();
    Properties props = new Properties();
    props.put("mail.smtp.auth", "true");
    props.put("mail.smpt.host", "smtp.live.com");
    props.put("mail.smtp.port", "587");
    props.put("mail.smtp.starttls.enable", "true");

    Session session = Session.getInstance(props, null);
    try {
        Transport transport = session.getTransport("smtp");
        try {
            transport.connect("smtp.live.com", username, password);
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
    } catch (NoSuchProviderException ex) {
        ex.printStackTrace();
    }
    
    }

    

    @FXML
    private void connexion(ActionEvent event)throws IOException{
    try{
        smtp();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Interface_Courriel.fxml"));
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene((AnchorPane) loader.load()));
        Interface_CourrielController CourrielController = loader.<Interface_CourrielController>getController();
        
            id = email.getText();
            passwd = mdp.getText();
            CourrielController.setExpediteur(id);
            CourrielController.setPassword(passwd);
            CourrielController.setFile(pathConnexion);
            stage.show();

            //Ferme le window actuel
            stage = (Stage) connexion.getScene().getWindow();
            stage.close();
    }
    catch(MessagingException e){
        erreur.setText("Mauvais nom d'utilisateur ou mot de passe. ");
        
        
    }
    
            
        }
    
}
