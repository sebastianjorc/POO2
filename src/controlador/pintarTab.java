package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

import vista.tablero;
import vista.tablero.ShapeItem;

public class pintarTab implements ActionListener {
	JPanel t;
	ArrayList<ShapeItem> shapes;

	public pintarTab(tablero tablero, ArrayList<ShapeItem> shapes) {
		t=tablero;
		this.shapes=shapes;
	}
	
	public void actionPerformed(ActionEvent e) {
	/*	Random rand = new Random();
		float r = (float) (rand.nextFloat() / 2f + 0.5);
		float g = (float) (rand.nextFloat() / 2f + 0.5);
		float b = (float) (rand.nextFloat() / 2f + 0.5);
		Color randomColor = new Color(r, g, b);*/		
		Random rnd = new Random();
		int i = (int)(rnd.nextDouble() * shapes.size());
		//shapes.get(i).setColor(randomColor.brighter()); 
		ShapeItem Item = shapes.get(i);
		Item.setColor(Color.GREEN);
        t.repaint();
		
	}	
}