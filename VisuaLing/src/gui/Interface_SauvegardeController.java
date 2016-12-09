package gui;

import controller.VisuaLigueController;
import domain.Enregistrement;
import domain.joueur.Joueur;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import java.awt.Color ;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import static java.lang.System.gc;
import java.util.Iterator;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javax.imageio.IIOException;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.stream.ImageOutputStream;

import javax.imageio.*;
import javax.imageio.metadata.*;
import javax.imageio.stream.*;
import java.awt.image.*;
import java.io.*;
import java.util.Iterator;

/**
 * FXML Controller class
 *
 * @author willl
 */


public class Interface_SauvegardeController implements Initializable {
    @FXML Button boutonAnnuler;
    @FXML Button boutonSauvegarder;
    @FXML Button boutonExporter;
    @FXML Button boutonCharger;
    @FXML TextField txtNomSauvegarde;
    public int i = 0 ;
    public int a =0 ; 
    private final int ARR_SIZE = 8;
    
    
    //FXMLLoader loader = new FXMLLoader(getClass().getResource("Interface_accueil.fxml")); //public  Interface_image_par_imageController IPIController = new IPIController();
   // Interface_image_par_imageController IPIcontroleur = loader.<Interface_image_par_imageController>getController();
    
    private Interface_image_par_imageController m_parentController;
    
