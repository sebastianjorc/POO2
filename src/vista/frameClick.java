package vista;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import controlador.ClickBoton;
import modelo.Partida;

public class frameClick extends frameBase{
	
	private static final long serialVersionUID = 1L;

	/**Inicializa cada JPanel y el frame con los datos de la partida
	 * @param unaPartida :integra los datos de la partida en los atributos para poder manejarlos en el tablero.
	 */
	frameClick(Partida unaPartida){
		super(unaPartida);
		init_jp1();
		init_jp2();
		init_jp3();
	}
	
	/* (non-Javadoc)
	 * @see vista.frameBase#init_jp2()
	 */
	public void init_jp2(){
		jp2.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		jp2.setLayout(new GridBagLayout());
		tablero untablero = new tablero(t2, datos);
		
		gbc.fill=GridBagConstraints.BOTH;        
        valorGrid(1, 1, 0, 0, 0, 4);
		jp2.add(untablero,gbc);
		
		JPanel jpb = new JPanel();
		JButton b1 = new JButton("START");
		JButton b2 = new JButton("STOP");
		b1.addActionListener(new ClickBoton(b2,untablero));
		b2.addActionListener(new ClickBoton(b1,untablero));
		
		jpb.setBackground(Color.decode("#FFFDE4"));		
		jpb.add(b1);	jpb.add(b2);

        valorGrid(1, 0, 0, 4, 0, 1);
		jp2.add(jpb,gbc);
		
	}
	
	/* (non-Javadoc)
	 * @see vista.frameBase#Descripcion()
	 */
	public String Descripcion(){
		return	"-\tPara comenzar presione el botón [Start]\n"
			  + "-\tPara pausar su partida presione el botón [Stop]\n"
			  + "- Al comenzar la partida, un cuadro del tablero cambiará a color amarillo de manera\n"
			  + "  alterna, a medida que avanza el cronometro. Ud debe poder seleccionar el cuadro\n"
			  + "  antes de que este cambie de color.\n"
			  + "- Si al hacerlo el cuadro cambia a verde ud ha acertado y sumará puntaje.\n"
		  	  + "- Si el cuadro cambia a rojo ud ha fallado y se restará puntaje.";
	}

}