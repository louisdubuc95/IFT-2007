/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import domain.coordoneeZoom.Coordonee;
import domain.coordoneeZoom.Zoom;
import domain.equipe.Equipe;
import domain.joueur.Joueur;
import domain.obstacle.Balle;
import domain.obstacle.Ballon;
import domain.obstacle.Objectif;
import domain.obstacle.Obstacle;
import domain.obstacle.Rondelle;
import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Circle;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javafx.scene.paint.Color;


/**
 *
 * @author louis
 */

public class SurfaceJeu {
    
    private Coordonee m_Coordonee;
    private Zoom m_zoom;
    private List<Joueur> m_ListeJoueur;
    private List<Obstacle> m_ListeObstacle;
    private List<Objectif> m_ListeObjectifs;
    private List<Equipe> m_ListeEquipes;
    private Image m_imgFond;
    private boolean m_Etat;
    private int m_Temps;
    
    private Joueur m_joueur;
    private Obstacle m_obstacle;
    private Objectif m_objectif;
    private Equipe m_equipe;
    
    
    public SurfaceJeu()
    {
    this.m_ListeJoueur = new ArrayList();
    this.m_ListeObstacle = new ArrayList();
    this.m_ListeObjectifs = new ArrayList();
    this.m_ListeEquipes = new ArrayList();

    this.m_Etat = false;
    this.m_Temps = 0;
    }
    
    public void addJoueur(Point2D.Float p_coordJoueur, Color p_colorChandail) {
        boolean ajouterJoueur = false;
        
        if(joueurEstPresent(p_coordJoueur) == false)
        {
            m_ListeJoueur.add(new Joueur(p_coordJoueur, p_colorChandail));
            ajouterJoueur = true;
            m_Etat = true;
        }
    }
    
    public boolean joueurEstPresent(Point2D.Float p_coordJoueur)
    {
        return obtenirJoueur(p_coordJoueur) != null;
    }
    
    public Joueur obtenirJoueur (Point2D.Float p_coordJoueur)
    {
        Joueur joueurTrouver = null;
        int compteurJoueur = 0;
        Joueur joueurPresent;
        
        while(compteurJoueur < m_ListeJoueur.size() && joueurTrouver == null)
        {
            joueurPresent = m_ListeJoueur.get(compteurJoueur);
            
            if(joueurPresent.estMemeCoord(p_coordJoueur))
            {
                joueurTrouver = joueurPresent;
            }
            compteurJoueur++;
        }
        return joueurTrouver;
    }
    
    public void addObstacle(Point2D.Float p_coordObstacle, Image p_image){
        boolean ajouterObstacle = false;
        
        if(obstacleEstPresent(p_coordObstacle) == false){
            m_ListeObstacle.add(new Obstacle(p_image, p_coordObstacle));
            ajouterObstacle = true;
            m_Etat = true;
        }
    }
    
    public boolean obstacleEstPresent(Point2D.Float p_obstacle){
        return obtenirObstacle(p_obstacle) != null;
    }
    
    public Obstacle obtenirObstacle (Point2D.Float p_coordObstacle)
    {
        Obstacle obstacleTrouver = null;
        int compteurObstacle = 0;
        Obstacle obstaclePresent;
        
        while(compteurObstacle < m_ListeObstacle.size() && obstacleTrouver == null)
        {
            obstaclePresent = m_ListeObstacle.get(compteurObstacle);
            
            if(obstaclePresent.estMemeCoord(p_coordObstacle))
            {
                obstacleTrouver = obstaclePresent;
            }
            compteurObstacle++;
        }
        return obstacleTrouver;
    }
    
    public void addRondelle(Point2D.Float p_coordObstacle){
        boolean ajouterRondelle = false;
        
        if(objectifEstPresent(p_coordObstacle) == false){
            m_ListeObjectifs.add(new Rondelle(p_coordObstacle));
            ajouterRondelle = true;
            m_Etat = true;
        }
    }
    
    public void addBalle(Point2D.Float p_coordObstacle){
        boolean ajouterBalle = false;
        
        if(objectifEstPresent(p_coordObstacle) == false){
            m_ListeObjectifs.add(new Balle(p_coordObstacle));
            ajouterBalle = true;
            m_Etat = true;
        }
    }
    
    public void addBallon(Point2D.Float p_coordObstacle){
        boolean ajouterBallon = false;
        
        if(objectifEstPresent(p_coordObstacle) == false){
            m_ListeObjectifs.add(new Ballon(p_coordObstacle));
            ajouterBallon = true;
            m_Etat = true;
        }
    }
        
