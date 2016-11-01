package vista;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

public class tablero extends Canvas {
	private static final long serialVersionUID = 1L;
	int sizex = 421;
	int sizey = 351;
	int tamCuadrado = 35;

	tablero(){
		this.setBackground(Color.decode("#E8FFFA"));
		this.setSize(sizex,sizey);
	}
	
	public void paint(Graphics g){
		List<ShapeItem> shapes = new ArrayList<ShapeItem>();
		g.setColor(Color.DARK_GRAY);

		for (int i = 0; i<sizex; i+=tamCuadrado){
			for (int j= 0; j<sizey; j+=tamCuadrado){
				 shapes.add(new ShapeItem(new Rectangle2D.Double(i, j, tamCuadrado, tamCuadrado),null));
				 g.drawRect(i, j, tamCuadrado, tamCuadrado);
			}
		}
	}
	
    class ShapeItem {
        private Shape shape;
        private Color color;

        public ShapeItem(Shape shape, Color color) {
            super();
            this.shape = shape;
            this.color = color;
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
}
