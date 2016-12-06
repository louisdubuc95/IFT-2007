/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.obstacle;

import java.awt.Image;
import java.awt.geom.Point2D;
import java.io.Serializable;

/**
 *
 * @author louis
 */
public class Obstacle implements Serializable{
    private String m_nom;
    private String m_type;
    private int m_hauteur;
    private int m_largeur;
    private String m_image;
    private Point2D.Float m_point;
    
    public Obstacle(String p_nom, String p_type, int p_hauteur, int p_largeur,String p_image, Point2D.Float p_point){
        this.m_nom = p_nom;
        this.m_type = p_type;
        this.m_hauteur = p_hauteur;
        this.m_largeur = p_largeur;
        this.m_image = p_image;
        this.m_point = p_point;
    }
    
    public void setCoordonneesObs(Point2D.Float p_point){
        m_point = p_point;
    }
    
    public void setImage(String p_image){
        m_image = p_image;
    }
    
    public boolean estMemeCoord(Point2D.Float p_coordObs){
        return (m_point.equals(p_coordObs));
    }
    
    public Point2D.Float getCoordonneeObs(){
        return m_point;
    }
    
    public String getImageObs(){
        return m_image;
    }
    
    public String getNom(){
        return m_nom;
    }
    public String getType(){
        return m_type;
    }
    
    public int getHauteur(){
        return m_hauteur;
    }
    
    public int getLargeur(){
        return m_largeur;
    }
    
    
    public void setNom(String p_nom){
        m_nom = p_nom;
    }
    public void setType(String p_type){
        m_type = p_type;
    }
    
    public void setHauteur(int p_hauteur){
        m_hauteur = p_hauteur;
    }
    
    public void setLargeur(int p_largeur){
        m_largeur = p_largeur;
    }
    
    
}

