/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.coordoneeZoom;

/**
 *
 * @author louis
 */
public class Coordonee {
    
  
    private double m_dimensionX ; 
    private double m_dimensionY ; 
    double m_X ; 
    double m_Y ; 
    double m_coorX ;
    double m_coorY ; 
    //Coordonee m_Coordonee = new Coordonee ();   
    //Double p_dimensionX, Double p_dimensionY
    //m_dimensionX = p_dimensionX ; 
    //m_dimensionY = p_dimensionY ; 
    
    public Coordonee (){
       m_dimensionX = 0.0 ;
       m_dimensionY = 0.0 ;
    }

    public Coordonee(Double p_dimensionX, Double p_dimensionY){
       
        m_dimensionX = p_dimensionX; 
        m_dimensionY = p_dimensionY; 
}

    
public void setDimensionX (Double p_dimensionX){
    m_dimensionX = p_dimensionX ; 
}    

public void setDimensionY (Double p_dimensionY) {
    m_dimensionY = p_dimensionY ; 
}

public double getDimensionX() {
    return m_dimensionX; 
}   


public double getDimensionY(){
    return m_dimensionY;    
}

/*
public double getX(){
    return m_X;
}

public double getY(){
    return m_Y;
}

public void setX (Double p_dimensionX){
    m_dimensionX= p_dimensionX ; 
    
}
public void setY (Double p_dimensionY){
    m_dimensionY= p_dimensionY ; 
    
}
/

public double dimensionReelX (Double p_dimensionX, Double p_X) {
    double coorX = p_X/p_dimensionX ; 
    return coorX ; 
}

public double dimensionReelY (Double p_dimensionY, Double p_Y) {
    double coorY = p_Y/p_dimensionY ; 
    return coorY ; 
}

public void setDimensionReelX (Double p_coorX){
    m_coorX = p_coorX ; 
}


public void setDimensionReelY (Double p_coorY){
    m_coorY = p_coorY ; 
}
*/    
}
