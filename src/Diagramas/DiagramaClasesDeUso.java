package Diagramas;

import javax.swing.JOptionPane;

/*	@startuml
left to right direction
skinparam packageStyle rect
actor customer
actor clerk
rectangle checkout {
  customer -- (checkout)
  (checkout) .> (payment) : include
  (help) .> (checkout) : extends
  (checkout) -- clerk	
  }
@enduml	
*/

public class DiagramaClasesDeUso {

	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null,"Generando Diagrama");
	}

}