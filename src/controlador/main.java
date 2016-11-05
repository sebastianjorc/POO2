package controlador;

import javax.swing.JOptionPane;

public class main {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		JOptionPane.showMessageDialog( null, 
		"¡Bienvenido! Este es un programa de entrenamiento cerebral.\n"
		+ "Acontinuacion encontrara varios programas para ejercitar su cerebro.");
		controlador c = new controlador();
	}

}