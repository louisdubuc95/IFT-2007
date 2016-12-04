/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controller.VisuaLigueController;
import domain.Enregistrement;
import domain.equipe.Equipe;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
 import javafx.scene.image.Image;
 import javafx.scene.image.ImageView;
import javafx.scene.control.Button; 
import javafx.scene.control.*;// 
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
  
/**
 * FXML Controller class
 *
 * @author louis
 */
public class Interface_temps_reelController implements Initializable {

    
    @FXML private MenuItem exit ;
    @FXML private MenuItem menuChoixNouvSport ;
    @FXML private MenuItem menuChoixModifSport ;
    @FXML private ImageView imgSurface;
    @FXML private ToggleButton boutonAjouterJoueur;
    @FXML private ToggleButton boutonAjouterObstacle;
    @FXML private Button boutonAjouterEquipe;
    @FXML MenuBar menuBarSport;
    @FXML Canvas canevasInterface;
    @FXML private ToggleButton boutonObjectif ;
    
    @FXML private CheckBox cbJoueurMax;
    @FXML private TextField txtJoueurMax;
    @FXML private AnchorPane boiteverticale ; 
    
    @FXML ImageView imgsurface ;
        
    //coordonée
    @FXML private Label labelcoordonnee;
    @FXML private Label  coordonee ;
    
    @FXML private String imagePath;
    
    @FXML private Color color;
    private String m_equipe;
    private String m_role;
    private String m_position;
    private float m_orientation;
    private int m_nbEquipeMax;
    private double m_x;
    private double m_y;
    @FXML public List<String> listeRoles = new ArrayList<>();
    
    
    public VisuaLigueController m_controller = new VisuaLigueController();
    public Enregistrement m_enregistrement = new Enregistrement();
    
    public String typeUtilisateur;
    private String pathVerif = "src/savedUtilisateurs/connecte.txt";
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try 
        (BufferedReader br = new BufferedReader(new FileReader(pathVerif))) {
            String line;
            while ((line = br.readLine()) != null) {
                typeUtilisateur = line;
            }
        }   
        catch (IOException ex) {
            Logger.getLogger(Interface_image_par_imageController.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (!typeUtilisateur.equals("entraineur"))
        {
            boutonAjouterEquipe.setDisable(true);
            boutonAjouterJoueur.setDisable(true);
            boutonAjouterObstacle.setDisable(true);
            boutonObjectif.setDisable(true);
            menuChoixNouvSport.setDisable(true);
            menuChoixModifSport.setDisable(true);
            //btnNouvelleImage.setDisable(true);
            cbJoueurMax.setDisable(true);
            Pane p_joueur = new Pane();
            p_joueur.setLayoutX(0);
            p_joueur.setLayoutY(0);
            p_joueur.setMinHeight(537);
            p_joueur.setMinWidth(1083);
            //stackSurface.getChildren().add(p_joueur);
        }
    }  
    
    public void setTitle(String p_title)
    {
        Stage currentStage = (Stage) boiteverticale.getScene().getWindow();
        currentStage.setTitle(p_title);
    }
    

    public void getX(String dimensionX){
        //testDimensionX.setText(dimensionX); 
        m_x = Double.parseDouble(dimensionX); 
    }
    
    public void getY(String dimensionY){
        //testDimensionY.setText(dimensionY);
        m_y = Double.parseDouble(dimensionY);
    }
    
    @FXML
    public void nouveauSportAction(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("Interface_choix_mode.fxml"));
          Stage stage = new Stage(StageStyle.DECORATED);
          stage.setTitle("Nouveau Sport");
          stage.setScene(new Scene((AnchorPane) loader.load()));
          //Show la nouvelle window
          stage.show();
    }
    
