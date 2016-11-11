package vista;

import java.awt.Color;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;

public class figura {
	Shape shape;	Color color;
	public int xVel=5, yVel=5;
	int x, y, xl, yl;	public int tipo;
	
	
	public figura(Shape shape, Color color, int tipo){
		x =(int)shape.getBounds2D().getX();
		y =(int)shape.getBounds2D().getY();
		yl=(int)shape.getBounds2D().getHeight();
		xl=(int)shape.getBounds2D().getWidth();

		this.setXl(xl-50);
		this.setYl(yl-50);
		System.out.println(x+"\t"+y+"\t"+xl+"\t"+yl);
		this.tipo =tipo;
		this.shape=shape;
		this.color=color;
	}

	public void update(){
	
			 if(tipo==3){ 	x=0;		y=y+yVel;	}
		else if(tipo==2){	x=x+xVel;	y=0;		}
		else if(tipo==0){ 	x=x-xVel;	y=y+yVel;	}
		else			{ 	x=x+xVel;	y=y+yVel;	}
		
		if(tipo==0  || tipo == 3){
			if(x<0  || x>tableroMov.sizex-xl/2)					xVel=-xVel;
			if(y<0  || y>tableroMov.tamCuadrado*10-(yl/2-10))	yVel=-yVel;
		}else{
			if(x<0  || x>tableroMov.sizex)						xVel=-xVel;
			if(y<0  || y>tableroMov.tamCuadrado*10+10)			yVel=-yVel;
		}
		
		this.setShape(nuevoShape(tipo));
	}
	
	public Shape nuevoShape(int op){
		if (op==0){						//		x=300  xl=110							
	        int puntosX[] = {	x+(xl/2),	x+(3*xl/5),	x+xl,		x+(2*xl/3),	x+(4*xl/5),	x+(xl/2), 	x+(xl/5), 	x+(xl/3), 	x, 			x+(2*xl/5)	};
	        int puntosY[] = {	y,			y+(2*yl/5), y+(yl*3/7), y+(3*yl/5),	y+yl, 		y+(yl*3/4),	y+yl, 		y+(yl*3/5), y+(yl*3/7),  y+(2*yl/5) };
	        GeneralPath estrella = new GeneralPath();  // crear objeto GeneralPath
	        estrella.moveTo(puntosX[0],puntosY[0] );
	        for ( int a = 1; a < puntosX.length; a++ )
	        	estrella.lineTo(puntosX[a],puntosY[a]);
	        estrella.moveTo(x,y); 
	        estrella.closePath();
			return estrella;
		}
		else if (op==1)	return new Rectangle2D.Double(x,y, xl,yl);		
		else if (op==2) return new Ellipse2D.Double	 (x,y, xl,yl);
		else if (op==3){
			
	        int valoresX[] = { x+(xl/2), 	x, 			x+(xl/5), 	x+(xl-(xl/5)), 	x+xl 		};
	        int valoresY[] = { y, 			y+(6*yl/13), 	y+yl, 		y+yl, 		y+(6*yl/13)	};
	        Polygon poligono1 = new Polygon( valoresX, valoresY, 5);
	        poligono1.translate(xVel,yVel);
	        return poligono1;	        
		}
		return null;
	}

	public void setBounds(int ix, int iy, int fx, int fy){
		this.x=ix;
		this.y=iy;
		this.xl=fx;
		this.yl=fy;
		
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
	public void setXl	(int xl) 	 {
		this.xl = xl;
	}
	public void setYl	(int yl)	 {
		this.yl = yl;
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
	public int		getXl	() {
		return xl;
	}
	public int 		getYl	() {
		return yl;
	}
	
}