package miniproject.views.selectC;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import miniproject.views.MainFrame;

public class Male extends JLabel{
	MainFrame mf;
	
	ImageIcon  m = new ImageIcon("src/miniproject/images/selectC/Characters02.gif");
	
	public Male(MainFrame mf) {
		this.mf = mf;
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(m.getImage(), 0, 0, null);
		try {
			Thread.sleep(400);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
		setOpaque(false);
		mf.repaint();
	
		
	}
	
}
