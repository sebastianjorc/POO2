package controlador;

import javax.swing.JOptionPane;

public class main {

	/**Corre el programa inicializando el controlador.
	 * Contiene el JOptionPane que da la bienvenida.
	 * @param args ....
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		JOptionPane.showMessageDialog( null, 
		"¡Bienvenido! Este es un programa de entrenamiento cerebral.\n"
		+ "Acontinuacion encontrara varios programas para ejercitar su cerebro.");
		Controlador c = new Controlador();
		
	}
}