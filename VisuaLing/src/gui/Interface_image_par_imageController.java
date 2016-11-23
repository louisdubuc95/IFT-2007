/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controller.VisuaLigueController;
import domain.equipe.Equipe;
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
import javafx.geometry.Pos;
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
    @FXML private ToggleButton boutonObjectif;
   
    //@FXML private Boolean VerifAjoutJoueur = false;

   
    @FXML private ToggleButton boutonAjouterObstacle;
    @FXML private Button boutonSauvegarder;
    @FXML private Button boutonChangerSports;
    @FXML MenuBar menuBarSport;
    @FXML private Canvas canevasInterface;
   
    @FXML private CheckBox cbJoueurMax;
    @FXML private TextField txtJoueurMax;
    
    
    
    @FXML ImageView imgsurface ;
    //coordonée
    @FXML private Label labelcoordonneeI;
    @FXML private Label  coordoneeI ;
    
    @FXML private String imagePath;
    @FXML private Color color;
    
    @FXML private ToggleGroup group ;
    private double x0, y0;
    @FXML private StackPane stackSurface ; 
    @FXML private Button btnnouveauSportAction;
    @FXML private AnchorPane boiteverticale ; 
    @FXML private HBox boiteHorizontaleBouton ; 
    @FXML private Button boutonTransfert ;  
    @FXML private Separator separateur1 ;
    @FXML private Separator separateur5 ;
    @FXML private Button boutonAvancer ;
    @FXML private Label testDimensionX;
    @FXML private Label testDimensionY;
    @FXML public static Stage primaryStage;
    private String m_equipe;
    private int m_nbEquipeMax;
    private double m_x;
    private double m_y;
    
    @FXML public List<String> listeRoles;
    
    //@FXML private 
    
     //instance du controller de Larman
     VisuaLigueController m_controller = new VisuaLigueController();
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
    menuBarSport.prefWidthProperty().bind(boiteverticale.widthProperty());
    boiteHorizontaleBouton.prefWidthProperty().bind(boiteverticale.widthProperty());
    separateur1.prefWidthProperty().bind(boutonAjouterJoueur.widthProperty());
    separateur5.prefWidthProperty().bind(boutonTransfert.widthProperty());
    separateur5.prefWidthProperty().bind(boiteHorizontaleBouton.widthProperty());
    stackSurface.prefHeightProperty().bind(boiteverticale.heightProperty());
    stackSurface.toBack();
    stackSurface.setAlignment(Pos.CENTER); 
    listeRoles = new ArrayList<>();
    }
    
    
   public void getX(String dimensionX){
     testDimensionX.setText(dimensionX); 
     m_x = Double.parseDouble(dimensionX);
     
   }
   public void getY(String dimensionY){
    testDimensionY.setText(dimensionY);
    m_y = Double.parseDouble(dimensionY);
   }
    public void nouveauSportAction(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("Interface_choix_mode.fxml"));
          Stage stage = new Stage(StageStyle.DECORATED);
          stage.setTitle("Nouveau Sport");
          stage.setScene(new Scene((AnchorPane) loader.load()));
          //Show la nouvelle window
          stage.show();
    }
    
    
    public void ChargerAction(ActionEvent event) throws IOException {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("Interface_accueil.fxml"));
      Stage stage = new Stage(StageStyle.DECORATED);
      stage.setTitle("Charger Jeu");
      stage.setScene(new Scene((AnchorPane) loader.load()));
      //Show la nouvelle window
      stage.show();
    }
    
      public void OuvrirInfoAction(ActionEvent event) throws IOException {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("Interface_InfoBox.fxml"));
      Stage stage = new Stage(StageStyle.DECORATED);
      stage.setTitle("Informations");
      stage.setScene(new Scene((AnchorPane) loader.load()));
      //Show la nouvelle window
      stage.show();
    }

    public void setImageInterface(String imageSurface) {
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
            Logger.getLogger(Interface_image_par_imageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setNombreEquipeInterface(int nombreEquipe){
        m_nbEquipeMax = nombreEquipe;
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
        String title = currentStage.getTitle();
        title = title.replaceAll(" - mode Image par Image", "");
        controller.setTitle(title);
        controller.setNombreEquipe(m_nbEquipeMax);
        controller.setX(m_x);
        controller.setY(m_y);
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
          FXMLLoader loader = new FXMLLoader(getClass().getResource("Interface_Sauvegarde.fxml"));
          Stage stage = new Stage(StageStyle.DECORATED);
          stage.setTitle("Sauvegarder");
          stage.setScene(new Scene((AnchorPane) loader.load()));
          
          //Show la nouvelle window
          stage.show();
    }
    
    @FXML 
    public void ajouterJoueurInterface()  {
        List<Equipe> listeEquipe = m_controller.getListEquipe();
        canevasInterface.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override public void handle(MouseEvent event){
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
                                if(equipe.getList_joueurs().size() <= Integer.parseInt(txtJoueurMax.getText()) )
                                {
                                    float x = (float) event.getX();
                                    float y = (float) event.getY();

                                    Point2D.Float p = new Point2D.Float(x,y);

                                    if(equipe.estMemeNom(m_equipe)){
                                        if(!m_controller.joueurEstPresent(p))
                                        {
                                            Color couleurEquipe = equipe.getCouleur();
                                            GraphicsContext gc = canevasInterface.getGraphicsContext2D();
                                            gc.setFill(couleurEquipe);
                                            gc.fillOval(event.getX(),event.getY(),20,20);
                                            m_controller.addJoueur(p, color);
                                        }
                                    }
                                }
                                else
                                {
                                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                    alert.setTitle("Information");
                                    alert.setHeaderText("Information sur la création de joueur!");
                                    alert.setContentText("Le nombre de joueur est égale ou suppérieur à la limite configurer!");
                                    alert.showAndWait();
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
                                    Color couleurEquipe = equipe.getCouleur();
                                    GraphicsContext gc = canevasInterface.getGraphicsContext2D();
                                    gc.setFill(couleurEquipe);
                                    gc.fillOval(event.getX(),event.getY(),20,20);
                                    m_controller.addJoueur(p, color);
                                }
                            }
                        }
                    } 
                   }  
                }
            
         });  
    }
    
    //@FXML
    public void setEquipe(String p_equipe) {
        m_equipe= p_equipe;
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
        canevasInterface.setOnMouseMoved(new EventHandler<MouseEvent>() {
      @Override public void handle(MouseEvent event) {
          // 1056 (nb de pixel de largeur) / 18.57 = 60.96m (grandeur patinoire nhl) 
          // 537  (nb de pixel de hauteur  / 20.73 = 25.8m (grandeur patinoire ngl)
          // on va remplacer la grandeur par les parametres entré par l'utilisateur.
          //je suis pas certain si je peux mettre ca ici ou il faut que ce soit dans le controleur de larman. 
          // et je sais pas trop comment limité au centième...ca reste a voir
        double dimensionX = event.getX() ;
        double dimensionY = event.getY(); 
        
        double doubleDimensionX; 
        double doubleDimensionY ; 
        doubleDimensionX = Double.valueOf(testDimensionX.getText());
        doubleDimensionY = Double.valueOf(testDimensionX.getText());
        
        String msg1 = "X : " +  dimensionX/doubleDimensionX + " Y : "  + dimensionY/doubleDimensionY;
        labelcoordonneeI.setText(msg1);
       
        }
    });
    }
    
   @FXML
    public void zoom (){
    
      canevasInterface.setOnScroll(new EventHandler<ScrollEvent>() {
      @Override public void handle(ScrollEvent event) { 
      double zoomFactor = 1.05;
       double deltaY = event.getDeltaY();
       //double deltaX = event.getDeltaX();
       if (deltaY < 0) {
                    zoomFactor = 2 - zoomFactor;
                }   
       
       //stackSurface.setScaleX(stackSurface.getScaleY () * zoomFactor);
      // stackSurface.setScaleY(stackSurface.getScaleY() * zoomFactor);
       
       
     
       canevasInterface.setScaleX(canevasInterface.getScaleX () * zoomFactor);
       canevasInterface.setScaleY(canevasInterface.getScaleY() * zoomFactor);
       imgsurface.setScaleX(canevasInterface.getScaleX () * zoomFactor);
       imgsurface.setScaleY(canevasInterface.getScaleY() * zoomFactor);
       event.consume();
       System.out.println("sup");
      
    }   
               });
    }
    /*canevasInterface.setOnScroll(new EventHandler<ScrollEvent>() {
      @Override public void handle(ScrollEvent event) {
       double zoomFactor = 1.05;
       double deltaY = event.getDeltaY();
       //double deltaX = event.getDeltaX();
       if (deltaY < 0) {
                    zoomFactor = 2 - zoomFactor;
                }   
       canevasInterface.setScaleX(canevasInterface.getScaleX () * zoomFactor);
       canevasInterface.setScaleY(canevasInterface.getScaleY() * zoomFactor);
            }
    });
      imgsurface.setOnScroll(new EventHandler<ScrollEvent>() {
      @Override public void handle(ScrollEvent event) {
       double zoomFactor = 1.05;
       double deltaY = event.getDeltaY();
      
       //double deltaX = event.getDeltaX();
       if (deltaY < 0) {
                    zoomFactor = 2 - zoomFactor;
                }
            
       imgsurface.setScaleX(imgsurface.getScaleX () * zoomFactor);
       imgsurface.setScaleY(imgsurface.getScaleY() * zoomFactor);
       event.consume();
  System.out.println("sup");
    }
        });
    
    }  */

            
    //Lamnbda expression "->" c'est la même chose que la fonction coordonee_interface. C'est juste plus rapide codé comme ça 
    //lorsque l'utilisateur sort la souris de l'interface de jeu, remet le conteur a zero. 
   
    /**
     *
     */
    
    
   @FXML
   public void sortieInterfaceI () {
      canevasInterface.setOnMouseExited((MouseEvent) -> {
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
    
    @FXML
    public void setTitle(String p_title)
    {
        Stage currentStage = (Stage) boiteverticale.getScene().getWindow();
        currentStage.setTitle(p_title);
    }


}    


