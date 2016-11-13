/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import domain.coordoneeZoom.Coordonee;
import domain.joueur.Joueur;
import domain.obstacle.Objectif;
import domain.obstacle.Obstacle;
import java.awt.Color;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;


/**
 *
 * @author louis
 */

public class SurfaceJeu {
    
    private Sport m_Sport;
    private List<Joueur> m_ListeJoueur;
    private List<Obstacle> m_ListeObstacle;
    private List<Objectif> m_ListeObjectifs;
    private String m_nomSport;
    private Image m_imgFond;
    private boolean m_Etat;
    private int m_Temps;
    
    public SurfaceJeu()
    {
        m_ListeJoueur = new ArrayList();
        m_ListeObstacle = new ArrayList();
        m_ListeObjectifs = new ArrayList();
        
        m_Etat = false;
        m_Temps = 0;
    }
    
    public void addJoueur(Point2D.Float p_coordJoueur, Color p_colorChandail) {
        boolean ajouterJoueur = false;
        
        if(joueurEstPresent(p_coordJoueur) == false)
        {
            m_ListeJoueur.add(new Joueur(p_coordJoueur, p_colorChandail));
            ajouterJoueur = true;
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
        // Retirer commentaire lorsque la classe Coordonnee sera implementer
        //if(img!=null)
            //m_image= img.getScaledInstance(Coordonee.largeurX, Coordonee.hauteurY, Image.SCALE_SMOOTH);   
    }
}