    public boolean objectifEstPresent(Point2D.Float p_coordObjectif){
            return obtenirObjectif(p_coordObjectif) != null;
    }
    
    public Objectif obtenirObjectif (Point2D.Float p_coordObstacle)
    {
        Objectif objectifTrouver = null;
        int compteurObstacle = 0;
        Objectif objectifPresent;
        
        while(compteurObstacle < m_ListeObjectifs.size() && objectifTrouver == null)
        {
            objectifPresent = m_ListeObjectifs.get(compteurObstacle);
            
            if(objectifPresent.estMemeCoord(p_coordObstacle))
            {
                objectifTrouver = objectifPresent;
            }
            compteurObstacle++;
        }
        return objectifTrouver;
    }
    
    public void addEquipe(String nom, Color couleur) throws Exception
    {
        Iterator<Equipe> iterateur = m_ListeEquipes.iterator();
        while(iterateur.hasNext())
        {
            Equipe equipe = iterateur.next();
            
            if (equipe.getNom().equals(nom) && 
                    equipe.getCouleur().getBlue() == couleur.getBlue() &&
                    equipe.getCouleur().getGreen() == couleur.getGreen() &&
                    equipe.getCouleur().getRed() == couleur.getRed() &&
                    equipe.getCouleur().getOpacity() == couleur.getOpacity())
            {
                throw new Exception("La combinaison nom-couleur a déjà été prise pour une autre équipe."
                        + " Veuillez choisir un autre nom ou une autre couleur.");
            }
        }
        m_ListeEquipes.add(new Equipe(nom,couleur));
    }

    
    public boolean estVide(){
        return m_Etat;
    }
    
    public void setImageSurface(String p_pathImage)
    {   
        BufferedImage img = null;
        try {
            img = ImageIO.read(getClass().getResource(p_pathImage));
        } catch (IOException ex) {
            Logger.getLogger(SurfaceJeu.class.getName()).log(Level.SEVERE, null, ex);
        }
         //Retirer commentaire lorsque la classe Coordonnee sera implementer
        //if(img!=null)
            //m_imgFond= img.getScaledInstance(m_Coordonee.getLargeurInterfaceX,m_Coordonee.getHauteurInterfaceY(), Image.SCALE_SMOOTH);   
    }
    
     public void Dessiner(Canvas p_graphics)
    {
        Point2D.Float coordJoueur;
        Point2D.Float coordObstacle;
        Point2D.Float coordObjectif;
        Image imgObs;
        Image imgObj;
        GraphicsContext gc = p_graphics.getGraphicsContext2D();
        
        for(int i=0;i < m_ListeJoueur.size();i++)
        {
            //Prend les joueurs de la liste 1 par 1
            Joueur ajouterJoueur = m_ListeJoueur.get(i);    
            
            //Prend la couleur de joueur
            Color couleurChandail = ajouterJoueur.getCouleurChandail();
            
            //Prend les coordonnée du joueur
            coordJoueur = ajouterJoueur.getCoordonneesJoueur();
                    
            //Dessine le joueur
            gc.setFill(couleurChandail);
            gc.fillOval(coordJoueur.x,coordJoueur.y, 20,20);
        }
        
        for(int j=0;j<m_ListeObstacle.size();j++)
        {
            //Prend les obstacle 1 par 1 
            Obstacle ajouterObs = m_ListeObstacle.get(j);
            
            //Prend l'image de l'obstacle
            imgObs = ajouterObs.getImageObs();
            
            //Prend la coordonnée de l'obstacle
            coordObstacle = ajouterObs.getCoordonneeObs();
            
            //Desine l'obstacle
            gc.drawImage(imgObs, coordObstacle.x, coordObstacle.y);
        }
        
        for(int x=0;x<m_ListeObjectifs.size();x++)
        {
            //Prend les obstacle 1 par 1 
            Objectif ajouterObj = m_ListeObjectifs.get(x);
            
            //Prend l'image de l'obstacle
            imgObj = ajouterObj.getImage();
            
            //Prend la coordonnée de l'obstacle
            coordObjectif = ajouterObj.getCoordonneesObj();
            
            //Desine l'obstacle
            gc.drawImage(imgObj, coordObjectif.x, coordObjectif.y);
        }
    }
    
    public List<Joueur> getListeJoueur(){
        return m_ListeJoueur;
    }
    
    public List<Obstacle> getListeObstacle(){
        return m_ListeObstacle;
    }
    
    public List<Objectif> getListeObjectif(){
        return m_ListeObjectifs;
    }
    
    public List<Equipe> getListeEquipe(){
        return m_ListeEquipes;
    }
}
