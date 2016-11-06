package prueba;

import javax.swing.JFrame;

public class TFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	public static int MAX_X=600;
	public static int MAX_Y=600;
	
	TFrame(){
		this.setSize(MAX_X,MAX_Y);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel p = new panel();
		this.add(p);
		this.setVisible(true);
		
	}

 }