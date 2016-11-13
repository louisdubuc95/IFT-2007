/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.joueur;

/**
 *
 * @author louis
 */
import java.awt.Color;
import java.awt.Point; 
import java.awt.geom.Point2D;


public class Joueur{
    
    private int m_idJoueur;
    private String m_roleJoueur;
    private int m_oriantationJoueur;
    private Color m_couleurChandail ; 
    private Point2D.Float m_position;
    private boolean m_enPossesion;
    
    public Joueur (Point2D.Float p_point, Color p_couleurChandail){
        m_position = p_point;
        m_couleurChandail = p_couleurChandail;
    }
    
    public boolean estMemeCoord(Point2D.Float p_coordJoueur){
        return (m_position.equals(p_coordJoueur));
    }
    
    public int getId(){
        return m_idJoueur;
    }
    
    public Color getCouleurChandail(){
        return m_couleurChandail;
    }
    
    public String getRoleJoueur(){
        return m_roleJoueur;
    }
    
    public int getOrientationJoueur(){
        return m_oriantationJoueur;
    }
    
    public Point2D.Float getCoordonneesJoueur(){
        return m_position;
    }
    
    public boolean getPossesion(){
        return m_enPossesion;
    }
    
    public void setId(int p_idJoueur){
        m_idJoueur = p_idJoueur;
    }
    
    public void setCouleurChandail(Color p_couleurChandail){
        m_couleurChandail = p_couleurChandail;
    }
    
    public void setCoordonneesJoueur(Point2D.Float p_point){
        m_position = p_point;
    }
    
    public void setRoleJoueur(String p_roleJoueur){
        m_roleJoueur = p_roleJoueur;
    }
    
    public void setOrientation(int p_oriantationJoueur){
        m_oriantationJoueur = p_oriantationJoueur;
    }
    
    public void setPossession(boolean p_enPossesion){
        m_enPossesion = p_enPossesion;
    }
    
}
