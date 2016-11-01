package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class tablero extends JPanel{
	private static final long serialVersionUID = 1L;
	public static final Color DEFAULT_COLOR = Color.decode("#E8FFFA");
    ArrayList<ShapeItem> shapes;
	int sizex = 421;
	int sizey = 351;
	int tamCuadrado = 35;
	Color	colorTrue  = Color.GREEN,
			colorFalse = Color.RED,
			ColorActual= Color.YELLOW;

    public tablero() {
		setLayout(new BorderLayout());
        shapes = new ArrayList<ShapeItem>();
		for (int i = 0; i<sizex-2; i+=tamCuadrado){
			for (int j= 0; j<sizey-2; j+=tamCuadrado){
				 shapes.add(new ShapeItem(new Rectangle2D.Double(i, j, tamCuadrado, tamCuadrado),DEFAULT_COLOR));
			}
		}
        ShapesPanel panel = new ShapesPanel(shapes);
        add(panel,BorderLayout.CENTER);
    }

    class ShapeItem {
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

    class ShapesPanel extends JPanel {
    	//HACER COMIENCE A DIBUJAR EN EL CENTRO.
		private static final long serialVersionUID = 1L;
		private List<ShapeItem> shapes;

        public ShapesPanel(List<ShapeItem> shapesList) {
        	setBackground(Color.decode("#FFFDE4"));
            this.shapes = shapesList;
            addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        for (ShapeItem item : shapes) {
                            if (item.getShape().contains(e.getPoint())) {
                                item.setColor(Color.RED);
                            }
                        }
                        repaint();
                    }
            });
        }        
        
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g.create();
            
            for (ShapeItem item : shapes) {
                g2.setColor(item.getColor());
                g2.fill(item.getShape());
            }
    		for (int i = 0; i<=sizex-2; i+=tamCuadrado){
    			for (int j= 0; j<=sizey-2; j+=tamCuadrado){
    				g.drawRect(i, j, tamCuadrado, tamCuadrado);
    			}
    		}

            g2.dispose();
        }

    }
}