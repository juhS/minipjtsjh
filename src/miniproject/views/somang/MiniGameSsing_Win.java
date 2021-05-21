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
import miniproject.views.minipublic.Sosok_dancebutton;


public class MiniGameSsing_Win extends JPanel{

	private MainFrame mf;
	private MiniGameSsing_Win panel = this;
	
	private ImageIcon back;
	private ImageIcon talk;
	private ImageIcon charac01;
	private ImageIcon win;
	
	private Player123 player;

	public MiniGameSsing_Win(MainFrame mf, Player123 player) {
		this.mf = mf;
		this.player = player;
		
		this.setLayout(null);
		back = new ImageIcon("src/miniproject/images/ssing/sosokSing.png");
		talk = new ImageIcon("src/miniproject/images/ssing/talkframe.png");
		charac01 = new ImageIcon("src/miniproject/images/ssing/Characters02.gif");
		win = new ImageIcon("src/miniproject/images/ssing/win.png");
		this.addMouseListener(new clickPanel());
	}
	
	public void jumsu(int jum) {
		int jum2 = jum;
		JLabel jlabel = new JLabel("능력치가"+jum2+"점 상승했다!");
		player.setSingScore(player.getSingScore() + jum2);
		jlabel.setBounds(5,5,300,50);
		jlabel.setFont(new Font("Sanscerif",Font.BOLD,20));
		jlabel.setForeground(Color.BLACK);
		panel.add(jlabel);
		
	}
	
	
	public void paintComponent(Graphics g) {
		g.drawImage(back.getImage(), 0, 0, null);
		g.drawImage(talk.getImage(), 5, 620, 1400, 250, null);
		g.drawImage(win.getImage(),350,50,700,170,null);
		if (charac01 != null) {
			g.drawImage(charac01.getImage(), 500, 250, 398, 398, this);
		}
		g.setFont(new Font("Neo둥근모", Font.BOLD, 40));
		g.drawString("만세~! 노래 능력치가 올랐다!!", 70, 750);
		
		setOpaque(false);
		super.paintComponent(g);
	}
	
	
	class clickPanel extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			
			ChangePanel.changePanel(mf, panel, new Sosok_dancebutton(mf,player));  //춤 문 버튼 있는 곳으로 나가야함.
			mf.revalidate();
			
		}

	}
	
}