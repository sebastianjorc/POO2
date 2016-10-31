package vista;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class tablero extends Canvas {
	private static final long serialVersionUID = 1L;
	int sizex = 421;
	int sizey = 351;
	int tamCuadrado = 35;

	tablero(){
		this.setBackground(Color.decode("#E8FFFA"));
		this.setSize(sizex,sizey);	
	}
	
	public void paint(Graphics g){
		
		g.setColor(Color.DARK_GRAY);
		for (int i = 0; i<sizex; i+=tamCuadrado){
			for (int j= 0; j<sizey; j+=tamCuadrado){
				g.drawRect(i, j, tamCuadrado, tamCuadrado);
			}
		}
		//g.fillRect(30, 10, 35, 35);
	}
}
