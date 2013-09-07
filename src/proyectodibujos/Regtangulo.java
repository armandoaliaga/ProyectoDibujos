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
public class Regtangulo implements Serializable,IFigura{
    
    private int posx;
    private int posy;
    private int altura;
    private int ancho;
    private Color color;
 
    public Regtangulo(int x,int y, int a,int an,Color co)
    {
        posx=x;
        posy=y;
        altura=a;
        ancho=an;
        color=co;
    }    

    @Override
    public void Dibujate(Graphics g) {
        g.setColor(color);
        g.fillRect(posx, posy, altura, ancho);
    }
}
