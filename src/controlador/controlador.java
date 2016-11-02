package controlador;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import vista.vista;

public class controlador {	
	boolean flag = true;
	int sel1;	String rut="hj";
	utilidades u = new utilidades();
	
	controlador(){
/*	ImageIcon icon = new ImageIcon("img/brainIcon.png");
	sel1 = 	JOptionPane.showOptionDialog(null,"Seleccione una opcion:", "Selección",
			JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,
			icon, new String[] { "BrainClicks" }, null);
	
	rut=u.validar_rut();
	@SuppressWarnings("unused")
*/
	vista v = new vista(sel1,rut);
	}

}