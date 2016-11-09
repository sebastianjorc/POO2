package vista;

import javax.swing.JFrame;

import modelo.Partida;
import prueba.TFrame;

public class vista {
	frameBase fb;
	public vista(Partida unaPartida) {		
		if (unaPartida.tPartida != -1){
			if (unaPartida.tPartida == 0)
				fb = new frameClick(unaPartida);
			else if (unaPartida.tPartida==1){
				fb = new frameMov(unaPartida);
				TFrame tf = new TFrame ();		
			}
			
			fb.setVisible(true);
			fb.setResizable(false);
			fb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
}