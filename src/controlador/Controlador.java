package controlador;

import modelo.Partida;
import vista.Vista;

/**Controlador macro del programa, es quién inicializa los datos y el tipo de partida a ejecutar.
 */
public class Controlador {
	utilidades u = new utilidades();
	Partida unaPartida;
	
	/**Inicializar los datos y tipo de partida a ejecutar.
	 */
	Controlador(){
		int juego = u.opcionesJuego();
		if (juego==-1) System.exit(0);
		else{
			unaPartida = new Partida(juego,u.validar_rut());
			new Vista(unaPartida);
		}
	}
}