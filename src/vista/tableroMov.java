package vista;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import controlador.ClickTableroMov;
import controlador.Cronometro;
import controlador.mov;
import modelo.Partida;

public class tableroMov extends JPanel {	
	private static final long serialVersionUID = 1L;
	public static final Color DEFAULT_COLOR = Color.decode("#E8FFFA");
	public JLabel lPts;
    public ArrayList<figura> figuras;
	public JLabel l = new JLabel("00:00");
	public int s=0,	m=0;
	public static int sizex = 421,	sizey = 351,	tamCuadrado = 30;
	public Timer t,Crono;
	public Partida datos;	
	Polygon poligono1;	GeneralPath estrella;
	Cronometro tm = new Cronometro (this);

    public tableroMov(JLabel t2, Partida datos) {
    	this.datos=datos;	lPts=t2;
    	setBackground(Color.decode("#FFFDE4"));
		setLayout(new FlowLayout(FlowLayout.CENTER));
        figuras = new ArrayList<figura>();		
        figuras = generarShapes();        
        t		= new Timer(100, new mov(this));
		Crono = new Timer (1000,tm);
		add(l);
        addMouseListener(new ClickTableroMov(figuras,this));
    }

    public void limpiar_tablero(){
    	l.setText("00:00");
    	datos.pts=0;
    	lPts.setText("               PUNTAJE: "+ datos.pts);
    	figuras.get(0).setBounds(300,30,50,50);
    	figuras.get(1).setBounds(80 ,30,50,50);
    	figuras.get(2).setBounds(5	,30,50,50);
    	figuras.get(3).setBounds(210,120,50,50);
        tm.s=0; tm.m=0;
        this.repaint();
    	
    }
    
    public ArrayList<figura> generarShapes(){
    	figuras = new ArrayList<figura>();
    	
        int puntosX[] = { 355, 367, 409, 373, 383, 355, 327, 337, 301, 343 };
        int puntosY[] = {  50,	86,  86, 104, 146, 122, 146, 104,  86,  86 };        
        
        GeneralPath estrella = new GeneralPath();
        estrella.moveTo(puntosX[0],puntosY[0] );
        for ( int a = 1; a < puntosX.length; a++ )
        	estrella.lineTo(puntosX[a],puntosY[a]);     
        estrella.closePath();
        
        figuras.add(new figura(estrella, Color.MAGENTA,0));        
        figuras.add(new figura(new Rectangle2D.Double(80, 30, 80,80),Color.CYAN, 1));
        figuras.add(new figura(new Ellipse2D.Double	 (5	, 30, 80,80),Color.pink, 2));
        
        int valoresX[] = { 260, 210, 230, 290, 310 };
        int valoresY[] = { 30, 70, 120, 120, 70 };
        Polygon poligono1 = new Polygon( valoresX, valoresY, 5 );
        figuras.add(new figura( poligono1, Color.blue,3));
    	
		return figuras; 
    }

    public void paintComponent(Graphics g) {
    	
    	super.paintComponent(g);    	  
    	Graphics2D g2 = (Graphics2D) g.create();    
    	g2.setStroke( new BasicStroke( 3.0f ) );
        
		for (int i = 0; i<sizex+30; i+=tamCuadrado){
			for (int j= 0; j<sizey; j+=tamCuadrado)
				g.drawRect(i, j, tamCuadrado, tamCuadrado);
		}
        
        for (figura item : figuras) {        	
            g2.setColor(item.getColor());
        	if 		(item.tipo==0)	g2.fill(item.getShape());
        	else if	(item.tipo==1)	g2.fill(item.getShape());
        	else if	(item.tipo==2)	g2.fill(item.getShape());
        	else if	(item.tipo==3)	g2.fill(item.getShape());
        }
        g2.dispose();        
    }
}