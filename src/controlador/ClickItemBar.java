package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.ConexionSQL;
import vista.frameBase;

public class ClickItemBar implements ActionListener {
	int op ;	controlador nc;	frameBase fb;	utilidades u = new utilidades();	String srt = null;	ConexionSQL con=null;

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
        	fb.datos.user = u.validar_rut();
        	fb.t1.setText("               USUARIO: "+ fb.datos.user);
        break;
 
        case 3:
        	System.exit( 0 ); 
        break;
 
        case 4:
        	con = new ConexionSQL();
			srt = con.consulta(fb.datos.user);
    		JOptionPane.showMessageDialog(null,"Ranking de usuario:\n"+srt);
        break;
 
        case 5:
        	con = new ConexionSQL();
			srt = con.consulta(null);
			JOptionPane.showMessageDialog(null,"Ranking General:\n"+srt);    
        break;
 
        case 6:
    		JOptionPane.showMessageDialog(null,"Concejos:\n"
    				+ fb.Descripcion());  
        break;
 
        case 7:
    		JOptionPane.showMessageDialog(null,"Datos del programa y documentacian:\n"
    				+ "Mis Datos:");  
        break;

        default:
    		JOptionPane.showMessageDialog(null,"NO EXISTE PARA ESTA OPCION");
        break;
 
 }
	}

}
