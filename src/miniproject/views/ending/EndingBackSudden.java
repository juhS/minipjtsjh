package miniproject.views.ending;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import miniproject.model.vo.Player123;
import miniproject.views.MainFrame;

public class EndingBackSudden extends JPanel { //돌발게임

	private MainFrame mf;
	private EndingBackSudden panel = this;
	private ImageIcon imageicon = new ImageIcon("src/miniproject/images/SJH/ending_sudden.PNG");

	Image image = imageicon.getImage();
	
	private Player123 player;
	
	public EndingBackSudden(MainFrame mf, Player123 player) {
		this.mf = mf;
		this.player = player;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
		g.setColor(Color.WHITE);
	

	}

	
}
