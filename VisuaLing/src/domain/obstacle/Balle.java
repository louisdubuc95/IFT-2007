/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.obstacle;

import java.awt.geom.Point2D;
import java.io.File;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;

/**
 *
 * @author louis
 */
public class Balle extends Objectif {
    private Image m_image;
    String imagepath = "/Photo/balle.png";
    File imageFile;
    
    public Balle (Point2D.Float p_point){
        super(p_point);
        
        imageFile = new File(imagepath);
        try {
            imagepath = imageFile.toURI().toURL().toString();
        } catch (MalformedURLException ex) {
            Logger.getLogger(Ballon.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.m_image = new Image(imagepath);
    }
    
    @Override
    public Image getImage()
    {
        return m_image;
    }
    
    public void setImage(Image p_image){
        this.m_image = p_image;
    }  
}
