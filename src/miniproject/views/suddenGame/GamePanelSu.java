package miniproject.views.suddenGame;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import miniproject.model.vo.Player123;
import miniproject.views.ChangePanel;
import miniproject.views.MainFrame;

public class GamePanelSu extends JPanel{
	private MainFrame mf;
	private GameInfo info = new GameInfo();
	private GamePanelSu panel = this;
	private Banner banner = new Banner();
	
	private Player123 player;
	
	public void paintComponent(Graphics g) {
		
		ImageIcon bground = new ImageIcon("src/miniproject/images/suddenGame/bground_0.jpg");
		g.drawImage(bground.getImage(), 0, 0, 1400, 900, null);
		setOpaque(false); //그림을 표시하게 설정,투명하게 조절
		super.paintComponent(g);
	}
	
	
	public GamePanelSu(MainFrame mf, Player123 player) {
		this.mf = mf;
		this.player = player;
		
		info.setLayout(null);
		info.setSize(1000, 700);
		info.setLocation(200, 100);
		this.add(info);
		banner.setLayout(null);
		banner.setBounds(15,630,1350,220);
		panel.add(banner);
		info.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				info.setVisible(false);
				
			}
		});
	
			this.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					ChangePanel.changePanel(mf, panel, new Gamepan(mf, player));
			}
			});
		}
	
	
}
