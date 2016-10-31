package vista;

import javax.swing.JFrame;

public class vista {
	
	public vista(){
		frameClick fb = new frameClick();
		fb.setVisible(true);
		fb.setResizable(false);
		fb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}