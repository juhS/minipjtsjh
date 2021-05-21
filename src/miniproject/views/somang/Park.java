package miniproject.views.somang;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import miniproject.model.vo.Player123;
import miniproject.views.ChangePanel;
import miniproject.views.MainFrame;

public class Park extends JPanel {
	private MainFrame mf;
	private JPanel panel;
	private ImageIcon icon;
	private ImageIcon talk;
	private ImageIcon Mark;
	private ImageIcon charac01;
	private Player123 player;
	
	public Park(MainFrame mf, Player123 player) {
		this.mf = mf;
		panel = this;
		this.player = player;
		
		this.setLayout(null);
		//배경
		icon = new ImageIcon("src/miniproject/images/park/park.png");
		//대화창
		talk = new ImageIcon("src/miniproject/images/park/talkFrame.png");
		//느낌표
		Mark = new ImageIcon("src/miniproject/images/park/exMark.png");
		
		this.addMouseListener(new clickPanel());


	}
	public void paintComponent(Graphics g) {
		g.drawImage(icon.getImage(), 0, 0, null);
		g.drawImage(talk.getImage(), 5, 620, 1390, 250, null);
		if (charac01 != null) {
			g.drawImage(charac01.getImage(), 50, 200, 398, 398, this);
		}
		g.setFont(new Font("Neo둥근모", Font.BOLD, 40));
		g.drawString("!!! 수상한 사람이다 !!!", 70, 750);
		g.drawImage(Mark.getImage(),900, 250, 154, 174, null);
		setOpaque(false); // 그림을 표시하게 설정,투명하게 조절
		super.paintComponent(g);
	}
	
	class clickPanel extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			ChangePanel.changePanel(mf, panel, new Park2(mf,player));
			mf.revalidate();
		}

	}

	
}