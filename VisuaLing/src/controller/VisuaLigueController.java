/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Point;
import java.util.List;
import javafx.scene.paint.Color;
import domain.SurfaceJeu;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
        

/**
 *
 * @author louis
 * Controlleur de Larman
 */
public class VisuaLigueController {
    
    SurfaceJeu m_surfaceJeu; 
    
    public void VisuaLigueController() {
        m_surfaceJeu = new SurfaceJeu();
    }
    
    public void setImageSurface(String p_pathImage)
    {   
        m_surfaceJeu.setImageSurface(p_pathImage);
    }
}
