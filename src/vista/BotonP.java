package vista;

import javax.swing.JButton;

public class BotonP extends JButton {
	boolean press = false;

	public BotonP(String string) {
		super(string);
	}
	
	public boolean isPress() {
		return press;
	}
	public void setPress(boolean press) {
		this.press = press;
	}
	
	private static final long serialVersionUID = 1L;
}
