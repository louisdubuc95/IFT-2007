/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controller.VisuaLigueController;
import domain.Enregistrement;
import domain.equipe.Equipe;
import domain.joueur.Joueur;
import java.awt.Point;
import java.awt.event.WindowEvent;
import java.awt.geom.Point2D;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
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
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.chart.NumberAxis;
import javafx.scene.input.ScrollEvent;
import javafx.scene.input.SwipeEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import javafx.scene.image.ImageView ;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox ;  

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
    Group root = new Group();
   
    //@FXML private Boolean VerifAjoutJoueur = false;

   
    @FXML private ToggleButton boutonAjouterObstacle;
    @FXML private Button boutonSauvegarder;
    @FXML private Button boutonChangerSports;
    @FXML MenuBar menuBarSport;
    
    @FXML private CheckBox cbJoueurMax;
    @FXML private TextField txtJoueurMax;
    @FXML private Pane conteneurJoueur;
    @FXML private CheckBox afficherRPJoueur;
    @FXML private boolean desafficherRPJoueur;
    @FXML ImageView imgsurface ;
    
    
    
    private Joueur joueurCourant;
    private Color couleurCourante;
    private Circle cercleCourant;
    
    
    
    
    //coordonée
    @FXML private Label labelcoordonneeI;
    @FXML private Label labelcoordonneeI1;
    
    @FXML private Label  coordoneeI ;
    
    @FXML private String imagePath;
    @FXML private Color color;
    
    
    private double x0, y0;
    @FXML private StackPane stackSurface ;
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
    private String m_equipe;
    private String m_role;
    private String m_position;
    private float m_orientation;
    private int m_nbEquipeMax;
    private double m_x;
    private double m_y;
    
    double orgSceneX, orgSceneY;
    double orgTranslateX, orgTranslateY;
    
    private DoubleProperty myScale = new SimpleDoubleProperty(1.0);
    double sourisPositionX;
    double sourisPositionY;
    double transfererPositionX;
    double transfererPositionY;
    
    @FXML public List<String> listeRoles = new ArrayList<>();
    
    //@FXML private 
    
    //instance du controller de Larman
    public VisuaLigueController m_controller = new VisuaLigueController();
    public Enregistrement m_enregistrement = new Enregistrement();
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
    menuBarSport.prefWidthProperty().bind(boiteverticale.widthProperty());
    boiteHorizontaleBouton.prefWidthProperty().bind(boiteverticale.widthProperty());
    separateur1.prefWidthProperty().bind(boutonAjouterEquipe.widthProperty());
    separateur5.prefWidthProperty().bind(boutonAvancer.widthProperty());
    separateur5.prefWidthProperty().bind(boiteHorizontaleBouton.widthProperty());
    separateur10.prefWidthProperty().bind(boiteHorizontaleBouton2.widthProperty());
    boiteHorizontaleBouton2.prefWidthProperty().bind(boiteverticale.widthProperty());
   
    
   // stackSurface.prefHeightProperty().bind(boiteverticale.heightProperty());
    stackSurface.toBack();
   // stackSurface.setAlignment(Pos.CENTER); 
    imgsurface.scaleXProperty().bind(myScale);
    imgsurface.scaleYProperty().bind(myScale);
    conteneurJoueur.scaleXProperty().bind(myScale);
    conteneurJoueur.scaleYProperty().bind(myScale);
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
    
    @FXML void afficherRoleJoueur(ActionEvent e) throws IOException{
        if(afficherRPJoueur.isSelected())
        {
            
        }
        if(!afficherRPJoueur.isSelected())
        {
            
        }
    }
    
    @FXML
    public void ajouterObstacleAction(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifObstacle.fxml"));
          Stage stage = new Stage(StageStyle.DECORATED);
          stage.setTitle("Ajout obstacle");
          stage.setScene(new Scene((AnchorPane) loader.load()));
         if (boutonAjouterObstacle.isSelected()){
          //Fonction qui bloque les window deriere la nouvelle
          Stage currentStage = (Stage) boiteverticale.getScene().getWindow();
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
    public void ajouterObstacleInterface (){
        
    }
          
    @FXML
    public void ajouterObjectifButton(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("Interface_CreerObjectif.fxml"));
          Stage stage = new Stage(StageStyle.DECORATED);
          stage.setTitle("Ajout objectif");
          stage.setScene(new Scene((AnchorPane) loader.load()));
         if (boutonObjectif.isSelected()){
          Stage currentStage = (Stage) boiteverticale.getScene().getWindow();
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
    public void ajouterObjectifInterface (){
        
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
            stage.show();
    }
    
    @FXML 
    public void ajouterJoueurInterface()  {
        List<Equipe> listeEquipe = m_controller.getListEquipe();
        conteneurJoueur.setOnMouseClicked((MouseEvent event) -> {
            if(event.getClickCount()==2)
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
                                            
                                            //Create Circles
                                            Circle cercle = new Circle(15, couleurEquipe);
                                            cercle.setLayoutX(event.getX());
                                            cercle.setLayoutY(event.getY());
                                            cercle.setCursor(Cursor.HAND);
                                            cercle.setOnMousePressed(circleOnMousePressedEventHandler);
                                            cercle.setOnMouseDragged(circleOnMouseDraggedEventHandler);
                                            cercle.setOnMouseEntered(circleOnMouseEnteredEventHandler);
                                            cercle.setOnMouseReleased(circleOnMouseReleasedEventHandler);
                                            cercle.setOnMouseClicked(circleOnRightMouseClickEventHandler);
                                            
                                            conteneurJoueur.getChildren().add(cercle);
                                            
                                            m_controller.addJoueur(p, couleurAWTEquipe, m_role, m_position, m_orientation, equipe);
                                            List<Joueur> liste_joueurs = m_controller.getListJoueurs();
                                            Joueur dernierJoueur = liste_joueurs.get(liste_joueurs.size()-1);
                                            dernierJoueur.getEquipe().addJoueur(dernierJoueur);
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

                                    Circle cercle = new Circle(15, couleurEquipe);
                                    cercle.setLayoutX(event.getX());
                                    cercle.setLayoutY(event.getY());
                                    cercle.setCursor(Cursor.HAND);
                                    cercle.setOnMousePressed(circleOnMousePressedEventHandler);
                                    cercle.setOnMouseDragged(circleOnMouseDraggedEventHandler);
                                    cercle.setOnMouseEntered(circleOnMouseEnteredEventHandler);
                                    cercle.setOnMouseReleased(circleOnMouseReleasedEventHandler);
                                    cercle.setOnMouseClicked(circleOnRightMouseClickEventHandler);

                                    conteneurJoueur.getChildren().add(cercle);
                                    /*
                                    GraphicsContext gc = canevasInterface.getGraphicsContext2D();
                                    gc.setFill(couleurEquipe);
                                    gc.fillOval(event.getX(),event.getY(),20,20);*/
                                    m_controller.addJoueur(p, couleurAWTEquipe, m_role, m_position, m_orientation, equipe);
                                    List<Joueur> liste_joueurs = m_controller.getListJoueurs();
                                    Joueur dernierJoueur = liste_joueurs.get(liste_joueurs.size()-1);
                                    Equipe equipe_joueur = dernierJoueur.getEquipe();
                                    equipe_joueur.addJoueur(dernierJoueur);
                                }
                            }
                        }
                    }  
                }
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
                        System.out.println(j.getCoordonneesJoueur().x);
                        System.out.println(j.getCoordonneesJoueur().y);
                        System.out.println(cercleCourant.getLayoutX());
                        System.out.println(cercleCourant.getLayoutY());
                        System.out.println("--------------------------------------------------------");
                        

                    }
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
                double offsetX = t.getSceneX() - orgSceneX;
                double offsetY = t.getSceneY() - orgSceneY;
                double newTranslateX = orgTranslateX + offsetX;
                double newTranslateY = orgTranslateY + offsetY;
                ((Circle)(t.getSource())).setLayoutX(newTranslateX);
                ((Circle)(t.getSource())).setLayoutY(newTranslateY);
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
            
            cercleCourant.setCenterX(t.getX());
            cercleCourant.setCenterY(t.getY());
            float xCercle =(float)cercleCourant.getLayoutX();
            float yCercle=(float)cercleCourant.getLayoutY();
            Point2D.Float point = new Point2D.Float(xCercle,yCercle);
            joueurCourant.setCoordonneesJoueur(point);
            //conteneurJoueur.getChildren().clear();
            /*for(Equipe e : listeEquipe)
            {
                
                for(Joueur j : e.getList_joueurs())
                {   
                    Circle cercle2 = new Circle(15, j.getCouleurChandail());
                    cercle2.setCenterX(j.getCoordonneesJoueur().x);
                    cercle2.setCenterY(j.getCoordonneesJoueur().y);
                    conteneurJoueur.getChildren().add(cercle2);

                }
            }*/
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
                    System.out.println(e.getSize());
                    for(Joueur j : e.getList_joueurs())
                    {   float xJoueur=j.getCoordonneesJoueur().x;
                        float yJoueur=j.getCoordonneesJoueur().y;
                        float xCercle =(float)cercle.getCenterX();
                        float yCercle=(float)cercle.getCenterY();
                        if((xJoueur == xCercle) && (yJoueur == yCercle))
                        {
                            e.getList_joueurs().remove(j);
                            System.out.println(e.getSize());
                            listeJoueur.remove(j);
                            break;
                        }
                    }
                }
                
                conteneurJoueur.getChildren().remove(cercle);

                }
            
    };
   };
            
    
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
            txtJoueurMax.setDisable(false);
        }
        else
        {
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


}  

