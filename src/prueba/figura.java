package prueba;

import java.awt.Color;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class figura {
	Shape shape;	Color color;	int tipo;
	int xVel=8;		int yVel=8;
	int x, y;
	
	figura(Shape shape, Color color, int tipo){
		x=(int) shape.getBounds2D().getX();
		y=(int) shape.getBounds2D().getY();
		this.tipo =tipo;
		this.shape=shape;
		this.color=color;
	}
	//EL UPDATE SOLO SIRVE PARA OBJETOS CUADRADOS DE UNA DIMENCION, ADAPTAR.
	//CREAR POR FIGURA, NUEVA FUNCIÓN.
	public void update(){
		
		x=x+xVel;	y=y+yVel;
		if(tipo==0 || tipo == 4){
			if(x<60 || x>TFrame.MAX_X-65)	xVel=-xVel;
			if(y<0 || y>TFrame.MAX_Y -150)	yVel=-yVel;
		}else{
			if(x<0 || x>TFrame.MAX_X-75)	xVel=-xVel;
			if(y<0  || y>TFrame.MAX_Y -130)	yVel=-yVel;
		}
		
		shape.getBounds().setLocation(x, y);
		this.setShape(nuevoShape(tipo));
	}
	
	public Shape nuevoShape(int op){
		if (op==0){
	        int puntosX[] = {	x,	x+12,	x+54,	x+18, 	x+28, 	x, 		x-28, 	x-18,	x-54,	x-12 };
	        int puntosY[] = {	y,	y+36,	y+36,	y+54, 	y+96, 	y+72, 	y+96, 	y+54,	y+36,	y+36};
	        GeneralPath estrella = new GeneralPath();  // crear objeto GeneralPath
	        estrella.moveTo(puntosX[0],puntosY[0] );
	        for ( int a = 1; a < puntosX.length; a++ )
	        	estrella.lineTo(puntosX[a],puntosY[a]);     
	        estrella.moveTo(x,y);	        
	        estrella.closePath();
	        
			return estrella;
		}
		else if (op==1)	return new Rectangle2D.Double(x,y, 65,100);		
		else if (op==2) return new Ellipse2D.Double	 (x,y, 65,100);		
		else if (op==3) return new Line2D.Double	 (x,y,150,130);		
		else if (op==4){

	        int valoresX[] = { x, x-50, x-30, x+30, x+50};
	        int valoresY[] = { y, y+40, y+90, y+90, y+40};
	        Polygon poligono1 = new Polygon( valoresX, valoresY, 5);
	        poligono1.translate(xVel,yVel);
	        return poligono1;
	        
		}
		return null;
	}

	public void	setShape(Shape shape){
		this.shape = shape;
	}
	public void setColor(Color color){
		this.color = color;
	}
	public void setX	(int x) 	 {
		this.x = x;
	}
	public void	setY	(int y) 	 {
		this.y = y;
	}
	public void setxVel	(int xVel)	 {
		this.xVel = xVel;
	}
	public void setyVel	(int yVel) 	 {
		this.yVel = yVel;
	}

	public Shape 	getShape() {
		return shape;
	}
	public Color 	getColor() {
		return color;
	}
	public double	getX	() {
		return x;
	}
	public double	getY	() {
		return y;
	}
	public int	 	getxVel () {
		return xVel;
	}
	public int	 	getyVel () {
		return yVel;
	}
	
}