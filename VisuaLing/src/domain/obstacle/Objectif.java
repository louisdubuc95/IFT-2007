/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.obstacle;

import java.awt.Image;
import java.awt.geom.Point2D;
import java.io.Serializable;

/**
 *
 * @author willl
 */
public abstract class Objectif implements Serializable{
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
    
    public boolean estMemeCoord(Point2D.Float p_coordObjectif){
        return (m_position.equals(p_coordObjectif));
    }
    
    public abstract Image getImage();
}
