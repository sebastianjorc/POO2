package controlador;

import modelo.Partida;
import vista.vista;

public class controlador {
	utilidades u = new utilidades();
	Partida unaPartida;
	
	controlador(){
		//new vista(u.opcionesJuego(),u.validar_rut());	
		unaPartida = new Partida(0,"un_rut");
		new vista(unaPartida);	
	}
}