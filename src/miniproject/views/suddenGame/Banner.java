package miniproject.views.suddenGame;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Banner extends JLabel {
	public void paintComponent(Graphics g) {
		ImageIcon banner = new ImageIcon("src/miniproject/images/suddenGame/banner.png");
		g.drawImage(banner.getImage(), 0, 0, 1350, 220, null);
		setOpaque(false); 
		super.paintComponent(g);
	}
	
}
