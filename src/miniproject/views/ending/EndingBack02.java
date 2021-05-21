package miniproject.views.ending;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import miniproject.model.vo.Player123;
import miniproject.views.MainFrame;

public class EndingBack02 extends JPanel { //51~75% 무명스타(남캐릭터)
	
	private MainFrame mf;
	private EndingBack02 panel = this;
	private Player123 player;

	private ImageIcon imageicon = new ImageIcon("src/miniproject/images/SJH/endingmo.png");

	private Image image = imageicon.getImage();
	
	public EndingBack02(MainFrame mf, Player123 player) {
		this.mf = mf;
		this.player = player;
		
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Neo둥근모",Font.BOLD,30));

	}
}


