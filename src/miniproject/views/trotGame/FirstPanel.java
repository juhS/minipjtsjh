package miniproject.views.trotGame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import miniproject.model.vo.Player123;
import miniproject.views.ChangePanel;
import miniproject.views.MainFrame;

public class FirstPanel extends JPanel{

	private MainFrame mf;
	private JFrame jf;
	private FirstPanel panel;
	
	private JLabel label;
	private Player123 player;
	
	private Image back = new ImageIcon("src/miniproject/images/camera/panel3.PNG").getImage().getScaledInstance(1400, 900, 0);


	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(back, 0,0,1400,900,this);
		setOpaque(false);
	}
	

	public FirstPanel(MainFrame mf, Player123 player) {
		System.out.println(player.getDanceScore());
		System.out.println(player.getSingScore());
		panel = this;
		this.mf = mf;
		this.player = player;
		
		label = new JLabel();
		label.setIcon(new ImageIcon("src/miniproject/images/camera/startp.png"));

		panel.setLayout(null);
		label.setBounds(200,50,1000,700);

		panel.add(label);
		label.setVisible(false);
		
		panel.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				label.setVisible(true);
			}

		});
		
		
		
		label.addMouseListener(new MouseAdapter() {
			
			
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePanel.changePanel(mf, panel, new TrotGame(mf,player));
				mf.validate();
				
			}
		});
		
	}
	
}