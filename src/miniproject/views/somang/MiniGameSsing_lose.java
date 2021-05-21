package miniproject.views.somang;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import miniproject.model.vo.Player123;
import miniproject.views.ChangePanel;
import miniproject.views.MainFrame;
import miniproject.views.minipublic.Sosok_singbutton;



public class MiniGameSsing_lose extends JPanel{

	private MainFrame mf;
	private JPanel panel;
	
	private ImageIcon back;
	private ImageIcon talk;
	private ImageIcon charac01;
	private ImageIcon lose;
	
	private int jum =0;
	
	private Player123 player;

	public MiniGameSsing_lose(MainFrame mf, Player123 player, int jum) {
		this.mf = mf;
		panel = this;
		this.player = player;
		
		this.setLayout(null);
		back = new ImageIcon("src/miniproject/images/ssing/sosokSing_b.png");
		talk = new ImageIcon("src/miniproject/images/ssing/talkFrame.png");
		charac01 = new ImageIcon("src/miniproject/images/ssing/Lose_Characters02.gif");
		lose = new ImageIcon("src/miniproject/images/ssing/lose.png");
		this.addMouseListener(new clickPanel());
	}
	
	public void jumsu(int jum) {
		int jum2 = jum;
		JLabel jlabel = new JLabel(jum2+"점! 능력치를 올리치 못했다!!");
		jlabel.setBounds(5,5,300,50);
		jlabel.setFont(new Font("Sanscerif",Font.BOLD,20));
		jlabel.setForeground(Color.BLACK);
		panel.add(jlabel);
		
	}
		
	
	
	public void paintComponent(Graphics g) {
		g.drawImage(back.getImage(), 0, 0, null);
		g.drawImage(talk.getImage(), 5, 620, 1390, 250, null);
		g.drawImage(lose.getImage(),350,50,700,170,null);
		if (charac01 != null) {
			g.drawImage(charac01.getImage(), 500, 250, 398, 398, this);
		}
		g.setFont(new Font("Neo둥근모", Font.BOLD, 40));
		g.drawString("아쉽게 노래 점수를 얻지 못했다..!", 70, 750);
		
		setOpaque(false);
		super.paintComponent(g);
	}
	
	
	class clickPanel extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			
			ChangePanel.changePanel(mf, panel, new Sosok_singbutton(mf, player));
			mf.revalidate();

		}

	}
	
}