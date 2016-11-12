package controlador;

import modelo.Partida;
import vista.vista;

/**Controlador macro del programa, es quién inicializa los datos y el tipo de partida a ejecutar.
 */
public class controlador {
	utilidades u = new utilidades();
	Partida unaPartida;
	
	/**Inicializar los datos y tipo de partida a ejecutar.
	 */
	controlador(){
		unaPartida = new Partida(u.opcionesJuego(),u.validar_rut());
		new vista(unaPartida);
	}
}