package miniproject.views.somang;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import miniproject.views.MainFrame;
import javax.swing.JPanel;

import miniproject.model.vo.Player123;
import miniproject.views.ChangePanel;

public class MiniGameSsing extends JPanel {
	private MainFrame mf;
	private JPanel panel;
	private ImageIcon icon;
	private ImageIcon talk;
	private ImageIcon charac01;
	private Player123 player;

	public MiniGameSsing(MainFrame mf, Player123 player) {
		this.mf = mf;
		panel = this;
		this.player = player;
		
		this.setLayout(null);
		icon = new ImageIcon("src/miniproject/images/ssing/sosokSing.png");
		talk = new ImageIcon("src/miniproject/images/ssing/talkframe.png");
		charac01 = new ImageIcon("src/miniproject/images/ssing/Characters02.gif");

		this.addMouseListener(new clickPanel());

	}
	

	public void paintComponent(Graphics g) {
		g.drawImage(icon.getImage(), 0, 0, null);
		g.drawImage(talk.getImage(), 5, 620, 1390, 250, null);
		if (charac01 != null) {
			g.drawImage(charac01.getImage(), 50, 200, 398, 398, this);
		}
		
		g.setFont(new Font("Neo둥근모", Font.BOLD, 40));
		g.drawString("오늘도 노래 연습을 해보자!", 70, 750);
		mf.validate();

		setOpaque(false);
		super.paintComponent(g);
	}

	
	
	class clickPanel extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			MiniGameSsing2 gp = new MiniGameSsing2(mf,player);
		
			ChangePanel.changePanel(mf, panel, gp);
			
		}

	}

}