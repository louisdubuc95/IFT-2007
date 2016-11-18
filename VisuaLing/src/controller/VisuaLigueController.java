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
import java.util.Iterator;
import java.util.LinkedList;
        

/**
 *
 * @author louis
 * Controlleur de Larman
 */
public class VisuaLigueController {
    
    SurfaceJeu m_surfaceJeu; 
    private List<Equipe> list_equipes = new LinkedList<>();
    
    public void VisuaLigueController() {
        m_surfaceJeu = new SurfaceJeu();
    }
    
    public void setImageSurface(String p_pathImage)
    {   
        m_surfaceJeu.setImageSurface(p_pathImage);
    }
    
    public List<Equipe> getList_equipes() {
        return list_equipes;
    }
    
    public void addEquipe(String nom, Color couleur) throws Exception
    {
        Iterator<Equipe> iterateur = list_equipes.iterator();
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
        
        Equipe nouv_equipe = new Equipe(nom, couleur);
        list_equipes.add(nouv_equipe);
    }
}
