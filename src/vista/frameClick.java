package vista;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import controlador.ClickBoton;
import modelo.Partida;


public class frameClick extends frameBase{
	
	private static final long serialVersionUID = 1L;

	frameClick(Partida unaPartida){
		super(unaPartida);
		init_jp1();
		init_jp2();
		init_jp3();
	}
	
	public void init_jp2(){
		jp2.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		jp2.setLayout(new GridBagLayout());		
		tablero untablero = new tablero(t2, datos);
		
		gbc.fill=GridBagConstraints.BOTH;        
        valorGrid(1, 1, 0, 0, 0, 4);
		jp2.add(untablero,gbc);
		
		JPanel jpb = new JPanel();
		BotonP b1 = new BotonP("START");
		BotonP b2 = new BotonP("STOP");
		b1.addActionListener(new ClickBoton(b2,untablero));
		b2.addActionListener(new ClickBoton(b1,untablero));
		
		jpb.setBackground(Color.decode("#FFFDE4"));		
		jpb.add(b1);	jpb.add(b2);

        valorGrid(1, 0, 0, 4, 0, 1);
		jp2.add(jpb,gbc);
		
	}
	
	public String Descripcion(){
		return	"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\n"
				+ "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\n"
				+"quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\n"
				+"consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\n"
				+"cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\n"
				+"proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n";
	}
}