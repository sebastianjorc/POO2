package prueba;

import javax.swing.JFrame;

public class main {

	public static void main(String[] args) {
		TFrame tf = new TFrame ();
		tf.setSize(600, 600);
		tf.setVisible(true);
		tf.setResizable(false);
		tf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}