    private Interface_temps_reelController m_parentControllerTR;
    
    
    public VisuaLigueController m_controller;
    //private Interface_image_par_imageController parentController;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void initialize(Interface_image_par_imageController p_controller) {
       m_parentController = p_controller;
    }
    
    public void initializeTR(Interface_temps_reelController p_controller) {
       m_parentControllerTR = p_controller;
    }
    
    @FXML
    public void boutonAnnulerAction(ActionEvent event) {
          Stage stage = (Stage) boutonAnnuler.getScene().getWindow();
          stage.close();
    }
    
    @FXML
    public void boutonExporterAction(MouseEvent event) throws IOException {
        
        Stage stage = (Stage) boutonExporter.getScene().getWindow();  
        
       

        /*List<Node> listeC = m_parentController.conteneurJoueur.getChildren();
           
            while(i  <   m_parentController.m_controller.getListeSauvegardeJoueur().size()-1)
                
            {
                //event.getEventType().equals(MouseEvent.MOUSE_CLICKED) ;
                Joueur J= m_parentController.m_controller.getListeSauvegardeJoueur().get(i).get(0) ;

                Joueur Jnext=  m_parentController.m_controller.getListeSauvegardeJoueur().get(i+1).get(0);

                Line line = new Line() ;
                Line arrow1 = new Line();
                Line arrow2 = new Line();
                line.setStyle("-fx-stroke: black;");

                line.setStartX(J.getCoordonneesJoueur().x);                           
                line.setStartY(J.getCoordonneesJoueur().y);

                line.setEndX(Jnext.getCoordonneesJoueur().x);                           
                line.setEndY(Jnext.getCoordonneesJoueur().y);
 
                double arrowAngle = Math.toRadians(45.0);
                double longueurArrow = 10.0;
        
                double lineAngle = Math.atan2(J.getCoordonneesJoueur().y - Jnext.getCoordonneesJoueur().y,
                J.getCoordonneesJoueur().x - Jnext.getCoordonneesJoueur().x);

                double Xfin1 = Math.cos(lineAngle + arrowAngle) * longueurArrow 
                                         + Jnext.getCoordonneesJoueur().x;
                double Yfin1 = Math.sin(lineAngle + arrowAngle) * longueurArrow 
                                         + Jnext.getCoordonneesJoueur().y;

                double Xfin2 = Math.cos(lineAngle - arrowAngle) * longueurArrow + 
                                            Jnext.getCoordonneesJoueur().x;
                double Yfin2 = Math.sin(lineAngle - arrowAngle) * longueurArrow + 
                        Jnext.getCoordonneesJoueur().y;
                
              
                arrow1.setStartX(Jnext.getCoordonneesJoueur().x);                           
                arrow1.setStartY(Jnext.getCoordonneesJoueur().y);
                arrow1.setEndX(Xfin1);
                arrow1.setEndY(Yfin1);
                arrow2.setStartX(Jnext.getCoordonneesJoueur().x);                           
                arrow2.setStartY(Jnext.getCoordonneesJoueur().y);
                arrow2.setEndX(Xfin2);
                arrow2.setEndY(Yfin2);
                line.setEndX(Jnext.getCoordonneesJoueur().x);                           
                line.setEndY(Jnext.getCoordonneesJoueur().y);
               
        
        //Group root = new Group();

                m_parentController.conteneurJoueur.getChildren().addAll(line,arrow1, arrow2);
                i = i + 1;       
            }
             try {
                SnapshotParameters parameters = new SnapshotParameters();
                
                
                WritableImage wi = new WritableImage((int)m_parentController.stackSurface.getBoundsInParent().getWidth(), (int)m_parentController.stackSurface.getBoundsInParent().getHeight());
                WritableImage snapshot = m_parentController.stackSurface.snapshot(new SnapshotParameters(), wi);
               
                
                
                
                File output = new File("src/Captures/" + new Date().getTime() + ".png");
                ImageIO.write(SwingFXUtils.fromFXImage(snapshot, null), "png", output);
                
                //////
                //Delete lignes
                for(Iterator<Node> it = m_parentController.conteneurJoueur.getChildren().iterator(); it.hasNext();)
                {
                    Node n = it.next();
                    if(n.getClass()==Line.class)
                    {
                        it.remove();
                    }
                }
                
                System.out.println("screen fait");
                
                } 
        catch (IOException ex) {
                    
                System.out.println("fail");
                Logger.getLogger(Interface_image_par_imageController.class.getName()).log(Level.SEVERE, null, ex);
            }   
        
        stage.close();*/
        m_parentController.capture = true;
        m_parentController.serviceExport.start();
        
        ImageOutputStream output = new FileImageOutputStream(new File("src/Captures/a.gif"));
        GifSequenceWriter writer = new GifSequenceWriter(output,m_parentController.listExport.get(0),1000, true);
        for(BufferedImage bi:m_parentController.listExport.get(0))
        {
             writer.writeToSequence(bi);
        }
        writer.close();
        output.close();
        
        
        
        
        
        stage.close();
   
    }
    
    
            
    @FXML
    public void boutonEnregistrerAction(ActionEvent even){
        String validateDot = txtNomSauvegarde.getText();
        if(validateDot.isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Information sur la sauvegarde");
            alert.setContentText("Le fichier de sauvegarde doit avoir un nom!!");
            alert.showAndWait();
        }
        else
        {
            if(validateDot.contains("."))
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText("Information sur la sauvegarde");
                alert.setContentText("Le nom de la sauvegarde ne peut contenir de POINT");
                alert.showAndWait();
            }
            try{
                m_parentControllerTR.m_enregistrement.serialize(validateDot, m_parentControllerTR.m_controller.getController(), "TR");
            }
            catch(NullPointerException e)
            {
                m_parentController.m_enregistrement.serialize(validateDot, m_parentController.m_controller.getController(), "IPI"); 
                
                List<Node> listeC = m_parentController.conteneurJoueur.getChildren();

                    while(i  <   m_parentController.m_controller.getListeSauvegardeJoueur().size()-1)

                    {
                        //event.getEventType().equals(MouseEvent.MOUSE_CLICKED) ;
                        Joueur J= m_parentController.m_controller.getListeSauvegardeJoueur().get(i).get(0) ;

                        Joueur Jnext=  m_parentController.m_controller.getListeSauvegardeJoueur().get(i+1).get(0);

                        Line line = new Line() ;
                        Line arrow1 = new Line();
                        Line arrow2 = new Line();
                        line.setStyle("-fx-stroke: black;");

                        line.setStartX(J.getCoordonneesJoueur().x);                           
                        line.setStartY(J.getCoordonneesJoueur().y);

                        line.setEndX(Jnext.getCoordonneesJoueur().x);                           
                        line.setEndY(Jnext.getCoordonneesJoueur().y);

                        double arrowAngle = Math.toRadians(45.0);
                        double longueurArrow = 10.0;

                        double lineAngle = Math.atan2(J.getCoordonneesJoueur().y - Jnext.getCoordonneesJoueur().y,
                        J.getCoordonneesJoueur().x - Jnext.getCoordonneesJoueur().x);

                        double Xfin1 = Math.cos(lineAngle + arrowAngle) * longueurArrow 
                                                 + Jnext.getCoordonneesJoueur().x;
                        double Yfin1 = Math.sin(lineAngle + arrowAngle) * longueurArrow 
                                                 + Jnext.getCoordonneesJoueur().y;

                        double Xfin2 = Math.cos(lineAngle - arrowAngle) * longueurArrow + 
                                                    Jnext.getCoordonneesJoueur().x;
                        double Yfin2 = Math.sin(lineAngle - arrowAngle) * longueurArrow + 
                                Jnext.getCoordonneesJoueur().y;


                        arrow1.setStartX(Jnext.getCoordonneesJoueur().x);                           
                        arrow1.setStartY(Jnext.getCoordonneesJoueur().y);
                        arrow1.setEndX(Xfin1);
                        arrow1.setEndY(Yfin1);
                        arrow2.setStartX(Jnext.getCoordonneesJoueur().x);                           
                        arrow2.setStartY(Jnext.getCoordonneesJoueur().y);
                        arrow2.setEndX(Xfin2);
                        arrow2.setEndY(Yfin2);
                        line.setEndX(Jnext.getCoordonneesJoueur().x);                           
                        line.setEndY(Jnext.getCoordonneesJoueur().y);


                //Group root = new Group();

                        m_parentController.conteneurJoueur.getChildren().addAll(line,arrow1, arrow2);
                        i = i + 1;       
                    }
                     try {
                        SnapshotParameters parameters = new SnapshotParameters();


                        WritableImage wi = new WritableImage((int)m_parentController.stackSurface.getBoundsInParent().getWidth(), (int)m_parentController.stackSurface.getBoundsInParent().getHeight());
                        WritableImage snapshot = m_parentController.stackSurface.snapshot(new SnapshotParameters(), wi);




                        File output = new File("src/Captures/" + validateDot + ".IPI"+ ".png");
                        ImageIO.write(SwingFXUtils.fromFXImage(snapshot, null), "png", output);

                        //////
                        //Delete lignes
                        for(Iterator<Node> it = m_parentController.conteneurJoueur.getChildren().iterator(); it.hasNext();)
                        {
                            Node n = it.next();
                            if(n.getClass()==Line.class)
                            {
                                it.remove();
                            }
                        }

                        System.out.println("screen fait");

                        } 
                catch (IOException ex) {

                        System.out.println("fail");
                        Logger.getLogger(Interface_image_par_imageController.class.getName()).log(Level.SEVERE, null, ex);
                    }   
            }   
            Stage stage = (Stage) boutonSauvegarder.getScene().getWindow();
            stage.close();   
        }
    }
    
    public void setMaxJoueur(int p_nbJoueurMax)
    {
        m_parentController.m_controller.setJoueurMax(p_nbJoueurMax);
    }
    

    
  public class GifSequenceWriter {
  protected ImageWriter gifWriter;
  protected ImageWriteParam imageWriteParam;
  protected IIOMetadata imageMetaData;
  
  public GifSequenceWriter(
      ImageOutputStream outputStream,
      int imageType,
      int timeBetweenFramesMS,
      boolean loopContinuously) throws IIOException, IOException {
    // my method to create a writer
    gifWriter = getWriter(); 
    imageWriteParam = gifWriter.getDefaultWriteParam();
    ImageTypeSpecifier imageTypeSpecifier =
      ImageTypeSpecifier.createFromBufferedImageType(imageType);

    imageMetaData =
      gifWriter.getDefaultImageMetadata(imageTypeSpecifier,
      imageWriteParam);

    String metaFormatName = imageMetaData.getNativeMetadataFormatName();

    IIOMetadataNode root = (IIOMetadataNode)
      imageMetaData.getAsTree(metaFormatName);

    IIOMetadataNode graphicsControlExtensionNode = getNode(
      root,
      "GraphicControlExtension");

    graphicsControlExtensionNode.setAttribute("disposalMethod", "none");
    graphicsControlExtensionNode.setAttribute("userInputFlag", "FALSE");
    graphicsControlExtensionNode.setAttribute(
      "transparentColorFlag",
      "FALSE");
    graphicsControlExtensionNode.setAttribute(
      "delayTime",
      Integer.toString(timeBetweenFramesMS / 10));
    graphicsControlExtensionNode.setAttribute(
      "transparentColorIndex",
      "0");

    IIOMetadataNode commentsNode = getNode(root, "CommentExtensions");
    commentsNode.setAttribute("CommentExtension", "Created by MAH");

    IIOMetadataNode appEntensionsNode = getNode(
      root,
      "ApplicationExtensions");

    IIOMetadataNode child = new IIOMetadataNode("ApplicationExtension");

    child.setAttribute("applicationID", "NETSCAPE");
    child.setAttribute("authenticationCode", "2.0");

    int loop = loopContinuously ? 0 : 1;

    child.setUserObject(new byte[]{ 0x1, (byte) (loop & 0xFF), (byte)
      ((loop >> 8) & 0xFF)});
    appEntensionsNode.appendChild(child);

    imageMetaData.setFromTree(metaFormatName, root);

    gifWriter.setOutput(outputStream);

    gifWriter.prepareWriteSequence(null);
  }
  
  public void writeToSequence(RenderedImage img) throws IOException {
    gifWriter.writeToSequence(
      new IIOImage(
        img,
        null,
        imageMetaData),
      imageWriteParam);
  }
  
  /**
   * Close this GifSequenceWriter object. This does not close the underlying
   * stream, just finishes off the GIF.
   */
  public void close() throws IOException {
    gifWriter.endWriteSequence();    
  }

  /**
   * Returns the first available GIF ImageWriter using 
   * ImageIO.getImageWritersBySuffix("gif").
   * 
   * @return a GIF ImageWriter object
   * @throws IIOException if no GIF image writers are returned
   */
  private ImageWriter getWriter() throws IIOException {
    Iterator<ImageWriter> iter = ImageIO.getImageWritersBySuffix("gif");
    if(!iter.hasNext()) {
      throw new IIOException("No GIF Image Writers Exist");
    } else {
      return iter.next();
    }
  }

  /**
   * Returns an existing child node, or creates and returns a new child node (if 
   * the requested node does not exist).
   * 
   * @param rootNode the <tt>IIOMetadataNode</tt> to search for the child node.
   * @param nodeName the name of the child node.
   * 
   * @return the child node, if found or a new node created with the given name.
   */
  private IIOMetadataNode getNode(
      IIOMetadataNode rootNode,
      String nodeName) {
    int nNodes = rootNode.getLength();
    for (int i = 0; i < nNodes; i++) {
      if (rootNode.item(i).getNodeName().compareToIgnoreCase(nodeName)
          == 0) {
        return((IIOMetadataNode) rootNode.item(i));
      }
    }
    IIOMetadataNode node = new IIOMetadataNode(nodeName);
    rootNode.appendChild(node);
    return(node);
  }
  
  /**
  public GifSequenceWriter(
       BufferedOutputStream outputStream,
       int imageType,
       int timeBetweenFramesMS,
       boolean loopContinuously) {
   
   */
  
  public void main(String[] args) throws Exception {
    if (args.length > 1) {
      // grab the output image type from the first image in the sequence
      BufferedImage firstImage = ImageIO.read(new File(args[0]));

      // create a new BufferedOutputStream with the last argument
      ImageOutputStream output = 
        new FileImageOutputStream(new File(args[args.length - 1]));
      
      // create a gif sequence with the type of the first image, 1 second
      // between frames, which loops continuously
      GifSequenceWriter writer = 
        new GifSequenceWriter(output, firstImage.getType(), 1, false);
      
      // write out the first image to our sequence...
      writer.writeToSequence(firstImage);
      for(int i=1; i<args.length-1; i++) {
        BufferedImage nextImage = ImageIO.read(new File(args[i]));
        writer.writeToSequence(nextImage);
      }
      
      writer.close();
      output.close();
    } else {
      System.out.println(
        "Usage: java GifSequenceWriter [list of gif files] [output file]");
    }
  }
  
  
}

}



