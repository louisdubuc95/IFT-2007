/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Point;
import java.util.List;
import javafx.scene.paint.Color;
import domain.SurfaceJeu;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import domain.equipe.Equipe;
import domain.joueur.Joueur;
import java.awt.geom.Point2D;
import java.util.Iterator;
import java.util.LinkedList;
        

/**
 *
 * @author louis
 * Controlleur de Larman
 */
public class VisuaLigueController implements java.io.Serializable{
    
    SurfaceJeu m_surfaceJeu = new SurfaceJeu();
    private static final long serialVersionUID = 1L;
    
    public void VisuaLigueController() 
    {
        m_surfaceJeu = new SurfaceJeu();
    }
    
    public void setImageSurface(String p_pathImage)
    {   
        m_surfaceJeu.setImageSurface(p_pathImage);
    }
    
    public List<Equipe> getListEquipe() 
    {
        return m_surfaceJeu.getListeEquipe();
    }
    
    public void addEquipe(String nom, Color couleur) throws Exception
    {
        m_surfaceJeu.addEquipe(nom, couleur);
    }
    
    public void addJoueur(Point2D.Float p_coordJoueur, Color p_colorChandail)
    {
        m_surfaceJeu.addJoueur(p_coordJoueur, p_colorChandail);
    }
    
    public boolean joueurEstPresent(Point2D.Float p_joueur){
        return m_surfaceJeu.joueurEstPresent(p_joueur);
    }
    
    public void addRole(String role) throws Exception
    {
        m_surfaceJeu.addRole(role);
    }
    
    public List<String> getListeRole()
    {
        return m_surfaceJeu.getListeRole();
    }
    
    public void addPosition(String position) throws Exception
    {
        m_surfaceJeu.addPosition(position);
    }
    
    public List<String> getListePosition()
    {
        return m_surfaceJeu.getListePosition();
    }
}
