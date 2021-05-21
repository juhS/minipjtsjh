package miniproject.views.mainMap;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dongyub.PlayerLabel;
import miniproject.model.vo.Player123;
import miniproject.views.ChangePanel;
import miniproject.views.MainFrame;
import miniproject.views.Pyosi;
import miniproject.views.jungukGame.MainPage;
import miniproject.views.somang.Park;
import miniproject.views.trotGame.FirstPanel;



public class MainMapJunguk extends JPanel {	
	private int donum;
	private MainFrame mf;
	private MainMapJunguk panel = this;
	private Player123 player;
	private Pyosi pyosi;
	private JLabel questWindow;
	private JLabel questWindow2;
	
	
	PlayerLabel fl = new PlayerLabel();
	
	public void paintComponent(Graphics g) {
		setFocusable(true);
		requestFocus();
		ImageIcon bground = new ImageIcon("src/miniproject/images/mainMap/MainMap.png");
		
		g.drawImage(bground.getImage(), 0, 0, 1400, 900, null);
		setOpaque(false); //그림을 표시하게 설정,투명하게 조절
		super.paintComponent(g);
	}
	
	
	public MainMapJunguk (MainFrame mf, Player123 player) {
		
		this.player = player;
		this.mf = mf;
		
		
		pyosi = new Pyosi(player);
		pyosi.setLayout(null);
		pyosi.setBounds(600,0,500,200);
		pyosi.setFont(new Font("맑은고딕", Font.BOLD, 25));
		pyosi.setForeground(Color.WHITE);
		panel.add(pyosi);
		
		questWindow = new JLabel() {
			public void paintComponent(Graphics g) {
				ImageIcon que = new ImageIcon("src/miniproject/images/firstPage/Que3.png");
				g.drawImage(que.getImage(),0,0,260,100,null);

				
				setOpaque(false); //그림을 표시하게 설정,투명하게 조절
				super.paintComponent(g);
			}};
			
			questWindow.setLayout(null);
			questWindow.setBounds(1100,10,260,100);
			questWindow.setVisible(true);
			this.add(questWindow);
		
			
			
		questWindow2 = new JLabel() {
			public void paintComponent(Graphics g) {
				ImageIcon que2 = new ImageIcon("src/miniproject/images/firstPage/Que4.png");
				g.drawImage(que2.getImage(),0,0,260,100,null);
				
				
				setOpaque(false); //그림을 표시하게 설정,투명하게 조절
				super.paintComponent(g);
			}};
			
			questWindow2.setLayout(null);
			questWindow2.setBounds(1100,10,260,100);
			questWindow2.setVisible(false);
			this.add(questWindow2);
				
		if(player.getSingScore() == 2 && player.getDanceScore() == 2) {
			questWindow.setVisible(false);
			questWindow2.setVisible(true);
			
		}
		fl.setLayout(null);
		fl.setBounds(600, 430, 100, 100);
		this.add(fl);
		this.setFocusable(true);
		addKeyListener(new MyKeyListenerJunGuk(fl, mf, panel, player));
		
	}
}
	

