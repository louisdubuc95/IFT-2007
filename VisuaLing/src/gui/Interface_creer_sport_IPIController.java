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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
/**
 * FXML Controller class
 *
 * @WL 
 */



public class Interface_creer_sport_IPIController implements Initializable {
    /**
     * Initializes the controller class.
     */
    
    @FXML //  fx:id= "boutonInterfaceImageParImage
    private javafx.scene.control.Button boutonCreerSportsIPI ;
    
    @FXML
    private javafx.scene.control.Button boutonChargerSportIPI;
    
    @FXML //  fx:id="boutonParcourirIPI"
    private javafx.scene.control.Button boutonParcourirIPI;
    
    @FXML //  fx:id="boutonParcourirIPI"
    private javafx.scene.control.Button boutonAnnulerSportsIMI;
    
    @FXML //  fx:id="boutonParcourirIPI"
    private TextField txtNomIPI;
    
    @FXML
    private TextField txtNbEquipe;
    
    @FXML
    private Label lblCheminImage;
    @FXML
    private TextField txtDimensionX;
    @FXML
    private TextField txtDimensionY;
    @FXML
    public static String image;
    
    @FXML
    private VBox content;
    @FXML
    private List<ToggleButton> listTB = new ArrayList<ToggleButton>();
     public VisuaLigueController m_controller = new VisuaLigueController();
    //Accéder a l'interface image par image 
    @FXML
      public void bouton_InterfaceImageParImageAction (ActionEvent event)throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("Interface_image_par_image.fxml"));
          Stage stage = new Stage(StageStyle.DECORATED);
          if(txtNomIPI.getText().trim().isEmpty())
          {
              stage.setTitle("Sans nom - mode Image par Image");
          }
          else
          {
              stage.setTitle(txtNomIPI.getText() + " - mode Image par Image");
          }
          
          stage.setScene(new Scene((AnchorPane) loader.load()));
          Interface_image_par_imageController IPIController = loader.<Interface_image_par_imageController>getController();
         
          
          if(!txtNbEquipe.getText().matches("^[1-9][0-9]*$"))
          {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Information sur la création du sports");
            alert.setContentText("Le nombre d'équipe doit être un nombre entier et ne peut commencer par 0!");
            alert.showAndWait();
          }
          else
              if(!txtDimensionX.getText().matches("^[0-9]{1,10}([.,][0-9]{1,4})?$"))
              {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText("Information sur la création du sports");
                alert.setContentText("Les dimensions doivent être des nombre décimaux (4 décimal après la virgule maximum)!");
                alert.showAndWait();
              }
              else
                if(!txtDimensionY.getText().matches("^[0-9]{1,10}([.,][0-9]{1,4})?$")){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information");
                    alert.setHeaderText("Information sur la création du sports");
                    alert.setContentText("Les dimensions doivent être des nombre décimaux (4 décimal après la virgule maximum)!");
                    alert.showAndWait();
                }
                    else
                    {
                        //Appel la classe qui set l'image
                        IPIController.setImageInterface(lblCheminImage.getText());

                        int i = Integer.parseInt(txtNbEquipe.getText());
                        IPIController.setNombreEquipeInterface(i);
                        
                        /*double p_dimensionX = Double.valueOf(txtDimensionX.getText());
                        
                        m_controller.setDimensionX(p_dimensionX);
                        double p_dimensionY = Double.valueOf(txtDimensionY.getText());
                        m_controller.setDimensionY(p_dimensionY);*/
                        IPIController.getX(txtDimensionX.getText());
                        IPIController.getY(txtDimensionY.getText());

                        //Sauvegarde sport dans fichier .txt
                        try
                        {
                            // Create file 
                            File file = new File("src/SavedSports/ImageParImage/"+txtNomIPI.getText()+".txt");
                            FileWriter fstream = new FileWriter(file);
                            BufferedWriter out = new BufferedWriter(fstream);
                            out.write(txtNomIPI.getText()+","+txtNbEquipe.getText()+","+txtDimensionX.getText()+","+
                                    txtDimensionY.getText()+","+lblCheminImage.getText());
                            //Close the output stream
                            out.close();
                        }

                        catch (Exception e){//Catch exception if any
                            System.err.println("Impossible de sauvegarder le sport: " + e.getMessage());
                            }

                        //Show la nouvelle window
                        stage.show();

                        //Ferme le window actuel
                        stage = (Stage) boutonCreerSportsIPI.getScene().getWindow();
                        stage.close();
                    }
      }
    
    //Accèdre au module parcourir image
    @FXML
      public void bouton_parcourirAction (ActionEvent event)throws IOException {
           Stage window = (Stage) boutonParcourirIPI.getScene().getWindow();
           FileChooser fileChooser = new FileChooser();
           fileChooser.setTitle("Choisir une image");
           fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Fichier image", "*.png", "*.jpg"));
           //File cheminDefault = new File("\\111129633_equipe18\\VisuaLing\\src\\Photo");
           //fileChooser.setInitialDirectory(cheminDefault);
           
           File selectedFile = fileChooser.showOpenDialog(window);
           if (selectedFile != null) {
               lblCheminImage.setText(selectedFile.toString());
           }
      }
      
    //Accèdre a l'interface précédante (choisir Mode)
    @FXML
    private void bouton_AnnulerAction (ActionEvent event) throws IOException {
        Parent interface_choix_mode_parent = FXMLLoader.load (getClass().getResource("Interface_choix_mode.fxml"));
        Scene interface_choix_mode_scene = new Scene (interface_choix_mode_parent); 
        Stage window = (Stage) boutonAnnulerSportsIMI.getScene().getWindow();
        window.setScene(interface_choix_mode_scene);
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
                    pathFichier = "src/savedSports/ImageParImage/"+pathFichier;
                    File file = new File(pathFichier);
                    Stage stage = new Stage(StageStyle.DECORATED);

                    stage.setTitle(file.getName());

                    stage.setScene(new Scene((AnchorPane) loader.load()));
                    Interface_image_par_imageController IPIController = loader.<Interface_image_par_imageController>getController();

                    //Appel la classe qui set l'image
                    
                    BufferedReader Buff = new BufferedReader(new FileReader(file));
                    String objet = Buff.readLine();
                    String[] partiesObjet = objet.split(",");
                    String nom = partiesObjet[0];
                    String nbEquipe = partiesObjet[1];
                    String X = partiesObjet[2];
                    String Y = partiesObjet[3];
                    String cheminImage = partiesObjet[4];

                    IPIController.setImageInterface(cheminImage);
                    IPIController.setNombreEquipeInterface(Integer.parseInt(nbEquipe));
                    IPIController.getX(X);
                    IPIController.getY(Y);
                    
                    
                    


                    //Show la nouvelle window
                    stage.show();

                    //Ferme le window actuel
                    stage = (Stage) boutonCreerSportsIPI.getScene().getWindow();
                    stage.close();
                }
            }     
    }
  
    
    
    @FXML
    private void afficherSauvegardes()
        {
        File folder = new File("src/savedSports/ImageParImage");
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

                  content.setPrefHeight(content.getPrefHeight() + TB.getPrefHeight());
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
