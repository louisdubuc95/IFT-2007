/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import domain.joueur.Joueur;
import java.util.List;


/**
 *
 * @author louis
 */

public class SurfaceJeu {
    
//    Sport m_Sport;
    List<Joueur> m_ListeJoueur;
//    List<Obstacle> m_ListeObstacle;
//    List<Objectif> m_ListeObjectifs;
    boolean m_Etat;
    int m_Temps;
    
    public SurfaceJeu()
    {
        m_Etat = false;
        m_Temps = 0;
    }
    
    public boolean estVide(){
        return m_Etat;
    }
}
