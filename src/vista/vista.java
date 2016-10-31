package vista;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class vista {	
	public vista(){
		
		ImageIcon icon = new ImageIcon("img/brainIcon.png");		
		int seleccion = JOptionPane.showOptionDialog(null,"Seleccione una opcion:", "Selección",
				JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,
				icon, new String[] { "BrainClicks", "salir" }, null);

		if (seleccion != -1){
			if (seleccion == 0){
				frameClick fb = new frameClick();
				fb.setVisible(true);
				fb.setResizable(false);
				fb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		}
	}
}