    @FXML
    public void ChargerAction(ActionEvent event) throws IOException {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("Interface_accueil.fxml"));
      Stage stage = new Stage(StageStyle.DECORATED);
      stage.setTitle("Charger Jeu");
      stage.setScene(new Scene((AnchorPane) loader.load()));
      //Show la nouvelle window
      stage.show();
    }
    
    @FXML
    public void OuvrirInfoAction(ActionEvent event) throws IOException {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("Interface_InfoBox.fxml"));
      Stage stage = new Stage(StageStyle.DECORATED);
      stage.setTitle("Informations");
      stage.setScene(new Scene((AnchorPane) loader.load()));
      //Show la nouvelle window
      stage.show();
    }
    

    public void setNombreEquipeInterface(int nombreEquipe){
        m_nbEquipeMax = nombreEquipe;
    }
    

    public void setImageInterface(String imageSurface) throws IOException {
        imagePath = imageSurface;
        
        try {
            if(!imageSurface.equals("src/Photo/%5E28C212DFD9632524D061D9D53482CD908188A15004C1096E60%5Epimgpsh_mobile_save_distr.jpg"))
            {
                File imageFile = new File(imageSurface);
                if (imageFile.exists()) {
                    String imagepath = imageFile.toURI().toURL().toString();
                    Image image = new Image(imagepath);
                    imgsurface.setImage(image);
                    m_controller.setImageSurface(imagePath);
                    System.out.println("TEST");
                }
            }
            else
            {
                m_controller.setImageSurface("src/Photo/%5E28C212DFD9632524D061D9D53482CD908188A15004C1096E60%5Epimgpsh_mobile_save_distr.jpg");
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(Interface_temps_reelController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML 
    private void quitterJeu (ActionEvent event){
        Platform.exit();
    }
    
    @FXML
    public void ajouterJoueurAction(ActionEvent event) throws IOException {
        List<Equipe> listeEquipe = m_controller.getListEquipe();
        if(!listeEquipe.isEmpty())
        {
            List<String> ListeRoles = m_controller.getListeRole();
            List<String> ListePositions = m_controller.getListePosition();
            Stage stage = new Stage(StageStyle.DECORATED);
            FXMLLoader loader ;
            loader = new FXMLLoader(getClass().getResource("Interface_CreerJoueur.fxml"));
            Parent parent = (Parent) loader.load();
            Scene scene = new Scene(parent);
            stage.setTitle("Ajout Joueur");
            stage.setScene(scene);
            Interface_CreerJoueurController CreerJoueurController = loader.<Interface_CreerJoueurController>getController();
            CreerJoueurController.initializeTR(this);

            if (boutonAjouterJoueur.isSelected()){
              CreerJoueurController.setListeEquipe(listeEquipe);
              CreerJoueurController.setListRole(ListeRoles);
              CreerJoueurController.setListPosition(ListePositions);

              //Fonction qui bloque les window deriere la nouvelle
              Stage currentStage = (Stage) boiteverticale.getScene().getWindow();
              stage.initModality(Modality.WINDOW_MODAL);
              stage.initOwner(currentStage);

              stage.show();
              boutonObjectif.setDisable(true);
              boutonAjouterObstacle.setDisable(true);
              
            }
            if (!boutonAjouterJoueur.isSelected()){
               boutonObjectif.setDisable(false);
               boutonAjouterObstacle.setDisable(false);
            } 
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Information sur la création de joueur");
            alert.setContentText("Il faut créer des équipe avant de créer des joueurs");
            alert.showAndWait();
            boutonAjouterJoueur.setSelected(false);
        }

        
    }
    
    //Accèdre au module parcourir image
    @FXML
    public void bouton_ChangerSports (ActionEvent event)throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Interface_ModifierSports.fxml"));
        Parent parent = (Parent) fxmlLoader.load();

        Scene scene = new Scene(parent);
        stage.setScene(scene);

        Interface_ModifierSportsController controller = fxmlLoader.<Interface_ModifierSportsController>getController();
        Stage currentStage = (Stage) boiteverticale.getScene().getWindow();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(currentStage);
        String title = currentStage.getTitle();
        title = title.replaceAll(" - mode Temps Reel", "");
        controller.setTitle(title);
        controller.setNombreEquipe(m_nbEquipeMax);
        controller.setX(m_x);
        controller.setY(m_y);
        controller.setImagePath(imagePath);
        controller.initializeTR(this);
        stage.show();

    }
    
    @FXML
    private void ajouterObstacleAction(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifObstacle.fxml"));
          Stage stage = new Stage(StageStyle.DECORATED);
          stage.setTitle("Ajout obstacle");
          stage.setScene(new Scene((AnchorPane) loader.load()));
         if (boutonAjouterObstacle.isSelected()){
          stage.show();
          boutonObjectif.setDisable(true);
          boutonAjouterJoueur.setDisable(true);
        }
        if (!boutonAjouterObstacle.isSelected()){
           boutonObjectif.setDisable(false);
           boutonAjouterJoueur.setDisable(false);
           stage.close();
        }  
         
    }
    @FXML
    public void ajouterObstacleInterface (){
        
    }
    
    @FXML 
    public void ajouterObjectifInterface (){
        
    }
    @FXML public void ajouterObjectifButton (ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("Interface_CreerObjectif.fxml"));
          Stage stage = new Stage(StageStyle.DECORATED);
          stage.setTitle("Ajout objectif");
          stage.setScene(new Scene((AnchorPane) loader.load()));
         if (boutonObjectif.isSelected()){
          stage.show();
          boutonAjouterJoueur.setDisable(true);
          boutonAjouterObstacle.setDisable(true);
        }
        if (!boutonObjectif.isSelected()){
           boutonAjouterJoueur.setDisable(false);
            boutonAjouterObstacle.setDisable(false);
            stage.close();
        }  
    }
    
      /*@FXML
      public void bouton_ChangerSports (ActionEvent event)throws IOException {
        Stage window = (Stage) menuBarSport.getScene().getWindow();
           FileChooser fileChooser = new FileChooser();
           fileChooser.setTitle("Choisir une image");
           fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Fichier image", "*.png", "*.jpg"));
           
           File selectedFile = fileChooser.showOpenDialog(window);
           if (selectedFile != null) {
               String path = selectedFile.getPath();
               imagePath = path;
               setImageInterface(path);
           }
      }*/
      
      @FXML
      public void bouton_changerMode (ActionEvent event)throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("Interface_image_par_image.fxml"));
          Stage Window = (Stage) menuBarSport.getScene().getWindow();
          Stage stage = new Stage(StageStyle.DECORATED);
          String titreWindow = Window.getTitle();
          titreWindow = titreWindow.replaceAll(" - mode Temps Reel", "");
          titreWindow = titreWindow + " - mode Image par Image";
          stage.setTitle(titreWindow);
          stage.setScene(new Scene((AnchorPane) loader.load()));
          Interface_image_par_imageController IPIController = loader.<Interface_image_par_imageController>getController();
          
          //Appel la classe qui set l'image
          IPIController.setImageInterface(imagePath);
          
          //Show la nouvelle window
          stage.show();
          
          //Ferme le window actuel
          stage = (Stage) menuBarSport.getScene().getWindow();
          stage.close();
      }
    
    @FXML
    private void sauvegarderAction(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("Interface_Sauvegarde.fxml"));
          Stage stage = new Stage(StageStyle.DECORATED);
          stage.setTitle("Sauvegarder");
          stage.setScene(new Scene((AnchorPane) loader.load()));
          
          //Show la nouvelle window
          stage.show();
    }
    
    @FXML 
    public void ajouterJoueurInterface() throws IOException {
        
       canevasInterface.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override public void handle(MouseEvent event){
                   if(boutonAjouterJoueur.isSelected()){
                    GraphicsContext gc = canevasInterface.getGraphicsContext2D();
                    gc.setFill(color);
                    gc.fillOval(event.getX(),event.getY(),20,20);
                   } 
                }
         });
       
    }
    
    
    public void addRoleToList(String Role)
    {
        boolean present = false;
        for (String item : listeRoles) {
            if(item.equals(Role))
            {
                present = true;
            }           
        }
        if(false == present)
        {        
            listeRoles.add(Role);
        }   
    }
    
    
    
    public void setEquipe(String p_equipe) {
        m_equipe= p_equipe;
    }
    
    public void setRole(String p_role) {
        m_role= p_role;
    }
    
    public void setPosition(String p_position) {
        m_position = p_position;
    }
    
    public void setOrientation(float p_orientation) {
        m_orientation = p_orientation;
    }
    
    @FXML
    public void cb_maxJoueur (ActionEvent event) throws IOException {
        if(cbJoueurMax.isSelected())
        {
            txtJoueurMax.setDisable(false);
        }
        else
        {
            txtJoueurMax.setDisable(true);
        }
    }
    
       @FXML
    public void ajouterEquipeAction(ActionEvent event) throws IOException {
        if(m_controller.getListEquipe().size() == m_nbEquipeMax)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Information sur la création des équipes");
            alert.setContentText("Vous avez atteint la limite du nombre d'équipe");
            alert.showAndWait();
        }
        else
        {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Interface_creerEquipe.fxml"));
            Parent parent = (Parent) fxmlLoader.load();

            Scene scene = new Scene(parent);
            stage.setScene(scene);

            Interface_creerEquipeController controller = fxmlLoader.<Interface_creerEquipeController>getController();
            controller.initializeTR(this);
            stage.show();
        }
    }
  
    /*@FXML
    public void coordonnee_interface (){
        coordonee.setOnMouseMoved(new EventHandler<MouseEvent>() {
      @Override public void handle(MouseEvent event) {
          // 1056 (nb de pixel de largeur) / 18.57 = 60.96m (grandeur patinoire nhl) 
          // 537  (nb de pixel de hauteur  / 20.73 = 25.8m (grandeur patinoire ngl)
          // on va remplacer la grandeur par les parametres entré par l'utilisateur.
          //je suis pas certain si je peux mettre ca ici ou il faut que ce soit dans le controleur de larman. 
          // et je sais pas trop comment limité au centième...ca reste a voir
        String msg = "X : "       + event.getX()/17.32      + " Y : "       + event.getY()/20.73;
        labelcoordonnee.setText(msg);
        }
    });
    }
    //Lamnbda expression "->" c'est la même chose que la fonction coordonee_interface. C'est juste plus rapide codé comme ça 
    //lorsque l'utilisateur sort la souris de l'interface de jeu, remet le conteur a zero. 
   @FXML
   public void sortieInterface () {
      coordonee.setOnMouseExited((MouseEvent) -> {
          String msg = "X : 0"+", Y : 0";
          labelcoordonnee.setText(msg);
      });
   }*/
}
