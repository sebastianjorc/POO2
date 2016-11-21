package Diagramas;

import javax.swing.JOptionPane;

/*@startuml 
  
  box "Base General" #LightBlue
  actor usuario #Orange
  activate usuario #Yellow
  usuario			<-->  main				: corre el programa 
  activate main #LightGreen
  main 				-> Controlador 		: Inicia
  activate Controlador #LightGreen
  Controlador 		-> Utilidades 		: Pide un usuario y partida valida  
  activate Utilidades#LightGreen
  Utilidades 		--> Controlador		: Devuelve valores requeridos
  Controlador 		-> Partida			: Inicia
  activate Partida#LightGreen
  Partida 			--> Controlador		: Devuelve
  Controlador 		-> Vista 			: Inicia con los valores obtenidos
  activate Vista #LightGreen
  deactivate Utilidades  
  end box
  
  
  alt \tSi el usuario escogió partida frameClick\t
	
  Vista 			-> frameClick		: Inicia
  activate frameClick #pink
  frameClick		-> tablero			: Inicia
  activate tablero #pink
  tablero			-> ShapeItem		: Inicia un arreglo
  activate ShapeItem #pink  
  ShapeItem			-> tablero			: devuelve
  tablero			-> Cronometro		: Inicia
  activate Cronometro #pink
  tablero			-> pintarTab		: Inicia
  activate pintarTab #pink
  tablero 			-> ClickTablero 	: Inicia
  activate ClickTablero #pink
  tablero			-> frameClick		: devuelve
  frameClick 		-> Vista			: devuelve
  
  
  
  Cronometro		-> pintarTab		: activa
  pintarTab			-> ShapeItem		: actionPerformed()
  pintarTab			-> tablero			: repaint() 
   
  ClickTablero		-> ShapeItem		: mouseClicked()
  ClickTablero		-> Partida			: Cambia valor pts
  ClickTablero		-> tablero			: repaint()
  Cronometro		-> pintarTab		: desactiva
  deactivate pintarTab
  
  Cronometro		-> ConexionSQL		: Inicia
  deactivate Cronometro
  activate ConexionSQL #pink
  database	poo2 #yellow
  ConexionSQL		-> poo2				: Inserta datos de partida
  activate poo2 #Yellow
  deactivate ConexionSQL
  deactivate poo2
  frameClick		-> usuario			: Muestra datos de la partida al usuario
  usuario			-> Vista			: Cierra frame
  frameClick		-> main				: al cerrar el frame, se cierra el programa
  
  deactivate ClickTablero
  deactivate tablero
  deactivate ShapeItem
  deactivate frameClick
  
  
  
  else \t\t\t\tSi el usuario escogió partida frameMov \t   
  Vista 			-> frameMov			: Inicia
  activate frameMov #violet
  frameMov			-> tableroMov		: Inicia
  activate tableroMov #violet
  tableroMov		-> figura			: Inicia un arreglo
  activate figura #violet  
  figura			-> tableroMov		: devuelve
  
  tableroMov		-> Cronometro		: Inicia
  activate Cronometro #violet
  tableroMov		-> mov				: Inicia
  activate mov #violet
  tableroMov 		-> ClickTableroMov	: Inicia
  activate ClickTableroMov #violet  
  tableroMov		-> frameMov			: devuelve
  frameMov 			-> Vista			: devuelve
  
  
  Cronometro		-> mov				: actionPerformed()
  mov				-> figura			: update()
  ClickTableroMov	-> figura			: mouseClicked()
  ClickTableroMov	-> figura			: udpate() cambiando valores de dirección
  mov				-> tableroMov		: repaint()
  Cronometro		-> Partida			: Cambia valor pts
  
  alt \tSi colisiona\t\t
  mov				-> tableroMov		: desactiva()
  mov				-> ConexionSQL		: inicia
  activate ConexionSQL #violet
  ConexionSQL		-> poo2				: Inserta datos de partida
  activate poo2 #yellow
  deactivate ConexionSQL
  deactivate poo2
  
  else \t\t\t\tSi no colisiona\t
  Cronometro		-> tableroMov		: desactiva
  Cronometro		-> ConexionSQL		: inicia
  activate ConexionSQL #violet
  ConexionSQL		-> poo2				: Inserta datos de partida
  activate poo2 #yellow
  deactivate ConexionSQL
  deactivate poo2
  end
  
  
  frameMov			-> usuario			: Muestra datos de la partida al usuario
  usuario			-> frameMov			: Cierra frame
  frameMov			-> main				: al cerrar el frame, se cierra el programa
  deactivate mov
  deactivate ClickTableroMov
  deactivate Cronometro
  deactivate tableroMov
  deactivate Partida
  deactivate frameMov
  deactivate figura

  end 
  
  deactivate usuario
  deactivate main 
  deactivate Controlador
  deactivate Vista

   
  
 @enduml
 */

public class DiagramaSecuencia {

	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null,"Generando Diagrama");
	}

}