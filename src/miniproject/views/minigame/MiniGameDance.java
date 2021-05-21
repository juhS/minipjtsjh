package miniproject.views.minigame;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import miniproject.model.vo.Player123;
import miniproject.views.ChangePanel;
import miniproject.views.MainFrame;



public class MiniGameDance extends JPanel { // 미니게임 연결화면 (춤연습장 들어가서 첫화면)

	private ImageIcon back;
	private ImageIcon talk;
	private ImageIcon characters;
	
	private MiniGameDance panel = this;
	
	private MainFrame mf;
	
	private Player123 player;

	public MiniGameDance(MainFrame mf, Player123 player) {

		this.mf = mf;
		panel = this;
		this.player = player;
		
		this.setLayout(null);
		back = new ImageIcon("src/miniproject/images/SJH/minigamekey.PNG"); //배경
		talk = new ImageIcon("src/miniproject/images/SJH/conv.PNG"); //대화창
		characters = new ImageIcon("src/miniproject/images/SJH/Characters_1.GIF"); //캐릭터


		this.addMouseListener(new MyMouseAdapter()); 
	}
	

	public void paintComponent(Graphics g) {

		g.drawImage(back.getImage(), 0, 0, this.getWidth(),this.getHeight(),null);
		g.drawImage(talk.getImage(), 0, 600, 1400, 250,null); //원래 위치 : 0,600,1400,250
		g.drawImage(characters.getImage(), 520, 200, 398, 398, this);//원래크기 : 398,398
		g.setFont(new Font("Neo둥근모", Font.BOLD, 30));
		g.drawString("※ 클릭하여 게임을 진행하세요 ※ ", 100, 660);
		g.drawString("오늘도 춤연습을 해보자 ♪", 100, 710); //글씨 위치 조절 필요    //700->700
		g.drawString("Yeah 다시 돌아왔지 내 이름 레인 스웩을 뽐내 WHOO ~ ♬  ", 100, 760);   //780->750
		g.drawString("They call it 왕의 귀환 ~ ♭ ", 100, 810);  //850->800
		setOpaque(false);
		super.paintComponent(g);
	}


	class MyMouseAdapter extends MouseAdapter{


		@Override
		public void mouseClicked(MouseEvent e) {
			ChangePanel.changePanel(mf, panel, new MiniGameDance2(mf,player));      //춤게임2화면으로 넘어감.
			mf.revalidate();
		}



	}
}



