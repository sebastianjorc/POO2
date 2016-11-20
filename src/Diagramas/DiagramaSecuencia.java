package Diagramas;

import javax.swing.JOptionPane;

/*@startuml
  main 				-> Controlador 		: Inicia
  Controlador 		-> Utilidades 		: Pide un usuario y partida valida
  Utilidades 		-> Controlador		: Devuelve valores requeridos
  Controlador 		-> Partida			: Inicia
  Partida 			-> Controlador		: Devuelve
  Controlador 		-> Vista 			: Inicia con los valores obtenidos
  
  alt \tSi el usuario escogió partida frameClick\t

  Vista 			-> frameClick		: Inicia  
  frameClick		-> tablero			: Inicia
  tablero			-> ShapeItem		: Inicia un arreglo  
  ShapeItem			-> tablero			: devuelve
  
  tablero			-> Cronometro		: Inicia
  tablero			-> pintarTab		: Inicia
  tablero 			-> ClickTablero 	: Inicia
  tablero			-> frameClick		: devuelve
  frameClick 		-> Vista			: devuelve
  
  Cronometro		-> pintarTab		: activa
  pintarTab			-> ShapeItem		: actionPerformed()
  pintarTab			-> tablero			: repaint() 
   
  ClickTablero		-> ShapeItem		: mouseClicked()
  ClickTablero		-> Partida			: Cambia valor pts
  ClickTablero		-> tablero			: repaint()
  Cronometro		-> pintarTab		: desactiva
  Cronometro		-> ConexionSQL		: Inicia
  database	poo2 #yellow
  ConexionSQL		-> poo2				: Inserta datos de partida
  
  
  else \t\t\t\tSi el usuario escogió partida frameMov \t  
  Vista 			-> frameMov			: Inicia un
  frameMov			-> tableroMov		: Inicia
  tableroMov		-> figura			: Inicia un arreglo  
  figura			-> tableroMov		: devuelve
  
  tableroMov		-> Cronometro		: Inicia
  tableroMov		-> mov				: Inicia
  tableroMov 		-> ClickTableroMov	: Inicia  
  tableroMov		-> frameMov			: devuelve
  frameMov 			-> Vista			: devuelve
  
  
  Cronometro		-> mov				: actionPerformed()
  mov				-> figura			: update()
  ClickTableroMov	-> figura			: mouseClicked()
  ClickTableroMov	-> figura			: udpate() cambiando valores de dirección
  mov				-> tableroMov		: repaint()
  Cronometro		-> Partida			: Cambia valor pts
  
  alt Si colisiona
  mov				-> tableroMov		: desactiva()
  mov				-> ConexionSQL		: inicia
  ConexionSQL		-> poo2				: Inserta datos de partida  
  end
  
  Cronometro		-> tableroMov		: desactiva
  
  end 
  
   
  
 @enduml
 */

public class DiagramaSecuencia {

	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null,"Generando Diagrama");
	}

}
