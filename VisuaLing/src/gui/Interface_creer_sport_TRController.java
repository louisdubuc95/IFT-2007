/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.FileChooser;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author louis
 */
public class Interface_creer_sport_TRController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML 
    private javafx.scene.control.Button boutonInterfaceTempsReel ;
    @FXML
    private Button boutonAnnulerTR;
    @FXML
    private TextField txtNomSportsTR;
    
    @FXML
    private javafx.scene.control.Button boutonChargerSportTR;
    
    @FXML
    private TextField txtNbEquipe;
    
    @FXML
    private TextField txtDimensionX;
    @FXML
    private TextField txtDimensionY;
    @FXML
    private Button boutonParcourirTR;
    @FXML
    private Label lblCheminImage;
    @FXML
    private VBox content;
    @FXML
    private List<ToggleButton> listTB = new ArrayList<ToggleButton>();
    
    //Accéder a l'interface pour créer une séquence en temps réel
    public void bouton_InterfaceTempsReelAction (ActionEvent event)throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("Interface_temps_reel.fxml"));
          Stage stage = new Stage(StageStyle.DECORATED);
          if(txtNomSportsTR.getText().trim().isEmpty())
          {
              stage.setTitle("Sans nom - mode Temps Reel");
          }
          else
          {
              stage.setTitle(txtNomSportsTR.getText() + " - mode Temps Reel");
          }
          stage.setScene(new Scene((AnchorPane) loader.load()));
          Interface_temps_reelController TRcontrolleur = loader.<Interface_temps_reelController>getController();
          
          //Appel la classe qui set l'image
          TRcontrolleur.setImageInterface(lblCheminImage.getText());
          
          //Show la nouvelle window
          stage.show();
          
          //Ferme le window actuel
          stage = (Stage) boutonInterfaceTempsReel.getScene().getWindow();
          stage.close();
         
          
          
            //Sauvegarde sport dans fichier .txt
            try
            {
                    // Create file 
                    File file = new File("src/savedSports/TempsReel/"+txtNomSportsTR.getText()+".txt");
                    FileWriter fstream = new FileWriter(file);
                    BufferedWriter out = new BufferedWriter(fstream);
                    out.write(txtNomSportsTR.getText()+","+txtNbEquipe.getText()+","+txtDimensionX.getText()+","+
                            txtDimensionY.getText()+","+lblCheminImage.getText());
                    //Close the output stream
                    out.close();
                }

            catch (Exception e){//Catch exception if any
                    System.err.println("Impossible de sauvegarder le sport: " + e.getMessage());
                    }
    }
    
    //Accèdre au module parcourir image
    @FXML
    public void bouton_parcourirAction (ActionEvent event)throws IOException {
         Stage window = (Stage) boutonParcourirTR.getScene().getWindow();
         FileChooser fileChooser = new FileChooser();
         fileChooser.setTitle("Choisir une image");
         fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Fichier image", "*.png", "*.jpg"));
           
         File selectedFile = fileChooser.showOpenDialog(window);
         if (selectedFile != null) {
             lblCheminImage.setText(selectedFile.toString());
         }
    }
    
    //Retourner a la fenêtre précédente
    @FXML
    private void bouton_AnnulerAction (ActionEvent event) throws IOException {
        Parent Interface_choix_mode_parent = FXMLLoader.load (getClass().getResource("Interface_choix_mode.fxml"));
        Scene Interface_choix_mode_scene = new Scene (Interface_choix_mode_parent); 
        Stage window = (Stage) boutonAnnulerTR.getScene().getWindow();
        window.setScene(Interface_choix_mode_scene);
        window.show();
    }
    
    @FXML
    private void bouton_Charger (ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Interface_image_par_image.fxml"));

            for(ToggleButton TB: listTB)
            {
                if(TB.isSelected())
                {
                    String s = TB.getText();
                    String[] partiesPath = s.split("\n");
                    String pathFichier = partiesPath[0];
                    pathFichier = pathFichier.replaceAll("\tNom du fichier  :  ", "");
                    pathFichier = "src/savedSports/TempsReel/"+pathFichier;
                    File file = new File(pathFichier);
                    Stage stage = new Stage(StageStyle.DECORATED);

                    stage.setTitle(file.getName());

                    stage.setScene(new Scene((AnchorPane) loader.load()));
                    Interface_image_par_imageController IPIController = loader.<Interface_image_par_imageController>getController();

                    //Appel la classe qui set l'image
                    
                    BufferedReader Buff = new BufferedReader(new FileReader(file));
                    String objet = Buff.readLine();
                    String[] partiesObjet = objet.split(",");
                    String image = partiesObjet[4];
                    String X = partiesObjet[2];
                    String Y = partiesObjet[3];
                    IPIController.setImageInterface(image);
                    IPIController.getX(X);
                    IPIController.getY(Y);


                    //Show la nouvelle window
                    stage.show();

                    //Ferme le window actuel
                    stage = (Stage) boutonChargerSportTR.getScene().getWindow();
                    stage.close();
                }
            }     
    }
    
    

    @FXML
    private void afficherSauvegardes()
    {
    File folder = new File("src/savedSports/TempsReel");
    File[] listOfFiles = folder.listFiles();
    
   
    for (File file : listOfFiles) {
      String extension = ".txt";
      if (file.getAbsolutePath().endsWith(extension)) {
            try {
                BufferedReader Buff = new BufferedReader(new FileReader(file));
                String text = Buff.readLine();
                String[] parts = text.split(",");
                String nom = parts[0];
                String path = parts[4];
                Image imageSport = new Image("file:"+path);
                ImageView IV = new ImageView();
                IV.setImage(imageSport);
                IV.setFitHeight(80.0);
                IV.setFitWidth(125.0);
                ToggleButton TB = new ToggleButton(file.getName());
  
                TB.setOnAction(updateButtonHandler);

                TB.setMinHeight(100);
                TB.setMinWidth(625);
                SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/DD HH:mm:ss");
                TB.setText("\tNom du fichier  :  "+ file.getName() + "\n" + "\tNom du sport : " + nom + "\n" + "\tDerniere modification  :  "
                        +sdf.format(file.lastModified())
                        + "\n" + "\tTaille  :  " + file.length() + " octets");
                Insets insets = new Insets(0,0,0,75);
                TB.setPadding(insets);
                TB.setGraphic(IV);
                TB.setGraphicTextGap(-550);
                listTB.add(TB);
                content.getChildren().add(TB);
            }
            catch (IOException ex) {
                Logger.getLogger(Interface_creer_sport_IPIController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
      }
    
    }
    
    
    
    EventHandler<ActionEvent> updateButtonHandler = new EventHandler<ActionEvent>() 
    {
        @Override
        public void handle(ActionEvent event) {
            ToggleButton source = (ToggleButton)event.getSource();
            if(!source.isSelected())
            {
                for (ToggleButton button : listTB) 
                {
                    button.setDisable(false);
                }
            }
            else{
                for (ToggleButton button : listTB) 
                {
                 button.setDisable(!button.isSelected());
                }
            }

        }
    };
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficherSauvegardes();
    }    
    
}
