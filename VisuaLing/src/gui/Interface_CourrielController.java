/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import javafx.fxml.Initializable;
import java.awt.Desktop;
import java.io.IOException;
import java.util.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import org.omg.CORBA.PRIVATE_MEMBER;
import controller.VisuaLigueController;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.File;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.ToggleButton;
import java.text.SimpleDateFormat;
import javafx.scene.text.TextAlignment;
import java.util.*;
import java.awt.event.*;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.StageStyle;




/**
 * FXML Controller class
 *
 * @author stlau
 */
public class Interface_CourrielController implements Initializable {
    @FXML
    private Label FromLabel;
    @FXML
    private Label fichierLabel;
    @FXML
    private TextArea ToTextArea;
    @FXML
    private TextArea messageTextArea;
    @FXML
    private Button boutonEnvoyer;
    
     // File Name SendEmail.java
 
      // Recipient's email ID needs to be mentioned.
      String To;
      String From;


      
      String StringMessage;
      String pathFile;
      
      String username;
      String password;
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

    }
    
    public void setFile(String fichier)
    {
        
        pathFile = fichier;
        fichierLabel.setText(pathFile);
    }
    
    public void setExpediteur(String expediteur)
    {   
        username = expediteur;
        FromLabel.setText(expediteur);
    }
    
    public void setPassword(String mdp)
    {
        password = mdp;
    }
    
    private class SMTPAuthenticator extends javax.mail.Authenticator {
        public PasswordAuthentication getPasswordAuthentication() {
           String usr = username;
           String pass = password;
           return new PasswordAuthentication(usr, pass);
        }
    }
//
   
      
    public void sendMail() throws NoSuchProviderException{
        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "smtp.live.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.setProperty("mail.transport.protocol", "smtp");
    props.setProperty("mail.host", "smtp.live.com");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.auth", "true");

        Authenticator auth = new SMTPAuthenticator();
        Session mailSession = Session.getDefaultInstance(props, auth);
        Transport transport = mailSession.getTransport();
        try {
           // Create a default MimeMessage object.
           MimeMessage message = new MimeMessage(mailSession);
           // Set From: header field of the header.
           From = FromLabel.getText();
           message.setFrom(new InternetAddress(From));
           // Set To: header field of the header.
           To = ToTextArea.getText();
           String[] partiesObjet = To.split(",");
           for(String courriels : partiesObjet)
           {    
               message.addRecipient(Message.RecipientType.TO,new InternetAddress(courriels)); 
           }
           // Set Subject: header field
           message.setSubject("Votre entraineur vous a envoyé une stratégie par courriel à partir de VisuaLigue!");


           StringMessage = messageTextArea.getText();
           // Create the message part 
            BodyPart messageBodyPart = new MimeBodyPart();

            // Fill the message
            messageBodyPart.setText(StringMessage);
         
            // Create a multipar message
            Multipart multipart = new MimeMultipart();

            // Set text message part
            multipart.addBodyPart(messageBodyPart);

            // Part two is attachment
            messageBodyPart = new MimeBodyPart();
            String filename = fichierLabel.getText();
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filename);
            multipart.addBodyPart(messageBodyPart);

            // Send the complete message parts
            message.setContent(multipart);

           // Send message
            transport.connect();

           transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
           boutonEnvoyer.setText("Le courriel a été envoyé avec succès!");
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
           transport.close();
           Stage stage = new Stage(StageStyle.DECORATED);
           stage = (Stage) boutonEnvoyer.getScene().getWindow();
           stage.close();
           alert.setTitle("Information");
            alert.setHeaderText("Information sur le courriel");
            alert.setContentText("Le courriel a été envoyé avec succès!");
            alert.showAndWait();
        }
        catch (MessagingException mex) 
        {
           mex.printStackTrace();
        }
      }
    }
