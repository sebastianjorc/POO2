package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import vista.figura;
import vista.tableroMov;
/**Clase que implementa mouseClicked de MouseListener
 * Integra la funcionalidad de al hacer click en alguna figura, esta reaccione e invierta su dirección de movimiento
 */

public class ClickTableroMov implements MouseListener {
	ArrayList<figura> figuras; 	//Guarda el arreglo de figuras entregado en el parametro del constructor
	tableroMov p;				//Guarda el tableroMov entregado en el parametro del constructor.

		
	/**Método constructor, recibe tablero y arreglo de clase figura en los que actuará el mouseClicked
	 * @param figuras :Arreglo que contiene los objeto de clase figura en los que actuará el mouseClicked
	 * @param tableroMov : Objeto de clase tableroMov que será usado como entorno donde actuan los objetos de clase figura
	 */
	public ClickTableroMov(ArrayList<figura> figuras, tableroMov tableroMov) {
		this.figuras=figuras;
		p=tableroMov;

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
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
