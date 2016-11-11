package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import modelo.ConexionSQL;
import vista.tablero;
import vista.tableroMov;

public class Cronometro implements ActionListener{
	public int 	s;
	public int m;
	JLabel 	l, lPts;

	private tablero tc;
	private tableroMov tm=null;

	public Cronometro(tablero t) {
		this.tc=t;
		this.l=t.l;		this.s=t.s; this.lPts=tc.lPts;
	}

	public Cronometro(tableroMov t) {
		this.tm=t;
		this.l=t.l;		this.s=t.s; this.lPts=tm.lPts;
	}

	public void actionPerformed(ActionEvent e) {
		if (tm!=null){
			tm.datos.pts++; tm.lPts.setText	("               PUNTAJE: "+ tm.datos.pts);
		}
		if (s==60){	s=0;	m++;	}		else{s++;}
		
		if (m<10 && s<10){	l.setText("0"+m+":0"+s);}
		else if (m<10)	 {	l.setText("0"+m+":"+s);	}
		else if (s<10)	 {	l.setText(m+":0"+s);	}
		else			 {	l.setText(m+":"+s);		}
		l.repaint();
		
		if (s==6){
			if (tm!=null){
				tm.t.stop();
				tm.Crono.stop();
				JOptionPane.showMessageDialog(null,"Su puntaje ha sido:"+tm.datos.pts+"/60");
				new ConexionSQL().insertar(tm.datos.user, tm.datos.tipoPartida, tm.datos.pts);
				tm.limpiar_tablero();
			}else{ 
				tc.t.stop();
				tc.Crono.stop();
				JOptionPane.showMessageDialog(null,"Su puntaje ha sido:"+tc.datos.pts+"/60");
				new ConexionSQL().insertar(tc.datos.user, tc.datos.tipoPartida, tc.datos.pts);
				tc.limpiar_tablero();
			}
		}
	}

}