package miniproject.views.suddenGame;

import java.awt.Graphics;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class GameInfo extends JLabel  implements Serializable{
	public void paintComponent(Graphics g) {
		ImageIcon info = new ImageIcon("src/miniproject/images/suddenGame/info_0.jpg");
		g.drawImage(info.getImage(), 0, 0, 1000, 700, null);
		//			Point p = scrollPane.getViewport().getViewPosition();
		//g.drawImage(bground.getImage(), p.x, p.y, null);
		setOpaque(false); //그림을 표시하게 설정,투명하게 조절
		super.paintComponent(g);
	}
}
