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

public class frameMov extends frameBase {
	
	private static final long serialVersionUID = 1L;

	/**Inicializa cada JPanel y el frame con los datos de la partida
	 * @param unaPartida :integra los datos de la partida en los atributos para poder manejarlos en el tablero.
	 */
	frameMov(Partida unaPartida){
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
		tableroMov untablero = new tableroMov(t2, datos);
		
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
		return	"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\n"
				+ "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\n"
				+"quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\n"
				+"consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\n"
				+"cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\n"
				+"proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n";
	}

}