/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import domain.coordoneeZoom.Coordonee;
import domain.equipe.Equipe;
import domain.joueur.Joueur;
import domain.obstacle.Balle;
import domain.obstacle.Ballon;
import domain.obstacle.Objectif;
import domain.obstacle.Obstacle;
import domain.obstacle.Rondelle;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


/**
 *
 * @author louis
 */

public class SurfaceJeu implements Serializable{
    
    private Coordonee m_Coordonee;
    private List<Joueur> m_ListeJoueur;
    private List<Obstacle> m_ListeObstacle;
    private List<Objectif> m_ListeObjectifs;
    private List<Equipe> m_ListeEquipes;
    private List<String> m_ListeRole;
    private List<String> m_ListePosition;
    private String m_imgFond;
    private boolean m_Etat;
    private int m_Temps;
    private int m_nombreEquipe;
    private int m_joueurMax;
    private boolean m_stateMaxJoueur;
    private boolean m_stateAfficherRP;
    
    Rectangle.Float m_calculTaille;
    int m_largeurPx;
    int m_hauteurPx;
    float m_distanceEntrePts;
    
    private Joueur m_joueur;
    private Obstacle m_obstacle;
    private Objectif m_objectif;
    //private Equipe m_equipe;
    
    
    private List<List<Joueur>> listeImages;
    
    
    public SurfaceJeu()
    {
    this.m_ListeJoueur = new ArrayList();
    this.m_ListeObstacle = new ArrayList();
    this.m_ListeObjectifs = new ArrayList();
    this.m_ListeEquipes = new ArrayList();
    this.m_Coordonee = new Coordonee ();
    this.listeImages = new ArrayList();
    this.m_nombreEquipe = 0;
    this.m_joueurMax = 0;
    this.m_stateMaxJoueur = false;
    this.m_ListePosition = new ArrayList<>();
    this.m_ListeRole = new ArrayList<>();

    this.m_Etat = false;
    this.m_Temps = 0;
    }
    
    public void addJoueur(Point2D.Float p_point, Color p_couleurChandail, String p_role, String p_position, float p_orientation, Equipe p_equipe) {
        boolean ajouterJoueur = false;
        
        if(joueurEstPresent(p_point) == false)
        {
            m_ListeJoueur.add(new Joueur(p_point, p_couleurChandail, p_role, p_position, p_orientation, p_equipe));
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
            
            if (equipe.getNom().equals(nom) 
////                    && 
//                    equipe.getCouleur().getBlue() == couleur.getBlue() &&
//                    equipe.getCouleur().getGreen() == couleur.getGreen() &&
//                    equipe.getCouleur().getRed() == couleur.getRed() &&
//                    equipe.getCouleur().getOpacity() == couleur.getOpacity()
                    )
            {
                throw new Exception("Le nom d'équipe est déjà choisi!"
                        + " Veuillez choisir un autre nom d'équipe");
            }
        }
        m_ListeEquipes.add(new Equipe(nom,couleur));
    }
    
    
    public void addRole(String role) throws Exception
    {
        if (m_ListeRole.contains(role))
        {
            throw new Exception("Ce rôle existe déjà");
        }
        else
        {
            m_ListeRole.add(role);
        }
    }
    
    public List<String> getListeRole()
    {
        return m_ListeRole;
    }
    
    public void addPosition(String position) throws Exception
    {
        if (m_ListePosition.contains(position))
        {
            throw new Exception("Cette position existe déjà");
        }
        else
        {
            m_ListePosition.add(position);
        }
    }
    
    public List<String> getListePosition()
    {
        return m_ListePosition;
    }
    
    public boolean estVide(){
        return m_Etat;
    }
    
   public void setImageSurface(String p_pathImage) throws IOException
    {   
        m_imgFond = p_pathImage;
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
    public void  setDimensionX(Double p_dimensionX){
        m_Coordonee.setDimensionX(p_dimensionX);
    }
    public void  setDimensionY(Double p_dimensionY){
        m_Coordonee.setDimensionY(p_dimensionY);
    }
    
    public void setNombreEquipe(int p_nombreEquipe){
        m_nombreEquipe = p_nombreEquipe;
    }
    
    public double getDimensionX() {
        return m_Coordonee.getDimensionX();
    }   


    public double getDimensionY(){
        return m_Coordonee.getDimensionY();
    }
    
    public int getNombreEquipe(){
        return m_nombreEquipe;
    }

    public String getImageSurface() {
        return m_imgFond;
    }
    
    public void addListeSauvegardeJoueur(List<Joueur> liste)
    {
        listeImages.add(liste);
    }
    
    public List<List<Joueur>> getListeSauvegardeJoueur()
    {
        return listeImages;
    }

    public void setJoueurMax(int p_joueurMax) {
        m_joueurMax = p_joueurMax;
    }

    public int getJoueurMax() {
        return m_joueurMax;
    }

    public void setStateMaxJoueur(boolean p_state) {
        m_stateMaxJoueur = p_state;
    }
    
    public boolean getStateMaxJoueur(){
        return m_stateMaxJoueur;
    }
    
     public void setStateAfficherRP(boolean p_state) {
        m_stateAfficherRP = p_state;
    }

    public boolean getStateAfficherRP() {
        return m_stateAfficherRP;
    }
}
