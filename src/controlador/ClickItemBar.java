package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import modelo.ConexionSQL;
import vista.frameBase;

/**Clase que implementa actionPerformed de ActionListener
 * Funciona sobre los item de la barra del frame
 * Su función es que cada item pueda llevar a cabo su función particular
 */
public class ClickItemBar implements ActionListener {
	
	int 		op;	//Objeto de clase int, recibe el objeto de clase int entregado al constructor.
	Controlador nc;	//
	frameBase 	fb; //
	JTable 		table 	= null;	
	ConexionSQL con		= null;
	utilidades 	u 		= new utilidades();	

	/**Recibe un objeto int y otro frameBase que son guardados en los atributos de la clase y le hacen funcionar
	 * @param i			:Sirve para reconocer qué item dentro del bar fue seleccionado
	 * @param frameBase	:Sirve como objeto que entrega los datos y en la que actua la esta clase.
	 */
	public ClickItemBar(int i, frameBase frameBase) {
		this.op=i;
		fb=frameBase;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent arg0) {
		switch (op) {
		 
        case 1:
        	nc = new Controlador();
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
        	con = new ConexionSQL();	table = con.consulta(fb.datos.user,fb.datos.tipoPartida);
    		JOptionPane.showMessageDialog(null,new JScrollPane(table));
        break;
 
        case 5:
        	con = new ConexionSQL();	table = con.consulta(null,fb.datos.tipoPartida);
    		JOptionPane.showMessageDialog(null, new JScrollPane(table));
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
