package prueba;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	JLabel l;	Timer t;	JButton b1,b2;	JPanel jp;
	
	public TFrame(){
		super();		
		ActionListener al = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ae){
				System.out.println("hola");
			}
		};
		b1=new JButton("start");
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				t.start();				
			}
			
		});
		b2=new JButton("stop");
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				t.stop();				
			}
			
		});
		jp=new JPanel();
		jp.add(b1);		jp.add(b2);
		l = new JLabel();		
		t = new Timer(100, al);
		
		add(jp);
	}
	
	
	public static void delayS(){
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){}
	}
	
	public void play(){
		int m,s;
		for (m=0;m<1;m++){
			for (s=0;s<60;s++){				
				delayS();
				l.repaint();
			}
		}		
	}

}