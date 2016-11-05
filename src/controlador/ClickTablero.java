package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import vista.tablero;
import vista.tablero.ShapeItem;

public class ClickTablero implements MouseListener{
	ArrayList<ShapeItem> shapes;
	tablero p;
	
	public ClickTablero(ArrayList<ShapeItem> shapes, tablero tablero){
		this.shapes=shapes;
		p=tablero;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
        for (ShapeItem item : shapes) {
            if (item.getShape().contains(e.getPoint())) {
            	if (item.getColor()==p.ColorActual){
                item.setColor(p.colorTrue);
                p.datos.pts++;
            	}else{item.setColor(p.colorFalse);p.datos.pts--;}
            }
        }
        tablero.lPts.setText("               PUNTAJE: "+ p.datos.pts);
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
