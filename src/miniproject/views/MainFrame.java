package miniproject.views;

import javax.swing.JFrame;

import miniproject.views.firstPage.FirstPage;
import miniproject.views.sangjin.MainRoom;


public class MainFrame extends JFrame {
	public MainFrame(){
		this.setBounds(60, 0, 1400, 900);
		FirstPage first = new FirstPage(this);
		this.add(first);
		
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	
	}
	
}
