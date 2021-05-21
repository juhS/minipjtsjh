package miniproject.views.minipublic;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import miniproject.model.vo.Player123;
import miniproject.views.ChangePanel;
import miniproject.views.MainFrame;

public class Sosok_02_trot extends JPanel {

	private MainFrame mf;
	private JPanel panel;

	private ImageIcon back; //배경
	private ImageIcon talk; //대화상자
	private ImageIcon characters =new ImageIcon("src/miniproject/images/SJH/Characters_6.png");
	private ImageIcon sajang = new ImageIcon("src/miniproject/images/sosok/sajang.PNG");

	private Player123 player;

	private Image doorR; //소속사 문(미니게임 춤)
	private Image doorL; //소속사 문(미니게임 노래)



	public Sosok_02_trot(MainFrame mf, Player123 player) {

		this.mf=mf;
		panel = this;
		this.player = player;
		
		this.setLayout(null);

		back = new ImageIcon("src/miniproject/images/SJH/minibackgroundfinish.PNG"); //배경-소속사
		talk = new ImageIcon("src/miniproject/images/SJH/conv.PNG"); //대화창

		Image cimage = characters.getImage().getScaledInstance(100, 100, 0);
		Image simage  = sajang.getImage().getScaledInstance(100, 100, 0);
		ImageIcon cIcon = new ImageIcon(cimage);
		ImageIcon sIcon = new ImageIcon(simage);

		this.addMouseListener(new clickButton() );
	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.drawImage(back.getImage(), 0, 0, this.getWidth(),this.getHeight(),null);
		g.drawImage(talk.getImage(), 0, 600, 1400, 250,null); //원래 위치 : 0,600,1400,250
		g.setFont(new Font("Neo둥근모", Font.BOLD, 30));
		g.drawString("[사장님!! 데뷔시켜주셔서 감사합니다!!!]", 100, 730);
		g.drawImage(sajang.getImage(), 300, 300, 250, 250, this);
		g.drawImage(characters.getImage(), 10, 300, 250, 250, this);

	}


	class clickButton extends MouseAdapter{  
		@Override
		public void mouseClicked(MouseEvent e) {
			ChangePanel.changePanel(mf, panel, new Sosok_03_trot(mf,player));
			mf.revalidate();
		}


	}
}
