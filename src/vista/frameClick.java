package vista;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;


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
		jp2.add(new tablero());
		
		JPanel jpb = new JPanel();
		JButton b1 = new JButton("START");
		JButton b2 = new JButton("STOP");
		jpb.setBackground(Color.decode("#FFFDE4"));		
		jpb.add(b1);	jpb.add(b2);
		
		jp2.add(jpb);
		
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