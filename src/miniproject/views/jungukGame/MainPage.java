package miniproject.views.jungukGame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import miniproject.model.vo.Player123;
import miniproject.views.ChangePanel;
import miniproject.views.MainFrame;

public class MainPage extends JPanel {
	private MainFrame mf;
	private JPanel panel;
	
	private ImageIcon jungukbg = new ImageIcon("src/miniproject/images/junguk/Junguk.PNG");
	private ImageIcon mal = new ImageIcon("src/miniproject/images/junguk/mal_junguk1.PNG");
	private Image character = new ImageIcon("src/miniproject/images/junguk/Characters02.PNG").getImage().getScaledInstance(270, 300, 0);
	
	private Player123 player;
	
	public MainPage(MainFrame mf, Player123 player) {
		this.mf = mf;
		panel =this;
		this.player = player;
		
		this.setLayout(null);
		
		JLabel label = new JLabel(new ImageIcon(character));
		label.setBounds(350,220,270,300);
		this.add(label);
		
	}
	
	
	public void paintComponent (Graphics g) {
		super.paintComponent(g);
		g. drawImage(jungukbg.getImage(), -300, 0, 1800, 750, null);
		g. drawImage(mal.getImage(),0,600,1400,250,null);
		setOpaque(false);
	
	
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePanel cp = new ChangePanel();
				cp.changePanel(mf, panel, new SubPage(mf,player));
				mf.revalidate();
				
				
			}
		});
		
	}

	
}