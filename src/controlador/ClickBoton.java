package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.BotonP;
import vista.tablero;

public class ClickBoton implements ActionListener {	
	BotonP btn;
	tablero tbl;
	public ClickBoton(BotonP b, tablero untablero) {
		btn=b;
		tbl=untablero;
	}
	public void actionPerformed(ActionEvent e) {
		
		BotonP btnPulsado=(BotonP) e.getSource();
		
		if (btnPulsado.getText()=="STOP"){
			tbl.t.stop();
			tbl.Crono.stop();
		}else if (btnPulsado.getText()=="START"){
			tbl.t.start();
			tbl.Crono.start();	
		}
		
		btnPulsado.setPress(true);
		btn.setPress(false);
	}

}
