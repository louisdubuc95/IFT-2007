/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.obstacle;

import java.awt.geom.Point2D;
import javafx.scene.image.Image;

/**
 *
 * @author louis
 */
public class Obstacle {
    private Image m_image;
    private Point2D.Float m_point;
    
    public Obstacle(Image p_image, Point2D.Float p_point){
        this.m_image = p_image;
        this.m_point = p_point;
    }
    
    public void setCoordonneesObs(Point2D.Float p_point){
        m_point = p_point;
    }
    
    public void setImage(Image p_image){
        m_image = p_image;
    }
    
    public boolean estMemeCoord(Point2D.Float p_coordObs){
        return (m_point.equals(p_coordObs));
    }
    
    public Point2D.Float getCoordonneeObs(){
        return m_point;
    }
    
    public Image getImageObs(){
        return m_image;
    }
}

