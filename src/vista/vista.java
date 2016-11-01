package vista;

import javax.swing.JFrame;

public class vista {
	
	public vista(int sel1, String rut){
		if (sel1 != -1){
			if (sel1 == 0){
				frameClick fb = new frameClick(rut);
				fb.setVisible(true);
				fb.setResizable(false);
				fb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		}
	}
}