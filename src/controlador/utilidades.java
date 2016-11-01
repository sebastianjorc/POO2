package controlador;

import javax.swing.JOptionPane;

public class utilidades {
	
	String  validar_rut(){
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
    
    public boolean ValidarRut(int rut, char dv){
        int m = 0, s = 1;
        for (; rut != 0; rut /= 10){
            s = (s + rut % 10 * (9 - m++ % 6)) % 11;
        }
        return dv == (char) (s != 0 ? s + 47 : 75);    	
    }
}