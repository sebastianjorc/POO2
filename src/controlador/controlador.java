package controlador;

import vista.vista;

public class controlador {
	utilidades u = new utilidades();
	
	controlador(){
		//new vista(u.opcionesJuego(),u.validar_rut());	
		new vista(0,"u.validar_rut()");	
	}

}