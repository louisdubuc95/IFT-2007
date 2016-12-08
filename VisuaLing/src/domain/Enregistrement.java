/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;
import controller.VisuaLigueController;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javafx.util.Pair;

/**
 *
 * @author louis
 */
public class Enregistrement {
    private List<String> m_listeSerialize;
    private List<String> m_listeUR;
    int compteur;
    int m_version;
    
    public Enregistrement(){
       this.m_listeSerialize = new ArrayList();
       this.m_listeUR = new ArrayList();
       this.m_version = 0;
       this.compteur = 0;
    }
    
    public void serialize(String p_nomSauvegarde, VisuaLigueController p_controller, String p_mode){
        ObjectOutputStream oos = null;
        try {
            final FileOutputStream fichier = new FileOutputStream("src/savedStrategies/"+ p_nomSauvegarde+"."+p_mode);
            oos = new ObjectOutputStream(fichier);
            oos.writeObject(p_controller);
            oos.flush();
            } 
        catch (final java.io.IOException e) {
            e.printStackTrace();
    } finally {
      try {
        if (oos != null) {
          oos.flush();
          oos.close();
        }
      } catch (final IOException ex) {
        ex.printStackTrace();
      }
     }
    }
    
    
    
    public void serializeUR(VisuaLigueController p_controller, int i){
        ObjectOutputStream oos = null;
        compteur ++;
        try {
            final FileOutputStream fichier = new FileOutputStream("src/UndoRedo/"+ compteur+".IPI");
            if(i+1<m_listeUR.size())
            {
                int y = i+1;
                while(y<m_listeUR.size())
                {
                    m_listeUR.remove(y);
                    y++;
                }
            }
            m_listeUR.add("src/UndoRedo/"+ compteur+".IPI");
            oos = new ObjectOutputStream(fichier);
            oos.writeObject(p_controller);
            oos.flush();
            } 
        catch (final java.io.IOException e) {
            e.printStackTrace();
    } finally {
      try {
        if (oos != null) {
          oos.flush();
          oos.close();
        }
      } catch (final IOException ex) {
        ex.printStackTrace();
      }
     }
    }
    
    public VisuaLigueController deSerialize(String p_nomSauvegarde){
        VisuaLigueController controller = null;
        ObjectInputStream ois = null;
        try {
            final FileInputStream fichier = new FileInputStream(p_nomSauvegarde);
            ois = new ObjectInputStream(fichier);
            controller = (VisuaLigueController) ois.readObject();
            System.out.println("Controller : charger ");
        } 
        catch (final java.io.IOException e) {
            e.printStackTrace();
    } catch (final ClassNotFoundException e) {
      e.printStackTrace();
    } finally {
      try {
        if (ois != null) {
          ois.close();
        }
      } catch (final IOException ex) {
        ex.printStackTrace();
      }
    }
    return controller;
  }
    
    
    
    public VisuaLigueController deSerializeUR(String p_nomSauvegarde){
        VisuaLigueController controller = null;
        ObjectInputStream ois = null;
        try {
            final FileInputStream fichier = new FileInputStream(p_nomSauvegarde);
            ois = new ObjectInputStream(fichier);
            controller = (VisuaLigueController) ois.readObject();
            System.out.println("Controller : charger ");
        } 
        catch (final java.io.IOException e) {
            e.printStackTrace();
    } catch (final ClassNotFoundException e) {
      e.printStackTrace();
    } finally {
      try {
        if (ois != null) {
          ois.close();
        }
      } catch (final IOException ex) {
        ex.printStackTrace();
      }
    }
    return controller;
  }
    
  public List<String> getListeEnregistrement(){
      return m_listeSerialize;
  }
  public List<String> getListeUR(){
      return m_listeUR;
  }
  
}


