/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.equipe;

/**
 *
 * @author antoinehudon
 */

import javafx.scene.paint.Color;
import java.util.List;
import domain.joueur.Joueur;
import java.util.ArrayList;
import java.util.Iterator;

public class Equipe {
    public static int nbEquipes = 0;
            
    private int id;
    private String nom;
    private Color couleur;
    private List<Joueur> list_joueurs;
    
    public Equipe(String nom, Color couleur)
    {
        nbEquipes++;
        id = nbEquipes;
        this.nom = nom;
        this.couleur = couleur;
    }
    
    // Getters

    public static int getNbEquipes() {
        return nbEquipes;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public Color getCouleur() {
        return couleur;
    }

    public List<Joueur> getList_joueurs() {
        return list_joueurs;
    }
    
    // Setters
    
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }
    
    // Ajouter joueur
    
    public void addJoueur(Joueur joueur)
    {
        list_joueurs.add(joueur);
    }
    
    // Supprimer un joueur de l'équipe
    public void deleteJoueur(int id)
    {
        Iterator<Joueur> iterateur = list_joueurs.iterator();
        while(iterateur.hasNext())
        {
            if (iterateur.next().getId() == id)
            {
                iterateur.remove();
                break;
            }
        }
        
    }
    
    public int getSize(){
        return list_joueurs.size();
    }

}
