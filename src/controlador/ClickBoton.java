package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.Timer;

import vista.tablero;
import vista.tableroMov;

/**Clase que implementa actionPerformed de ActionListener
 * Funciona sobre los botones de cual sea el tablero
 * Su función es iniciar y detener el juego del tablero actual
 */

public class ClickBoton implements ActionListener {

	JButton		btn; 	//Objeto clase JButton, recibe el objeto JButton entregado por parametro al constructor dentro de untablero;
	Timer 		t;		//Objero clase Timer, recibe el objeto Timer t entregado por el parametro al constructor dentro de untablero;
	Timer 		Crono;	//Objero clase Timer, recibe el objeto Timer Crono entregado por el parametro al constructor dentro de untablero;
	tablero 	tc; 	//Objeto clase tablero, recive el objeto tablero entregado por parametro al constructor
	tableroMov 	tm;		//Objeto clase tableroMov, recive el objeto tableroMov entregado por parametro al constructor
	
	/**Método constructor, recibe un objeto de clase Boton y otro de clase tablero en los actua el actionListener
	 * @param b :Objeto de clase BotonP, es utilizado para ser detenido en caso de ser precionado el contrario
	 * @param untablero :objeto de clase tablero, es donde se ejecutará la clase Timer en caso de ser presionado algun botón
	 */
	public ClickBoton(JButton b, tablero untablero) {
		this.tc=untablero;
		this.t=untablero.t;
		this.Crono=untablero.Crono;
		this.btn=b;
	}
	/**Método constructor, recibe un objeto de clase Boton y otro de clase tablero en los actua el actionListener
	 * @param b2 :Objeto de clase BotonP, es utilizado para ser detenido en caso de ser precionado el contrario
	 * @param untablero :objeto de clase tableroMov, es donde se ejecutará la clase Timer en caso de ser presionado algun botón
	 */
	public ClickBoton(JButton b2, tableroMov untablero) {
		this.tm=untablero;
		this.t=untablero.t;
		this.Crono=untablero.Crono;
		this.btn=b2;
	}
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		JButton btnPulsado=(JButton) e.getSource();
		
		if (btnPulsado.getText()=="STOP"){			
			t.stop();
			Crono.stop();
			if (tm!=null) tm.limpiar_tablero();
			else tc.limpiar_tablero();
		}else if (btnPulsado.getText()=="START"){
			t.start();
			Crono.start();	
		}
		btnPulsado.setSelected(true);
		btn.setSelected(false);
	}

}
