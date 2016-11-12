package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.ConexionSQL;
import vista.figura;
import vista.tableroMov;

/**Implementa el metodo actionPerformed que hará mover cada figura inicializando el juego.
 */
public class mov implements ActionListener{
	tableroMov tm; int tipo;

	/**Recibe el objeto tableroMov que será quién contiene y en quién actuará la clase actionPerformed
	 */
	public mov(tableroMov tableroMov) {
		this.tm=tableroMov;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent arg0) {
		tm.repaint();
		for (figura item: tm.figuras)
			item.update();
		if(revisar_colisiones()){
			tm.t.stop();
			tm.Crono.stop();
			
			JOptionPane.showMessageDialog(null,"Su puntaje ha sido:"+tm.datos.pts+"/60");
			new ConexionSQL().insertar(tm.datos.user, tm.datos.tipoPartida, tm.datos.pts);
			tm.limpiar_tablero();
		}
	}

	/**Revisa si después de cada movimiento si esque alguno de los objetos a colisionado con otro.
	 * @return En caso de que devuelva false, no hubo colisión. En caso de que devuelva un true, hubo colisión y se debe detener el juego.
	 */
	private boolean revisar_colisiones() {
		for(figura item: tm.figuras){
			for(figura item2: tm.figuras){
				if (item.getShape().getBounds2D().intersects(item2.getShape().getBounds2D()) && item!=item2){
					return true;
				}
			}
		}
		return false;
	}
}