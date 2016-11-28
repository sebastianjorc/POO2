package vista;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

import controlador.ClickItemBar;
import modelo.Partida;

/** Clase base para los frames de cada juego.
 * Contiene todos los componentes necesarios para el frame, a excepción del tablero que deberá ser implementado en su clase hija
 */
public abstract class frameBase extends JFrame{
	
	private static final long serialVersionUID = 1L;

	Toolkit 	pantalla	= Toolkit.getDefaultToolkit();
	Image 		Icono		= pantalla.getImage("img/brain1.png");	
	JMenuBar 	miBar 		= new JMenuBar();
    JMenu 		jmOpciones 	= new JMenu("Opciones"),
    			jmRanking 	= new JMenu ("Ranking"),
    			jmAyuda 	= new JMenu ("Ayuda");
    JMenuItem	item1 		= new JMenuItem("Nuevo juego"),
    			item2 = new JMenuItem("Cambiar jugador"),
    			item3 = new JMenuItem("Salir"),

    	    	item4 = new JMenuItem("Ver mi ranking"),
    			item5 = new JMenuItem("Ver ranking general"),
    		
    			item6 = new JMenuItem("Consejos"),
				item7 = new JMenuItem("Sobre nosotros");
    public JPanel	jp1 	= new JPanel(), 
    				jp2 	= new JPanel(),
    				jp3 	= new JPanel();
    GridBagConstraints gbc	= new GridBagConstraints();
    public JLabel t1,t2;	public Partida datos;
    public String descrip;
    
	/**Inicializa y asigna valores a los los atributos generales del frame como tamaño, bar, layout, etc
	 * @param unaPartida agrega los valores de la partida generada en los atributos para utilizarlo en el frame
	 */
	frameBase(Partida unaPartida){
		this.datos=unaPartida;
		this.setIconImage(Icono);
		this.setTitle(datos.tipoPartida);
		
		this.setBounds(350, 50, 490, 670);
		InicializarBar();	this.setJMenuBar(miBar);
		this.getContentPane().setLayout(new GridBagLayout());
		gbc.fill=GridBagConstraints.BOTH;
        	
        valorGrid(1, 0.1, 0, 0, 0, 1);
		this.getContentPane().add(jp1,gbc);
		
        valorGrid(1, 1, 0, 1, 0, 5);
		this.getContentPane().add(jp2,gbc);		

        valorGrid(1, 0.035, 0, 6, 0, 2);
		this.getContentPane().add(jp3,gbc);
		
		init();
		descrip=this.Descripcion();
	}
	
	/**Inicializa barra y sus items.
	 */
	private void InicializarBar(){
		item1.addActionListener(new ClickItemBar(1,this));
		item2.addActionListener(new ClickItemBar(2,this));
		item3.addActionListener(new ClickItemBar(3,this));
		item4.addActionListener(new ClickItemBar(4,this));
		item5.addActionListener(new ClickItemBar(5,this));
		item6.addActionListener(new ClickItemBar(6,this));
		item7.addActionListener(new ClickItemBar(7,this));
		
		jmOpciones.add(item1);	jmOpciones.add(item2);	jmOpciones.add(item3);		
		miBar.add(jmOpciones);
		
		jmRanking.add(item4);	jmRanking.add(item5);	miBar.add(jmRanking);
		
		jmAyuda.add(item6);	jmAyuda.add(item7);	miBar.add(jmAyuda);		
	}

	/** Asigna valores al grid.
	 * @param weightx 		Porcentaje de expanción en x
	 * @param weighty 		Porcentaje de expanción en y
	 * @param gridx			posición x donde se ubicará en el layout
	 * @param gridy			posición y donde se ubicará en el layout
	 * @param gridWidth		numero de celdas que tomará en x
	 * @param gridHeight	numero de celdas que tomará en y
	 */
	void valorGrid(double weightx, double weighty, int gridx, int gridy, int gridWidth, int gridHeight){
        gbc.weightx 	= weightx;
		gbc.weighty 	= weighty;
		gbc.gridx 		= gridx;
		gbc.gridy 		= gridy;
		gbc.gridwidth 	= gridWidth;
		gbc.gridheight	= gridHeight;
	}

	/**Inicializa los colores de cada JPanel
	 */
	void init(){
		jp1.setBackground(Color.decode("#B2AEFF"));
		jp2.setBackground(Color.decode("#FFFDE4"));
		jp3.setBackground(Color.decode("#FFD8CB"));
				 
	 }

	/**Inicializa el primer JPanel y sus componentes
	 */
	void init_jp1(){
		jp1.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		jp1.setLayout(new GridLayout());
		t1	= new JLabel("               USUARIO: "+ datos.user);
		t2	= new JLabel("               PUNTAJE: "+ datos.pts);
		jp1.add(t1);	jp1.add(t2);
	}
	
	/**Inicializa el tercer JPanel y sus componentes
	 */
	void init_jp3(){
		jp3.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		JTextArea t1 = new JTextArea(Descripcion());
		t1.setBackground(Color.decode("#FFD8CB"));
		t1.setEditable(false);	 jp3.add(t1);	
	}

	/**Inicializa el segundo JPanel y sus componentes. Aquí va el tablero de juego.
	 */
	public abstract void init_jp2();
	/**Contiene la descricpión del juego
	 * @return devuelve un string con la descricpción del juego.
	 */
	public abstract String Descripcion();
}