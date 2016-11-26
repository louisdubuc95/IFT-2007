/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.obstacle;

import java.awt.Image;
import java.awt.geom.Point2D;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author louis
 */

public class Ballon extends Objectif implements Serializable{
    private Image m_image;
    String imagepath = "/Photo/ballon.png";
    File imageFile;
    
    public Ballon (Point2D.Float p_point){
        super(p_point);
        
        imageFile = new File(imagepath);
        try {
            m_image = ImageIO.read(imageFile);
        }   catch (IOException ex) {
            Logger.getLogger(Balle.class.getName()).log(Level.SEVERE, null, ex);
        }
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

