package miniproject.views.mainMap;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dongyub.PlayerLabel;
import miniproject.model.vo.Player123;
import miniproject.views.ChangePanel;
import miniproject.views.MainFrame;
import miniproject.views.Pyosi;
import miniproject.views.sangjin.MainRoom;
import miniproject.views.somang.Park;



public class MainMapFirst extends JPanel {	
	private MainFrame mf;
	private MainMapFirst panel = this;
	private Player123 player;
	private JLabel quest = new JLabel();
	private Pyosi pyosi;

	private PlayerLabel fl = new PlayerLabel();
	private JLabel quest2;
	
	public void paintComponent(Graphics g) {
		setFocusable(true);
		requestFocus();

		ImageIcon bground = new ImageIcon("src/miniproject/images/mainMap/MainMap.png");
		ImageIcon que = new ImageIcon("src/miniproject/images/firstPage/Que1.png");
		g.drawImage(que.getImage(),1000,250,300,200,null);

		g.drawImage(bground.getImage(), 0, 0, 1400, 900, null);
		setOpaque(false); //그림을 표시하게 설정,투명하게 조절
		super.paintComponent(g);
	}
	public MainMapFirst (MainFrame mf, Player123 player) {


		this.mf = mf;
		this.player = player;
		
		pyosi = new Pyosi(player);
		
		pyosi.setLayout(null);
		pyosi.setBounds(600,0,500,200);
		pyosi.setFont(new Font("맑은고딕", Font.BOLD, 25));
		pyosi.setForeground(Color.WHITE);
		panel.add(pyosi);
		
		quest.setIcon(new ImageIcon("src/miniproject/images/mainMap/parkQ.png"));
		quest.setBounds(200,50,1000,700);
		quest.setVisible(true);
		panel.add(quest);
		
		fl.setLayout(null);
		fl.setBounds(1075, 500, 100, 100);
		this.add(fl);
		this.addKeyListener(new MyKeyListenerMainMap(fl,mf,panel,player));

		JLabel questWindow = new JLabel() {
		public void paintComponent(Graphics g) {
			ImageIcon que = new ImageIcon("src/miniproject/images/firstPage/Que1.png");
			g.drawImage(que.getImage(),0,0,260,100,null);

			
			setOpaque(false); //그림을 표시하게 설정,투명하게 조절
			super.paintComponent(g);
		}};
		
		questWindow.setLayout(null);
		questWindow.setBounds(1100,10,260,100);
		this.add(questWindow);
		
		panel.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				quest.setVisible(false);
			}
		});
	
	}



}


