package vista;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.GeneralPath;
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
  //  ArrayList<ShapeItem> shapes;
	public JLabel l = new JLabel("00:00");
	public int s=0,	m=0,	sizex = 421,	sizey = 351,	tamCuadrado = 35;
	public Timer t,Crono;
	public Color	colorTrue  = Color.GREEN,
			colorFalse = Color.RED,
			ColorActual= Color.YELLOW;
	public Partida datos;
	

    public tableroMov(JLabel t2, Partida datos) {
    	this.datos=datos;	tablero.lPts=t2;
    	setBackground(Color.decode("#FFFDE4"));
		setLayout(new FlowLayout(FlowLayout.CENTER));
		
        //shapes = generarShapes();
        
		//addMouseListener(new ClickTablero(shapes,this));
		//t = new Timer(1000, new pintarTab(this,shapes));		
		//Crono = new Timer (1000,new Cronometro(this));
        
		//add(l);
    }
/*
    public ArrayList<ShapeItem> generarShapes(){
		//Obtengo dimenciones y lugar fisico de las figuras (shapes)
        shapes = new ArrayList<ShapeItem>();
		for (int i = 35; i<sizex+33; i+=tamCuadrado){
			for (int j= 20; j<sizey+18; j+=tamCuadrado){
				 shapes.add(new ShapeItem(new Rectangle2D.Double(i, j, tamCuadrado, tamCuadrado),DEFAULT_COLOR));
			}
		}
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
*/
    @Override
    public void paintComponent(Graphics g) {
    	
    	  super.paintComponent(g);  // llamar al m�todo paint de la superclase    	  
    	  Graphics2D g2d = (Graphics2D) g.create();  // convertir g a Graphics2D    
          g2d.setStroke( new BasicStroke( 3.0f ) );   //ancho de las lineas
    
          //Valores del pentagono
          int valoresX[] = { 260, 210, 230, 290, 310 };
          int valoresY[] = { 30, 70, 120, 120, 70 };
          Polygon poligono1 = new Polygon( valoresX, valoresY, 5 );
    
          //Valores de estrella
          int puntosX[] = { 55, 67, 109, 73, 83, 55, 27, 37, 1, 43 };
          int puntosY[] = { 0, 36, 36, 54, 96, 72, 96, 54, 36, 36 };
    
          GeneralPath estrella = new GeneralPath();  // crear objeto GeneralPath
    
          // establecer la coordenada inicial de la ruta general
          estrella.moveTo( puntosX[ 0 ], puntosY[ 0 ] );
    
           //Crear la estrella
          for ( int a = 1; a < puntosX.length; a++ )
             estrella.lineTo( puntosX[ a ], puntosY[ a ] );
    
          estrella.closePath();  // cerrar la figura
    
          //Dibujar elipse 2D
          g2d.setPaint(Color.blue);
          g2d.drawOval(5, 30, 65, 100);
    
          //Dibujar rectangulo 2D
          g2d.setPaint(Color.CYAN);
          g2d.draw( new Rectangle2D.Double( 80, 30, 65, 100 ) );
    
          //Dibujar linea diagonal 2D
          g2d.setPaint(Color.PINK);
          g2d.drawLine(200, 30, 150, 130);
    
          //Dibujar pentagono 2D
          g2d.setPaint(Color.MAGENTA);
          g2d.drawPolygon(poligono1);
    
          //Dibujar estrella
          g2d.translate( 320, 30 );  // trasladar el origen a (320, 30)
          g2d.setPaint(Color.YELLOW);
          g2d.draw( estrella );
          
          
          g2d.dispose();    	
    	/*
        
        //pinto cuadros rellenos        
        for (ShapeItem item : shapes) {
            g2.setColor(item.color);
            g2.fill(item.shape);
        }

        //creo los marcos
		for (int i = 35; i<sizex+33; i+=tamCuadrado){
			for (int j= 20; j<sizey+18; j+=tamCuadrado){
				g.drawRect(i, j, tamCuadrado, tamCuadrado);
			}
		}
        g2.dispose();*/
    }

}
