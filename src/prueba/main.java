package prueba;

import javax.swing.JFrame;

public class main {
	public static void main(String[] args) {
		DemoShapes ds = new DemoShapes();
		JFrame jf = new JFrame ();
		jf.add(ds);
		jf.setBounds(200,100,600,600);
		jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
	}
}
