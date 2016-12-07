/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author antoinehudon
 */
public class Interface_ConnexionUtilisateurController implements Initializable {

    @FXML
    private TextField txtNomUtilisateur;
    @FXML
    private Button btnConnexion;
    @FXML
    private PasswordField txtMotDePasse;
    @FXML
    private Label txtErreur;
    private String path = "src/savedUtilisateurs/utilisateurs.txt";
    private String pathVerif = "src/savedUtilisateurs/connecte.txt";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtErreur.setVisible(false);
    }    

    @FXML
    private void btnConnexionAction(ActionEvent event) throws IOException {
        String login = txtNomUtilisateur.getText();
        String mdp = txtMotDePasse.getText();
        boolean match = false;
        
        try 
        (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parties = line.split(";");
                if (login.equals(parties[0]) && mdp.equals(parties[1]))
                {
                    match = true;
                    break;
                }
            }
            
            if (!match)
            {
                txtErreur.setVisible(true);
            }
            else
            {
                try
                (PrintWriter writer = new PrintWriter(pathVerif)) {
                    writer.println(login);
                }
                
                Parent interface_accueil = FXMLLoader.load (getClass().getResource("Interface_accueil.fxml"));
                Scene Interface_choix_mode_scene = new Scene (interface_accueil); 
                Stage window = (Stage) btnConnexion.getScene().getWindow();
                window.setScene(Interface_choix_mode_scene);
                window.show();
            }
        }
    }
    
}
