package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.ConexionSQL;
import vista.figura;
import vista.tableroMov;

public class mov implements ActionListener{
	tableroMov tm; int tipo;

	public mov(tableroMov tableroMov) {
		this.tm=tableroMov;
	}

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
			
			tm.s=0; tm.m=0;	tm.l.setText("00:00");
		}
	}

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