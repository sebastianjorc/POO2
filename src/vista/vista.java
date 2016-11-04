package vista;

import javax.swing.JFrame;

import modelo.Partida;

public class vista {
	public vista(Partida unaPartida) {		
		if (unaPartida.tPartida != -1){
			if (unaPartida.tPartida == 0){
				frameClick fb = new frameClick(unaPartida);
				fb.setVisible(true);
				fb.setResizable(false);
				fb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		}
	}
}