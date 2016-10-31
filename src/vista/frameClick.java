package vista;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;


public class frameClick extends frameBase{
	
	private static final long serialVersionUID = 1L;
	int pts, user=1865552016;

	frameClick(){
		init_jp1();
		init_jp2();
		init_jp3();
		
	}
	
	void init_jp1(){
		pts = 0;
		jp1.setLayout(new GridLayout());
		JLabel t1 = new JLabel("               USUARIO: "+ user);
		JLabel t2 = new JLabel("               PUNTAJE: "+ pts);
		jp1.add(t1);	jp1.add(t2);
	}
	
	void init_jp2(){
		jp2.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		
	}
	
	void init_jp3(){
		JButton b1 = new JButton("START");
		JButton b2 = new JButton("STOP");
		jp3.add(b1);	jp3.add(b2);
		
	}

}