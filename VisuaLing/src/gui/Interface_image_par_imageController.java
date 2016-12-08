/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

//Git

import controller.VisuaLigueController;
import domain.Enregistrement;
import domain.equipe.Equipe;
import domain.joueur.Joueur;
import domain.obstacle.Objectif;
import domain.obstacle.Obstacle;
import java.awt.Point;
import java.awt.event.WindowEvent;
import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.PauseTransition;
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
import javafx.scene.shape.*;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.chart.NumberAxis;
import javafx.scene.effect.Effect;
import javafx.scene.effect.SepiaTone;
import javafx.scene.input.ScrollEvent;
import javafx.scene.input.SwipeEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.*;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import javafx.scene.image.ImageView ;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox ;  
import javafx.scene.effect.Effect.*;
import javafx.concurrent.*;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.WritableImage;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author louis
 */
public class Interface_image_par_imageController implements Initializable {
    


    @FXML private ImageView imgSurface;
    @FXML private Button boutonQuitter ;
    @FXML private ToggleButton boutonAjouterJoueur; 
    @FXML private Button boutonAjouterEquipe;
    @FXML private ToggleButton boutonObjectif;
    
    
    
    
    
    
    private Service service;

   
    //@FXML private Boolean VerifAjoutJoueur = false;

   
    @FXML private ToggleButton boutonAjouterObstacle;
    @FXML private Button boutonSauvegarder;
    @FXML private Button boutonChangerSports;
    @FXML MenuBar menuBarSport;
    @FXML private MenuItem menuChoixNouvSport;
    @FXML private MenuItem menuChoixModifSport;
    @FXML private MenuItem btnNouvelleImage;
    
    @FXML private MenuItem undo;
    @FXML private MenuItem redo;
    
    
    @FXML private CheckBox cbJoueurMax;
    @FXML private TextField txtJoueurMax;
    @FXML public Pane conteneurJoueur;
    @FXML private CheckBox afficherRPJoueur;
    @FXML private boolean desafficherRPJoueur;
    @FXML ImageView imgsurface ;
    
    @FXML private Button boutonRecommencer ;
    @FXML private Button boutonDebuter;
    @FXML private Button boutonPause;
    private boolean onPause;
    
    private Joueur joueurCourant;
    private Color couleurCourante;
    private Circle cercleCourant;
    private Rectangle rectangleCourant;
    private Objectif objectifCourant;
    private ArrayList<Shape> nodes = new ArrayList<>();
    
    public int indexListe = -1;
    
    private int indexUndoRedo = -1;
    
   
    
    //coordonée
    @FXML private Label labelcoordonneeI;
    @FXML private Label labelcoordonneeI1;
    
    @FXML private Label  coordoneeI ;
    
    @FXML private String imagePath;
    @FXML private Color color;
    @FXML private String objectifAjouer = "";
    @FXML private Image imageObjectif;
    
    @FXML private String nomObstacle;
    @FXML private String typeObstacle;
    @FXML private int hauteurObstacle;
    @FXML private int largeurObstacle;
    @FXML private Image imageObstacle;
    @FXML private String imageObstaclePath;
    @FXML private String imageObjectifPath;
    
        
    @FXML private CheckBox afficherRotation ;
    private List<Label> list_labelJoueurRotation = new ArrayList<>(); 
    private List<Button>  list_buttonRotationGauche = new ArrayList<>();
    private List<Button>  list_buttonRotationDroite = new ArrayList<>();
    private Label label_joueurRotationCourant ;
    double label_RotationSceneX; 
    double label_RotationSceneY; 
    double labelRotation_orgTanslateX;
    double labelRotation_orgTanslateY;
    
    private Button btn_gaucheCourant;
    private Button btn_droitCourant;
    
    private double x0, y0;
    @FXML public StackPane stackSurface ;
    @FXML private Button btnnouveauSportAction;
    @FXML private AnchorPane boiteverticale ; 
    @FXML private HBox boiteHorizontaleBouton ; 
    @FXML private HBox boiteHorizontaleBouton2 ;
    @FXML private Button boutonTransfert ;  
    @FXML private Separator separateur1 ;
    @FXML private Separator separateur5 ;
    @FXML private Separator separateur10;
    @FXML private Button boutonAvancer ;
    @FXML private Label testDimensionX;
    @FXML private Label testDimensionY;
    @FXML public static Stage primaryStage;
    
    @FXML private Button screenShotInterface ;
   
    private String m_equipe;
    private String m_role;
    private String m_position;
    private float m_orientation;
    private int m_nbEquipeMax;
    private double m_x;
    private double m_y;
    
    private List<Label> list_labelRolePosition = new ArrayList<>();
    private Label label_rolePositionCourant;
    private boolean label_afficherRolePosition = false;
    private boolean label_afficherRotationPosition = false ;
    
    double orgSceneX, orgSceneY;
    double orgTranslateX, orgTranslateY;
    
    double label_orgSceneX, label_orgSceneY;
    double label_orgTranslateX, label_orgTranslateY;
    
    private DoubleProperty myScale = new SimpleDoubleProperty(1.0);
    double sourisPositionX;
    double sourisPositionY;
    double transfererPositionX;
    double transfererPositionY;
    int dimensionObstacleX;
    int dimensionObstacleY;
    
    @FXML public List<String> listeRoles = new ArrayList<>();
    
    public String typeUtilisateur;
    private String pathVerif = "src/savedUtilisateurs/connecte.txt";
    
    //@FXML private 
    
    //instance du controller de Larman
    public VisuaLigueController m_controller = new VisuaLigueController();
    public Enregistrement m_enregistrement = new Enregistrement();
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        clearUR();
       
    menuBarSport.prefWidthProperty().bind(boiteverticale.widthProperty());
    boiteHorizontaleBouton.prefWidthProperty().bind(boiteverticale.widthProperty());
   
