package controlador;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import vista.tablero;
import vista.tablero.ShapeItem;

public class ClickTablero implements MouseListener{
	ArrayList<ShapeItem> shapes;
	JPanel p;
	
	public ClickTablero(ArrayList<ShapeItem> shapes, tablero tablero){
		this.shapes=shapes;
		p=tablero;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
        for (ShapeItem item : shapes) {
            if (item.getShape().contains(e.getPoint())) {
                item.setColor(Color.RED);
            }
        }
        p.repaint();        
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
