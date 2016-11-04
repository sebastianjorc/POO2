package modelo;

import java.sql.Date;

public class Partida {
	public String tipoPartida, user;
	Date fecha;
	public int pts,tPartida;
	
	public Partida(int i, String string){
		tPartida = i; pts=0; user=string;
		if (i==0){tipoPartida="BrainClick";}
	}

}