package miniproject.views.suddenGame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import miniproject.model.vo.Player123;
import miniproject.views.ChangePanel;
import miniproject.views.MainFrame;

public class SuddenGameStart extends JPanel {
	private MainFrame mf;
	private Player123 player;
	private JPanel panel = this;
	private Image gi = new ImageIcon("src/miniproject/images/suddenGame/start.png").getImage().getScaledInstance(1000, 400, 0);
	public void paintComponent(Graphics g) {
		ImageIcon bground = new ImageIcon("src/miniproject/images/suddenGame/bground_0.jpg");
		
		g.drawImage(bground.getImage(), 0, 0, 1400, 900, null);
		//			Point p = scrollPane.getViewport().getViewPosition();
		//g.drawImage(bground.getImage(), p.x, p.y, null);
		setOpaque(false); //그림을 표시하게 설정,투명하게 조절
		super.paintComponent(g);
	}
	
	public SuddenGameStart(MainFrame mf,Player123 player) {
		
		JLabel giza = new JLabel(new ImageIcon(gi)); 
		giza.setOpaque(false);
		giza.setLayout(null);
		giza.setBounds(200,50,1000,700);
		this.add(giza);
		
		giza.addMouseListener(new MouseAdapter() {
			
			
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePanel.changePanel(mf, panel, new GamePanelSu(mf,player));
				
			}
		});
	}
	
	
}
