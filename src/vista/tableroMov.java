package vista;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import modelo.Partida;

public class tableroMov extends JPanel {
	
	private static final long serialVersionUID = 1L;
	public static final Color DEFAULT_COLOR = Color.decode("#E8FFFA");
	public static JLabel lPts;
    ArrayList<ShapeItem> shapes;
	public JLabel l = new JLabel("00:00");
	public int s=0,	m=0,	sizex = 421,	sizey = 351,	tamCuadrado = 34;
	public Timer t,Crono;
	public Color	colorTrue  = Color.GREEN,
			colorFalse = Color.RED,
			ColorActual= Color.YELLOW;
	public Partida datos;
	
	Polygon poligono1;	GeneralPath estrella;

    public tableroMov(JLabel t2, Partida datos) {
    	this.datos=datos;	tablero.lPts=t2;
    	setBackground(Color.decode("#FFFDE4"));
		setLayout(new FlowLayout(FlowLayout.CENTER));		
        shapes = generarShapes();
        
		//addMouseListener(new ClickTablero(shapes,this));
		//t = new Timer(1000, new pintarTab(this,shapes));		
		//Crono = new Timer (1000,new Cronometro(this));
        
		//add(l);
    }

    public ArrayList<ShapeItem> generarShapes(){
		//Obtengo dimenciones y lugar fisico de las figuras (shapes)
        shapes = new ArrayList<ShapeItem>();

        //Valores del pentagono
        int valoresX[] = { 260, 210, 230, 290, 310 };
        int valoresY[] = { 30, 70, 120, 120, 70 };
        poligono1 = new Polygon( valoresX, valoresY, 5 );
        shapes.add(new ShapeItem( poligono1, Color.blue ));
  
        //Valores de estrella
        int puntosX[] = { 55, 67, 109, 73, 83, 55, 27, 37, 1, 43 };
        int puntosY[] = { 0, 36, 36, 54, 96, 72, 96, 54, 36, 36 };
        estrella = new GeneralPath();  // crear objeto GeneralPath
          
        // establecer la coordenada inicial de la ruta general
        estrella.moveTo( puntosX[0], puntosY[0] );  
         //Crear la estrella
        for ( int a = 1; a < puntosX.length; a++ )
           estrella.lineTo( puntosX[a], puntosY[a] );        
        estrella.closePath();  // cerrar la figura
        
        shapes.add(new ShapeItem(estrella, Color.blue));
        shapes.add(new ShapeItem(new Rectangle2D.Double( 80, 30, 65, 100 ),Color.CYAN));
        //elipse 2D
        shapes.add(new ShapeItem(new Ellipse2D.Double(5, 30, 65, 100),Color.pink));
        //linea diagonal 2D
        shapes.add(new ShapeItem(new Line2D.Double(200, 30, 150, 130),Color.black));
    	
		return shapes;    	
    }

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
    }

    @Override
    public void paintComponent(Graphics g) {
    	
    	super.paintComponent(g);  // llamar al metodo paint de la superclase    	  
    	Graphics2D g2d = (Graphics2D) g.create();  // convertir g a Graphics2D    
    	g2d.setStroke( new BasicStroke( 3.0f ) );   //ancho de las lineas    	
        
        //creo los marcos
		for (int i = 0; i<sizex+30; i+=tamCuadrado){
			for (int j= 0; j<sizey; j+=tamCuadrado){
				g.drawRect(i, j, tamCuadrado, tamCuadrado);
			}
		}        
        //pinto cuadros rellenos        
        for (ShapeItem item : shapes) {
            g2d.setColor(item.color);
            g2d.fill(item.shape);	}
        
        g2d.dispose();
    }

}
