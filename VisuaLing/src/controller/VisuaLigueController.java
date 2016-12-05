/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Point;
import java.util.List;
import domain.SurfaceJeu;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import domain.equipe.Equipe;
import domain.joueur.Joueur;
import domain.obstacle.Objectif;
import java.awt.Color;
import java.awt.Image;
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
    
    public void setImageSurface(String p_pathImage) throws IOException
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
    
    public void addJoueur(Point2D.Float p_point, Color p_couleurChandail, String p_role, String p_position, float p_orientation, Equipe p_equipe)
    {
        m_surfaceJeu.addJoueur(p_point, p_couleurChandail, p_role, p_position, p_orientation, p_equipe);
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
    
    public List<Joueur> getListJoueurs()
    {
        return m_surfaceJeu.getListeJoueur();
    }
    
    
    public void  setDimensionX(Double p_dimensionX){
        
        m_surfaceJeu.setDimensionX(p_dimensionX);
    }
    public void  setDimensionY(Double p_dimensionY){
        
        m_surfaceJeu.setDimensionY(p_dimensionY);
    }
    
    public double getDimensionX() {
        
        return m_surfaceJeu.getDimensionX();
    }   


    public double getDimensionY(){
        
    return m_surfaceJeu.getDimensionY();
    }
    
    public VisuaLigueController getController(){
        return this;
    }
    
    public void setNombreEquipe(int p_nombreEquiep){
        m_surfaceJeu.setNombreEquipe(p_nombreEquiep);
    }
    
    public int getNombreEquipe(){
        return m_surfaceJeu.getNombreEquipe();
    }
    
    public String getImageSurface(){
        return m_surfaceJeu.getImageSurface();
    }
    
    
    public void addListeSauvegardeJoueur(List<Joueur> list)
    {
        m_surfaceJeu.addListeSauvegardeJoueur(list);
    }
    
    public List<List<Joueur>> getListeSauvegardeJoueur()
    {
        return m_surfaceJeu.getListeSauvegardeJoueur();
    }
    
    public void setJoueurMax(int p_joueurMax){
        m_surfaceJeu.setJoueurMax(p_joueurMax);
    }
    
    public int getJoueurMax(){
        return m_surfaceJeu.getJoueurMax();
    }

    public void setStateMaxJoueur(boolean p_state) {
        m_surfaceJeu.setStateMaxJoueur(p_state);
    }
    
    public boolean getStateMaxJoueur(){
        return m_surfaceJeu.getStateMaxJoueur();
    }

    public void setStateAfficherRP(boolean p_state) {
        m_surfaceJeu.setStateAfficherRP(p_state);
    }
    
    public boolean getStateAfficherRP(){
        return m_surfaceJeu.getStateAfficherRP();
    }
    
    public void addRondelle(Point2D.Float p_point){
        m_surfaceJeu.addRondelle(p_point);
    }
    
    public void addBalle(Point2D.Float p_point){
        m_surfaceJeu.addBalle(p_point);
    }
    
    public void addBallon(Point.Float p_poFloat){
        m_surfaceJeu.addBallon(p_poFloat);
    }
    
    public void addObstacle(Point2D.Float p_coordObstacle, String p_image){
        m_surfaceJeu.addObstacle(p_coordObstacle, p_image);
    }
    
    public List<Objectif> getListeObjectif(){
        return m_surfaceJeu.getListeObjectif();
    }
}
