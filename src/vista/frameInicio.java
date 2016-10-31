package vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class frameInicio extends JFrame {
	
	frameInicio(){
		super("POO2");
		JPanel p = new JPanel();
		JButton bClick = new JButton("Programa de Click");
		p.add(bClick);
		this.add(p);
		this.setBounds(350, 50,350,250);
		
	}	
}