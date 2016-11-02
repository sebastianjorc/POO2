package vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import controlador.ClickTablero;

public class tablero extends JPanel{
	private static final long serialVersionUID = 1L;
	public static final Color DEFAULT_COLOR = Color.decode("#E8FFFA");
    ArrayList<ShapeItem> shapes;
	public int sizex = 421;
	public int sizey = 351;
	public int tamCuadrado = 35;
	Color	colorTrue  = Color.GREEN,
			colorFalse = Color.RED,
			ColorActual= Color.YELLOW;
	
	
    public tablero() {
    	setBackground(Color.decode("#FFFDE4"));
		setLayout(new GridLayout());
        shapes = new ArrayList<ShapeItem>();
		for (int i = 35; i<sizex+33; i+=tamCuadrado){
			for (int j= 10; j<sizey+8; j+=tamCuadrado){
				 shapes.add(new ShapeItem(new Rectangle2D.Double(i, j, tamCuadrado, tamCuadrado),DEFAULT_COLOR));
			}
		}
        addMouseListener(new ClickTablero(shapes,this));
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

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        
        for (ShapeItem item : shapes) {
            g2.setColor(item.getColor());
            g2.fill(item.getShape());
        }
		for (int i = 35; i<sizex+33; i+=tamCuadrado){
			for (int j= 10; j<sizey+8; j+=tamCuadrado){
				g.drawRect(i, j, tamCuadrado, tamCuadrado);
			}
		}

        g2.dispose();
    }

}