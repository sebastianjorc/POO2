package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import vista.tablero;
import vista.tablero.ShapeItem;

public class pintarTab implements ActionListener {
	tablero t;
	ArrayList<ShapeItem> shapes;

	public pintarTab(tablero tablero, ArrayList<ShapeItem> shapes) {
		t=tablero;
		this.shapes=shapes;
	}
	
	public void actionPerformed(ActionEvent e) {
		t.pintar(shapes);
		
		Random rnd = new Random();
		int i = (int)(rnd.nextDouble() * shapes.size());
		ShapeItem Item = shapes.get(i);
		Item.setColor(t.ColorActual);
        t.repaint();
	}
}