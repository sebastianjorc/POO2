package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import modelo.ConexionSQL;
import vista.tablero;

public class Cronometro implements ActionListener{
	tablero t;	JLabel l;	int s,m;

	public Cronometro(tablero t) {
		this.t=t;
		l=t.l;
		s=t.s;
	}

	public void actionPerformed(ActionEvent arg0) {
		if (s==60){	s=0;	m++;	}
		else{s++;}
		
		if (m<10 && s<10){	l.setText("0"+m+":0"+s);}
		else if (m<10){		l.setText("0"+m+":"+s);}
		else if (s<10){		l.setText(m+":0"+s);}
		else{ 				l.setText(m+":"+s);}
		
		l.repaint();		
		if (s==10){	
			ConexionSQL con = new ConexionSQL();
			t.Crono.stop();	t.t.stop();	
			JOptionPane.showMessageDialog(null,"Su puntaje ha sido:"+t.datos.pts+"/60");
			con.insertar(t.datos.user, t.datos.tipoPartida, t.datos.pts);
			t.datos.pts=0;	tablero.lPts.setText("               PUNTAJE: "+ t.datos.pts);
		}		
	}

}
