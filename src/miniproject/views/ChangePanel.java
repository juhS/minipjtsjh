package miniproject.views;

import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;

import miniproject.model.vo.Player123;


public class ChangePanel {
	private JFrame mf;
	private JPanel panel;
	private JPanel panel2;
	private Player123 player;
	
	
	
	public ChangePanel() {
		
	}
	


	public static void changePanel(MainFrame mf, JPanel op, JPanel np){
		mf.remove(op);
		mf.add(np);
		np.setLayout(null);
		np.setSize(1400,900);
		mf.repaint();
	
	}
}


		

