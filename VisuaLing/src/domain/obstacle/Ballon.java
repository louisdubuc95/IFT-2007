/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.obstacle;

import java.awt.geom.Point2D;

/**
 *
 * @author louis
 */

public class Ballon extends Objectif {
    private String m_image;
    
    public Ballon (Point2D.Float p_point){
        super(p_point);
        this.m_image = "/Photo/ballon.png";
    }
    
    @Override
    public String getImage()
    {
        return m_image;
    }
    
    public void setImage(String p_image){
        this.m_image = p_image;
    }  
}