    separateur5.prefWidthProperty().bind(boutonAvancer.widthProperty());
    separateur5.prefWidthProperty().bind(boiteHorizontaleBouton.widthProperty());
    separateur10.prefWidthProperty().bind(boiteHorizontaleBouton2.widthProperty());
    boiteHorizontaleBouton2.prefWidthProperty().bind(boiteverticale.widthProperty());
   
    
   // stackSurface.prefHeightProperty().bind(boiteverticale.heightProperty());
    stackSurface.toBack();
    stackSurface.prefHeightProperty().bind(conteneurJoueur.prefHeightProperty());
    stackSurface.prefWidthProperty().bind(conteneurJoueur.prefWidthProperty());
    
    
   // stackSurface.setAlignment(Pos.CENTER); 
    imgsurface.scaleXProperty().bind(myScale);
    imgsurface.scaleYProperty().bind(myScale);
    conteneurJoueur.scaleXProperty().bind(myScale);
    conteneurJoueur.scaleYProperty().bind(myScale);
   // stackSurface.scaleXProperty().bind(myScale);
   //stackSurface.scaleYProperty().bind(myScale);
    
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
        btnNouvelleImage.setDisable(true);
        cbJoueurMax.setDisable(true);
        Pane p_joueur = new Pane();
        p_joueur.setLayoutX(0);
        p_joueur.setLayoutY(0);
        p_joueur.setMinHeight(537);
        p_joueur.setMinWidth(1083);
        stackSurface.getChildren().add(p_joueur);
    }
    }

    public void clearUR()
    {
        File folder = new File("src/UndoRedo");
        File[] listOfFiles = folder.listFiles();

    
        for (File file : listOfFiles) 
        {
            file.delete();
        }
    }
        
    
    
    @FXML
    public void undoAction(ActionEvent e)
    {
        if(indexUndoRedo==0)
        {
            clearUR();
            conteneurJoueur.getChildren().clear();   
        }
        if(indexUndoRedo>0)
        {
       indexUndoRedo = indexUndoRedo - 1;
       VisuaLigueController controllerUndo = m_enregistrement.deSerializeUR(m_enregistrement.getListeUR().get(indexUndoRedo));
       conteneurJoueur.getChildren().clear();
        setController(controllerUndo);
        setJoueur();
        setStateAfficherPosition();
        setStateMaxJoueur();
        setJoueurMax();
        }
    }
    
    
    @FXML
    public void redoAction(ActionEvent e)
    {
        if(indexUndoRedo<m_enregistrement.getListeUR().size()-1)
        {
       indexUndoRedo = indexUndoRedo + 1;
       VisuaLigueController controllerUndo = m_enregistrement.deSerializeUR(m_enregistrement.getListeUR().get(indexUndoRedo));
       conteneurJoueur.getChildren().clear();
        setController(controllerUndo);
        setJoueur();
        setStateAfficherPosition();
        setStateMaxJoueur();
        setJoueurMax();
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   public void getX(String dimensionX){
     testDimensionX.setText(dimensionX); 
     m_x = Double.parseDouble(dimensionX);
     m_controller.setDimensionX(m_x);
     
   }
   public void getY(String dimensionY){
    testDimensionY.setText(dimensionY);
    m_y = Double.parseDouble(dimensionY);
    m_controller.setDimensionY(m_y);
     
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
                }
            }
            else
            {
                m_controller.setImageSurface("src/Photo/%5E28C212DFD9632524D061D9D53482CD908188A15004C1096E60%5Epimgpsh_mobile_save_distr.jpg");
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(Interface_image_par_imageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setNombreEquipeInterface(int nombreEquipe){
        m_nbEquipeMax = nombreEquipe;
        m_controller.setNombreEquipe(nombreEquipe);
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
        title = title.replaceAll(" - mode Image par Image", "");
        controller.setTitle(title);
        controller.setNombreEquipe(m_controller.getNombreEquipe());
        controller.setX(m_controller.getDimensionX());
        controller.setY(m_controller.getDimensionY());
        controller.setImagePath(imagePath);
        controller.initialize(this);
        stage.show();
    }
      
    @FXML
    public void bouton_changerMode (ActionEvent event)throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("Interface_temps_reel.fxml"));
          Stage Window = (Stage) menuBarSport.getScene().getWindow();
          Stage stage = new Stage(StageStyle.DECORATED);
          String titreWindow = Window.getTitle();
          titreWindow = titreWindow.replaceAll(" - mode Image par Image", "");
          titreWindow = titreWindow + " - mode Temps Reel";
          stage.setTitle(titreWindow);
          stage.setScene(new Scene((AnchorPane) loader.load()));
          Interface_temps_reelController TRcontrolleur = loader.<Interface_temps_reelController>getController();
          
          //Appel la classe qui set l'image
          TRcontrolleur.setImageInterface(imagePath);
          
          //Show la nouvelle window
          stage.show();
          
          //Ferme le window actuel
          stage = (Stage) menuBarSport.getScene().getWindow();
          stage.close();
      }
    
    @FXML 
    private void quitterJeu (final ActionEvent event){
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
            CreerJoueurController.initialize(this);

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
    
    @FXML
    public void ajouterObstacleAction(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("Interface_CreerObstacle.fxml"));
          Stage stage = new Stage(StageStyle.DECORATED);
          stage.setTitle("Ajout obstacle");
          stage.setScene(new Scene((AnchorPane) loader.load()));
         if (boutonAjouterObstacle.isSelected()){
          //Fonction qui bloque les window deriere la nouvelle
          Stage currentStage = (Stage) boiteverticale.getScene().getWindow();
          Interface_CreerObstacleController CreerObstacle = loader.<Interface_CreerObstacleController>getController();
          CreerObstacle.initialize(this);
          stage.initModality(Modality.WINDOW_MODAL);
          stage.initOwner(currentStage);
          
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
    public void ajouterObjectifButton(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("Interface_CreerObjectif.fxml"));
          Stage stage = new Stage(StageStyle.DECORATED);
          stage.setTitle("Ajout objectif");
          stage.setScene(new Scene((AnchorPane) loader.load()));
         if (boutonObjectif.isSelected()){
          Stage currentStage = (Stage) boiteverticale.getScene().getWindow();
          Interface_CreerObjectifController CreerObjectif = loader.<Interface_CreerObjectifController>getController();
          CreerObjectif.initialize(this);
          stage.initModality(Modality.WINDOW_MODAL);
          stage.initOwner(currentStage);
          
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

    @FXML
    private void sauvegarderAction(ActionEvent event) throws IOException {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Interface_Sauvegarde.fxml"));
            Parent parent = (Parent) fxmlLoader.load();

            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.setTitle("Sauvegarde");

            Interface_SauvegardeController controllerSauvegarde = fxmlLoader.<Interface_SauvegardeController>getController();
            controllerSauvegarde.initialize(this);
            if(!txtJoueurMax.getText().isEmpty())
            {
                controllerSauvegarde.setMaxJoueur(Integer.parseInt(txtJoueurMax.getText()));
            }
            stage.show();
    }
    
    @FXML
    public void afficherRotationAction (ActionEvent event) throws IOException
    {
        if (label_afficherRotationPosition)
        {
            for (Button buton : list_buttonRotationGauche)
            {
                buton.setVisible(false);
            }
            
            for (Button buton : list_buttonRotationDroite)
            {
                buton.setVisible(false);
            }
            
            for (Label fleche : list_labelJoueurRotation)
            {
                fleche.setVisible(false);
            }
            
            label_afficherRotationPosition = false;
            m_controller.setStateAfficherOriantation(label_afficherRotationPosition);
        }
        else
        {
            for (Button buton : list_buttonRotationGauche)
            {
                buton.setVisible(true);
            }
            
            for (Button buton : list_buttonRotationDroite)
            {
                buton.setVisible(true);
            }
            
            for (Label fleche : list_labelJoueurRotation)
            {
                fleche.setVisible(true);
            }
            
            label_afficherRotationPosition = true ;
            m_controller.setStateAfficherOriantation(label_afficherRotationPosition);
        }
    }
    
    @FXML
    public void afficherRPJoueurAction(ActionEvent event) throws IOException
    {
        if (label_afficherRolePosition)
        {
            for (Label label : list_labelRolePosition)
            {
                label.setVisible(false);
            }

            label_afficherRolePosition = false;
            m_controller.setStateAfficherRP(label_afficherRolePosition);
        }
        else
        {
            for (Label label : list_labelRolePosition)
            {
                label.setVisible(true);
            }

            label_afficherRolePosition = true;
            m_controller.setStateAfficherRP(label_afficherRolePosition);
        }
    
    }
    
    @FXML 
    public void ajouterJoueurInterface()  {
        List<Equipe> listeEquipe = m_controller.getListEquipe();
        conteneurJoueur.setOnMouseClicked((MouseEvent event) -> {
            if(event.getClickCount()==2 && event.getButton() == MouseButton.PRIMARY)
            {
                if(boutonAjouterJoueur.isSelected()){
                    
                    Iterator<Equipe> iterateur = listeEquipe.iterator();
                    while(iterateur.hasNext())
                    {
                        Equipe equipe = iterateur.next();
                        if(cbJoueurMax.isSelected())
                        {
                            if(!txtJoueurMax.getText().matches("^[1-9][0-9]*$"))
                            {
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setTitle("Information");
                                alert.setHeaderText("Information sur la création de joueur!");
                                alert.setContentText("Le nombre de joueur maximum par équipe doit être un nombre entier (qui ne commence pas par 0)!");
                                alert.showAndWait();
                            }
                            else
                            {
                                if(equipe.estMemeNom(m_equipe)){
                                    if(equipe.getList_joueurs().size() < Integer.parseInt(txtJoueurMax.getText()) )
                                    {
                                        float x = (float) event.getX();
                                        float y = (float) event.getY();

                                        Point2D.Float p = new Point2D.Float(x,y);
                                        
                                        
                                        if(!m_controller.joueurEstPresent(p))
                                        {
                                            java.awt.Color couleurAWTEquipe = equipe.getCouleur();
                                            Color couleurEquipe = javafx.scene.paint.Color.rgb(couleurAWTEquipe.getRed(), couleurAWTEquipe.getGreen(), couleurAWTEquipe.getBlue(), couleurAWTEquipe.getAlpha()/255.0);
                                            
                                            m_controller.addJoueur(p, couleurAWTEquipe, m_role, m_position, m_orientation, equipe);
                                            List<Joueur> liste_joueurs = m_controller.getListJoueurs();
                                            Joueur dernierJoueur = liste_joueurs.get(liste_joueurs.size()-1);
                                            dernierJoueur.getEquipe().addJoueur(dernierJoueur);
                                            
                                            //AJOUT DU JOUEUR
                                            int idJoueur = dernierJoueur.getId();
                                            Circle cercle = new Circle(15, couleurEquipe);
                                            cercle.setLayoutX(event.getX());
                                            cercle.setLayoutY(event.getY());
                                            cercle.setCursor(Cursor.HAND);
                                            cercle.setOnMousePressed(circleOnMousePressedEventHandler);
                                            cercle.setOnMouseDragged(circleOnMouseDraggedEventHandler);
                                            cercle.setOnMouseEntered(circleOnMouseEnteredEventHandler);
                                            cercle.setOnMouseReleased(circleOnMouseReleasedEventHandler);
                                            cercle.setOnMouseClicked(circleOnRightMouseClickEventHandler);
                                            cercle.setId(""+idJoueur);

                                            //AJOUT DU LABEL DE ROLE POSITION
                                            Label labelRolePosition = new Label(m_role + "\n" + m_position);
                                            labelRolePosition.setLayoutX(event.getX()+20);
                                            labelRolePosition.setLayoutY(event.getY()-15);
                                            labelRolePosition.setId(""+idJoueur);
                                            labelRolePosition.setVisible(false);

                                            // AJOUT DU BOUTON DROIT
                                            Button boutonRotationDroite = new Button ("\u21BB") ; 
                                            boutonRotationDroite.setLayoutX(event.getX()+5);
                                            boutonRotationDroite.setLayoutY(event.getY()+20);
                                            boutonRotationDroite.setId("" + idJoueur);
                                            boutonRotationDroite.setVisible(false);

                                            //AJOUT DU BOUTON GAUCHE
                                            Button boutonRotationGauche = new Button ("\u21BA") ;
                                            boutonRotationGauche.setLayoutX(event.getX()-35);
                                            boutonRotationGauche.setLayoutY(event.getY()+20);
                                            boutonRotationGauche.setId("" + idJoueur);
                                            boutonRotationGauche.setVisible(false);

                                            //AJOUT DE LA FLÈCHE
                                            Label labelJoueurRotation = new Label("\u27a4");
                                            labelJoueurRotation.setRotate(m_orientation);
                                            labelJoueurRotation.setLayoutX(event.getX()-6);
                                            labelJoueurRotation.setLayoutY(event.getY()-35); 
                                            labelJoueurRotation.setScaleX(labelJoueurRotation.getScaleX()*2);
                                            labelJoueurRotation.setScaleY(labelJoueurRotation.getScaleY()*2);
                                            labelJoueurRotation.setId("" + idJoueur);

                                            //EVENT POUR LES BOUTONS
                                            boutonRotationDroite.setOnMouseClicked((MouseEvent eventrotation)->{
                                                double rotation = labelJoueurRotation.getRotate()+20;
                                                labelJoueurRotation.setRotate(rotation);
                                                Button bouton = (Button)eventrotation.getSource();
                                                int id = Integer.parseInt(bouton.getId());
                                                BigDecimal number = new BigDecimal(rotation);
                                                float rotation_float = number.floatValue();

                                                m_controller.getJoueur(id).setOrientationJoueurFloat(rotation_float);
                                            });

                                            boutonRotationGauche.setOnMousePressed((MouseEvent eventrotation)->{
                                                double rotation = labelJoueurRotation.getRotate()-20;
                                                labelJoueurRotation.setRotate(rotation);
                                                Button bouton = (Button)eventrotation.getSource();
                                                int id = Integer.parseInt(bouton.getId());
                                                BigDecimal number = new BigDecimal(rotation);
                                                float rotation_float = number.floatValue();

                                                m_controller.getJoueur(id).setOrientationJoueurFloat(rotation_float);
                                            });

                                            if (label_afficherRolePosition)
                                            {
                                                labelRolePosition.setVisible(true); 
                                            }

                                            if (label_afficherRotationPosition)
                                            {
                                                boutonRotationGauche.setVisible(true);
                                                boutonRotationDroite.setVisible(true);
                                            }

                                            list_labelRolePosition.add(labelRolePosition);
                                            list_labelJoueurRotation.add(labelJoueurRotation);
                                            list_buttonRotationGauche.add(boutonRotationGauche);
                                            list_buttonRotationDroite.add(boutonRotationDroite);

                                            conteneurJoueur.getChildren().addAll(cercle, labelRolePosition, labelJoueurRotation,boutonRotationDroite,boutonRotationGauche);
                                        }
                                    }
                                    else
                                    {
                                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                        alert.setTitle("Information");
                                        alert.setHeaderText("Information sur la création de joueur!");
                                        alert.setContentText("Le nombre de joueur dans cet équipe est égale ou suppérieur à la limite configurer!");
                                        alert.showAndWait();
                                    }
                                }
                            }
                        }
                        else
                        {
                            float x = (float) event.getX();
                            float y = (float) event.getY();

                            Point2D.Float p = new Point2D.Float(x,y);
                            
                            if(equipe.estMemeNom(m_equipe)){
                                
                                if(!m_controller.joueurEstPresent(p))
                                {
                                    java.awt.Color couleurAWTEquipe = equipe.getCouleur();
                                    Color couleurEquipe = javafx.scene.paint.Color.rgb(couleurAWTEquipe.getRed(), couleurAWTEquipe.getGreen(), couleurAWTEquipe.getBlue(), couleurAWTEquipe.getAlpha()/255.0);
                                    
                                    m_controller.addJoueur(p, couleurAWTEquipe, m_role, m_position, m_orientation, equipe);
                                    List<Joueur> liste_joueurs = m_controller.getListJoueurs();
                                    Joueur dernierJoueur = liste_joueurs.get(liste_joueurs.size()-1);
                                    Equipe equipe_joueur = dernierJoueur.getEquipe();
                                    equipe_joueur.addJoueur(dernierJoueur);
                                    
                                    //AJOUT DU JOUEUR
                                    int idJoueur = dernierJoueur.getId();
                                    Circle cercle = new Circle(15, couleurEquipe);
                                    cercle.setLayoutX(event.getX());
                                    cercle.setLayoutY(event.getY());
                                    cercle.setCursor(Cursor.HAND);
                                    cercle.setOnMousePressed(circleOnMousePressedEventHandler);
                                    cercle.setOnMouseDragged(circleOnMouseDraggedEventHandler);
                                    cercle.setOnMouseEntered(circleOnMouseEnteredEventHandler);
                                    cercle.setOnMouseReleased(circleOnMouseReleasedEventHandler);
                                    cercle.setOnMouseClicked(circleOnRightMouseClickEventHandler);
                                    cercle.setId(""+idJoueur);
                                    
                                    //AJOUT DU LABEL DE ROLE POSITION
                                    Label labelRolePosition = new Label(m_role + "\n" + m_position);
                                    labelRolePosition.setLayoutX(event.getX()+20);
                                    labelRolePosition.setLayoutY(event.getY()-15);
                                    labelRolePosition.setId(""+idJoueur);
                                    labelRolePosition.setVisible(false);
                                    
                                    // AJOUT DU BOUTON DROIT
                                    Button boutonRotationDroite = new Button ("\u21BB") ; 
                                    boutonRotationDroite.setLayoutX(event.getX()+5);
                                    boutonRotationDroite.setLayoutY(event.getY()+20);
                                    boutonRotationDroite.setId("" + idJoueur);
                                    boutonRotationDroite.setVisible(false);
                                    
                                    //AJOUT DU BOUTON GAUCHE
                                    Button boutonRotationGauche = new Button ("\u21BA") ;
                                    boutonRotationGauche.setLayoutX(event.getX()-35);
                                    boutonRotationGauche.setLayoutY(event.getY()+20);
                                    boutonRotationGauche.setId("" + idJoueur);
                                    boutonRotationGauche.setVisible(false);
                                    
                                    //AJOUT DE LA FLÈCHE
                                    Label labelJoueurRotation = new Label("\u27a4");
                                    labelJoueurRotation.setRotate(m_orientation);
                                    labelJoueurRotation.setLayoutX(event.getX()-6);
                                    labelJoueurRotation.setLayoutY(event.getY()-35); 
                                    labelJoueurRotation.setScaleX(labelJoueurRotation.getScaleX()*2);
                                    labelJoueurRotation.setScaleY(labelJoueurRotation.getScaleY()*2);
                                    labelJoueurRotation.setId("" + idJoueur);
                                    labelJoueurRotation.setVisible(false);
                                    
                                    //EVENT POUR LES BOUTONS
                                    boutonRotationDroite.setOnMouseClicked((MouseEvent eventrotation)->{
                                        double rotation = labelJoueurRotation.getRotate()+20;
                                        labelJoueurRotation.setRotate(rotation);
                                        Button bouton = (Button)eventrotation.getSource();
                                        int id = Integer.parseInt(bouton.getId());
                                        BigDecimal number = new BigDecimal(rotation);
                                        float rotation_float = number.floatValue();
                                        
                                        m_controller.getJoueur(id).setOrientationJoueurFloat(rotation_float);
                                    });
                                            
                                    boutonRotationGauche.setOnMousePressed((MouseEvent eventrotation)->{
                                        double rotation = labelJoueurRotation.getRotate()-20;
                                        labelJoueurRotation.setRotate(rotation);
                                        Button bouton = (Button)eventrotation.getSource();
                                        int id = Integer.parseInt(bouton.getId());
                                        BigDecimal number = new BigDecimal(rotation);
                                        float rotation_float = number.floatValue();

                                        m_controller.getJoueur(id).setOrientationJoueurFloat(rotation_float);
                                    });
                                    
                                    if (label_afficherRolePosition)
                                    {
                                        labelRolePosition.setVisible(true); 
                                    }
                                    
                                    if (label_afficherRotationPosition)
                                    {
                                        boutonRotationGauche.setVisible(true);
                                        boutonRotationDroite.setVisible(true);
                                        labelJoueurRotation.setVisible(true);
                                    }
                                    
                                    list_labelRolePosition.add(labelRolePosition);
                                    list_labelJoueurRotation.add(labelJoueurRotation);
                                    list_buttonRotationGauche.add(boutonRotationGauche);
                                    list_buttonRotationDroite.add(boutonRotationDroite);
                                    
                                    conteneurJoueur.getChildren().addAll(cercle, labelRolePosition, labelJoueurRotation,boutonRotationDroite,boutonRotationGauche);
                                }
                            }
                        }
                    }  
                }
                else
                    if(boutonObjectif.isSelected()){
                    switch (objectifAjouer) {
                        case "Rondelle":
                            Circle cercle = new Circle(10);
                            cercle.setLayoutX(event.getX());
                            cercle.setLayoutY(event.getY());
                            cercle.setCursor(Cursor.HAND);
                            cercle.setOnMousePressed(objOnMousePressedEventHandler);
                            cercle.setOnMouseDragged(objOnMouseDraggedEventHandler);
                            cercle.setOnMouseEntered(objOnMouseEnteredEventHandler);
                            cercle.setOnMouseReleased(objOnMouseReleasedEventHandler);
                            cercle.setOnMouseClicked(objOnRightMouseClickEventHandler);
                            float x = (float) event.getX();
                            float y = (float) event.getY();
                            Point2D.Float p = new Point2D.Float(x,y);
                            m_controller.addRondelle(p,imageObjectifPath);
                            File imageFileRondelle = new File(imageObjectifPath);
                            String imagepathRondelle= null;
                            try {
                                imagepathRondelle = imageFileRondelle.toURI().toURL().toString();
                            } catch (MalformedURLException ex) {
                                Logger.getLogger(Interface_image_par_imageController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            Image ImageRondelle= new Image(imagepathRondelle);
                            ImagePattern imagePatternRondelle = new ImagePattern(ImageRondelle);
                            cercle.setFill(imagePatternRondelle);
                            conteneurJoueur.getChildren().addAll(cercle);
                            break;
                        case "Balle":
                            Circle balle = new Circle(10);
                            balle.setLayoutX(event.getX());
                            balle.setLayoutY(event.getY());
                            balle.setCursor(Cursor.HAND);
                            balle.setOnMousePressed(objOnMousePressedEventHandler);
                            balle.setOnMouseDragged(objOnMouseDraggedEventHandler);
                            balle.setOnMouseEntered(objOnMouseEnteredEventHandler);
                            balle.setOnMouseReleased(objOnMouseReleasedEventHandler);
                            balle.setOnMouseClicked(objOnRightMouseClickEventHandler);
                            float xBalle = (float) event.getX();
                            float yBalle = (float) event.getY();
                            Point2D.Float pBalle = new Point2D.Float(xBalle,yBalle);
                            m_controller.addBalle(pBalle,imageObjectifPath);
                            File imageFileBalle = new File(imageObjectifPath);
                            String imagepathBalle = null;
                            try {
                                imagepathBalle = imageFileBalle.toURI().toURL().toString();
                            } catch (MalformedURLException ex) {
                                Logger.getLogger(Interface_image_par_imageController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            Image ImageBalle = new Image(imagepathBalle);
                            ImagePattern imagePatternBalle = new ImagePattern(ImageBalle);
                            balle.setFill(imagePatternBalle);
                            conteneurJoueur.getChildren().addAll(balle);
                            break;
                        case "Ballon":
                            Circle ballon = new Circle(10);
                            ballon.setLayoutX(event.getX());
                            ballon.setLayoutY(event.getY());
                            ballon.setCursor(Cursor.HAND);
                            ballon.setOnMousePressed(objOnMousePressedEventHandler);
                            ballon.setOnMouseDragged(objOnMouseDraggedEventHandler);
                            ballon.setOnMouseEntered(objOnMouseEnteredEventHandler);
                            ballon.setOnMouseReleased(objOnMouseReleasedEventHandler);
                            ballon.setOnMouseClicked(objOnRightMouseClickEventHandler);
                            float xBallon = (float) event.getX();
                            float yBallon = (float) event.getY();
                            Point2D.Float pBallon = new Point2D.Float(xBallon,yBallon);
                            m_controller.addBallon(pBallon,imageObjectifPath);
                            File imageFileBallon = new File(imageObjectifPath);
                            String imagepathBallon = null;
                            try {
                                imagepathBallon = imageFileBallon.toURI().toURL().toString();
                            } catch (MalformedURLException ex) {
                                Logger.getLogger(Interface_image_par_imageController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            Image ImageBallon = new Image(imagepathBallon);
                            ImagePattern imagePatternBallon = new ImagePattern(ImageBallon);
                            ballon.setFill(imagePatternBallon);
                            conteneurJoueur.getChildren().addAll(ballon);
                            break;
                        default:
                            break;
                    }
                }
                else
                    if(boutonAjouterObstacle.isSelected())
                    {
                        Rectangle rekt = new Rectangle(largeurObstacle,hauteurObstacle);
                        rekt.setLayoutX(event.getX()-largeurObstacle/2);
                        rekt.setLayoutY(event.getY()-hauteurObstacle/2);
                        rekt.setCursor(Cursor.HAND);
                        rekt.setOnMouseClicked(obsOnRightMouseClickEventHandler);
                        nodes.add(rekt);
                        float x = (float) event.getX();
                        float y = (float) event.getY();
                        Point2D.Float p = new Point2D.Float(x,y);
                        m_controller.addObstacle(nomObstacle,typeObstacle,hauteurObstacle,largeurObstacle,p, imageObstaclePath);
                        ImagePattern imagePattern = new ImagePattern(imageObstacle);
                        rekt.setFill(imagePattern);
                        conteneurJoueur.getChildren().addAll(rekt);
                    }
            m_enregistrement.serializeUR(m_controller.getController(), indexUndoRedo);
            indexUndoRedo ++;
            }
        }); 
        
        
       
       
    }
    

/////////////////////////////////////////////////////////////////

    
    EventHandler<MouseEvent> circleOnMouseEnteredEventHandler = 
        (MouseEvent t) -> {

            List<Equipe> listeEquipe = m_controller.getListEquipe();
            Circle cercle = (Circle)t.getSource();
            couleurCourante = (Color)cercle.getFill();
            
            for(Equipe e : listeEquipe)
            {
                
                for(Joueur j : e.getList_joueurs())
                {   float xJoueur=j.getCoordonneesJoueur().x;
                    float yJoueur=j.getCoordonneesJoueur().y;
                    float xCercle =(float)cercle.getLayoutX();
                    float yCercle=(float)cercle.getLayoutY();
                    if((xJoueur == xCercle) && (yJoueur == yCercle))
                    {
                        joueurCourant=j;
                        cercleCourant= cercle;
                        label_rolePositionCourant = getLabelRolePosition(j.getId());
                        label_joueurRotationCourant = getLabelJoueurRotation(j.getId());
                        btn_gaucheCourant = getBoutonsOrientationGauche(j.getId());
                        btn_droitCourant = getBoutonsOrientationDroit(j.getId());
                      
                        System.out.println(j.getCoordonneesJoueur().x);
                        System.out.println(j.getCoordonneesJoueur().y);
                        System.out.println(cercleCourant.getLayoutX());
                        System.out.println(cercleCourant.getLayoutY());
                        System.out.println("--------------------------------------------------------");
                        

                    }
                }
            }
    };
    
    EventHandler<MouseEvent> objOnMouseEnteredEventHandler = 
        (MouseEvent t) -> {

            Circle rect = (Circle)t.getSource();
            List<Objectif> listeObj = m_controller.getListeObjectif();
 
                for(Objectif o : listeObj)
                {   float xJoueur=o.getCoordonneesObj().x;
                    float yJoueur=o.getCoordonneesObj().y;
                    float xRect =(float)rect.getLayoutX();
                    float yRect=(float)rect.getLayoutY();
                    if((xJoueur == xRect) && (yJoueur == yRect))
                    {
                        objectifCourant=o;
                        cercleCourant= rect;
                    }
                }
            
    };
    
/////////////////////////////////////////////////////////////////
    EventHandler<MouseEvent> circleOnMousePressedEventHandler = 
        (MouseEvent t) -> {
            if(t.getButton()==MouseButton.PRIMARY)
            {
            orgSceneX = t.getSceneX();
            orgSceneY = t.getSceneY();
            label_orgSceneX = t.getSceneX() + 20;
            label_orgSceneY = t.getSceneY() - 15;
            label_RotationSceneX = t.getSceneX()-6; 
            label_RotationSceneY = t.getSceneY()-35; 
            orgTranslateX = ((Circle)(t.getSource())).getLayoutX();
            orgTranslateY = ((Circle)(t.getSource())).getLayoutY();
            label_orgTranslateX = label_rolePositionCourant.getLayoutX();
            label_orgTranslateY = label_rolePositionCourant.getLayoutY();
            labelRotation_orgTanslateX =  label_joueurRotationCourant.getLayoutX();
            labelRotation_orgTanslateY = label_joueurRotationCourant.getLayoutY();
            }
            
    };
    
        EventHandler<MouseEvent> objOnMousePressedEventHandler = 
        (MouseEvent t) -> {
            if(t.getButton()==MouseButton.PRIMARY)
            {
                orgSceneX = t.getSceneX();
                orgSceneY = t.getSceneY();
                label_orgSceneX = t.getSceneX() + 20;
                label_orgSceneY = t.getSceneY() - 15;
                orgTranslateX = ((Circle)(t.getSource())).getLayoutX();
                orgTranslateY = ((Circle)(t.getSource())).getLayoutY();
            }
            
    };
    
/////////////////////////////////////////////////////////////////
    EventHandler<MouseEvent> circleOnMouseDraggedEventHandler = 
        new EventHandler<MouseEvent>() {
 
        @Override
        public void handle(MouseEvent t) {
            if(t.getButton()==MouseButton.PRIMARY)
            {
                if (btn_gaucheCourant.isVisible() && btn_droitCourant.isVisible())
                {
                    btn_gaucheCourant.setVisible(false);
                    btn_droitCourant.setVisible(false);
                }
                
                double scale = myScale.get() ;
                double offsetX = (t.getSceneX() - orgSceneX)/scale;
                double offsetY = (t.getSceneY() - orgSceneY)/scale;
                double newTranslateX = orgTranslateX + offsetX;
                double newTranslateY = orgTranslateY + offsetY;
                
                double label_offsetX = (t.getSceneX() + 20 - label_orgSceneX)/scale;
                double label_offsetY = (t.getSceneY() - 15 - label_orgSceneY)/scale;
                double label_newTranslateX = label_orgTranslateX + label_offsetX;
                double label_newTranslateY = label_orgTranslateY + label_offsetY;
                
                double label_RotationOffsetX = (t.getSceneX()- 6 - label_RotationSceneX)/scale; 
                double label_RotationOffsetY = (t.getSceneY()- 35 - label_RotationSceneY)/scale;
                double label_newRotationTranslateX = labelRotation_orgTanslateX + label_RotationOffsetX ;
                double label_newRotationTranslateY = labelRotation_orgTanslateY + label_RotationOffsetY ;
               
                ((Circle)(t.getSource())).setLayoutX(newTranslateX);
                ((Circle)(t.getSource())).setLayoutY(newTranslateY);
                label_rolePositionCourant.setLayoutX(label_newTranslateX);
                label_rolePositionCourant.setLayoutY(label_newTranslateY);
                label_joueurRotationCourant.setLayoutX(label_newRotationTranslateX);
                label_joueurRotationCourant.setLayoutY(label_newRotationTranslateY);
                
                checkShapeIntersection(cercleCourant);
            }
        }
    };
    
    EventHandler<MouseEvent> objOnMouseDraggedEventHandler = 
        new EventHandler<MouseEvent>() {
 
        @Override
        public void handle(MouseEvent t) {
            if(t.getButton()==MouseButton.PRIMARY)
            {
                double scale = myScale.get() ;
                double offsetX = (t.getSceneX() - orgSceneX)/scale;
                double offsetY = (t.getSceneY() - orgSceneY)/scale;
                double newTranslateX = orgTranslateX + offsetX;
                double newTranslateY = orgTranslateY + offsetY;
                ((Circle)(t.getSource())).setLayoutX(newTranslateX);
                ((Circle)(t.getSource())).setLayoutY(newTranslateY);
                checkShapeIntersection(cercleCourant);
            }
        }
    };
    
/////////////////////////////////////////////////////////////////////
        EventHandler<MouseEvent> circleOnMouseReleasedEventHandler = 
        new EventHandler<MouseEvent>() {
 
        @Override
        public void handle(MouseEvent t) {
            if(t.getButton()==MouseButton.PRIMARY)
            {
                List<Equipe> listeEquipe = m_controller.getListEquipe();

                //cercleCourant.setCenterX(t.getX());
                //cercleCourant.setCenterY(t.getY());
                float xCercle =(float)cercleCourant.getLayoutX();
                float yCercle=(float)cercleCourant.getLayoutY();
                label_rolePositionCourant.setLayoutX(xCercle+20);
                label_rolePositionCourant.setLayoutY(yCercle-15);
                label_joueurRotationCourant.setLayoutX(xCercle-6);
                label_joueurRotationCourant.setLayoutY(yCercle-35);
                Point2D.Float point = new Point2D.Float(xCercle,yCercle);
                joueurCourant.setCoordonneesJoueur(point);
                m_enregistrement.serializeUR(m_controller.getController(), indexUndoRedo);
                indexUndoRedo ++;
                
                btn_gaucheCourant.setLayoutX(xCercle - 35);
                btn_gaucheCourant.setLayoutY(yCercle + 20);
                btn_droitCourant.setLayoutX(xCercle + 5);
                btn_droitCourant.setLayoutY(yCercle + 20);

                if (label_afficherRotationPosition)
                {
                    btn_gaucheCourant.setVisible(true);
                    btn_droitCourant.setVisible(true);
                }
            }
    };
   };
        EventHandler<MouseEvent> objOnMouseReleasedEventHandler = 
        new EventHandler<MouseEvent>() {
 
        @Override
        public void handle(MouseEvent t) {
            if(t.getButton()==MouseButton.PRIMARY)
            { 
                float xRect =(float)cercleCourant.getLayoutX();
                float yRect=(float)cercleCourant.getLayoutY();
                Point2D.Float point = new Point2D.Float(xRect,yRect);
                objectifCourant.setCoordonneesObj(point);
                m_enregistrement.serializeUR(m_controller.getController(),indexUndoRedo);
                indexUndoRedo ++;
            }
    };
        
   };
        
        
        EventHandler<MouseEvent> circleOnRightMouseClickEventHandler = 
        new EventHandler<MouseEvent>() {
 
        @Override
        public void handle(MouseEvent t) {
            if(t.getButton()==MouseButton.SECONDARY)
            {
                Circle cercle = (Circle)t.getSource();
                List<Equipe> listeEquipe = m_controller.getListEquipe();
                List<Joueur> listeJoueur = m_controller.getListJoueurs();
                couleurCourante = (Color)cercle.getFill();
                for(Equipe e : listeEquipe)
                {
                    for(Joueur j : e.getList_joueurs())
                    {   float xJoueur=j.getCoordonneesJoueur().x;
                        float yJoueur=j.getCoordonneesJoueur().y;
                        float xCercle =(float)cercle.getLayoutX();
                        float yCercle=(float)cercle.getLayoutY();
                        if((xJoueur == xCercle) && (yJoueur == yCercle))
                        {
                            e.getList_joueurs().remove(j);
                            listeJoueur.remove(j);
                            supprimerLabelRolePosition(j.getId());
                            supprimerLabelJoueurRotation(j.getId());
                            supprimerBoutonsOrientationGauche(j.getId());
                            supprimerBoutonsOrientationDroit(j.getId());
                            break;
                        }
                    }
                }
                
                conteneurJoueur.getChildren().remove(cercle);
                m_enregistrement.serializeUR(m_controller.getController(),indexUndoRedo);
                indexUndoRedo ++;

                }
            
    };
   };
        
        EventHandler<MouseEvent> objOnRightMouseClickEventHandler = 
        new EventHandler<MouseEvent>() {
 
        @Override
        public void handle(MouseEvent t) {
            if(t.getButton()==MouseButton.SECONDARY)
            {
                Circle rekt = (Circle)t.getSource();
                List<Objectif> listeObjectif = m_controller.getListeObjectif();
                for(Objectif o : listeObjectif)
                {
                    float xObstacle=o.getCoordonneesObj().x;
                    float yObstacle=o.getCoordonneesObj().y;
                    float xRekt =(float)rekt.getLayoutX();
                    float yRekt=(float)rekt.getLayoutY();
                    if((xObstacle == xRekt) && (yObstacle == yRekt))
                        {
                            m_controller.getListeObjectif().remove(o);
                            listeObjectif.remove(o);
                            break;
                        }                    
                }

                conteneurJoueur.getChildren().remove(rekt);
                m_enregistrement.serializeUR(m_controller.getController(),indexUndoRedo);
                indexUndoRedo ++;
            }
    };
   };
        EventHandler<MouseEvent> obsOnRightMouseClickEventHandler = 
        new EventHandler<MouseEvent>() {
 
        @Override
        public void handle(MouseEvent t) {
            if(t.getButton()==MouseButton.SECONDARY)
            {
                Rectangle rekt = (Rectangle)t.getSource();
                List<Obstacle> listeObstacle = m_controller.getListeObstacle();
                for(Obstacle o : listeObstacle)
                {
                    float xObstacle=o.getCoordonneeObs().x;
                    float yObstacle=o.getCoordonneeObs().y;
                    float xRekt =(float)rekt.getLayoutX();
                    float yRekt=(float)rekt.getLayoutY();
                    if((xObstacle == xRekt) && (yObstacle == yRekt))
                        {
                            m_controller.getListeObstacle().remove(o);
                            listeObstacle.remove(o);
                            break;
                        }                    
                }
                conteneurJoueur.getChildren().remove(rekt);
                m_enregistrement.serializeUR(m_controller.getController(),indexUndoRedo);
                indexUndoRedo ++;
            }
    };
   };
        
    private void checkShapeIntersection(Shape block) {
        boolean collisionDetected = false;
        for (Shape static_bloc : nodes) {
          if (static_bloc != block) {
            System.out.println("Collision non deteted");

            Shape intersect = Shape.intersect(block, static_bloc);
            if (intersect.getBoundsInLocal().getWidth() != -1) {
              collisionDetected = true;
            }
          }
        }

        if (collisionDetected) {
          block.setFill(Color.BLUE);
        } else {
            System.out.println("Collision non deteted");
        }
    }

    
        
    /**
     *
     * @param idJoueur
     */
    public void supprimerLabelRolePosition(int idJoueur)
    {
        String idJoueurString = "" + idJoueur;
        
        for (Label label : list_labelRolePosition)
        {
            if (idJoueurString.equals(label.getId()))
            {
                list_labelRolePosition.remove(label);
                conteneurJoueur.getChildren().remove(label);
                break;
            }
        }
    }
    
    public void supprimerLabelJoueurRotation(int idJoueur)
    {
        String idJoueurString = "" + idJoueur;
        
        for (Label label : list_labelJoueurRotation)
        {
            if (idJoueurString.equals(label.getId()))
            {
                list_labelJoueurRotation.remove(label);
                conteneurJoueur.getChildren().remove(label);
                break;
            }
        }
    }
    
    public void supprimerBoutonsOrientationGauche(int idJoueur)
    {
        String idJoueurString = "" + idJoueur;
        
        for (Button button : list_buttonRotationGauche)
        {
            if (idJoueurString.equals(button.getId()))
            {
                list_buttonRotationGauche.remove(button);
                conteneurJoueur.getChildren().remove(button);
                break;
            }
        }
    }
    
    public void supprimerBoutonsOrientationDroit(int idJoueur)
    {
        String idJoueurString = "" + idJoueur;
        
        for (Button button : list_buttonRotationDroite)
        {
            if (idJoueurString.equals(button.getId()))
            {
                list_buttonRotationGauche.remove(button);
                conteneurJoueur.getChildren().remove(button);
                break;
            }
        }
    }
    
    public Label getLabelRolePosition(String idJoueur)
    {        
        for (Iterator<Label> it = list_labelRolePosition.iterator(); it.hasNext();) {
            Label label = it.next();
            if (idJoueur.equals(label.getId()))
            {
                return label;
            }
        }
        
        return new Label();
    }
    
    public Label getLabelRolePosition(int idJoueur)
    {
        String idJoueurString = "" + idJoueur;
        
        for (Iterator<Label> it = list_labelRolePosition.iterator(); it.hasNext();) {
            Label label = it.next();
            if (idJoueurString.equals(label.getId()))
            {
                return label;
            }
        }
        
        return new Label();
    }
    
    public Label getLabelJoueurRotation(int idJoueur)
    {
        String idJoueurString = "" + idJoueur;
        
        for (Iterator<Label> it = list_labelJoueurRotation.iterator(); it.hasNext();) {
            Label label = it.next();
            if (idJoueurString.equals(label.getId()))
            {
                return label;
            }
        }
        
        return new Label();
    }
    
    public Button getBoutonsOrientationGauche(int idJoueur)
    {
        String idJoueurString = "" + idJoueur;
        
        for (Iterator<Button> it = list_buttonRotationGauche.iterator(); it.hasNext();) {
            Button button = it.next();
            if (idJoueurString.equals(button.getId()))
            {
                return button;
            }
        }
        
        return new Button();
    }
    
    public Button getBoutonsOrientationDroit(int idJoueur)
    {
        String idJoueurString = "" + idJoueur;
        
        for (Iterator<Button> it = list_buttonRotationDroite.iterator(); it.hasNext();) {
            Button button = it.next();
            if (idJoueurString.equals(button.getId()))
            {
                return button;
            }
        }
        
        return new Button();
    }
        
    @FXML   
    public void creerImage(ActionEvent e)
    {
       ObservableList<Node> listeC = conteneurJoueur.getChildren();
       List<Joueur> listeJ = m_controller.getListJoueurs();
       List<Joueur> listeSauvegarde = new ArrayList<>();
       for(Joueur j : listeJ)
        { 
            java.awt.Color color = j.getCouleurChandail();
            int r = color.getRed();
            int g = color.getGreen();
            int b = color.getBlue();
            int a = color.getAlpha();
            
            java.awt.Color nColor = new java.awt.Color(r, g, b, 127);

            j.setCouleurChandail(nColor);
 
                for(Node cercle : listeC)
                {
                    float xJoueur=j.getCoordonneesJoueur().x;
                    float yJoueur=j.getCoordonneesJoueur().y;
                    float xCercle =(float)cercle.getLayoutX();
                    float yCercle=(float)cercle.getLayoutY();
                    if((xJoueur == xCercle) && (yJoueur == yCercle))
                    {      
                        if(cercle.getOpacity() == 1.0)
                        {
                            cercle.setOpacity(127.0/255.0);
                            listeSauvegarde.add(j);
                        }
                    }
                }
        }
        m_controller.addListeSauvegardeJoueur(listeSauvegarde); 
        System.out.println(m_controller.getListeSauvegardeJoueur().size());
   }

    

     public class IteratingTask0 extends Task<Circle> {
         private final Circle cercleFinal;

         public IteratingTask0(Circle cercleParam) {
             this.cercleFinal = cercleParam;
         }
         @Override protected Circle call() throws Exception {
             cercleFinal.setOpacity(0.5);
                    
                 Platform.runLater(new Runnable() {
                     @Override public void run() {
                         
                     }
                 });
                 
             
             return null;
         }
     };
     

      public class IteratingTask1 extends Task<Circle> {
         private final Circle cercleFinal;

         public IteratingTask1(Circle cercleParam) {
             this.cercleFinal = cercleParam;
         }
         @Override protected Circle call() throws Exception {
                 cercleFinal.setOpacity(1.0);
                 Platform.runLater(new Runnable() {
                     @Override public void run() {
                         
                     }
                 });
                 
             
             return null;
         }
     };
      
     Service process = new Service() {
    @Override
    protected Task createTask() {
        return new Task() {
            @Override protected Void call() throws Exception {
             List<List<Joueur>> listeSauvegardeJoueur = m_controller.getListeSauvegardeJoueur();
            List<Node> listeC = conteneurJoueur.getChildren();
            while(indexListe<listeSauvegardeJoueur.size()-1)

       {
            indexListe = indexListe + 1;
            System.out.println(indexListe);
           if(indexListe == 0)
           {
                for(Joueur J : listeSauvegardeJoueur.get(indexListe))
                {
                    for(Node cercle : listeC)
                    {
                         float xJoueur=J.getCoordonneesJoueur().x;
                         float yJoueur=J.getCoordonneesJoueur().y;
                         float xCercle =(float)cercle.getLayoutX();
                         float yCercle=(float)cercle.getLayoutY();

                         if((xJoueur == xCercle) && (yJoueur == yCercle) && cercle.getClass() == Circle.class)
                          {
                              IteratingTask1 task = new IteratingTask1((Circle)cercle);
                              Thread th = new Thread(task);
                                th.setDaemon(true);
                                th.start();
                                
                          }
                    }
                }
                
           }
           
           
           else
           {
                for(Joueur J : listeSauvegardeJoueur.get(indexListe-1))
                {
                    for(Node cercle : listeC)
                    {
                         float xJoueur=J.getCoordonneesJoueur().x;
                         float yJoueur=J.getCoordonneesJoueur().y;
                         float xCercle =(float)cercle.getLayoutX();
                         float yCercle=(float)cercle.getLayoutY();

                         if((xJoueur == xCercle) && (yJoueur == yCercle) && cercle.getClass() == Circle.class)
                          {
                              IteratingTask0 task = new IteratingTask0((Circle)cercle);
                              Thread th = new Thread(task);
                                th.setDaemon(true);
                                th.start();
                                

  
                          }
                    }
                }
                
                for(Joueur J : listeSauvegardeJoueur.get(indexListe))
                {
                    for(Node cercle : listeC)
                    {
                         float xJoueur=J.getCoordonneesJoueur().x;
                         float yJoueur=J.getCoordonneesJoueur().y;
                         float xCercle =(float)cercle.getLayoutX();
                         float yCercle=(float)cercle.getLayoutY();

                         if((xJoueur == xCercle) && (yJoueur == yCercle)&& cercle.getClass() == Circle.class)
                          {
                              IteratingTask1 task = new IteratingTask1((Circle)cercle);
                              Thread th = new Thread(task);
                                th.setDaemon(true);
                                th.start();

                          }
                    }
                }
                
                
               
           }
           

            
            Thread.sleep(1000);
       }
             return null;
         }
        };
    }
};
      
     
 
    @FXML
    public void debuterStrategie()
    {   
        process.start();
        onPause = false;
    }
    
    
    @FXML
    public void stopStrategie()
    {
        
        process.cancel();
        process.reset();
        onPause = true;
    }
    
    
    @FXML
    public void avancerStrategie()
    {
        List<List<Joueur>> listeSauvegardeJoueur = m_controller.getListeSauvegardeJoueur();
        
        if(onPause==true)
        {
            if(indexListe<listeSauvegardeJoueur.size()-1)
            {
            
            
            List<Node> listeC = conteneurJoueur.getChildren();
            indexListe = indexListe + 1;
            for(Joueur J : listeSauvegardeJoueur.get(indexListe-1))
                {
                    for(Node cercle : listeC)
                    {
                         float xJoueur=J.getCoordonneesJoueur().x;
                         float yJoueur=J.getCoordonneesJoueur().y;
                         float xCercle =(float)cercle.getLayoutX();
                         float yCercle=(float)cercle.getLayoutY();

                         if((xJoueur == xCercle) && (yJoueur == yCercle) && cercle.getClass() == Circle.class)
                          {
                              /*IteratingTask0 task = new IteratingTask0((Circle)cercle);
                              Thread th = new Thread(task);
                                th.setDaemon(true);
                                th.start();*/
                              
                              cercle.setOpacity(0.5);

  
                          }
                    }
                }
                for(Joueur J : listeSauvegardeJoueur.get(indexListe))
                {
                    for(Node cercle : listeC)
                    {
                         float xJoueur=J.getCoordonneesJoueur().x;
                         float yJoueur=J.getCoordonneesJoueur().y;
                         float xCercle =(float)cercle.getLayoutX();
                         float yCercle=(float)cercle.getLayoutY();

                         if((xJoueur == xCercle) && (yJoueur == yCercle)&& cercle.getClass() == Circle.class)
                          {
                              /*IteratingTask1 task = new IteratingTask1((Circle)cercle);
                              Thread th = new Thread(task);
                                th.setDaemon(true);
                                th.start();*/
                              
                              cercle.setOpacity(1.0);

                          }
                    }
            
            
            
                }
            }
        
    }
        
    }
    
    @FXML
    public void reculerStrategie()
    {
        List<List<Joueur>> listeSauvegardeJoueur = m_controller.getListeSauvegardeJoueur();
        if(onPause==true)
        {
            if(indexListe>0)
            {
            
            
            List<Node> listeC = conteneurJoueur.getChildren();
            indexListe = indexListe - 1;
            for(Joueur J : listeSauvegardeJoueur.get(indexListe+1))
                {
                    for(Node cercle : listeC)
                    {
                         float xJoueur=J.getCoordonneesJoueur().x;
                         float yJoueur=J.getCoordonneesJoueur().y;
                         float xCercle =(float)cercle.getLayoutX();
                         float yCercle=(float)cercle.getLayoutY();

                         if((xJoueur == xCercle) && (yJoueur == yCercle) && cercle.getClass() == Circle.class)
                          {
                              /*IteratingTask0 task = new IteratingTask0((Circle)cercle);
                              Thread th = new Thread(task);
                                th.setDaemon(true);
                                th.start();*/
                              
                              cercle.setOpacity(0.5);

  
                          }
                    }
                }
                for(Joueur J : listeSauvegardeJoueur.get(indexListe))
                {
                    for(Node cercle : listeC)
                    {
                         float xJoueur=J.getCoordonneesJoueur().x;
                         float yJoueur=J.getCoordonneesJoueur().y;
                         float xCercle =(float)cercle.getLayoutX();
                         float yCercle=(float)cercle.getLayoutY();

                         if((xJoueur == xCercle) && (yJoueur == yCercle)&& cercle.getClass() == Circle.class)
                          {
                              /*IteratingTask1 task = new IteratingTask1((Circle)cercle);
                              Thread th = new Thread(task);
                                th.setDaemon(true);
                                th.start();*/
                              
                              cercle.setOpacity(1.0);

                          }
                    }
            
            
            
                }
            }
        
    }
        
    }
        


   
   @FXML public void recommencerStrategie(ActionEvent e)
   {
       ObservableList<Node> listeC = conteneurJoueur.getChildren();
       List<List<Joueur>> listeJ = m_controller.getListeSauvegardeJoueur();
       List<Joueur> listeSauvegarde = new ArrayList<>();
       indexListe = -1;
       for(List<Joueur> LJ : listeJ)
       {
        for(Joueur j : LJ)
         { 
             java.awt.Color color = j.getCouleurChandail();
             int r = color.getRed();
             int g = color.getGreen();
             int b = color.getBlue();
             int a = color.getAlpha();
             java.awt.Color nColor = new java.awt.Color(r, g, b, 127);
             j.setCouleurChandail(nColor);

                 for(Node cercle : listeC)
                 {
                     float xJoueur=j.getCoordonneesJoueur().x;
                     float yJoueur=j.getCoordonneesJoueur().y;
                     float xCercle =(float)cercle.getLayoutX();
                     float yCercle=(float)cercle.getLayoutY();
                     if((xJoueur == xCercle) && (yJoueur == yCercle))
                     {      
                             cercle.setOpacity(127.0/255.0);
                         }
                     }
                 }
       }

       process.restart();
   }
   
           

       
            
   
    //@FXML
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
            m_controller.setStateMaxJoueur(true);
            txtJoueurMax.setDisable(false);
        }
        else
        {
            m_controller.setStateMaxJoueur(false);
            txtJoueurMax.setDisable(true);
        }
    }

    /**
     *
     */
    @FXML
    public void coordonnee_interfaceI (){
        conteneurJoueur.setOnMouseMoved((MouseEvent event) -> {
            
            double dimensionX = event.getX() ;
            double dimensionY = event.getY();
            
            double doubleDimensionX;
            double doubleDimensionY ;
            doubleDimensionX = m_controller.getDimensionX() ;
            doubleDimensionY = m_controller.getDimensionY();
            testDimensionX.setVisible(false);
            testDimensionY.setVisible(false);
            
            String msg0 = "X : " +  dimensionX + " Y : "  + dimensionY;
            String msg1 = "X : " +  dimensionX/doubleDimensionX + " Y : "  + dimensionY/doubleDimensionY;
            labelcoordonneeI.setText(msg0);
            labelcoordonneeI1.setText(msg1);
        });
    }
    
   @FXML
    public void bougerInterface () {
        
        conteneurJoueur.setOnMousePressed(new EventHandler<MouseEvent>(){
        @Override public void handle(MouseEvent event) { 
            if( event.isSecondaryButtonDown()){    
            sourisPositionX = event.getSceneX();
            sourisPositionY = event.getSceneY();
            transfererPositionX = conteneurJoueur.getTranslateX();
            transfererPositionY = conteneurJoueur.getTranslateY();
            transfererPositionX = imgsurface.getTranslateX();
            transfererPositionY = imgsurface.getTranslateY();
            }
        }
        });
        conteneurJoueur.setOnMouseDragged(new EventHandler<MouseEvent>(){
        @Override public void handle(MouseEvent event) { 
            if(event.isSecondaryButtonDown()){  
            conteneurJoueur.setTranslateX(transfererPositionX + 
                    (event.getSceneX() - sourisPositionX));
            conteneurJoueur.setTranslateY(transfererPositionY + 
                    (event.getSceneY() - sourisPositionY));
            
            imgsurface.setTranslateX(transfererPositionX + 
                    (event.getSceneX() - sourisPositionX));
            imgsurface.setTranslateY(transfererPositionY + 
                    (event.getSceneY() -  sourisPositionY));
            event.consume();
            }
        }
        });  
    }

   @FXML
    public void zoom (){
    
     conteneurJoueur.setOnScroll(new EventHandler<ScrollEvent>() {
      @Override public void handle(ScrollEvent event) { 
            double delta = 1.2;
            double scale = myScale.get(); 
            double oldScale = scale;
            //Nous avons seulement besoins de travailler avec la valeur deltaY
            if (event.getDeltaY() < 0)
                scale /= delta;
            
            else scale *= delta;
            
            double reposition = (scale / oldScale)-1;
            
            
            
            double dimensionImagex = (event.getSceneX() - 
                    (imgsurface.getBoundsInParent().getWidth()/2 + 
                    imgsurface.getBoundsInParent().getMinX()));
            
            double dimensionImagey = (event.getSceneY() - 
                    (imgsurface.getBoundsInParent().getHeight()/2 + 
                    imgsurface.getBoundsInParent().getMinY()));
            
            imgsurface.setTranslateX(imgsurface.getTranslateX()-
                    (reposition*dimensionImagex));
            imgsurface.setTranslateY(imgsurface.getTranslateY()-
                    (reposition*dimensionImagey));
            
            myScale.set(scale);
            
            double dimensionPanex = (event.getSceneX() - 
                    (conteneurJoueur.getBoundsInParent().getWidth()/2 + 
                    conteneurJoueur.getBoundsInParent().getMinX()));
            double dimensionPaney= (event.getSceneY() - 
                    (conteneurJoueur.getBoundsInParent().getHeight()/2 + 
                    conteneurJoueur.getBoundsInParent().getMinY()));
            
            conteneurJoueur.setTranslateX(conteneurJoueur.getTranslateX()-
                    (reposition*dimensionPanex));
            conteneurJoueur.setTranslateY(conteneurJoueur.getTranslateY()-
                    (reposition*dimensionPaney)); 
           
            event.consume();
   
    }   
               }); 
 
    }
   
   @FXML
   public void sortieInterfaceI () {
      conteneurJoueur.setOnMouseExited((MouseEvent) -> {
          String msg = "X : 0"+", Y : 0";
          labelcoordonneeI.setText(msg);
      });
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
            controller.initialize(this);
            stage.show();
        }
    }
    

    public void setTitle(String p_title)
    {
        Stage currentStage = (Stage) boiteverticale.getScene().getWindow();
        currentStage.setTitle(p_title);
    }

    public void setController (VisuaLigueController p_controller){
        m_controller = p_controller;
    }
    
    public void setJoueur()
    {
        List<Joueur> joueur = m_controller.getListJoueurs();
        
        Iterator<Joueur> iterateur = joueur.iterator();
        
        while(iterateur.hasNext())
        {
            Joueur joueurAjouter = iterateur.next();
            
            //Convertie couleur AWT(domaine) à FX pour l'interface
            java.awt.Color couleurAWTEquipe = joueurAjouter.getCouleurChandail();
            Color colorJoueur = javafx.scene.paint.Color.rgb(couleurAWTEquipe.getRed(), couleurAWTEquipe.getGreen(), couleurAWTEquipe.getBlue(), 1.0);
            
            
            Circle cercle = new Circle(15, colorJoueur);
            cercle.setOpacity(couleurAWTEquipe.getAlpha()/255.0);
            cercle.setLayoutX(joueurAjouter.getCoordonneesJoueur().x);
            cercle.setLayoutY(joueurAjouter.getCoordonneesJoueur().y);
            cercle.setCursor(Cursor.HAND);
            cercle.setOnMousePressed(circleOnMousePressedEventHandler);
            cercle.setOnMouseDragged(circleOnMouseDraggedEventHandler);
            cercle.setOnMouseEntered(circleOnMouseEnteredEventHandler);
            cercle.setOnMouseReleased(circleOnMouseReleasedEventHandler);
            cercle.setOnMouseClicked(circleOnRightMouseClickEventHandler);
            cercle.setId(""+joueurAjouter.getId());

            Label labelRolePosition = new Label(joueurAjouter.getRoleJoueur() + "\n" + joueurAjouter.getPositionJoueur());
            labelRolePosition.setLayoutX(joueurAjouter.getCoordonneesJoueur().x+20);
            labelRolePosition.setLayoutY(joueurAjouter.getCoordonneesJoueur().y-15);
            labelRolePosition.setId(""+joueurAjouter.getId());
            labelRolePosition.setVisible(false);
            
            // AJOUT DU BOUTON DROIT
            Button boutonRotationDroite = new Button ("\u21BB") ; 
            boutonRotationDroite.setLayoutX(joueurAjouter.getCoordonneesJoueur().x+5);
            boutonRotationDroite.setLayoutY(joueurAjouter.getCoordonneesJoueur().y+20);
            boutonRotationDroite.setId(""+joueurAjouter.getId());
            boutonRotationDroite.setVisible(false);

            //AJOUT DU BOUTON GAUCHE
            Button boutonRotationGauche = new Button ("\u21BA") ;
            boutonRotationGauche.setLayoutX(joueurAjouter.getCoordonneesJoueur().x-35);
            boutonRotationGauche.setLayoutY(joueurAjouter.getCoordonneesJoueur().y+20);
            boutonRotationGauche.setId(""+joueurAjouter.getId());
            boutonRotationGauche.setVisible(false);

            //AJOUT DE LA FLÈCHE
            Label labelJoueurRotation = new Label("\u27a4");
            labelJoueurRotation.setRotate(joueurAjouter.getOrientationJoueur());
            labelJoueurRotation.setLayoutX(joueurAjouter.getCoordonneesJoueur().x-6);
            labelJoueurRotation.setLayoutY(joueurAjouter.getCoordonneesJoueur().y-35); 
            labelJoueurRotation.setScaleX(labelJoueurRotation.getScaleX()*2);
            labelJoueurRotation.setScaleY(labelJoueurRotation.getScaleY()*2);
            labelJoueurRotation.setId(""+joueurAjouter.getId());

            //EVENT POUR LES BOUTONS
            boutonRotationDroite.setOnMouseClicked((MouseEvent eventrotation)->{
                labelJoueurRotation.setRotate(labelJoueurRotation.getRotate()+20);
            });

            boutonRotationGauche.setOnMousePressed((MouseEvent eventrotation)->{
                labelJoueurRotation.setRotate(labelJoueurRotation.getRotate()-20);
            });
                       
           
            if (afficherRPJoueur.isSelected())
            {
                labelRolePosition.setVisible(true);
            }
            
            if(afficherRotation.isSelected()){                     
                boutonRotationDroite.setVisible(true);
                boutonRotationGauche.setVisible(true);
                labelJoueurRotation.setVisible(true);
            }
            else
            {
                boutonRotationDroite.setVisible(false);
                boutonRotationGauche.setVisible(false);
                labelJoueurRotation.setVisible(false);
            }

            list_labelRolePosition.add(labelRolePosition);
            list_labelJoueurRotation.add(labelJoueurRotation);
            list_buttonRotationGauche.add(boutonRotationGauche);
            list_buttonRotationDroite.add(boutonRotationDroite);
            conteneurJoueur.getChildren().addAll(cercle, labelRolePosition,labelJoueurRotation,boutonRotationGauche,boutonRotationDroite);     
        }
        
        if (afficherRotation.isSelected())
        {
            label_afficherRotationPosition = true;    
        }
        else
        {
            label_afficherRotationPosition = false; 
        }
        
        
        if (afficherRPJoueur.isSelected())
        {
            label_afficherRolePosition = true;
        }
        else
        {
            label_afficherRolePosition = false;
        }
    }
    
    public void setObstacle()
    {
        List<Obstacle> obstacle = m_controller.getListeObstacle();
        
        Iterator<Obstacle> iterateur = obstacle.iterator();
        
        while(iterateur.hasNext())
        {
            Obstacle obstacleAjouter = iterateur.next();
            int x = obstacleAjouter.getLargeur();
            int y = obstacleAjouter.getHauteur();
            String pathImage = obstacleAjouter.getImageObs();
            File imageFile = new File(pathImage);
            String imagepath;
            try {
                imagepath = imageFile.toURI().toURL().toString();
                Image imageObs = new Image(imagepath);
                ImagePattern imagePattern = new ImagePattern(imageObs);
                Rectangle rekt = new Rectangle(x,y);
                rekt.setLayoutX(obstacleAjouter.getCoordonneeObs().x - largeurObstacle/2);
                rekt.setLayoutY(obstacleAjouter.getCoordonneeObs().y - hauteurObstacle/2);
                rekt.setCursor(Cursor.HAND);
                rekt.setOnMouseClicked(obsOnRightMouseClickEventHandler);
                nodes.add(rekt);
                rekt.setFill(imagePattern);
                conteneurJoueur.getChildren().addAll(rekt);
                
            } catch (MalformedURLException ex) {
                Logger.getLogger(Interface_image_par_imageController.class.getName()).log(Level.SEVERE, null, ex);
            }         
        }
        
    }
    
    public void setObjectif()
    {
        List<Objectif> objectif = m_controller.getListeObjectif();
        
        Iterator<Objectif> iterateur = objectif.iterator();
        
        while(iterateur.hasNext())    
        {
            Objectif objectifAjouter = iterateur.next();
            
            String pathImage = objectifAjouter.getImage();
            File imageFile = new File(pathImage);
            String imagepath;
            try {
                imagepath = imageFile.toURI().toURL().toString();
                Image imageObs = new Image(imagepath);
                ImagePattern imagePattern = new ImagePattern(imageObs);
                Circle cercle = new Circle(10);
                cercle.setLayoutX(objectifAjouter.getCoordonneesObj().x);
                cercle.setLayoutY(objectifAjouter.getCoordonneesObj().y);
                cercle.setCursor(Cursor.HAND);
                cercle.setOnMousePressed(objOnMousePressedEventHandler);
                cercle.setOnMouseDragged(objOnMouseDraggedEventHandler);
                cercle.setOnMouseEntered(objOnMouseEnteredEventHandler);
                cercle.setOnMouseReleased(objOnMouseReleasedEventHandler);
                cercle.setOnMouseClicked(objOnRightMouseClickEventHandler);
                cercle.setFill(imagePattern);
                conteneurJoueur.getChildren().addAll(cercle);

                
            } catch (MalformedURLException ex) {
                Logger.getLogger(Interface_image_par_imageController.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
    }
    
    //test
    public void setJoueurMax()
    {
        txtJoueurMax.setText(Integer.toString(m_controller.getJoueurMax()));
    }
    
    public void setObjeticAjoueter(String p_Objectif){
        objectifAjouer = p_Objectif;
    }
    
    public void setOjbectifImage(Image p_image){
        imageObjectif = p_image;
    }
    
    public void setImageObstacle(Image p_image){
        imageObstacle = p_image;
    }
    
    public void setNomObstacle(String p_nom){
       nomObstacle = p_nom;
    }
    
    public void setTypeObstacle(String p_type){
       typeObstacle = p_type;
    }
    
    
    public void setHautObstacle(int p_hauteur){
       hauteurObstacle = p_hauteur;
    }
   
    public void setLargObstacle(int p_largeur){
       largeurObstacle = p_largeur;
    }
    
    public void setImagePathObstacle(String p_path)
    {
        imageObstaclePath = p_path;
    }
    
    public void setImagePathObjectif(String p_path)
    {
        imageObjectifPath = p_path;
    }
    
    
    public void setStateMaxJoueur(){
        if(m_controller.getStateMaxJoueur())
        {
            cbJoueurMax.setSelected(true);
            txtJoueurMax.setDisable(false);
        }
        else
        {
            cbJoueurMax.setSelected(false);
            txtJoueurMax.setDisable(true);
        }
    }
    
    public void setStateAfficherPosition(){
        if(m_controller.getStateAfficherRP())
        {
            afficherRPJoueur.setSelected(true);
        }
        else
        {
            afficherRPJoueur.setSelected(false);
        }    
    }
    
    public void setStateOrientation(){
        if(m_controller.getStateAfficherOriantation())
        {
            afficherRotation.setSelected(true);
        }
        else
        {
            afficherRotation.setSelected(false);
        }  
    }
    //public void setStateAfficherBD()

    @FXML
    public void screenShotInterfaceAction ()   {
    
            
     
}

}  

