package miniproject.views.minigame;

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
import miniproject.views.minipublic.Sosok_junguk;


public class MiniGameDance3_Win extends JPanel{ // 미니게임 이기면 나오는 화면

	private MainFrame mf;
	private JPanel panel;
	
	private ImageIcon back;
	private ImageIcon talk;
	private ImageIcon characters;
	private ImageIcon win;
	
	private int su;
	
	private Player123 player;

	public MiniGameDance3_Win(MainFrame mf, Player123 player) {
		this.mf = mf;
		panel = this;
		this.player = player;
		
		
		this.setLayout(null);
		back = new ImageIcon("src/miniproject/images/SJH/minigamekey.png");
		talk = new ImageIcon("src/miniproject/images/SJH/conv.png");
		characters = new ImageIcon("src/miniproject/images/SJH/Characters_5.png");
		win = new ImageIcon("src/miniproject/images/SJH/win.png");

		this.setFocusable(true);
		this.addMouseListener(new clickPanel());

	}
	

	public void keyjumsu(int su) {
		int susu = su;
		JLabel jlabel = new JLabel("능력치가"+susu+"점 상승했습니당!");
		jlabel.setBounds(5,5,300,50);
		jlabel.setFont(new Font("Sanscerif",Font.BOLD,20));
		panel.add(jlabel);
	}



	public void paintComponent(Graphics g) {
		g.drawImage(back.getImage(), 0, 0,1400,900, null);
		g.drawImage(talk.getImage(), 5, 620, 1400, 250, null);
		g.drawImage(win.getImage(),350,50,700,170,null);
		g.drawImage(characters.getImage(), 500, 250, 398, 398, this);      
		g.setFont(new Font("Neo둥근모", Font.BOLD, 40));
		g.drawString("깡춤한번 더 춰볼까~ 춤능력치 +1 !!!", 70, 750);

		setOpaque(false);
		super.paintComponent(g);
	}




	class clickPanel extends MouseAdapter {
		
		@Override
		public void mouseClicked(MouseEvent e) {

			ChangePanel.changePanel(mf, panel, new Sosok_junguk(mf,player));   //소속사 밖으로 나가는 문이 활성화되어있는 곳으로 나가야함.
			mf.revalidate();
		}

	}

}



