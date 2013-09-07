/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectodibujos;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

/**
 *
 * @author NANDO
 */
public class Circulo implements Serializable,IFigura {
    
    private int x;
    private int y;  
    private Color color;
    private int radio;
    
    public Circulo(int x, int y, int radio, Color color)
    {
        this.x = x;
        this.y = y;
        this.color = color;
        this.radio = radio;
    }       
    
    @Override
    public void Dibujate(Graphics g) {       
        g.setColor(color);
        g.drawOval(x - radio, y - radio, 2 * radio, 2 * radio);  
    }
    
}
