/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import domain.SurfaceJeu;
import java.io.Serializable;
import javafx.scene.image.Image;

/**
 *
 * @author willl
 */
public class Sport implements Serializable{
    private String m_nomSport;
    private Image m_imageSurface;
    
    public void setImageSurface(Image p_imageSurface){
        m_imageSurface = p_imageSurface;
    }
    
}
