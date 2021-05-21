package miniproject.views.somang;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import miniproject.model.vo.Player123;
import miniproject.views.ChangePanel;
import miniproject.views.mainMap.MainMapSosok;
import miniproject.views.MainFrame;


public class Park2 extends JPanel {
	private MainFrame mf;
	private JPanel panel = this;
	private ImageIcon icon;
	private ImageIcon talk;
	private ImageIcon Mark;
	private Player123 player;

	public Park2(MainFrame mf, Player123 player) {
		this.mf = mf;
		this.player = player;
		this.setLayout(null);
		// 배경
		icon = new ImageIcon("src/miniproject/images/park/park2.png");
		// 대화창
		talk = new ImageIcon("src/miniproject/images/park/talkFrame.png");
		// 느낌표
		

		this.addMouseListener(new MouseAdapter() {
		
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePanel.changePanel(mf, panel, new MainMapSosok(mf,player));
				mf.repaint();
			}
		});

	}

	public void paintComponent(Graphics g) {
		g.drawImage(icon.getImage(), 0, 0, null);
		g.drawImage(talk.getImage(), 5, 620, 1390, 250, null);		
		g.setFont(new Font("Neo둥근모", Font.BOLD, 40));
		g.drawString("수상한 사람 : 자네 트로트의 신이 되어 보지 않을 텐가?", 70, 730);
		g.drawString("관심이 있다면 내가 있는 JYB소속사로 오게나!", 290, 780);
		
		setOpaque(false); // 그림을 표시하게 설정,투명하게 조절
		super.paintComponent(g);
	}

	
}