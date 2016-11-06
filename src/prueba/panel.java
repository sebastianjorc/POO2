package prueba;

import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class panel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	Timer t;	ArrayList<figura>	figuras;
	
	public panel (){
		this.setFocusable(true);
        figuras = new ArrayList<figura>();
        t		= new Timer(100,this);
        figuras = this.generarShapes();
		t.start();
	}

    public ArrayList<figura> generarShapes(){
    	figuras = new ArrayList<figura>();
        
        int valoresX[] = { 260, 210, 230, 290, 310 };
        int valoresY[] = { 30, 70, 120, 120, 70 };
        Polygon poligono1 = new Polygon( valoresX, valoresY, 5 );
        figuras.add(new figura( poligono1, Color.blue,4));
  
        //Valores de estrella
        int puntosX[] = { 355, 367, 409, 373, 383, 355, 327, 337, 301, 343 };
        int puntosY[] = { 50, 86, 86, 104, 146, 122, 146, 104, 86, 86 };
        GeneralPath estrella = new GeneralPath();  // crear objeto GeneralPath
        estrella.moveTo(puntosX[0],puntosY[0] );
        for ( int a = 1; a < puntosX.length; a++ )
        	estrella.lineTo(puntosX[a],puntosY[a]);     
        estrella.closePath();
        
        figuras.add(new figura(estrella, Color.blue,0));        
        figuras.add(new figura(new Rectangle2D.Double(80, 30, 65,100),Color.CYAN, 1));
        figuras.add(new figura(new Ellipse2D.Double	 (5	, 30, 65,100),Color.pink, 2));
        figuras.add(new figura(new Line2D.Double	 (200,30,150,130),Color.black,3));
    	
		return figuras;    	
    }

	public void paint (Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        
        for (figura item : figuras) {        	
        	if 		(item.tipo==0)	g2.fill(item.getShape());
        	else if	(item.tipo==1)	g2.fill(item.getShape());
        	else if	(item.tipo==2)	g2.fill(item.getShape());
        	else if	(item.tipo==3)	g2.fill(item.getShape());
        	else if	(item.tipo==4)	g2.fill(item.getShape());
        	
            g2.setColor(item.getColor());
        }
		
	}
	
	public void update(){	
		for (figura item: figuras)
			item.update();
	}
	
	public void actionPerformed(ActionEvent e) {
		this.repaint();	update();	
	}
}