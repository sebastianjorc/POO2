package modelo;

import java.sql.Date;

/**Inicializa y guarda los datos de la partida del usuario
 */
public class Partida {
	public String tipoPartida, user;
	Date fecha;
	public int pts,tPartida;
	
	/** Inicializa la partida
	 * @param i		: tipo de partida escogida por el usuario.
	 * @param string: id del usuario.
	 */
	public Partida(int i, String string){
		tPartida = i; pts=0; user=string;
		if (i==0)tipoPartida="BrainClick";
		else if (i==1) tipoPartida="BrainClickMov";
	}
}