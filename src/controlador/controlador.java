package controlador;

import modelo.Partida;
import vista.vista;

public class controlador {
	utilidades u = new utilidades();
	Partida unaPartida;
	
	controlador(){
		unaPartida = new Partida(u.opcionesJuego(),u.validar_rut());
		new vista(unaPartida);
		//new vista(u.opcionesJuego(),u.validar_rut());	
	}
}