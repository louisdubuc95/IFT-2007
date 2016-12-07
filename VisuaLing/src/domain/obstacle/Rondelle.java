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
public class Rondelle extends Objectif implements Serializable{
    String imagepath;
    
    public Rondelle (Point2D.Float p_point, String p_path){
        super(p_point);
        this.imagepath =  p_path;
    }
    
    @Override
    public String getImage()
    {
        return imagepath;
    }
    
    public void setImage(String p_image){
        this.imagepath = p_image;
    }  
}
