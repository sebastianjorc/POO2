package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import prueba.panel;
import vista.figura;
import vista.tableroMov;

public class ClickTableroMov implements MouseListener {
	ArrayList<figura> figuras;
	tableroMov p; JPanel p2;

	public ClickTableroMov(ArrayList<figura> figuras, tableroMov tableroMov) {
		this.figuras=figuras;
		p=tableroMov;

	}

	public ClickTableroMov(ArrayList<figura> figuras2, panel panel) {
		this.figuras=figuras2;
		p2=panel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {		
        for (figura item : figuras) {
            if (item.getShape().getBounds2D().contains(e.getPoint())) {
            	if(item.tipo!=3  && item.tipo != 2){
                	item.xVel=-item.getxVel();
                	item.yVel=-item.getyVel();         		
            	}else if(item.tipo==3)
                	item.yVel=-item.getyVel();            		
            	else 
                	item.xVel=-item.getxVel();
            	item.update();
            	//p.repaint();
            }
        }

	}

	@Override
	public void mouseEntered(MouseEvent e) {

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
