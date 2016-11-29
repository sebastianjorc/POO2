package vista;


import javax.swing.JFrame;

import modelo.Partida;

/**Manipula qué tipo de frame/vista mostrará al usuario acorde a su elección del juego.
 */
public class Vista {
	frameBase fb;
	/**Inicializa los valores de la partida y el frame del juego.
	 * @param unaPartida Integra los datos de la partida al juego
	 */
	public Vista(Partida unaPartida){
		if (unaPartida.tPartida != -1){
			
			if (unaPartida.tPartida == 0)
				fb = new frameClick(unaPartida);
			
			else if (unaPartida.tPartida==1){
				fb = new frameMov(unaPartida);
			}			
			fb.setVisible(true);
			fb.setResizable(false);
			fb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
}