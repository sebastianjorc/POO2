package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import vista.tablero;
import vista.tablero.ShapeItem;

/**Implementa el m�todo actionPerformed que pintar� de forma random un ShapeItem en el tablero.
 */
public class pintarTab implements ActionListener {
	tablero t;
	ArrayList<ShapeItem> shapes;

	/**Obtiene los objetos tablero y shapes que contendr�n los datos a usar y en los que actuar
	 * @param tablero	: Es el container al cual se aplicar� el repaint para los ItemShapes. Tambi�n contiene el atributo colorActual.
	 * @param shapes	: Contiene los ItemShapes del tablero, los cuales deber�n ser pintados.
	 */
	public pintarTab(tablero tablero, ArrayList<ShapeItem> shapes) {
		t=tablero;
		this.shapes=shapes;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		t.pintar(shapes);
		
		Random rnd = new Random();
		int i = (int)(rnd.nextDouble() * shapes.size());
		ShapeItem Item = shapes.get(i);
		Item.setColor(t.ColorActual);
        t.repaint();
	}
}