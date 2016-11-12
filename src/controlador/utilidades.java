package controlador;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**Clase auxiliar, contiene los métodos que no guardan total cohesión con las demás clases pero son necesarias para el funcionamiento del programa.
 */
public class utilidades {
		
	/**Pide al usuario ingresar su rut, el cual será el id para monitorizar los avances del jugador.
	 * Este a la vez, validará el rut, y en caso de ser incorrecta volverá a solicitarlo.
	 * @return Devuelve un rut válido. (o cerrará el programa en caso de que el usuario de a "cancelar" en el JOptionPane)
	 */
	String validar_rut(){
		boolean flag=true;
		String Rut;	String[] rut_dv;	int rut;	char dv;
		while (flag){
            try{
            	Rut=JOptionPane.showInputDialog(null,"Ingrese su Rut con digito verificador. \n(Ej: 10.283.392-k): ",JOptionPane.QUESTION_MESSAGE);
                if(Rut==null){System.exit(0);}
        		rut_dv = Rut.replace(".","").split("-");
                rut = Integer.parseInt( rut_dv[0] );
                dv = rut_dv[1].charAt(0);              
                if (ValidarRut(rut, dv)){return (Integer.toString(rut))+"-"+dv;}
                else{	JOptionPane.showMessageDialog(null,"Rut incorrecto, intentelo otra vez");	}
            }catch( Exception ex ){
            	JOptionPane.showMessageDialog(null,"Rut incorrecto, intentelo otra vez");
            }
		}
		return null;
	}
    
    /**Valida un rut para el método validar_rut.
     * @param rut	: Rut a validar.
     * @param dv	: Digito verificador.
     * @return		: Devuelve true en caso de que el rut exista, de lo contrario, false.
     */
    public boolean ValidarRut(int rut, char dv){
        int m = 0, s = 1;
        for (; rut != 0; rut /= 10){
            s = (s + rut % 10 * (9 - m++ % 6)) % 11;
        }
        return dv == (char) (s != 0 ? s + 47 : 75);    	
    }
    
    /**Muestra al usuario un JOptionPane para poder seleccionar el juago a iniciar.
     * @return Devuelve la opción elegida por el usuario.
     */
    int opcionesJuego(){    	
    	ImageIcon icon = new ImageIcon("img/brainIcon.png");
    	return 	JOptionPane.showOptionDialog(null,"Seleccione una opcion:", "SelecciÃ³n",
    			JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,
    			icon, new String[] { "BrainClicks","BrainMovClick" }, null);
    }
}