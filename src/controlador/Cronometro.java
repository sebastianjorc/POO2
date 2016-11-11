package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import modelo.ConexionSQL;
import modelo.Partida;
import vista.tablero;
import vista.tableroMov;

public class Cronometro implements ActionListener{
	int 	s, m,	tipo;	
	JLabel 	l, lPts;	
	Timer 	t, Crono;	
	Partida datos;

	private tablero tc;
	private tableroMov tm;

	public Cronometro(tablero t) {
		tipo=1;
		this.tc=t;
		this.t=t.t;
		this.Crono=t.Crono;
		datos=t.datos;
		l=t.l;		s=t.s; lPts=tablero.lPts;
	}

	public Cronometro(tableroMov t) {
		this.tm=t;
		this.t=t.t;
		this.Crono=t.Crono;
		datos=t.datos;
		l=t.l;		s=t.s; lPts=tableroMov.lPts;
	}

	public void actionPerformed(ActionEvent e) {
		if (s==60){	s=0;	m++;	}		else{s++;}
		
		if (m<10 && s<10){	l.setText("0"+m+":0"+s);}
		else if (m<10)	 {	l.setText("0"+m+":"+s);	}
		else if (s<10)	 {	l.setText(m+":0"+s);	}
		else			 {	l.setText(m+":"+s);		}
		l.repaint();
		
		if (s==10){
			ConexionSQL con = new ConexionSQL();
			t.stop();
			if (tipo==1)tc.Crono.stop();
			else tm.Crono.stop();
			
			JOptionPane.showMessageDialog(null,"Su puntaje ha sido:"+datos.pts+"/60");
			con.insertar(datos.user, datos.tipoPartida, datos.pts);
						
			datos.pts=0;
			if (tipo==1)tablero.lPts.setText	("               PUNTAJE: "+ datos.pts);
			else 		tableroMov.lPts.setText	("               PUNTAJE: "+ datos.pts);
			
			s=0; m=0;	l.setText("00:00");
		}
	}

}