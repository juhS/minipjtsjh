package miniproject.views.selectC;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import miniproject.model.vo.Player123;
import miniproject.views.ChangePanel;
import miniproject.views.MainFrame;
import miniproject.views.firstPage.FirstPage;
import miniproject.views.sangjin.MainRoom;
public class SelectC extends JPanel {
	
	private MainFrame mf;
	private SelectC sc = this;
	
	
	private JLabel label;
	private JLabel label2;
	private Player123 player;
	
	public void paintComponent(Graphics g) {	
		ImageIcon  sback = new ImageIcon("src/miniproject/images/nickNameSelect/nickname_background.jpeg");
		g.drawImage(sback.getImage(), 0, 0, 1400, 900, null);
		mf.repaint();
		setOpaque(false); 
		super.paintComponent(g);
		mf.repaint();
		
	}
	
	public SelectC(MainFrame mf, Player123 player) {
		this.mf = mf;
		this.player = player;
		
		label = new JLabel();
		label.setIcon(new ImageIcon("src/miniproject/images/selectC/character02.gif"));
		label2 = new JLabel();
		label2.setIcon(new ImageIcon("src/miniproject/images/selectC/character01.gif"));
		label.setBounds(200,50,1000,700);
		label2.setBounds(800,50,1000,700);
		
		label.addMouseListener(new MouseAdapter() {
			
			
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePanel.changePanel(mf, sc, new MainRoom(mf,player));
				mf.validate();
				
			}
		});
		sc.add(label);
		sc.add(label2);
		
		
		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePanel.changePanel(mf, sc, new FirstPage(mf));
				mf.validate();
				
			}
			
		});
		
	}
	
}	
