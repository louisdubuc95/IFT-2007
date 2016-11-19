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
import java.util.Date;
import java.util.List;
import javafx.util.Pair;

/**
 *
 * @author louis
 */
public class Enregistrement {
    private List<Pair<Date,String>> m_listeSerialize;
    
    public Enregistrement(){
    }
    
    public void serialize(){
        Class controller = VisuaLigueController.class.getClass();
        ObjectOutputStream oos = null;
        try {
            
            final FileOutputStream fichier = new FileOutputStream("controller.ser");
            oos = new ObjectOutputStream(fichier);
            oos.writeObject(controller);
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
    
    public void deSerialize(){    
        ObjectInputStream ois = null;
        try {
            final FileInputStream fichier = new FileInputStream("controller.ser");
            ois = new ObjectInputStream(fichier);
            final VisuaLigueController controller = (VisuaLigueController) ois.readObject();
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
  }
}


