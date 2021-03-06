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
import java.awt.Point; 
import java.awt.geom.Point2D;
import domain.equipe.Equipe;
import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Joueur implements Serializable{
    
    public static int nb_joueur = 0;
    
    private int m_idJoueur;
    private String m_roleJoueur;
    private String m_positionJoueur;
    private float m_oriantationJoueur;
    private Color m_couleurChandail ; 
    private Point2D.Float m_point;
    private boolean m_enPossesion;
    private Equipe m_equipe;
    private List<Point2D.Float> m_listeDeplacement;
    
    
    public Joueur (Point2D.Float p_point, Color p_couleurChandail, String p_role, String p_position, float p_oriantationJoueur, Equipe p_equipe){
        m_point = p_point;
        m_couleurChandail = p_couleurChandail;
        m_roleJoueur = p_role;
        m_positionJoueur = p_position;
        m_oriantationJoueur = p_oriantationJoueur;
        m_enPossesion = false;
        m_equipe = p_equipe;
        nb_joueur++;
        m_idJoueur = nb_joueur;
        m_listeDeplacement = new ArrayList<>();
    }
    
    public boolean estMemeCoord(Point2D.Float p_coordJoueur){
        return (m_point.equals(p_coordJoueur));
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
    
    public float getOrientationJoueur(){
        return m_oriantationJoueur;
    }
    
    public Point2D.Float getCoordonneesJoueur(){
        return m_point;
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
    
    public void setOrientationJoueurFloat (float p_orientationJoueur){
        m_oriantationJoueur = p_orientationJoueur ; 
    }
    
    public void setCoordonneesJoueur(Point2D.Float p_point){
        m_point = p_point;
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

    public String getPositionJoueur() {
        return m_positionJoueur;
    }

    public void setPositionJoueur(String m_positionJoueur) {
        this.m_positionJoueur = m_positionJoueur;
    }

    public Equipe getEquipe() {
        return m_equipe;
    }

    public void setEquipe(Equipe m_equipe) {
        this.m_equipe = m_equipe;
    }
    
    public List<Point2D.Float> getListeDeplacement(){
        return m_listeDeplacement;
    }
    
    
}
