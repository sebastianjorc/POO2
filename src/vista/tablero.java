package vista;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import controlador.ClickTablero;
import controlador.Cronometro;
import controlador.pintarTab;
import modelo.Partida;

/** Contiene el tablero del juego BrainClick y cada uno de sus componentes
 */
public class tablero extends JPanel{
	private static final long serialVersionUID = 1L;
	public static final Color DEFAULT_COLOR = Color.decode("#E8FFFA");
	public JLabel lPts;
    ArrayList<ShapeItem> shapes;
	public JLabel l = new JLabel("00:00");
	public int s=0,	m=0,	sizex = 421,	sizey = 351,	tamCuadrado = 35;
	public Timer t,Crono;
	public Color	colorTrue  = Color.GREEN,
			colorFalse = Color.RED,
			ColorActual= Color.YELLOW;
	public Partida datos;
	Cronometro mov = new Cronometro(this);
	

    /**Inicializa los datos del tablero y cada uno de sus componentes
     * @param t2	: Se utiliza para actualizar el puntaje del usuario a medida que el juego avanza
     * @param datos	: Datos de la partida que son integrados los atributos para poder manipularlos en el tablero.
     */
    public tablero(JLabel t2, Partida datos) {
    	this.datos=datos;	lPts=t2;
    	setBackground(Color.decode("#FFFDE4"));
		setLayout(new FlowLayout(FlowLayout.CENTER));
		inicializar_tablero();
        addMouseListener(new ClickTablero(shapes,this));
		t = new Timer(1000, new pintarTab(this,shapes));
		Crono = new Timer (1000,mov);
		add(l);
    }

    /** Limpia el tablero y los datos de la partida para cuando acaba el juego o se detiene.
     */
    public void limpiar_tablero(){
    	l.setText("00:00");
    	datos.pts=0;
    	lPts.setText("               PUNTAJE: "+ datos.pts);
		for (ShapeItem item : shapes){
			item.color=DEFAULT_COLOR;
		}
        mov.s=0; mov.m=0;
		this.repaint();
    }

	/**Inicializa los valores de los ShapeItem del tablero 
	 */
	public void inicializar_tablero() {
        shapes = new ArrayList<ShapeItem>();
		for (int i = 35; i<sizex+33; i+=tamCuadrado){
			for (int j= 20; j<sizey+18; j+=tamCuadrado){
				 shapes.add(new ShapeItem(new Rectangle2D.Double(i, j, tamCuadrado, tamCuadrado),DEFAULT_COLOR));
			}
		}		
	}

	/**Pinta cada uno de los ShapeItem el color inicial.
	 * @param shapes2 Shape a pintar.
	 */
	public void pintar(ArrayList<ShapeItem> shapes2) {
		for (ShapeItem item : shapes2){
			if (item.color!=DEFAULT_COLOR){
				item.color=DEFAULT_COLOR;
			}
		}
    }

	/**Contiene los valores de cada ShapeItem, que es el tipo de objeto con el que itneractuamos en el juego.
	 */
	public class ShapeItem {
    	boolean estado, presionado;
        Shape shape;
        Color color;

        public ShapeItem(Shape shape, Color color) {
            super();
            this.presionado = false;
            this.estado = false;
            this.shape = shape;
            this.color = color;
        }

        public boolean isEstado() {
			return estado;
		}

		public void setEstado(boolean estado) {
			this.estado = estado;
		}

		public boolean isPresionado() {
			return presionado;
		}

		public void setPresionado(boolean presionado) {
			this.presionado = presionado;
		}

		public Shape getShape() {
            return shape;
        }

        public void setShape(Shape shape) {
            this.shape = shape;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }
    }

    /* (non-Javadoc)
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        
        for (ShapeItem item : shapes) {
            g2.setColor(item.getColor());
            g2.fill(item.getShape());
        }
		for (int i = 35; i<sizex+33; i+=tamCuadrado){
			for (int j= 20; j<sizey+18; j+=tamCuadrado){
				g.drawRect(i, j, tamCuadrado, tamCuadrado);
			}
		}

        g2.dispose();
    }
}