package vista;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

import controlador.ClickBoton;


public class frameClick extends frameBase{
	
	private static final long serialVersionUID = 1L;
	int pts; 
	String user;

	frameClick(String rut){
		this.user = rut;
		this.setTitle("BrainClick");
		init_jp1();
		init_jp2();
		init_jp3();
		
	}
	
	void init_jp1(){
		jp1.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		pts = 0;
		jp1.setLayout(new GridLayout());
		JLabel t1 = new JLabel("               USUARIO: "+ user);
		JLabel t2 = new JLabel("               PUNTAJE: "+ pts);
		jp1.add(t1);	jp1.add(t2);
	}
	
	void init_jp2(){
		jp2.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		jp2.setLayout(new GridBagLayout());		
		tablero untablero = new tablero();
		//untablero.listener
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
	
	void init_jp3(){
		jp3.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		JTextArea t1 = new JTextArea(Descripcion());
		t1.setEditable(false);	 jp3.add(t1);	
	}
	
	String Descripcion(){
		return	"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\n"
				+ "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\n"
				+"quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\n"
				+"consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\n"
				+"cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\n"
				+"proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n";
	}
	
	
}