package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import vista.BotonP;
import vista.tablero;
import vista.tableroMov;

public class ClickBoton implements ActionListener {	
	BotonP btn;
	Timer t,Crono;
	public ClickBoton(BotonP b, tablero untablero) {
		this.t=untablero.t;
		this.Crono=untablero.Crono;
		this.btn=b;
	}
	public ClickBoton(BotonP b2, tableroMov untablero) {
		this.t=untablero.t;
		this.Crono=untablero.Crono;
		this.btn=b2;
	}
	public void actionPerformed(ActionEvent e) {
		BotonP btnPulsado=(BotonP) e.getSource();
		
		if (btnPulsado.getText()=="STOP"){
			t.stop();
			Crono.stop();
		}else if (btnPulsado.getText()=="START"){
			t.start();
			Crono.start();	
		}
		
		btnPulsado.setPress(true);
		btn.setPress(false);
	}

}
