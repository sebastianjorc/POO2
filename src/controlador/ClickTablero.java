package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import vista.tablero;
import vista.tablero.ShapeItem;

/**Implementa el m�todo mouseClicked que funciona sobre los objetos del arreglo shapes.
 * Su funci�n es poder pintar (en el caso de que sea correcta o incorrecta la pulsaci�n) el ItemShape y asignar puntaje.
 */
public class ClickTablero implements MouseListener{
	ArrayList<ShapeItem> shapes;
	tablero p;
	
	/**Guarda los objetos entregados por parametro dentro de los atributos de la clase, y ser�n �stos con los que actuar�
	 * @param shapes  : Contiene los itemShapes en los que actuar� la clase
	 * @param tablero : Es el  de los itemShapes que ser�n presionado y cambiaran su color asignando el puntaje. 
	 * Tambi�n contiene los datos necesarios de asignaci�n de puntaje y otros.
	 */
	public ClickTablero(ArrayList<ShapeItem> shapes, tablero tablero){
		this.shapes=shapes;
		p=tablero;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	public void mouseClicked(MouseEvent e) {
        for (ShapeItem item : shapes) {
            if (item.getShape().contains(e.getPoint())) {
            	if (item.getColor()==p.ColorActual){
                item.setColor(p.colorTrue);
                p.datos.pts++;
            	}else{item.setColor(p.colorFalse);p.datos.pts--;}
            }
        }
        p.lPts.setText("               PUNTAJE: "+ p.datos.pts);
        p.repaint();
	}

	@Override
	public void mouseEntered (MouseEvent arg0){
		// TODO Auto-generated method stub
		
	}
	public void mouseExited  (MouseEvent arg0){
		// TODO Auto-generated method stub
		
	}
	public void mousePressed (MouseEvent arg0){
		// TODO Auto-generated method stub
		
	}
	public void mouseReleased(MouseEvent arg0){
		// TODO Auto-generated method stub
		
	}

}