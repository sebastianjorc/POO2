package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import vista.frameBase;

public class ClickItemBar implements ActionListener {
	int op ;	controlador nc;	frameBase fb;	utilidades u = new utilidades();

	public ClickItemBar(int i, frameBase frameBase) {
		this.op=i;
		fb=frameBase;
	}
	public void actionPerformed(ActionEvent arg0) {
		switch (op) {
		 
        case 1:
        	nc = new controlador();
        	fb.dispose();
        break;
 
        case 2:
        	fb.user = u.validar_rut();
        	fb.t1.setText("               USUARIO: "+ fb.user);
        break;
 
        case 3:
        	System.exit( 0 ); 
        break;
 
        case 4:
    		JOptionPane.showMessageDialog(null,"Ranking de usuario "+fb.user+":\n"
    				+ "Acontinuación mostrar ranking");        	
        break;
 
        case 5:
    		JOptionPane.showMessageDialog(null,"Ranking General: \n"
    				+ "Acontinuación mostrar ranking");    
        break;
 
        case 6:
    		JOptionPane.showMessageDialog(null,"Concejos:\n"
    				+ fb.Descripcion());  
        break;
 
        case 7:
    		JOptionPane.showMessageDialog(null,"Datos del programa y documentación:\n"
    				+ "Mis Datos:");  
        break;

        default:
    		JOptionPane.showMessageDialog(null,"NO EXISTE PARA ESTA OPCION");
        break;
 
 }
	}

}
