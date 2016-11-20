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
 * @author willl
 */
public abstract class Objectif{
    private Point2D.Float m_position;
     
    public Objectif (Point2D.Float p_point){
        this.m_position = p_point;
    }
     
    public Point2D.Float getCoordonneesObj(){
        return m_position;
    }
    
    public void setCoordonneesObj(Point2D.Float p_point){
        m_position = p_point;
    }
    
    public abstract Image getImage();
}
