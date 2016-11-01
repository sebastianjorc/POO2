package vista;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class frameBase extends JFrame {
	
	private static final long serialVersionUID = 1L;

	Toolkit pantalla=Toolkit.getDefaultToolkit();
	Image Icono=pantalla.getImage("img/brain1.png");
    GridBagConstraints gbc=new GridBagConstraints();
	JPanel  jp1 = new JPanel(), 
			jp2 = new JPanel(),
			jp3 = new JPanel();
	
	frameBase(){
		super("POO2");
		this.setIconImage(Icono);
		this.setBounds(350, 50, 490, 650);
		this.getContentPane().setLayout(new GridBagLayout());
		gbc.fill=GridBagConstraints.BOTH;
        
        valorGrid(1, 0.1, 0, 0, 0, 1);
		this.getContentPane().add(jp1,gbc);
		
        valorGrid(1, 1, 0, 1, 0, 5);
		this.getContentPane().add(jp2,gbc);		

        valorGrid(1, 0.035, 0, 6, 0, 2);
		this.getContentPane().add(jp3,gbc);
		
		init();
	}
	
	void valorGrid(double weightx, double weighty, int gridx, int gridy, int gridWidth, int gridHeight){
        gbc.weightx = weightx;
		gbc.weighty = weighty;
		gbc.gridx = gridx;
		gbc.gridy = gridy;
		gbc.gridwidth = gridWidth;
		gbc.gridheight = gridHeight;
	}

	void init(){
		jp1.setBackground(Color.decode("#B2AEFF"));
		jp2.setBackground(Color.decode("#FFFDE4"));
		jp3.setBackground(Color.decode("#FFD8CB"));
				 
	 }
}